package com.cliff.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cliff.activemq.producer.queue.QueueSender;
import com.cliff.activemq.producer.topic.TopicSender;

public class ActivemqController {
	@Resource
	QueueSender queueSender;
	@Resource
	TopicSender topicSender;
	
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(@RequestParam("message") String message){
		String opt = "";
		try {
			queueSender.send("test.queue", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("message") String message){
		String opt = "";
		try {
			topicSender.send("test.topic", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
}
