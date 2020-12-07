import org.json4s.Xml.toJson
import org.json4s.jackson.JsonMethods.{pretty, render}

import java.io.FileWriter
import scala.xml.XML.loadFile

object IS_stationInfo extends App {

  val airbase = loadFile("./src/resources/IS_meta.xml")
  val allStationIS = airbase \ "country" \ "network" \ "station"

  val stationAkureyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0008A:Akureyri Tryggvabraut")}
    // must optimize other station info making

    // val stationHvanneyri = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0007A:Hvanneyri")}
    // val stationKeldnaholt_ozone = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0004A:Keldnaholt_ozone")}
    // .....
 val StInfo = stationAkureyri \\ "station_info"
  // must automatize naming formula

//val StInfo = stationHvanneyri \\ "station_info"
// val StInfo = stationKeldnaholt_ozone \\ "station_info"
// ......

  val StToJson = toJson(StInfo)
  val SI = pretty(render(StToJson))
  println(SI)

  val destName = "./src/resources/Akureyri_Tryggvabraut_IS0008A_meta.json"
  // must automatize naming formula

//val destName = "./src/resources/Hvanneyri_IS0007A_meta.json"
// val destName = "./src/resources/Keldnaholt_ozone_IS0004A_meta.json"
// ......


  def saveSeq(destName:String, mySeq:Seq[Any]) = {
    val fw = new FileWriter(destName)
    mySeq.map(_.toString).foreach(fw.write)
    fw.close()
  }
    saveSeq(destName, SI)
  }
