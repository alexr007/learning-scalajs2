package j02

import j02.Domain.Pt
import org.scalajs.dom
import org.scalajs.dom.html.Canvas

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

/** to make it working, wee need to include resulted `js`` into `html`:
  * {{{
  * <script
  *   type="text/javascript"
  *   src="./target/scala-2.13/j02-fastopt/main.js">
  * </script>
  * }}}
  * and call it
  * {{{
  * <script>
  *   app.run()
  * </script>
  * }}}
  */
@JSExportTopLevel("app")
object PolygonApp {

  @JSExport
  def run(): Unit = {
    val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
    canvas.width = 2560
    canvas.height = 1400
    dom.document.body.appendChild(canvas)
    paint(canvas)
  }

  def paint(canvas: Canvas): Unit = {
    val ctx = canvas
      .getContext("2d")
      .asInstanceOf[dom.CanvasRenderingContext2D]

    val pointsUnsorted = Data.points
    val pointsNormFn: (Int, Int) => Seq[Pt] = Implementation.normalize(pointsUnsorted)

    pointsNormFn(canvas.width, canvas.height) match {
      case h :: ts =>
        ctx.beginPath()
        ctx.moveTo(h.x, h.y)
        ts.foreach { p => ctx.lineTo(p.x, p.y) }
        ctx.lineTo(h.x, h.y)
        ctx.stroke()
    }
  }
}
