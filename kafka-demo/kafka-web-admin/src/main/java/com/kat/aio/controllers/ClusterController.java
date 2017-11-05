package com.kat.aio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kat.aio.model.ServerType;
import com.kat.aio.services.ServerService;

@Controller
public class ClusterController {

	@Autowired
	private ServerService serverService;

	@RequestMapping(value = "/brokers", method = RequestMethod.GET)
	public String getBrokers() {

		// TODO Remove; this is just for Testing
		String type = ServerType.BROKER.type();
		serverService.startServer("server.properties", type);
		serverService.startServer("server1.properties", type);
		serverService.startServer("server2.properties", type);
		
		return "brokers";
	}

	@RequestMapping(value = "/zookeepers", method = RequestMethod.GET)
	public String zookeeper() {
		// TODO Remove; this is just for Testing
		String type = ServerType.ZOOKEEPER.type();
		serverService.startServer("zookeeper.properties", type);
		// startService.stopServer("zookeeper.properties", type);

		return "zookeeper";
	}

}
