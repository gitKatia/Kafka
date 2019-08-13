package com.kat.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.kafka.model.ServerType;
import com.kat.kafka.services.util.ServerServiceUtil;

/**
 * @author ki
 *
 */
@Service
public class ServerServiceImpl implements ServerService {
	
	@Autowired
	private ServerServiceUtil serverServiceUtil;

	@Override
	public void startServer(String configFileName, ServerType type) {
		
		if(type == ServerType.ZOOKEEPER){
			serverServiceUtil.executeCommand("zookeeper.server.start.script", configFileName);
		} else if(type == ServerType.BROKER) {
			serverServiceUtil.executeCommand("kafka.server.start.script", configFileName);
		} else {
			// Should add logging
			System.out.println("No match");
		}
		
	}

	@Override
	public void stopServer(String configFileName, ServerType type) {
		
		if(type == ServerType.ZOOKEEPER){
			serverServiceUtil.executeCommand("zookeeper.server.stop.script", configFileName);
		} else if(type == ServerType.BROKER) {
			serverServiceUtil.executeCommand("kafka.server.stop.script", configFileName);
		} else {
			// Should add logging
			System.out.println("No match");
		}

	}

	@Override
	public boolean checkServerStatus(String configFileName, ServerType type) {
		
		return false;
	}
	
	
	

}
