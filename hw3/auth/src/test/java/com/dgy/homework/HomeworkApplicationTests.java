package com.dgy.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class HomeworkApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}

	@Test
	@WithAnonymousUser
	public void queryActuatorAsAnonymousUserShouldBeRedirected() throws Exception{
		RequestBuilder req = null;

		req = MockMvcRequestBuilders.get("/actuator");
		mvc.perform(req)
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}

	@Test
	@WithMockUser(username="test",password="123")
	public void queryActuatorAsNonadminAccountShouldBeForbidden() throws Exception{
		RequestBuilder req = null;

		req = MockMvcRequestBuilders.get("/actuator");
		mvc.perform(req)
				.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
	
	@Test
	@WithMockUser(username="admin",password="123",authorities="SUPER_ADMIN")
	public void queryActuatorAsAdminShouldBeOK() throws Exception{
		RequestBuilder req = null;

		req = MockMvcRequestBuilders.get("/actuator");
		mvc.perform(req)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@WithMockUser(username="admin",password="123",authorities="SUPER_ADMIN")
	public void checkActuatorHealth() throws Exception{
		RequestBuilder req;
		MvcResult res;	

		req = MockMvcRequestBuilders.get("/actuator/health");
		res = mvc.perform(req).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		Assert.assertEquals("Status: UP", res.getResponse().getContentAsString(), "{\"status\":\"UP\"}");
	}

	@Test
	@WithMockUser(username="admin",password="123",authorities="SUPER_ADMIN")
	public void checkActuatorInfo() throws Exception{
		RequestBuilder req;
		MvcResult res;

		req = MockMvcRequestBuilders.get("/actuator/info");
		res = mvc.perform(req).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		Assert.assertEquals("Status: UP", res.getResponse().getContentAsString(), "{\"app\":{\"name\":\"wordLadder_java\",\"version\":\"1.0.0\"}}");
	}


}
