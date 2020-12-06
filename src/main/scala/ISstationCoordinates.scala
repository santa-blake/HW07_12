import scala.xml.XML.loadFile

object ISstationCoordinates extends App{

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

}

