package dgy.container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContainerApplicationTests {
	@Autowired
	private ContainerCore container;

	@Test
	public void contextLoads() {
	}

	@Test
	public void containerCoreTest() {
		// Test basic function
		for(Integer i = 1; i < 5; i++){
			container.push(i);
		}
		Assert.assertEquals(container.pop(),1);
		Assert.assertEquals(container.pop(),2);
		for(Integer j = 5; j < 16; j++){
			container.push(j);
		}
		Assert.assertEquals(container.pop(),15);
		Assert.assertEquals(container.pop(),14);

		container.clear();
		Assert.assertTrue(container.isEmpty());

		// Test the correctness of memory optimizaion
		for(Integer i = 1; i < 10; i++){
			container.push(i);
			Assert.assertEquals(container.pop(),i);
		}
		for(Integer j = 11; j < 15; j++){
			container.push(j);
		}
		Assert.assertEquals(container.pop(),11);
		Assert.assertEquals(container.pop(),12);
		for(Integer k = 15; k < 26; k++){
			container.push(k);
		}
		Assert.assertEquals(container.pop(),25);
		Assert.assertEquals(container.pop(),24);

		container.clear();
		Assert.assertTrue(container.isEmpty());
		
	}

}
