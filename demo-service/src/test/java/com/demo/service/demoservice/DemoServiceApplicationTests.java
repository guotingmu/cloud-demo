package com.demo.service.demoservice;


import com.demo.api.demoapi.service.TestService;
import com.demo.service.demoservice.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceApplicationTests {

	@Autowired
	TestService mapper;

	@Test
	public void contextLoads() {
		mapper.test();
	}

}
