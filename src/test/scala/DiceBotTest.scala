import org.scalatest.FunSuite
import scala.util.Random

class DiceBotTest extends FunSuite {
  test("constructor with null random throws") {
    val thrown = intercept[IllegalArgumentException](new DiceBot(null))
    assert(thrown != null)
  }

  test("process with null input throws") {
    val thrown = intercept[IllegalArgumentException](
      new DiceBot().process(null))
    assert(thrown != null)
  }

  Seq(
    "invalid string",
    "",
    "roll 1d").foreach(x => {
    test(s"process with invalid input '$x' returns none.") {
      val expected = None
      val sut = new DiceBot()

      val actual = sut.process(x)

      assert(expected == actual)
    }
  })

  Seq(
    "roll 1d1",
    "roll 2d1",
    "roll 20000d11232",
    "roll    2d1",
    "  roll \t  2d1  ",
    "  \r\n roll \r\n\t  2d1 \r\n ").foreach(x => {
    test(s"process with valid input '$x' returns some.") {
      val sut = new DiceBot()
      val actual = sut.process(x)
      assert(classOf[Some[String]] == actual.getClass)
    }
  })

  Seq(
    ("roll 1d1", "1"),
    ("RoLl 1d1", "1"),
    ("roLL 1D1", "1")).foreach{ case (rawInput, result) => {
    test(s"process with input '${rawInput}' returns correct result '${result}'.") {
      val expected = Some(result)
      val sut = new DiceBot()

      val actual = sut.process(rawInput)

      assert(expected == actual)
    }
  }}

  test("process returns correct result.") {
    // Fixture setup
    val random = new Random(1)

    val sut = new DiceBot(new Random(1))

    val orderString: String =
      (1 to 3)
        .map(_ => random.nextInt(100) + 1)
        .mkString(", ")

    val expected = Some(orderString)

    // Exercise system
    val actual = sut.process("roll 3d100")

    // Verify outcome
    assert(expected == actual)
  }
}
