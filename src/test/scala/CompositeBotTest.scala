import org.scalatest.FunSuite

class CompositeBotTest extends FunSuite {
  test("sut is Bot.") {
    val sut = new CompositeBot
    assert(sut.isInstanceOf[Bot])
  }

  test("process returns None when all bots return None.") {
    val bot1 = new DelegatingBot
    val bot2 = new DelegatingBot
    val bot3 = new DelegatingBot
    bot1.onProcess = _ => None
    bot2.onProcess = _ => None
    bot3.onProcess = _ => None
    val sut = new CompositeBot(bot1, bot2, bot3)

    val actual = sut.process("dummy")

    assert(None == actual)
  }

  test("process returns first result from bots.") {
    val input = "input"
    val expected = Some("result")
    val bot1 = new DelegatingBot
    val bot2 = new DelegatingBot
    val bot3 = new DelegatingBot
    bot1.onProcess = _ => None
    bot2.onProcess = x => {
      assert(x == input)
      expected
    }
    bot3.onProcess = _ => throw new Exception
    val sut = new CompositeBot(bot1, bot2, bot3)

    val actual = sut.process(input)

    assert(expected == actual)
  }

  class DelegatingBot extends Bot{
    var onProcess: String => Option[String] = null

    override def process(input: String): Option[String] = onProcess(input)
  }
}
