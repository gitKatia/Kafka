package com.kat.aio.services;

public interface IServerService {

	public void startServer(String configFileName, String type);
	public void stopServer(String configFileName, String type);
}
