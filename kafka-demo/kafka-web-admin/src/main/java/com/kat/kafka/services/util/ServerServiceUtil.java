package com.kat.kafka.services.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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

	public void executeCommand(String scriptPropertyKey, String configFileName) {

		String configLocation = "../config/" + configFileName;
		String scriptName = env.getProperty(scriptPropertyKey);
		String kafkaScriptsFolder = env.getProperty("KAFKA_BIN");
		String osName = System.getProperty("os.name").toLowerCase();
		String command = "";
		if (osName.contains("win")) {
			command = scriptName;
		} else if (osName.contains("mac") || osName.contains("nix") || osName.contains("nux")) {
			command = "./" + scriptName + ".sh";
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
