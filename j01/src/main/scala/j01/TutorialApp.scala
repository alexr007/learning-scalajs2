package j01

import org.scalajs.dom
import org.scalajs.dom.document

object TutorialApp {

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def setupUI() = {

    /** print to console */
    println("Hello world!")

    /** attach button */
    val button = document.createElement("button")
    button.textContent = "Click me!"
    document.body.appendChild(button)

    /** add listener */
    button.addEventListener(
      "click",
      { e: dom.MouseEvent =>
        addClickedMessage()
      },
    )

    /** add tag <p> */
    appendPar(document.body, "HELLO")
  }

  def main(args: Array[String]): Unit =
    document.addEventListener(
      "DOMContentLoaded",
      { (e: dom.Event) =>
        setupUI()
      },
    )

}
