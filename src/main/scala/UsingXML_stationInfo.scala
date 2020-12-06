import org.json4s.Xml.toJson
import org.json4s.jackson.JsonMethods.{pretty, render}

import java.io.FileWriter
import scala.xml.XML.loadFile

object UsingXML_stationInfo extends App {

  val airbase = loadFile("./src/resources/IS_meta.xml")
  val allStationIS = airbase \ "country" \ "network" \ "station"

  val stationAkureyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0008A:Akureyri Tryggvabraut")}
    // must optimize other station info making

    // val stationHvanneyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0007A:Hvanneyri")}
    // val stationKeldnaholt_ozone = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0004A:Keldnaholt_ozone")}
    // val stationMiklatorgO = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0003A:Miklatorg_svif")}
    // val stationHvaleyrarholt = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002A:Hvaleyrarholt")}
    // val stationIrafoss = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002R:Irafoss")}
    // val stationMiklatorg = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0001A:Miklatorg")}
    // val stationGrensas = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0005A:Grensas")}
    // val stationHusdyrargardurinn = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0006A:Husdyragardurinn")}

 val StInfo = stationAkureyri \\ "station_info"
  // must automatize naming formula

//val StInfo = stationHvanneyri \\ "station_info"
// val StInfo = stationKeldnaholt_ozone \\ "station_info"
// val StInfo = stationMiklatorgO \\ "station_info"
// val StInfo = stationHvaleyrarholt \\ "station_info"
// val StInfo = stationIrafoss \\ "station_info"
// val StInfo = stationMiklatorg \\ "station_info"
// val StInfo = stationGrensas \\ "station_info"
// val StInfo = stationHusdyrargardurinn \\ "station_info"

  val StToJson = toJson(StInfo)
  val SI = pretty(render(StToJson))
  println(SI)

  val destName = "./src/resources/Akureyri_Tryggvabraut_IS0008A_meta.json"
  // must automatize naming formula

//val destName = "./src/resources/Hvanneyri_IS0007A_meta.json"
// val destName = "./src/resources/Keldnaholt_ozone_IS0004A_meta.json"
// val destName = "./src/resources/Miklatorg_svif_IS0003A_meta.json"
// val destName = "./src/resources/Hvaleyrarholt_IS0002A_meta.json"
// val destName = "./src/resources/Irafoss_IS0002R_meta.json"
// val destName = "./src/resources/Miklatorg_IS0001A_meta.json"
// val destName = "./src/resources/Grensas_IS0005A_meta.json"
// val destName = "./src/resources/Husdyragardurinn_IS0006A_meta.json"


  def saveSeq(destName:String, mySeq:Seq[Any]) = {
    val fw = new FileWriter(destName)
    mySeq.map(_.toString).foreach(fw.write)
    fw.close()
  }
    saveSeq(destName, SI)
  }
