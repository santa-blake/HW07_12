import ISstationCoordinates.{SIrLatitude, SIrLongitude}

object stationCoordin {
    def FindPoint(x1: Double, y1: Double, x2: Double, y2: Double, x: Double, y: Double): Boolean = {
      if (x > x1 && x < x2 && y > y1 && y < y2) return true
      false

  // ICELAND coordinates extent (Wikipedia):
  // North: Kolbeinsey, 67°08,9 N
  //South: Surtsey, 63°17,7 N
  //West: Bjargtangar, 24°32′1" W
  //East: Hvalbakur, 13°16,6 W

    def main(args: Array[String]): Unit = {
      val x1 = 63.177 //South
      val y1 = 13.166 //East
      val x2 = 67.089 //North
      val y2 = 24.321 //West

      val x = SIrLatitude
      val y = SIrLongitude // MISTAKE!!!! in data - regaring to wikipedia all coordinates in Iceland are positive nummbers [re-checked with google.maps]

      if (FindPoint(x1, y1, x2, y2, x, y)) System.out.println("Yes")
      else System.out.println("No")
    }
  }
