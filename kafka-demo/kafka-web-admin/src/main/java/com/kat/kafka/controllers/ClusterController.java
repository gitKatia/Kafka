package com.kat.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kat.kafka.model.ServerType;
import com.kat.kafka.services.ServerServiceImpl;

/**
 * @author ki
 *
 */
@Controller
public class ClusterController {

	@Autowired
	private ServerServiceImpl serverService;

	@RequestMapping(value = "/brokers", method = RequestMethod.GET)
	public String getBrokers() {

		// TODO Remove; this is just for Testing
		String type = ServerType.BROKER.type();
		serverService.startServer("server.properties", type);
		serverService.startServer("server1.properties", type);
		serverService.startServer("server2.properties", type);
		
		return "brokers";
	}

	@RequestMapping(value = "/zookeeper", method = RequestMethod.GET)
	public String zookeeper() {
		// TODO Remove; this is just for Testing
		String type = ServerType.ZOOKEEPER.type();
		serverService.startServer("zookeeper.properties", type);
		//serverService.stopServer("zookeeper.properties", type);

		return "zookeeper";
	}

}
