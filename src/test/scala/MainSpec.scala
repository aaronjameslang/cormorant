import com.aaronjameslang.cormorant.Main
import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

  List(
    "akh-14-gideon-of-the-trials",
    "kld-67-torrential-gearhulk",
    "xln-179-carnage-tyrant",
    "xln-268-swamp"
  ) foreach testTextFromImage

  private def testTextFromImage(card: String) = {
    it should "recognise text from image " + card in {
      val imgFilepath = s"src/test/img/$card.jpg"
      val txtFilepath = s"src/test/txt/$card.txt"
      val txt = io.Source.fromFile(txtFilepath).mkString
      Main textFromImage imgFilepath should be (txt)
    }
  }
}
