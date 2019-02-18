import net.logstash.logback.argument.StructuredArguments
import net.logstash.logback.marker.Markers
import org.slf4j.LoggerFactory

object Example extends App {

  val logger = LoggerFactory.getLogger(getClass)

  // ふつうのログ
  logger.info("Hello, Logging with JSON!")

  // StructuredArgument で動的にフィールドを追加
  logger.info("log message {}", StructuredArguments.value("name", Map(1 -> "a")))

  // Marker で動的にフィールドを追加
  logger.info(Markers.append("marker", "mkr"), "Marker")
}
