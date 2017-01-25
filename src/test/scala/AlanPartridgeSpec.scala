//import com.test.AlanPartridge
import org.scalatest.{FlatSpec, Matchers, WordSpecLike, _}

class AlanPartridgeSpec extends WordSpecLike with Matchers {
  val minesAPint="Mines a pint"
  val stoodOnASpike="I've stood on a spike!"
  "Calling findWords" should {

    "return I've stood on a spike where an empty list is passed" in {
      AlanPartridge.findWords(List()) shouldBe stoodOnASpike
    }

    "return I've stood on a spike where an list with no matching words is passed" in {
      AlanPartridge.findWords(List("Cat","Dog","Lard")) shouldBe stoodOnASpike
    }
    "return I've stood on a spike where an list where a there is a matched word but captitalised" in {
      AlanPartridge.findWords(List("PARTRIDGE")) shouldBe stoodOnASpike
    }

    "return I've stood on a spike where an list where a there is a matched word but has a space" in {
      AlanPartridge.findWords(List(" Toblerone")) shouldBe stoodOnASpike
    }

    "return mines a pint! with one ! where an list with one matching words is passed" in {
      AlanPartridge.findWords(List("Dan")) shouldBe minesAPint + "!"
    }

    "return mines a pint! with one ! where an list with one matching words and some none matching words are passed" in {
      AlanPartridge.findWords(List("Cat","Dan","Lard")) shouldBe minesAPint + "!"
    }

    "return mines a pint!! with two !! where the same word occurs twice" in {
      AlanPartridge.findWords(List("Cat","Toblerone","Toblerone")) shouldBe minesAPint + "!!"
    }

    "return mines a pint!!!!!!! where a list with all matching words are passed" in {
      AlanPartridge.findWords(List("Pear Tree", "Chat","Dan","Toblerone","Lynn","Alpha Papa","Nomad")) shouldBe minesAPint + "!!!!!!!"
    }


    //    "return mines a pint! with two ! where an list with a matching words is passed but along with non strings" in {
//      AlanPartridge.aha(List("Ellen",12,"Andrew")) shouldBe minesAPint + "!!"
//    }
  }

  "Calling findWordsDistinct" should {
    "return I've stood on a spike where an empty list is passed" in {
      AlanPartridge.findWordsDistinct(List()) shouldBe stoodOnASpike
    }

    "return I've stood on a spike where an list with no matching words is passed" in {
      AlanPartridge.findWordsDistinct(List("Cat","Dog","Lard")) shouldBe stoodOnASpike
    }
    "return I've stood on a spike where an list where a there is a matched word but captitalised" in {
      AlanPartridge.findWordsDistinct(List("PARTRIDGE")) shouldBe stoodOnASpike
    }

    "return I've stood on a spike where an list where a there is a matched word but has a space" in {
      AlanPartridge.findWordsDistinct(List(" Toblerone")) shouldBe stoodOnASpike
    }
    "return mines a pint! with one ! where an list with one matching words is passed" in {
      AlanPartridge.findWordsDistinct(List("Cat","Dan","Lard")) shouldBe minesAPint + "!"
    }

    "return mines a pint! with where the same matching word occurs twice" in {
      AlanPartridge.findWordsDistinct(List("Cat","Toblerone","Toblerone")) shouldBe minesAPint + "!"
    }

    "return mines a pint!!!!!!! where a list with all matching words are passed" in {
      AlanPartridge.findWordsDistinct(List("Pear Tree", "Chat","Dan","Toblerone","Lynn","Alpha Papa","Nomad")) shouldBe minesAPint + "!!!!!!!"
    }
  }
}
