package com.macrosoft.gestionboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
/**

By default, @SpringBootTest does not start the server. 
@SpringBootTest(classes = DemoApplication.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT), an available port is picked at random each time your test runs.
**/
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
