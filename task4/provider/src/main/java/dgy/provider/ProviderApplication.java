package dgy.provider;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

@SpringBootApplication
@EnableScheduling
public class ProviderApplication {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void provide(){
		String str = "\""+UUID.randomUUID().toString().substring(0,5)+"\"";
		System.out.println(str);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> req = new HttpEntity<String>(str,headers);
		System.out.println(this.restTemplate.postForEntity("http://localhost:8080/push",req,String.class));
	}

	@Bean
	public RestTemplate createRestTemplate(){
		return new RestTemplate();
	}
}
