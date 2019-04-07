package com.dgy.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class HomeworkApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

    @Override
    public void run(String[] args) {
		if(args.length < 2){
			System.out.println("Two args needed.");
			return;
		}

		String s1 = args[0];
		String s2 = args[1];

		Ladder.run(s1,s2);
    }

}
