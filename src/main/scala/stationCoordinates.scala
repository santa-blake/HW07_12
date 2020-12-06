import scala.xml.XML.loadFile

object stationCoordinates {

    val airbase = loadFile("./src/resources/IS_meta.xml")
    val allStationIS = airbase \ "country" \ "network" \ "station"

    //   val stationAkureyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0008A:Akureyri Tryggvabraut")}
    //   val stationHvanneyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0007A:Hvanneyri")}
    //   val stationKeldnaholt_ozone = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0004A:Keldnaholt_ozone")}
    //   val stationMiklatorgO = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0003A:Miklatorg_svif")}
    //   val stationHvaleyrarholt = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002A:Hvaleyrarholt")}
    val stationIrafoss = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002R:Irafoss")}
    //   val stationMiklatorg = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0001A:Miklatorg")}
    //   val stationGrensas = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0005A:Grensas")}
    //   val stationHusdyrargardurinn = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0006A:Husdyragardurinn")}

    val SIrLatitude = (stationIrafoss \\ "station_latitude_decimal_degrees").text.toDouble
    val SIrLongitude = (stationIrafoss \\ "station_longitude_decimal_degrees").text.toDouble
    println(SIrLatitude)
    println(SIrLongitude)

    //  val SAkLatitude = (stationAkureyri \\ "station_latitude_decimal_degrees").text
    //  val SAkLongitude = (stationAkureyri \\ "station_longitude_decimal_degrees").text
    //  val SAkLatitude = (stationAkureyri \\ "station_latitude_decimal_degrees").text
    //  val SAkLongitude = (stationAkureyri \\ "station_longitude_decimal_degrees").text
    //  val SAkLatitude = (stationAkureyri \\ "station_latitude_decimal_degrees").text
    //  val SAkLongitude = (stationAkureyri \\ "station_longitude_decimal_degrees").text
    //  val SAkLatitude = (stationAkureyri \\ "station_latitude_decimal_degrees").text
    //  val SAkLongitude = (stationAkureyri \\ "station_longitude_decimal_degrees").text
    //  val SAkLatitude = (stationAkureyri \\ "station_latitude_decimal_degrees").text
    //  val SAkLongitude = (stationAkureyri \\ "station_longitude_decimal_degrees").text
    //  val SAkLatitude = (stationAkureyri \\ "station_latitude_decimal_degrees").text
    //  val SAkLongitude = (stationAkureyri \\ "station_longitude_decimal_degrees").text


  def FindPoint(x1: Double, y1: Double, x2: Double, y2: Double, x: Double, y: Double): Boolean = {
      if (x > x1 && x < x2 && y < y1 && y > y2) return true
      false
    }

  // ICELAND coordinates extent (Wikipedia):
      //North: Kolbeinsey, 67°08,9 N
      //South: Surtsey, 63°17,7 N
      //West: Bjargtangar, 24°32′1" W
      //East: Hvalbakur, 13°16,6 W

    def main(args: Array[String]): Unit = {
      val x1 = 63.177 //South
      val y1 = -13.166 //East
      val x2 = 67.089 //North
      val y2 = -24.321 //West

      val x = SIrLatitude
      val y = SIrLongitude

      if (FindPoint(x1, y1, x2, y2, x, y)) System.out.println("Yes")
      else System.out.println("No")
    }
  }
