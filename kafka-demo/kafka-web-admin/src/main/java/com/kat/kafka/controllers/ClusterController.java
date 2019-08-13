package com.kat.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/cluster/brokers", method = RequestMethod.GET)
	public String getBrokers() {

		//check brokers status

		return "cluster";
	}
	
	@RequestMapping(value = "/cluster/zookeeper", method = RequestMethod.GET)
	public String getZookeeper() {
		
		// check zookeeper status
		return "cluster";
	}

	@RequestMapping(value = "/cluster", method = RequestMethod.GET)
	public String showCluster(@RequestParam(value = "action", required=false) String action) {
		if("start".equals(action)) {
			serverService.startServer("zookeeper.properties", ServerType.ZOOKEEPER);
			
			for (int k = 0; k < 3; k++) {
				String configFileName = String.format("server%s.properties", k);
				serverService.startServer(configFileName, ServerType.BROKER);
			}
		} else if("stop".equals(action)) {
			for (int k = 0; k < 3; k++) {
				String configFileName = String.format("server%s.properties", k);
				serverService.stopServer(configFileName, ServerType.BROKER);
			}
			serverService.stopServer("zookeeper.properties", ServerType.ZOOKEEPER);
		}
		return "cluster";
	}

}
