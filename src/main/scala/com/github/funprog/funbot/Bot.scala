package com.github.funprog.funbot

trait Bot {
  def process(input: String): Option[String]
}
