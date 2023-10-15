package j02

object Implementation {

  import Domain.Pt
  import scala.math.atan2
  import scala.math.max
  import scala.math.min
  import scala.math.toDegrees

  def centroid(pts: List[Pt]): Pt = {
    val len = pts.length
    val (sumx, sumy) = pts.foldLeft((0.toDouble, 0.toDouble))((a, p) => (a._1 + p.x, a._2 + p.y))
    new Pt(sumx / len, sumy / len)
  }

  def sortPoints(pts: List[Pt]): List[Pt] = {
    def angle(dx: Double, dy: Double) = (toDegrees(atan2(dx, dy)) + 360) % 360
    def anglePt(a: Pt, c: Pt) = angle(a.x - c.x, a.y - c.y)
    val c = centroid(pts)
    pts.sortWith { (a, b) => anglePt(a, c) < anglePt(b, c) }
  }

  def normalize(pts: Seq[Pt])(width: Int, height: Int) = {
    val (minx, miny, maxx, maxy) = pts.foldLeft(
      (
        Double.MaxValue,
        Double.MaxValue,
        Double.MinPositiveValue,
        Double.MinPositiveValue
      )
    ) { (acc, pt) =>
      (
        min(acc._1, pt.x),
        min(acc._2, pt.y),
        max(acc._3, pt.x),
        max(acc._4, pt.y)
      )
    }
    val (dx, dy) = (maxx - minx, maxy - miny)
    val scale = min(width / dx, height / dy)

    val normalize1 = (offset: Double) => (x: Int) => (x - offset) * scale
    val normx = normalize1(minx)
    val normy = normalize1(miny)
    val scaled = pts map { p => new Pt(normx(p.x), normy(p.y)) }
    scaled
  }

}
