package com.hongzhou.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hongzhou.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {

	@Autowired
	//private KafkaTemplate<String, String> kafkaTemplate;
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "Kafka_User";
	
	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable("message") String name) {
		//kafkaTemplate.send(TOPIC, message);
		kafkaTemplate.send(TOPIC, new User(name, "Biology", 150000L));
		
		return "Published successfully";
	}
}
