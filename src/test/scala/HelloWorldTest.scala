import org.scalatest.{FunSuite, Matchers}

class HelloWorldTest extends FunSuite with Matchers {
  test("Without name") {
    HelloWorld.hello() should be ("Hello, World!")
  }

  test("with name") {
    HelloWorld.hello("Jane") should be ("Hello, Jane!")
  }

  test("with umlaut name") {
    HelloWorld.hello("Jürgen") should be ("Hello, Jürgen!")
  }
}
