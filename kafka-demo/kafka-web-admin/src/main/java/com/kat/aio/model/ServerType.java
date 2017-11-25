package com.kat.aio.model;

/**
 * @author ki
 *
 */
public enum ServerType {
	
	ZOOKEEPER("zookeeper"), BROKER("broker");
	
	private String type;

    ServerType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

}
