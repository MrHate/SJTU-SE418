package dgy.consumer;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsumerApplication {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void consume(){
		System.out.println(restTemplate.getForObject("http://localhost:8080/pop",String.class));
	}

	@Bean
	public RestTemplate createRestTemplate(){
		return new RestTemplate();
	}
}
