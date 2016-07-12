class CompositeBot(val bots: Bot*) extends Bot {
  override def process(input: String): Option[String] =
    bots.toStream.map(x => x.process(input))
        .find(x => x != None) match {
      case Some(result) => result
      case None => None
    }
}
