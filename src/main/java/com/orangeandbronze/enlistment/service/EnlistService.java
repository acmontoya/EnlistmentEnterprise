package com.orangeandbronze.enlistment.service;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	private StudentSemEnlistmentsDAO studentSemEnlistmentsDao;
	private SemesterDAO semesterDao;
	
	public void enlist(int studentNo, String sectionId, String semesterId) {
		// TODO: Implement this method
		
		Student student = studentDao.findBy(studentNo);
		Section section = sectionDao.findBy(sectionId);
		Semester semester = semesterDao.findBy(semesterId);
		StudentSemEnlistments studentSemEnlistments = studentSemEnlistmentsDao.findBy(student, semester);
//		StudentSemEnlistments studentSemEnlistments = new StudentSemEnlistments(student, semester);
		studentSemEnlistments.addNewSection(section);
		studentSemEnlistmentsDao.update(studentSemEnlistments);
	}

	public void setSemesterDao(SemesterDAO semesterDao){
		this.semesterDao = semesterDao;
	}
	
	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public void setStudentSemEnlistmentsDao(
			StudentSemEnlistmentsDAO studentSemEnlistmentsDao) {
		this.studentSemEnlistmentsDao = studentSemEnlistmentsDao;
	}
}
