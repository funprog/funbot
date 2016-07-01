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
