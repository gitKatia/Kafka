package com.kat.aio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClusterController {
	
	@RequestMapping(value="/brokers", method=RequestMethod.GET)
	public String getBrokers(){
		return "brokers";
	}
	
	@RequestMapping(value="/zookeepers", method=RequestMethod.GET)
	public String zookeeper(){
		return "zookeeper";
	}

}
