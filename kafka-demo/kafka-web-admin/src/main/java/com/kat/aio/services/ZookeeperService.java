package com.kat.aio.services;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ZookeeperService implements IZookeeperService {
	
	@Autowired
	Environment env;

	@Override
	public void startZookeeper(String configFileName) {

		String configLocation = "../config/" + configFileName;
		String command = "";
		String scriptName = env.getProperty("zookeeper.server.start.script");
		String kafkaScriptsFolder = env.getProperty("KAFKA_BIN");
		//System.out.println(System.getProperty("os.name"));
		
		if(scriptName.endsWith(".sh")){
			command = "./" + scriptName;
		} else if(scriptName.endsWith(".bat")){
			command = scriptName;
		}
		
		ProcessBuilder pb = new ProcessBuilder(command, configLocation);
		pb.directory(new File(kafkaScriptsFolder));
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stopZookeeper(String configFileName) {

		String configLocation = "../config/" + configFileName;
		String command = "";
		String scriptName = env.getProperty("zookeeper.server.stop.script");
		String kafkaScriptsFolder = env.getProperty("KAFKA_BIN");
		//System.out.println(System.getProperty("os.name"));
		
		if(scriptName.endsWith(".sh")){
			command = "./" + scriptName;
		} else if(scriptName.endsWith(".bat")){
			command = scriptName;
		}
		
		ProcessBuilder pb = new ProcessBuilder(command, configLocation);
		pb.directory(new File(kafkaScriptsFolder));
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
