abstract class measurements {
  val statistic_set: String
  val statistic_name: String
  val statistic_result_shortname: String
  val statistic_value: Int

  override def toString = s"In \n $statistic_name \n  ($statistic_result_shortname) - \n Result measurement: $statistic_value."
}
