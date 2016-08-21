package scalaspec.matcher.oo

import java.lang.Iterable
import java.util.{Arrays, Iterator}

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
    * Appends the description of a {@link SelfDescribing} value to this description.
    */
  def appendDescriptionOf(value: SelfDescribing): Description = {
    value.describeTo(this)
    this
  }

  /**
    * Appends an arbitrary value to the description.
    */
  def appendValue(value: Any): Description = {
    if (value == null) {
      append("null")
    } else if (value.isInstanceOf[String]) {
      toJavaSyntax(value.asInstanceOf[String])
    } else if (value.isInstanceOf[Character]) {
      append('"')
      toJavaSyntax(value.asInstanceOf[Character])
      append('"')
    } else if (value.isInstanceOf[Short]) {
      append('<')
      append(descriptionOf(value))
      append("s>")
    } else if (value.isInstanceOf[Long]) {
      append('<')
      append(descriptionOf(value))
      append("L>")
    } else if (value.isInstanceOf[Float]) {
      append('<')
      append(descriptionOf(value))
      append("F>")
    } else if (value.getClass.isArray) {
      appendValueList("[", ", ", "]", new ArrayIterator(value))
    } else {
      append('<')
      append(descriptionOf(value))
      append('>')
    }
    this
  }

  private def descriptionOf(value: Any): String = try {
    String.valueOf(value)
  } catch {
    case e: Exception => {
      value.getClass.getName + "@" + Integer.toHexString(value.hashCode)
    }
  }

  /**
    * Append the String <var>str</var> to the description.
    * The default implementation passes every character to {@link #append(char)}.
    * Override in subclasses to provide an efficient implementation.
    */
  protected def append(str: String) {
    str.foreach(append(_))
  }

  /**
    * Append the char <var>c</var> to the description.
    */
  protected def append(c: Char)

  private def toJavaSyntax(unformatted: String) {
    append('"')
    unformatted.foreach(toJavaSyntax(_))
    append('"')
  }

  private def toJavaSyntax(ch: Char) {
    ch match {
      case '"'  => append("\\\"")
      case '\n' => append("\\n")
      case '\r' => append("\\r")
      case '\t' => append("\\t")
      case '\\' => append("\\\\")
      case _    => append(ch)
    }
  }

  /**
    * Appends a list of values to the description.
    */
  def appendValueList[T](start: String, separator: String, end: String, values: T*): Description =
    appendValueList(start, separator, end, Arrays.asList(values))

  /**
    * Appends a list of values to the description.
    */
  def appendValueList[T](start: String, separator: String, end: String, values: Iterable[T]): Description =
    appendValueList(start, separator, end, values.iterator)

  /**
    * Appends a list of {@link org.hamcrest.SelfDescribing} objects
    * to the description.
    */
  def appendList(start: String, separator: String, end: String, values: Iterable[_ <: SelfDescribing]): Description =
    appendList(start, separator, end, values.iterator)

  private def appendValueList[T](start: String, separator: String, end: String, values: Iterator[T]): Description =
    appendList(start, separator, end, new SelfDescribingValueIterator[T](values))

  private def appendList(start: String, separator: String, end: String, i: Iterator[_ <: SelfDescribing]): Description = {
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