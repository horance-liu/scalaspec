package scalaspec.matcher.oo

import scalaspec.matcher.oo.internal.{ArrayIterator, SelfDescribingValueIterator}

object Description {
  /**
    * A description that consumes input but does nothing.
    */
  val NONE = new Description {
    override protected def append(c: Char) = ()
    override def toString: String = ""
  }
}

trait Description {
  /**
    * Appends some plain text to the description.
    */
  def appendText(text: String): Description = {
    append(text)
    this
  }

  /**
    * Appends the description of a SelfDescribing value to this description.
    */
  def appendDescriptionOf(value: SelfDescribing): Description = {
    value.describeTo(this)
    this
  }

  /**
    * Appends an arbitrary value to the description.
    */
  def appendValue(value: Any): Description = {
    value match {
      case null => append("null")
      case s: String => toScalaSyntax(s)
      case c: Character =>
        append('"')
        toScalaSyntax(c)
        append('"')
      case s: Short =>
        append('<')
        append(descriptionOf(value))
        append("s>")
      case l: Long =>
        append('<')
        append(descriptionOf(value))
        append("L>")
      case f: Float =>
        append('<')
        append(descriptionOf(value))
        append("F>")
      case a: Array[_] =>
        appendValueList("[", ", ", "]", a)
      case o: Any =>
        append('<')
        append(descriptionOf(o))
        append('>')
    }
    this
  }

  private def descriptionOf(value: Any): String = try {
    String.valueOf(value)
  } catch {
    case e: Exception =>
      value.getClass.getName + "@" + Integer.toHexString(value.hashCode)
  }

  /**
    * Append the String <var>str</var> to the description.
    * The default implementation passes every character to append(char).
    * Override in subclasses to provide an efficient implementation.
    */
  protected def append(str: String): Unit = {
    str.foreach(append(_))
  }

  /**
    * Append the char <var>c</var> to the description.
    */
  protected def append(c: Char): Unit

  private def toScalaSyntax(unformatted: String): Unit = {
    append('"')
    unformatted.foreach(toScalaSyntax(_))
    append('"')
  }

  private def toScalaSyntax(ch: Char): Unit =
    ch match {
      case '"'  => append("\\\"")
      case '\n' => append("\\n")
      case '\r' => append("\\r")
      case '\t' => append("\\t")
      case '\\' => append("\\\\")
      case _    => append(ch)
    }

  /**
    * Appends a list of values to the description.
    */
  def appendValueList[T](start: String, separator: String, end: String, values: Iterable[T]): Description =
    appendValueList(start, separator, end, values.iterator)

  /**
    * Appends a list of values to the description.
    */
  def appendValueList[T](start: String, separator: String, end: String, values: Iterator[T]): Description =
    appendList(start, separator, end, SelfDescribingValueIterator(values))

  /**
    * Appends a list of SelfDescribing to the description.
    */
  def appendList(start: String, separator: String, end: String, i: Iterable[SelfDescribing]): Description =
    appendList(start, separator, end, i.iterator)

  private def appendList(start: String, separator: String, end: String, i: Iterator[SelfDescribing]): Description = {
    var separate: Boolean = false
    append(start)
    while (i.hasNext) {
      if (separate) append(separator)
      appendDescriptionOf(i.next)
      separate = true
    }
    append(end)
    this
  }
}