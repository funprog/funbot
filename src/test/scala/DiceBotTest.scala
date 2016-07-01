import org.scalatest.FunSuite
import scala.util.Random

class DiceBotTest extends FunSuite {
  test("constructor with null random throws") {
    val thrown = intercept[IllegalArgumentException] (new DiceBot(null))
    assert(thrown != null)
  }

  test("random is correct when initialized with default constructor.") {
    val sut = new DiceBot()
    val actual = sut.random
    assert(classOf[Random] == actual.getClass)
  }

  test("random is correct when initialized with a random.") {
    val expected = new Random()
    val sut = new DiceBot(expected)

    val actual = sut.random

    assert(expected == actual)
  }

  test("process with null input throws") {
    val thrown = intercept[IllegalArgumentException] (
      new DiceBot().process(null))
    assert(thrown != null)
  }

  Seq(
    "invalid string",
    "").foreach(x => {
    test(s"process with invalid input '$x' returns none.") {
      val expected = None
      val sut = new DiceBot()

      val actual = sut.process(x)

      assert(expected == actual)
    }
  })

  Seq(
    ("1d1", "1")).foreach(x => {
    test(s"process with input '${x._1}' returns correct result '${x._2}'.") {
      val expected = Some(x._2)
      val sut = new DiceBot()

      val actual = sut.process(x._1)
      assert(expected == actual)
    }
  })
}
