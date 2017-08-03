package com.orangeandbronze.enlistment.domain;
import static com.orangeandbronze.enlistment.domain.Subject.PreReq.*;


public enum Subject {
	ENGLISH(NONE), MATH(NONE), HISTORY(NONE), SCIENCE(NONE), ART(PREREQ), PE(NONE), FILIPINO(NONE), CHINESE(PREREQ), FRENCH(PREREQ);
	
	enum PreReq {PREREQ,NONE};
	
	private final PreReq preReq;
	
	private Subject(PreReq preReq) {
		this.preReq = preReq;
	}
	public PreReq getPreReq() {
		return preReq;
	}
}
