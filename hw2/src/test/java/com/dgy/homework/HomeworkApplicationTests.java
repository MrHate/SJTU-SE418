package com.dgy.homework;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new LadderController()).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void ladderTest_1() {
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
	public void restTest() throws Exception{
		RequestBuilder req = null;

		req = MockMvcRequestBuilders.get("/ladder/dog&cat");
		mvc.perform(req)
				.andExpect(status().isOk())
				.andExpect(content().string("[\"cat\",\"cag\",\"cog\",\"dog\"]"));
	}

	//@Test
	//public void ladderTest_2(){
	//    //[hack, back, balk, ball]
	//    ArrayList<String> answer = new ArrayList(); 
	//    answer.add("hack");
	//    answer.add("back");
	//    answer.add("balk");
	//    answer.add("ball");
	//    ArrayList<String> result = Ladder.run("ball","hack");
	//    assertEquals(answer,result);
	//}
}
