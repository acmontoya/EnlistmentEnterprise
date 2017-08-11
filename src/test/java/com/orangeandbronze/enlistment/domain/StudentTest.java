package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {
	@Test(expected=IllegalArgumentException.class)
	public void cannotAcceptNegativeStudentNumber() {
		new Student(-1, "Macky", "Abiño");
	}
	
	@Test
	public void AcceptPositiveStudentNumber(){
		Student student = new Student(2014589, "Renz", "Exconde");
		assertEquals("Student# 2014589 Renz Exconde", student.toString());
	}
	
}
