package com.kat.aio.services.util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author ki
 *
 */
@Component
public class ServerServiceUtil {
	
	@Autowired
	private Environment env;
	
	public void executeCommand(String scriptPropertyKey, String configFileName){
		
		String configLocation = "../config/" + configFileName;
		String scriptName = env.getProperty(scriptPropertyKey);
		String kafkaScriptsFolder = env.getProperty("KAFKA_BIN");
		
		String command = "";
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
	};
}
