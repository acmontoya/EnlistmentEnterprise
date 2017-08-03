package com.orangeandbronze.enlistment.service;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.SemesterDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import com.orangeandbronze.enlistment.dao.StudentSemEnlistmentsDAO;
import com.orangeandbronze.enlistment.domain.MaxCapacityException;
import com.orangeandbronze.enlistment.domain.Room;
import com.orangeandbronze.enlistment.domain.SameScheduleException;
import com.orangeandbronze.enlistment.domain.SameSectionException;
import com.orangeandbronze.enlistment.domain.Section;
import com.orangeandbronze.enlistment.domain.Semester;
import com.orangeandbronze.enlistment.domain.Student;
import com.orangeandbronze.enlistment.domain.StudentSemEnlistments;
import com.orangeandbronze.enlistment.domain.Subject;
import com.orangeandbronze.enlistment.domain.Time;

public class EnlistServiceTest {
	
	@Test(expected=MaxCapacityException.class)
	public void enlistWithMaxCapacity(){
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);
		StudentSemEnlistmentsDAO studentSemEnlistmentsDao = mock(StudentSemEnlistmentsDAO.class);
		SemesterDAO semesterDao = mock(SemesterDAO.class);
		EnlistService service = new EnlistService();
		
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		
		final int mockStudentId1 = 111;
		final int mockStudentId2 = 112;
		final int mockStudentId3 = 113;
		final int mockStudentId4 = 114;
		final int mockStudentId5 = 115;
		final Student mockStudent1 = new Student (mockStudentId1, "Macky", "Abino");
		final Student mockStudent2 = new Student (mockStudentId2, "Doe", "John");
		final Student mockStudent3 = new Student (mockStudentId3, "Sample", "Abino");
		final Student mockStudent4 = new Student (mockStudentId4, "Wewe", "Abino");
		final Student mockStudent5 = new Student (mockStudentId5, "Wew", "Weew");
		final String mockSectionId = "FILKOMU";
		final Section mockSection = new Section("ABC123", Subject.ART, new Room("Rm312") , Time.MONTHUA);
		final String mockSemesterId = "1";
		final Semester mockSemester = new Semester(mockSemesterId, 2017, 1);
		final StudentSemEnlistments mockEnlistments = new StudentSemEnlistments(mockStudent1, mockSemester);
		final StudentSemEnlistments mockEnlistments2 = new StudentSemEnlistments(mockStudent2, mockSemester);
		final StudentSemEnlistments mockEnlistments3 = new StudentSemEnlistments(mockStudent3, mockSemester);
		final StudentSemEnlistments mockEnlistments4 = new StudentSemEnlistments(mockStudent4, mockSemester);
		final StudentSemEnlistments mockEnlistments5 = new StudentSemEnlistments(mockStudent5, mockSemester);
		
		when(studentDao.findBy(mockStudentId1)).thenReturn(mockStudent1);
		when(studentDao.findBy(mockStudentId2)).thenReturn(mockStudent2);
		when(studentDao.findBy(mockStudentId3)).thenReturn(mockStudent3);
		when(studentDao.findBy(mockStudentId4)).thenReturn(mockStudent4);
		when(studentDao.findBy(mockStudentId5)).thenReturn(mockStudent5);
		when(sectionDao.findBy(mockSectionId)).thenReturn(mockSection);
		when(semesterDao.findBy(mockSemesterId)).thenReturn(mockSemester);
		when(studentSemEnlistmentsDao.findBy(mockStudent1, mockSemester)).thenReturn(mockEnlistments);
		when(studentSemEnlistmentsDao.findBy(mockStudent2, mockSemester)).thenReturn(mockEnlistments2);
		when(studentSemEnlistmentsDao.findBy(mockStudent3, mockSemester)).thenReturn(mockEnlistments3);
		when(studentSemEnlistmentsDao.findBy(mockStudent4, mockSemester)).thenReturn(mockEnlistments4);
		when(studentSemEnlistmentsDao.findBy(mockStudent5, mockSemester)).thenReturn(mockEnlistments5);
		
