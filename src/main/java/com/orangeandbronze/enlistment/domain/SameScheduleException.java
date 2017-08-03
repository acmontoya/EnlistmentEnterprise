package com.orangeandbronze.enlistment.domain;

public class SameScheduleException extends RuntimeException{
	public SameScheduleException(String message){
		super(message);
	}
}
