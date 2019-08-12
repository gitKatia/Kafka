package com.kat.kafka.services;

public interface ServerService {

	public void startServer(String configFileName, String type);
	public void stopServer(String configFileName, String type);
	public boolean checkServerStatus(String configFileName, String type);
	
}