		service.setSectionDao(sectionDao);
		service.setStudentDao(studentDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		service.setSemesterDao(semesterDao);
		
		service.enlist(mockStudentId1, mockSectionId, mockSemesterId);
		service.enlist(mockStudentId2, mockSectionId, mockSemesterId);
		service.enlist(mockStudentId3, mockSectionId, mockSemesterId);
		service.enlist(mockStudentId4, mockSectionId, mockSemesterId);
		service.enlist(mockStudentId5, mockSectionId, mockSemesterId);
		
		verify(studentDao).findBy(mockStudentId1);
		verify(studentDao).findBy(mockStudentId2);
		verify(studentDao).findBy(mockStudentId3);
		verify(studentDao).findBy(mockStudentId4);
		verify(studentDao).findBy(mockStudentId5);
		verify(sectionDao).findBy(mockSectionId);
		verify(semesterDao).findBy(mockSemesterId);
		verify(studentSemEnlistmentsDao).update(mockEnlistments);
		verify(studentSemEnlistmentsDao).update(mockEnlistments2);
		verify(studentSemEnlistmentsDao).update(mockEnlistments3);
		verify(studentSemEnlistmentsDao).update(mockEnlistments4);
		verify(studentSemEnlistmentsDao).update(mockEnlistments5);
	}
	
	@Test
	public void enlist(){
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);
		StudentSemEnlistmentsDAO studentSemEnlistmentsDao = mock(StudentSemEnlistmentsDAO.class);
		SemesterDAO semesterDao = mock(SemesterDAO.class);
		EnlistService service = new EnlistService();
		
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		
		final int mockStudentId = 111;
		final Student mockStudent = new Student (mockStudentId, "Macky", "Abino");
		final String mockSectionId = "FILKOMU";
		final Section mockSection = new Section("ABC123", Subject.ART, new Room("Rm312") , Time.MONTHUA);
		final String mockSemesterId = "1";
		final Semester mockSemester = new Semester(mockSemesterId, 2017, 1);
		final StudentSemEnlistments mockEnlistments = new StudentSemEnlistments(mockStudent, mockSemester);
		
		
		service.setSectionDao(sectionDao);
		service.setStudentDao(studentDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		service.setSemesterDao(semesterDao);
		
		when(studentDao.findBy(mockStudentId)).thenReturn(mockStudent);
		when(sectionDao.findBy(mockSectionId)).thenReturn(mockSection);
		when(semesterDao.findBy(mockSemesterId)).thenReturn(mockSemester);
		when(studentSemEnlistmentsDao.findBy(mockStudent, mockSemester)).thenReturn(mockEnlistments);
		
		service.enlist(mockStudentId, mockSectionId, mockSemesterId);
		
		verify(studentDao).findBy(mockStudentId);
		verify(sectionDao).findBy(mockSectionId);
		verify(semesterDao).findBy(mockSemesterId);
		verify(studentSemEnlistmentsDao).update(mockEnlistments);
		
		
	}
	
	
	@Test(expected=SameSectionException.class)
	public void enlistSameSectionAgain(){
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);
		StudentSemEnlistmentsDAO studentSemEnlistmentsDao = mock(StudentSemEnlistmentsDAO.class);
		SemesterDAO semesterDao = mock(SemesterDAO.class);
		EnlistService service = new EnlistService();
		
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		
		final int mockStudentId = 111;
		final Student mockStudent = new Student (mockStudentId, "Macky", "Abino");
		final String mockSectionId = "FILKOMU";
		final Section mockSection = new Section("ABC123", Subject.ART, new Room("Rm312") , Time.MONTHUA);
		final String mockSemesterId = "1";
		final Semester mockSemester = new Semester(mockSemesterId, 2017, 1);
		final StudentSemEnlistments mockEnlistments = new StudentSemEnlistments(mockStudent, mockSemester);
		mockEnlistments.addNewSection(mockSection);
		
		
		service.setSectionDao(sectionDao);
		service.setStudentDao(studentDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		service.setSemesterDao(semesterDao);
		
		when(studentDao.findBy(mockStudentId)).thenReturn(mockStudent);
		when(sectionDao.findBy(mockSectionId)).thenReturn(mockSection);
		when(semesterDao.findBy(mockSemesterId)).thenReturn(mockSemester);
		when(studentSemEnlistmentsDao.findBy(mockStudent, mockSemester)).thenReturn(mockEnlistments);
		
		service.enlist(mockStudentId, mockSectionId, mockSemesterId);
		
		verify(studentDao).findBy(mockStudentId);
		verify(sectionDao).findBy(mockSectionId);
		verify(semesterDao).findBy(mockSemesterId);
		verify(studentSemEnlistmentsDao).update(mockEnlistments);
		
	}
	
