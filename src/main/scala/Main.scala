package com.aaronjameslang.cormorant

import java.io.File
import net.sourceforge.tess4j.Tesseract

object Main extends App {
  println("Hello, World!")

  def textFromImage(filepath: String): String =
    new Tesseract().doOCR(new File(filepath))
}
