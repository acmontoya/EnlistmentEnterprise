package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class SemesterTest {
	@Test
	public void TestingSemesterOpen(){
		Integer year=2017;
		Integer sem=2;
		Semester sem1 = new Semester("sem1", 2017, 2);
		assertTrue(sem1.ifSemesterIsOpen(year, sem));
	}
	
	@Test(expected=ClosedSemesterException.class)
	public void TestingSemesterClosed(){
		Integer year=2017;
		Integer sem=2;
		Semester sem1 = new Semester("sem1", 2015, 1);
		assertTrue(sem1.ifSemesterIsOpen(year, sem));
	}

}
