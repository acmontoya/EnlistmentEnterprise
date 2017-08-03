package com.orangeandbronze.enlistment.domain;

public class Student {
	private final Integer STUDENT_NUMBER;
	private final String FIRST_NAME;
	private final String LAST_NAME;
	
	public Student (Integer studentNumber, String firstName, String lastName) {
		validateStudentNumber(studentNumber);
		
		STUDENT_NUMBER = studentNumber;
		FIRST_NAME = firstName;
		LAST_NAME = lastName;
	}
	
	private void validateStudentNumber(Integer studentNumber){
		if(studentNumber < 0) {
			throw new IllegalArgumentException("Cannot accept negative student number. Was: " + studentNumber);
		}
 	}
	
	public void enlist(Section newSection){
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FIRST_NAME == null) ? 0 : FIRST_NAME.hashCode());
		result = prime * result + ((LAST_NAME == null) ? 0 : LAST_NAME.hashCode());
		result = prime * result + ((STUDENT_NUMBER == null) ? 0 : STUDENT_NUMBER.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (FIRST_NAME == null) {
			if (other.FIRST_NAME != null)
				return false;
		} else if (!FIRST_NAME.equals(other.FIRST_NAME))
			return false;
		if (LAST_NAME == null) {
			if (other.LAST_NAME != null)
				return false;
		} else if (!LAST_NAME.equals(other.LAST_NAME))
			return false;
		if (STUDENT_NUMBER == null) {
			if (other.STUDENT_NUMBER != null)
				return false;
		} else if (!STUDENT_NUMBER.equals(other.STUDENT_NUMBER))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student# " + STUDENT_NUMBER + ' ' + FIRST_NAME + ' ' + LAST_NAME;
	}

	public Integer getSTUDENT_NUMBER() {
		return STUDENT_NUMBER;
	}
	
	
}
