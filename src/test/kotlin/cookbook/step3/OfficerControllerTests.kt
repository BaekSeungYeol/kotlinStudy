package cookbook.step3

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class OfficerControllerTests {

    @Autowired
    lateinit var client: WebTestClient

    // @Autowired
    // lateinit var repository: OfficerRepository


}