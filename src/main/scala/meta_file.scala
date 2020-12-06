//import java.io.File
//import java.util
//import com.fasterxml.jackson.core
//import com.fasterxml.jackson.core.`type`.TypeReference
//
//type.TypeReference
//
//import com.fasterxml.jackson.databind.ObjectMapper
//  //import org.codehaus.jackson.map.ObjectMapper
//  //import org.codehaus.jackson.
//
//type.TypeReference
//
//import com.google.common.collect.ImmutableMap
//
//object meta_file extends App {
//    def main(args: Array[String]): Unit = {
//      try {
//        val mapper = new ObjectMapper
//        // read JSON from a file
//        val map_json1 = mapper.readValue(new File("./src/resources/Akureyri_Tryggvabraut_IS0008A_meta.json"), new TypeReference[util.Map[String, AnyRef]]() {})
//        val map_json2 = mapper.readValue(new File("./src/resources/Grensas_IS0005A_meta.json"), new TypeReference[util.Map[String, AnyRef]]() {})
//        //val map_json3 = mapper.readValue(new File("./src/resources/Akureyri_Tryggvabraut_IS0008A_meta.json"), new TypeReference[util.Map[String, AnyRef]]() {})
//
//        System.out.println(map_json1)
//        System.out.println(map_json2)
//        val map2 = map_json1.get("metadata").asInstanceOf[util.Map[String, AnyRef]]
//        var map_json3 = new util.HashMap[String, AnyRef]
//        map_json3 = mergeMyTwoMaps(map_json1.get("metadata").asInstanceOf[util.Map[String, AnyRef]], map_json2.get("metadata").asInstanceOf[util.Map[String, AnyRef]])
//        System.out.println(map_json3)
//      } catch {
//        case e: Exception =>
//          e.printStackTrace()
//      }
//    }
//
//    def mergeMyTwoMaps(map1: util.Map[String, AnyRef], map2: util.Map[String, AnyRef]): util.Map[String, AnyRef] = ImmutableMap.builder[String, Any].putAll(map1).putAll(map2).build
//}