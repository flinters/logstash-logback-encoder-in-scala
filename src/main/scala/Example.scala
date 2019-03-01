import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

object Example extends App {

  val logger = LoggerFactory.getLogger(getClass)

  // ふつうのログ
  logger.info("Hello, Logging with JSON!")

  // StructuredArgument で動的にフィールドを追加
  import net.logstash.logback.argument.StructuredArguments._
  logger.info("StructuredArguments.value {}", value("KEY", "VALUE"))
  logger.info("StructuredArguments.keyValue {}", keyValue("KEY", "VALUE"))
  logger.info("StructuredArguments.entries {}", entries(Map("k1" -> "v1", "k2" -> "v2").asJava))
  logger.info("StructuredArguments.array {}", array("array", "a", "b", "c"))
  logger.info("StructuredArguments.raw {}", raw("raw", """{"KEY":"VALUE"}"""))

  // Marker で動的にフィールドを追加
  import net.logstash.logback.marker.Markers._
  logger.info(append("marker", "mkr"), "Markers.append")
}
