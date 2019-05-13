package spring.io.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import spring.io.beans.TopicBean;

@Service
public class TopicDadhboardService {
	@Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${service.TopicsService.serviceId}")
    private String employeeSearchServiceId;
	
	public List<TopicBean> getTopicsfromtopicService(){
		
		Application app = eurekaClient.getApplication(employeeSearchServiceId);
		InstanceInfo  instanceInfo =app.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort()+ "/" + "Topics";
		
		System.out.println("URL :" + url);
		List<TopicBean> topicList = restTemplate.getForObject(url, List.class);
		return topicList;
		
		
		
	}
}
