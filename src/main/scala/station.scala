abstract class station {
  val station_european_code: Int
  val station_local_code: Int
  val station_name: String
  val station_description: String
  val station_start_date: String
  val station_latitude_decimal_degrees: String
  val station_longitude_decimal_degrees: String
  val station_latitude_dms: String
  val station_longitude_dms: String
  val station_altitude: String
  val type_of_station: String
  val station_type_of_area: String
  val station_characteristic_of_zone: String
  val main_emission_source: String
  val station_area_of_representativeness: String
  val station_city: String
  val population: String
  val street_name: String
  val street_type: String
  val number_of_vehicles: String
  val station_lorry_percentage: String
  val station_traffic_speed: String
  val station_street_width: String
  val monitoring_obj: String
  val meteorological_parameter: String

  override def toString = s" $station_european_code $station_local_code in $station_name."


//  def getAuthorSeq() =
//    for (author <- authors) yield <author>{author}</author>
//
//  def toXML = <book category="children">
//    <title lang="en">{title}</title>
//    {getAuthorSeq()}
//    <year>{year}</year>
//    <price>{price}</price>
//  </book>
}
