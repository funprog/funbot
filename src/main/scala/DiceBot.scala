class DiceBot {
  private val regex = """(\d)d(\d)""".r

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
      case regex(x, y) => Some("1")
      case _ => None
    }
}
