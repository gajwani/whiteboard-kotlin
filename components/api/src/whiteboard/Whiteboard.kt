package whiteboard

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Whiteboard {

    @RequestMapping("/")
    fun home(): ResponseEntity<Object> {
        return ResponseEntity(HttpStatus.OK)
    }
}
