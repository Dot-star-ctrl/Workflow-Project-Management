package workflow.microservices.core;

import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"eureka.client.enabled=false"})
class ProjectServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}

}
