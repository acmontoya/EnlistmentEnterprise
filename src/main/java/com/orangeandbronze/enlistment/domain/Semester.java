package com.orangeandbronze.enlistment.domain;

public class Semester {
	private String semesterId;
	private final Integer year;
	private final Integer sem;
	
	public Semester (String semesterId, Integer year, Integer sem){
		this.semesterId = semesterId;
		this.year = year;
		this.sem = sem;
	}
	
	public boolean ifSemesterIsOpen(Integer currentYear, Integer currentSem){
		if (this.year != currentYear){
			if(this.sem != currentSem){
				throw new ClosedSemesterException("Cannot create a semester that is closed ");	
			}
		}
		return true;
	}
	
}
