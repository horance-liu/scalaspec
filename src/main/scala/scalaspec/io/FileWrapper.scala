package scalaspec.io

import java.io.File

class FileWrapper(val file: File) {
  def /(child: String) = new FileWrapper(new File(file, child))
  override def toString = file.getCanonicalPath
}

object FileWrapper {
  implicit def wrap(file : File): FileWrapper = new FileWrapper(file)
  implicit def unwrap(wrapper: FileWrapper): File = wrapper.file
}
