import scala.util.Random

class DiceBot(val random: Random) {
  require(random != null, "the 'random' value cannot be null.")

  private lazy val regex = """(?i)\s*roll\s+(\d+)d(\d+)\s*""".r

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
  def process(input: String): Option[String] =
    input match {
      case null =>
        throw new IllegalArgumentException(
          "the 'input' value cannot be null.")
      case regex(count, max) =>
        Some(makeOrderString(count.toInt, max.toInt))
      case _ =>
        None
    }

  private def makeOrderString(count: Int, max: Int) = {
    (1 to count)
      .map(_ => random.nextInt(max.toInt) + 1)
      .mkString(", ")
  }
}
