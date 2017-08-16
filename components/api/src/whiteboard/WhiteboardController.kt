package whiteboard

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WhiteboardController {

    @RequestMapping("/")
    fun home(): ResponseEntity<List<Whiteboard>> {
        val listWhiteboardsUseCase = ListWhiteboardsUseCase()
        val whiteboardsList = listWhiteboardsUseCase.execute()

        return ResponseEntity(whiteboardsList, HttpStatus.OK)
    }

}

class ListWhiteboardsUseCase {
    fun execute(): WhiteboardListResponse { return listOf() }

}

class Whiteboard {

}
