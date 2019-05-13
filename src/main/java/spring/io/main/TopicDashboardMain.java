package spring.io.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@RibbonClient(name = "TopicsService")
@SpringBootApplication
@ComponentScan(basePackages = {"spring.io"})
public class TopicDashboardMain {

	public static void main(String[] args) {
		SpringApplication.run(TopicDashboardMain.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
