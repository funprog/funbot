import org.scalatest.FunSuite

class DiceBotTest extends FunSuite {
  Seq(
    "invalid string",
    null,
    "").foreach(x => {
    test(s"process with invalid input '$x' returns none.") {
      val expected = None
      val sut = new DiceBot()

      val actual = sut.process("invalid string")

      assert(expected == actual)
    }
  })
}