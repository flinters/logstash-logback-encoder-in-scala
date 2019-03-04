import net.logstash.logback.marker.LogstashMarker
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

object Example extends App {

  val logger = LoggerFactory.getLogger(getClass)

  // ふつうのログ
  logger.info("Hello, Logging with JSON!")

  println("\n=== StructuredArguments ===================================================\n")

  // StructuredArgument で動的にフィールドを追加
  import net.logstash.logback.argument.StructuredArguments._
  logger.info("StructuredArguments.value {}", value("KEY", "VALUE"))
  logger.info("StructuredArguments.keyValue {}", keyValue("KEY", "VALUE"))
  logger.info("StructuredArguments.entries {}", entries(Map("k1" -> "v1", "k2" -> "v2").asJava))
  logger.info("StructuredArguments.array {}", array("array", "a", "b", "c"))
  logger.info("StructuredArguments.raw {}", raw("raw", """{"KEY":"VALUE"}"""))

  println("\n=== Markers ===================================================\n")

  // Marker で動的にフィールドを追加
  import net.logstash.logback.marker.Markers._
  logger.info(append("KEY", "VALUE"), "Markers.append")
  logger.info(appendEntries(Map("k1" -> "v1", "k2" -> "v2").asJava), "Markers.appendEntries")
  logger.info(appendArray("array", "a", "b", "c"), "Markers.appendArray")
  logger.info(appendRaw("raw", """{"KEY":"VALUE"}"""), "Markers.appendRaw")

  val marker: LogstashMarker =
    append("KEY_A", "VALUE_A").and(append("KEY_B", "VALUE_B"))
  logger.info(marker, "multiple markers")

}
