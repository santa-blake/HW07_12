import scala.xml.{Node, NodeSeq}
import scala.xml.XML.{loadFile, save}

object UsingXML_S extends App {

  val airbase = loadFile("./src/resources/IS_meta.xml") // built in xml loading AND parsing
  //  println(airbase)

  val countries = airbase \ "country"
  val country_name = for (country <- countries) yield (country \ "country_name").text
  println("Country observed:")
  country_name.foreach(println)
  //val countryName = (airbase \\ "country_name").map(it => it.text)
  //countryName.foreach(println)

  println("")

  println("Stations in this country:")
  val stations = airbase \ "station_info"
  //val station_name = for (station <- stations) yield (station \ "station_name").text
  val station_name = (airbase \\ "station_name").map(it => it.text)
  station_name.foreach(println)

  println("")

  def getStationInfoFromEl(el:Node): station = {
    new station {
      val station_european_code = (el \ "station_european_code").text.toInt
      val station_local_code = (el \ "station_local_code").text.toInt
      val station_name = (el \ "station_local_code").text
      val station_description = (el \ "station_description").text
    }
  }
  // val station1 = getStationInfoFromEl(stations(0))
  // print(station1)

  //deserialization of XML into our internal data forma
  def getStationList(stationNodes: NodeSeq): Seq[station] = {
    for (station <- stationNodes) yield getStationInfoFromEl(station)
  }

  val stationList = getStationList(stations)
  println("Station information in lists by each:")
  stationList.foreach(println)

  //println(stations(0))

  val stationDescription = for (station <- stations) yield station \ "station_description"
  stationDescription.foreach(println)


  //  dirPrices.foreach(println)
  //  val hp = (bookstore \ "books").filter(item => item.attribute.get("category") == "children")
  //  val hp = books.filter(_.attribute("category").contains("children"))

  val stationInfo = (airbase \\ "station_info").map(it => it.text)
  stationInfo.foreach(println)

//  val hp = (airbase \\ "country" filter {
//    _ \\ "@category" exists (_.text == "children")
//  }).text
//  //  println(hp)
//  val stationsNew = airbase \\ "country" filter {
//    _ \\ "@category" exists (_.text == "web")
// val stationsNew = airbase \\ "station_info" filter { _ \\ "@category" exists (_.text == "web")}
  //  //so we can save our book collection by adding some parent element for example root
  save("./src/resources/IS_new.xml", <root>{stationInfo}</root>, xmlDecl = true)
}


//  def getBookFromEl(el:Node): Book = {
//    new Book {
//      val category = (el \ "@category").text
//      val title = (el \ "title").text
//      val titleLang = (el \ "title" \ "@lang").text
//      val authors = (el \ "author").toList.map(_.text)
//      //avoid magic numbers define the defaults somewhere
//      val year = if ((el \ "year").isEmpty) 2048 else (el \ "year").text.toInt
//      val price = (el \ "price").text.toDouble
//    }
//  }
//  val book1 = getBookFromEl(countries(0))
//  println(book1)
//
//  //deserialization of XML into our internal data forma
//  def getBookList(bookNodes: NodeSeq): Seq[Book] = {
//    for (book <- bookNodes) yield getBookFromEl(book)
//  }
//  val bookList = getBookList(countries)
//  bookList.foreach(println)

//  //  println(books(0))
//  //  val prices = for (book <- books) yield book \ "price" //one way of extracting prices
//  val prices = for (book <- countries) yield (book \ "price").text.toDouble //one way of extracting prices
//  //  prices.foreach(println)
//  //below you are saying you want all prices you do not care for which element  they are
//  // so \\ is like a wildcard going as deep into XML as needed
//  // for huge XML this can take some time
//  val dirPrices = (airbase \\ "price").map(it => it.text.toDouble)
//  //  dirPrices.foreach(println)


  //  val hp = (bookstore \ "books").filter(item => item.attribute.get("category") == "children")
  //  val hp = books.filter(_.attribute("category").contains("children"))
  //  hp.foreach(println)
  //val hp = (airbase \\ "book" filter { _ \\ "@category" exists (_.text == "children")}).text
  //  println(hp)


  //  println(stationsNew)
  //  println(books.head.attribute("category"))
  //  println(books.head.attributes)
  //  val cat = books.head.attribute("category")
  //  println(cat)

  //  val myBook = new Book {
  //    val category = "childrens"
  //    val title = "Happy Potter"
  //    val titleLang = "en"
  //    val authors = List("J.K. Rowling","Richard Galbraith")
  //    val year = 1997
  //    val price = 19.95
  //  println(myBook.toXML)
  //  save("./src/resources/mybook.xml", myBook.toXML, xmlDecl = true)