	@Test(expected=SameSectionException.class)
	public void enlistSameSubject(){
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);
		StudentSemEnlistmentsDAO studentSemEnlistmentsDao = mock(StudentSemEnlistmentsDAO.class);
		SemesterDAO semesterDao = mock(SemesterDAO.class);
		EnlistService service = new EnlistService();
		
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		
		final int mockStudentId = 111;
		final Student mockStudent = new Student (mockStudentId, "Macky", "Abino");
		final String mockSectionId = "ART2";
		final Section mockSection = new Section("ABC123", Subject.ART, new Room("Rm312") , Time.MONTHUA);
		final String mockSemesterId = "1";
		final Semester mockSemester = new Semester(mockSemesterId, 2017, 1);
		final StudentSemEnlistments mockEnlistments = new StudentSemEnlistments(mockStudent, mockSemester);
		mockEnlistments.addNewSection(mockSection);
		
		
		service.setSectionDao(sectionDao);
		service.setStudentDao(studentDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		service.setSemesterDao(semesterDao);
		
		when(studentDao.findBy(mockStudentId)).thenReturn(mockStudent);
		when(sectionDao.findBy("ABC123")).thenReturn(mockSection);
		when(sectionDao.findBy(mockSectionId)).thenReturn(new Section(mockSectionId, Subject.ART, new Room("Rm111"), Time.MONTHUB));
		when(semesterDao.findBy(mockSemesterId)).thenReturn(mockSemester);
		when(studentSemEnlistmentsDao.findBy(mockStudent, mockSemester)).thenReturn(mockEnlistments);
		
		service.enlist(mockStudentId, "ART2", mockSemesterId);
		
		verify(studentDao).findBy(mockStudentId);
		verify(sectionDao).findBy(mockSectionId);
		verify(semesterDao).findBy(mockSemesterId);
		verify(studentSemEnlistmentsDao).update(mockEnlistments);
		
	}
	
	
	@Test(expected=SameScheduleException.class)
	public void enlistSameSchedule(){
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);
		StudentSemEnlistmentsDAO studentSemEnlistmentsDao = mock(StudentSemEnlistmentsDAO.class);
		SemesterDAO semesterDao = mock(SemesterDAO.class);
		EnlistService service = new EnlistService();
		
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		
		final int mockStudentId = 111;
		final Student mockStudent = new Student (mockStudentId, "Macky", "Abino");
		final String mockSectionId = "ART2";
		final Section mockSection = new Section("ABC123", Subject.FILIPINO, new Room("Rm312") , Time.MONTHUA);
		final String mockSemesterId = "1";
		final Semester mockSemester = new Semester(mockSemesterId, 2017, 1);
		final StudentSemEnlistments mockEnlistments = new StudentSemEnlistments(mockStudent, mockSemester);
		mockEnlistments.addNewSection(mockSection);
		
		
		service.setSectionDao(sectionDao);
		service.setStudentDao(studentDao);
		service.setStudentSemEnlistmentsDao(studentSemEnlistmentsDao);
		service.setSemesterDao(semesterDao);
		
		when(studentDao.findBy(mockStudentId)).thenReturn(mockStudent);
		when(sectionDao.findBy("ABC123")).thenReturn(mockSection);
		when(sectionDao.findBy(mockSectionId)).thenReturn(new Section(mockSectionId, Subject.ART, new Room("Rm111"), Time.MONTHUA));
		when(semesterDao.findBy(mockSemesterId)).thenReturn(mockSemester);
		when(studentSemEnlistmentsDao.findBy(mockStudent, mockSemester)).thenReturn(mockEnlistments);
		
		service.enlist(mockStudentId, "ART2", mockSemesterId);
		
		verify(studentDao).findBy(mockStudentId);
		verify(sectionDao).findBy(mockSectionId);
		verify(semesterDao).findBy(mockSemesterId);
		verify(studentSemEnlistmentsDao).update(mockEnlistments);
		
	}

}
