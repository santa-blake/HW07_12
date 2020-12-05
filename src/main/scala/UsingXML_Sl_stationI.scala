import org.json4s.Xml.toJson
  import org.json4s.jackson.JsonMethods.{pretty, render}

  import scala.xml.XML.loadFile

object UsingXML_Sl_stationI extends App {

  val airbase = loadFile("./src/resources/IS_meta.xml")
  val allStationIS = airbase \ "country" \ "network" \ "station"

  val stationAkureyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0008A:Akureyri Tryggvabraut")}
    //  val stationHvanneyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0007A:Hvanneyri")}
    //  val stationKeldnaholt = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0004A:Keldnaholt_ozone")}
    //  val stationMiklatorgO = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0003A:Miklatorg_svif")}
    //  val stationHvaleyrarholt = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002A:Hvaleyrarholt")}
    //  val stationIrafoss = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002R:Irafoss")}
    //  val stationMiklatorg = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0001A:Miklatorg")}
    //  val stationGrensas = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0005A:Grensas")}
    //  val stationHusdyrargardurinn = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0006A:Husdyragardurinn")}

  val stationAkureyriStInfo = stationAkureyri \\ "station_info"
  val stAkureyriAllMeasurementjson = toJson(stationAkureyriStInfo)
  val SI = pretty(render(stAkureyriAllMeasurementjson))
  println(SI)
  }
