package demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import whiteboard.WhiteboardController

@SpringBootApplication(scanBasePackageClasses = arrayOf(
    WhiteboardController::class
))
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
