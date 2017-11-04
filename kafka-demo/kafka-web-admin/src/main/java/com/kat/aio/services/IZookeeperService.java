package com.kat.aio.services;

public interface IZookeeperService {
	
	public void startZookeeper(String configFileName);
	public void stopZookeeper(String configFileName);
}
