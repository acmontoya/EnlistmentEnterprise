package com.orangeandbronze.enlistment.domain;

public class Room {
	private final String roomId;
	private final Integer CAPACITY_MAX = 4;
	
	public Room(String roomId){
		this.roomId = roomId;
	}
	
	public String getRoomId() {
		return new String(roomId);
	}

	public Integer getCapacity() {
		return new Integer(CAPACITY_MAX);
	}
}
