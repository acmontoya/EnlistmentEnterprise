package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.domain.Semester;

public interface SemesterDAO {
	Semester findBy(String semesterId);
}
