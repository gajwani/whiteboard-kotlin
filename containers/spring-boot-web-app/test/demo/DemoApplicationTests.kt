package demo

import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired private lateinit var context: WebApplicationContext

	@Test
	fun `GET home endpoint shows a list of whiteboards`() {
		val client = MockMvcBuilders.webAppContextSetup(context).build()
		client.perform(get("/"))
				.andExpect(status().is2xxSuccessful)
				.andExpect(jsonPath("whiteboards", Matchers.hasSize<Any>(2)))
				.andExpect(jsonPath("whiteboards[0].id", Matchers.notNullValue()))
				.andExpect(jsonPath("whiteboards[0].name", Matchers.`is`("The First WhiteboardController")))
				.andExpect(jsonPath("whiteboards[1].id", Matchers.notNullValue()))
				.andExpect(jsonPath("whiteboards[1].name", Matchers.`is`("WhiteboardController Numba Two")))
	}

}
