import org.json4s.Xml.toJson
import org.json4s.jackson.JsonMethods.{pretty, render}

import java.io.FileWriter
import scala.xml.XML.loadFile

object IS_measurements extends App {

    val airbase = loadFile("./src/resources/IS_meta.xml")
    val allStationIS = airbase \ "country" \ "network" \ "station"

    val stationAkureyriMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0008A:Akureyri Tryggvabraut")}
    // must optimize other station info making

     val stationHvanneyriMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0007A:Hvanneyri")}
     val stationKeldnaholt_ozoneMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0004A:Keldnaholt_ozone")}
     val stationMiklatorgOMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0003A:Miklatorg_svif")}
     val stationHvaleyrarholtMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002A:Hvaleyrarholt")}
     val stationIrafossMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002R:Irafoss")}
     val stationMiklatorgMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0001A:Miklatorg")}
     val stationGrensasMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0005A:Grensas")}
     val stationHusdyrargardurinnMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0006A:Husdyragardurinn")}

    val StationMC = stationAkureyriMC \\ "measurement_configuration"
    val StationMC2 = stationHvanneyriMC \\ "measurement_configuration"
    val StationMC3 = stationKeldnaholt_ozoneMC \\ "measurement_configuration"
    // must automatize naming formula


    val StToJson = toJson(StationMC)
    val StToJson2 = toJson(StationMC2)
    val StToJson3 = toJson(StationMC3)
      ....

    val SI = pretty(render(StToJson))
    val SI2 = pretty(render(StToJson2))
    val SI3 = pretty(render(StToJson3))
      ....

    println(SI)
    println(SI2)
    println(SI3)
      ...

    val destName = "./src/resources/Akureyri_Tryggvabraut_yearly.json"
    val destName2 = "./src/resources/Akureyri_Tryggvabraut_yearly.tsv"
    // must automatize naming formula

//    val destName = "./src/resources/Hvanneyri_yearly.json"
//    val destName2 = "./src/resources/Hvanneyri_yearly.tsv"
//     val destName = "./src/resources/Keldnaholt_ozone_yearly.json"
//     val destName2 = "./src/resources/Keldnaholt_ozone_yearly.tsv"
//    ....

    def saveSeq(destName:String, mySeq:Seq[Any]) = {
      val fw = new FileWriter(destName)
      mySeq.map(_.toString).foreach(fw.write)
      fw.close()
    }
    saveSeq(destName, StationMC)
    saveSeq(destName2, StationMC)
  }

