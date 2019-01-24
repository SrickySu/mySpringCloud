package myService1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MyService1Test.class})
public class MyService1Test {
	public static final Logger logger = LoggerFactory.getLogger(MyService1Test.class);
	
	@Test
	public void loggerTest() {
		String date1 = "2018-01-01";
		int records = 2;
		logger.info("test log date1 = {}, records = {}", date1, records);
	}

}
