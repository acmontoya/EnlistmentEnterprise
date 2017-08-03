package com.orangeandbronze.enlistment.dao;

import java.util.Collection;

import com.orangeandbronze.enlistment.domain.*;

public interface StudentSemEnlistmentsDAO {
	
	void update(StudentSemEnlistments studentSemEnlistments);
	StudentSemEnlistments findBy(Student student, Semester semester);
	Collection<StudentSemEnlistments> getListOfEnlistments();
}
