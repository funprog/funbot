object DiceBot {
  /** Processes an `input` to return sequential string values
    * representing order.
    *
    * @param input consists of two numbers concatenated using the 'd' character.
    *              (eg. "2d4") The two numbers represent the number of
    *              rolling and the number of dice dimensions(inclusive)
    *              respectively.
    * @return returns `None` if the `input` is invalid, otherwise `Some[String]`
    *         representing the order.
    */
  def process(input: String): Option[String] = None
}
