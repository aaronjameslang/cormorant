package com.aaronjameslang.cormorant

case class OcrResult (
  cardNumber: Int,
  setSize: Int,
  typeInitial: Char,
  setAcronym: String
)

object OcrResultBuilder{

  def fromText(text: String): OcrResult = {
    val regex = raw"(\d{3})\/(\d{3}) (\w).*\n(\w{3})".r.unanchored

    text match {
      case regex(
        cardNumber,
        setSize,
        typeInitial,
        setAcronym
      ) => OcrResult(
        cardNumber.toInt,
        setSize.toInt,
        typeInitial(0),
        setAcronym
      )
    }
  }

}
