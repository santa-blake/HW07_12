import scala.xml.XML.loadFile
import scala.xml.{Node, NodeSeq}

object IS_measurements_showed_in_text_format extends App {

    val airbase = loadFile("./src/resources/IS_meta.xml")
    val allStationIS = airbase \ "country" \ "network" \ "station"

    val stationAkureyriMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0008A:Akureyri Tryggvabraut")}
    // must optimize other station info making

//     val stationHvanneyriMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0007A:Hvanneyri")}
//     val stationKeldnaholt_ozoneMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0004A:Keldnaholt_ozone")}
//     val stationMiklatorgOMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0003A:Miklatorg_svif")}
//     val stationHvaleyrarholtMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002A:Hvaleyrarholt")}
//     val stationIrafossMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0002R:Irafoss")}
//     val stationMiklatorgMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0001A:Miklatorg")}
//     val stationGrensasMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0005A:Grensas")}
//     val stationHusdyrargardurinnMC = allStationIS.filter { _ \\ "@Id" exists (_.text == "IS0006A:Husdyragardurinn")}

    val StationMC = stationAkureyriMC \\ "measurement_configuration"
    // must automatize naming formula
//    val StationMC2 = stationHvanneyriMC \\ "measurement_configuration"
//    val StationMC3 = stationKeldnaholt_ozoneMC \\ "measurement_configuration"

    val MI = stationAkureyriMC \\ "measurement_configuration" \\ "statistic_set"

   MI.foreach { el =>
    val setType = (el \\ "@type").text
    val ST_Name = (el \\ "statistic_name").text
    val ST_resultSN  = (el \\ "statistic_result_shortname").text
    val ST_value  = (el \\ "statistic_value").text
    println( s"In year 2006 at station Akureyri (Iceland) \n $setType type shows: \n Statistic result - $ST_Name \n with shortname ($ST_resultSN) - \n Result measurement(s) are: $ST_value.")
     // should include regex use to sort out result numbers and format consecutive values
     // statistic_result_shortname fails to read - Int type version did not work also
   }

  def getMeasureInfoFromEl(el:Node): measurements = {
    new measurements {
      val statistic_set: String = (el \ "statistic_set").text
      val statistic_name: String = (el \ "statistic name").text
      val statistic_result_shortname: String = (el \ "statistic_result_shortname").text
      val statistic_value: Int = (el \ "station_description").text.toInt
    }
  }

  def getMeasurements(MeasureNodes: NodeSeq): Seq[measurements] = {
    for (measurements <- MeasureNodes) yield getMeasureInfoFromEl(measurements)
  }

  }

