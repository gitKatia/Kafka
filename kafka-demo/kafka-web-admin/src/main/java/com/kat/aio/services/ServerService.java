package com.kat.aio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.aio.model.ServerType;
import com.kat.aio.services.util.ServerServiceUtil;

/**
 * @author ki
 *
 */
@Service
public class ServerService implements IServerService {
	
	@Autowired
	private ServerServiceUtil serverServiceUtil;

	@Override
	public void startServer(String configFileName, String type) {
		
		if(type.equals(ServerType.ZOOKEEPER.type())){
			serverServiceUtil.executeCommand("zookeeper.server.start.script", configFileName);
		} else if(type.equals(ServerType.BROKER.type())) {
			serverServiceUtil.executeCommand("kafka.server.start.script", configFileName);
		} else {
			// Should add logging
			System.out.println("No match");
		}
		
	}

	@Override
	public void stopServer(String configFileName, String type) {
		
		if(type.equals(ServerType.ZOOKEEPER.type())){
			serverServiceUtil.executeCommand("zookeeper.server.stop.script", configFileName);
		} else if(type.equals(ServerType.BROKER.type())) {
			serverServiceUtil.executeCommand("kafka.server.stop.script", configFileName);
		} else {
			// Should add logging
			System.out.println("No match");
		}

	}
	

}
