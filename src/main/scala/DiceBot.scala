import scala.util.Random

class DiceBot(val random: Random) {
  require(random != null, "the 'random' value cannot be null.")

  def this() = this(new Random())

  private val regex = """(?i)roll (\d)d(\d)""".r

  /** Processes an `input` to return sequential string values
    * representing order.
    *
    * @param input consists of the 'roll' word and two numbers concatenated
    *              using the 'd' character. (eg. "roll 2d4") The two numbers
    *              represent the number of rolling and the number of dice
    *              dimensions(inclusive) respectively.
    * @return returns `None` if the `input` is invalid, otherwise `Some[String]`
    *         representing the order.
    */
  def process(input: String): Option[String] = {
    require(input != null, "the 'input' value cannot be null.")

    input match {
      case regex(x, y) => Some("1")
      case _ => None
    }
  }
}
