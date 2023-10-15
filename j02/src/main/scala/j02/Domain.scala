package j02

object Domain {

  case class Pt(x: Int, y: Int) {
    def this(x: Double, y: Double) = this(x.toInt, y.toInt)

    def this(xy: Array[Int]) = this(xy(0), xy(1))
  }

}
