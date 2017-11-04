package com.kat.aio.services;

public interface IBrokerService {
	
	public void startBroker(String configFileName);
	public void stopBroker(String configFileName);

}
