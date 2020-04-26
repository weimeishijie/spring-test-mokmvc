package com.text.mockmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SpringTestMockmvcApplication.class)
public class SpringTestMockmvcApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void contextLoads() throws Exception{
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/mock") //构建get方式来调用接口。
						.contentType(MediaType.APPLICATION_JSON_UTF8) //设置请求参数的类型
						.param("hello","world")// 构建请求参数
		        ).andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());

	}


}
