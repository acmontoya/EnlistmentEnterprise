package com.orangeandbronze.enlistment.domain;
import static org.junit.Assert.*;
import org.junit.Test;

public class SectionTest {
	//some comment
	@Test
	public void enlistSectionAndSubject() {
		Section section = new Section("ABC123", Subject.ART, new Room("Rm312") , Time.MONTHUA);
		assertEquals("ABC123 ART Rm313 MONTHUA", section.toString());
	}
	
	@Test(expected=PreRequisiteException.class) //should fail, same sections
	public void twoSameSections() {
		Section enlistedSection = new Section("ABC123", Subject.FILIPINO, new Room("Rm315") , Time.MONTHUA);
		Section newSection = new Section("ABC133", Subject.ART, new Room("Rm316") , Time.MONTHUF);
		enlistedSection.validateIfSubjectHasPreRequisite(newSection);
	}
	
	@Test(expected=SameSectionException.class) //should fail, same subjects
	public void twoSameSubjects() {
		Section enlistedSection = new Section("CBD345", Subject.ART, new Room("Rm317") , Time.MONTHUA);
		Section newSection = new Section("ABC123", Subject.ART, new Room("Rm313") , Time.MONTHUA);
		enlistedSection.validateIfSubjectHasConflict(newSection);
	}
	
	@Test
	public void twoDifferentSubjectsAndSections() {
		Section enlistedSection = new Section("CBD345", Subject.PE, new Room("Rm315") , Time.MONTHUA);
		Section newSection = new Section("ABC123", Subject.ART, new Room("Rm312") , Time.MONTHUA);
		enlistedSection.validateIfSubjectHasConflict(newSection);
	}
	
	@Test(expected=SameScheduleException.class) //should fail, same schedule
	public void sameSchedDifferentSection() {
		Section enlistedSection = new Section("CBD345", Subject.PE, new Room("Rm314") , Time.MONTHUA);
		Section newSection = new Section("ABC123", Subject.ART, new Room("Rm313") , Time.MONTHUA);
		enlistedSection.validateIfTimeHasConflict(newSection);
	}
}
