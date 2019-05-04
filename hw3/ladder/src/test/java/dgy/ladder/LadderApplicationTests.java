package dgy.ladder;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LadderApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void ladderFromDogToCat(){
		//[cat, cag, cog, dog];
		ArrayList<String> answer = new ArrayList(); 
		answer.add("cat");
		answer.add("cag");
		answer.add("cog");
		answer.add("dog");
		ArrayList<String> result = Ladder.run("dog","cat");
		Assert.assertEquals(answer,result);
	}

}
