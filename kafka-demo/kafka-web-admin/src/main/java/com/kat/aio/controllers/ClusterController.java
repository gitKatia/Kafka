package com.kat.aio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kat.aio.services.BrokerService;
import com.kat.aio.services.ZookeeperService;

@Controller
public class ClusterController {

	@Autowired
	ZookeeperService zookeeperService;

	@Autowired
	BrokerService brokerService;

	@RequestMapping(value = "/brokers", method = RequestMethod.GET)
	public String getBrokers() {

		// TODO Remove; this is just for Testing
		brokerService.startBroker("server.properties");
		brokerService.startBroker("server1.properties");
		brokerService.startBroker("server2.properties");
		
		return "brokers";
	}

	@RequestMapping(value = "/zookeepers", method = RequestMethod.GET)
	public String zookeeper() {
		// TODO Remove; this is just for Testing
		zookeeperService.startZookeeper("zookeeper.properties");
		// zookeeperService.stopZookeeper("zookeeper.properties");

		return "zookeeper";
	}

}
