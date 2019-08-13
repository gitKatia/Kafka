package com.kat.kafka.services;

import com.kat.kafka.model.ServerType;

public interface ServerService {

	public void startServer(String configFileName, ServerType type);
	public void stopServer(String configFileName, ServerType type);
	public boolean checkServerStatus(String configFileName, ServerType type);
	
}
