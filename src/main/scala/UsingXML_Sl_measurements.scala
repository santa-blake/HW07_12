
import scala.xml.XML.loadFile

object UsingXML_Sl_measurements extends App {

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

  val stationAkureyriAllMeasurement = stationAkureyri \\ "measurement_configuration"
  val stationAkureyriAllMeasurementInfo = stationAkureyri \\ "measurement_info"

  // save("./src/resources/IS_stationAk_measurements.xml", <root> {stationAkureyriAllMeasurement}</root>, xmlDecl = true)

//  val pw2 = new PrintWriter(new File( "./src/resources/Akureyri_All_Measurement.json"))
//  pw2.write(write(stationAkureyriAllMeasurement, "./src/resources/Akureyri_All_Measurement1.json"))


  //val jsonAkureyri = toJson(stationAkureyriAllMeasurement)


        //  val stAkureyriAllMeasurementjson = toJson(stationAkureyriAllMeasurement)
        //  val j = pretty(render(stAkureyriAllMeasurementjson))
        //println(j)
        //
        //  val component_name = stationAkureyri \\ "measurement_configuration" \\ "component_name"
        //  val component_caption = stationAkureyri \\ "measurement_configuration" \\ "component_caption"
        //  val measurement_unit = stationAkureyri \\ "measurement_configuration" \\ "measurement_unit"
        //  val measurement_technique_principle = stationAkureyri \\ "measurement_configuration" \\ "measurement_technique_principle"
//  val stationAkureyriAllMeasurement = stationAkureyri \\ "measurement_configuration" \\ "
//  val stationAkureyriAllMeasurement = stationAkureyri \\ "measurement_configuration" \\ "

//  component_name\tcomponent_caption\measurement_unit\tmeasurement_technique_principle\tYear 2005 mean\tYear 2005 median(P50)\t All the years
//    Benzene (air)\tC6H6\tug/m3\tgas chromatography mass spectrometry (GC-MS)\t0.883\t0.700

  //override def toString = s"component_name:$component_name\tcomponent_caption:$component_caption\tmeasurement_unit:$measurement_unit\tmeasurement_technique_principle:$measurement_technique_principle"
  //scala.xml.XML.save("savedJSON.json", node, "UTF-8", true, null)
}

