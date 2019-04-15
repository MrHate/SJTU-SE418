package com.dgy.Ladder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import static com.dgy.Ladder.Ladder.generateDict;
import static com.dgy.Ladder.Ladder.generateLadder;

public class JunitTest{
	private static int num = 0;
	private static String str = "";

	@Before
	public void setValue(){
		num = 2222;
		str = "test";
	}
	@Test
	public void test_Junit(){
		assertEquals(num,2222);
		assertEquals(str,"test");
	}

	@Test
	public void test_generateDict(){
		ArrayList<String> dict = null;
		dict = generateDict("dictionary.txt");
		assertNotNull(dict);
	}

	@Test
	public void test_generateLadder_1(){
		//[cat, cag, cog, dog];
		ArrayList<String> answer = new ArrayList(); 
		answer.add("cat");
		answer.add("cag");
		answer.add("cog");
		answer.add("dog");
		ArrayList<String> result = generateLadder("dog","cat");
		assertEquals(answer,result);
	}

	@Test
	public void test_generateLadder_2(){
		//[hack, back, balk, ball]
		ArrayList<String> answer = new ArrayList(); 
		answer.add("hack");
		answer.add("back");
		answer.add("balk");
		answer.add("ball");
		ArrayList<String> result = generateLadder("ball","hack");
		assertEquals(answer,result);
	}
}

