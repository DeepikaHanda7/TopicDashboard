package spring.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.io.beans.TopicBean;
import spring.io.services.TopicDadhboardService;

@RestController
public class TopicDashboardController {
  
	@Autowired
	private TopicDadhboardService topicDashboardService;
	
	@GetMapping("/DashboardTopics")
	public List<TopicBean> getTopics(){
		return topicDashboardService.getTopicsfromtopicService();
	}
}
