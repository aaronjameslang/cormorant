import com.aaronjameslang.cormorant._
import org.scalatest._

class OcrResultSpec extends FlatSpec with Matchers {

  "OcrResultBuilder" should "build from text"

  Map(
    "akh-14-gideon-of-the-trials" -> OcrResult( 14, 269, 'M', "AKH"),
    //"kld-67-torrential-gearhulk"  -> OcrResult( 67, 264, 'M', "KLD"),
    "xln-179-carnage-tyrant"      -> OcrResult(179, 279, 'M', "XLN"),
    "xln-268-swamp"               -> OcrResult(268, 279, 'L', "XLN")
  ) foreach {
    case (card, ocrResult) => testOcrResultFromText (card, ocrResult)
  }

  private def testOcrResultFromText(
    card: String,
    ocrResult: OcrResult
  ) = {
    it should "build " + card in {
      val txtFilepath = s"src/test/txt/$card.txt"
      val txt = io.Source.fromFile(txtFilepath).mkString
      OcrResultBuilder fromText (txt) should be (ocrResult)
    }
  }
}
