import net.logstash.logback.argument.StructuredArguments
import org.slf4j.LoggerFactory

object Example extends App {

  val logger = LoggerFactory.getLogger(getClass)

  logger.info("Hello, Logging with JSON!")

  logger.info("log message {}", StructuredArguments.value("name", Map(1 -> "a")))
}
