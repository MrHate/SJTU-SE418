package com.dgy.homework;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithAnonymousUser;

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
	public void ladderFromDogToCat() {
		//[cat, cag, cog, dog];
		ArrayList<String> answer = new ArrayList(); 
		answer.add("cat");
		answer.add("cag");
		answer.add("cog");
		answer.add("dog");
		ArrayList<String> result = Ladder.run("dog","cat");
		Assert.assertEquals(answer,result);
	}

	@Test
	public void ladderFromBallToHack(){
		//[hack, back, balk, ball]
		ArrayList<String> answer = new ArrayList(); 
		answer.add("hack");
		answer.add("back");
		answer.add("balk");
		answer.add("ball");
		ArrayList<String> result = Ladder.run("ball","hack");
		Assert.assertEquals(answer,result);
	}

	@Test
	public void restLadderFromDogToCat() throws Exception{
		RequestBuilder req = null;

		req = MockMvcRequestBuilders.get("/ladder/dog&cat");
		mvc.perform(req)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[\"cat\",\"cag\",\"cog\",\"dog\"]"));
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
	@WithMockUser(username="salaboy",password="123")
	public void queryActuatorAsSalaboyShouldBeForbidden() throws Exception{
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
