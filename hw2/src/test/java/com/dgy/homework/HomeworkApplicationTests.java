package com.dgy.homework;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {

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
		assertEquals(answer,result);
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
