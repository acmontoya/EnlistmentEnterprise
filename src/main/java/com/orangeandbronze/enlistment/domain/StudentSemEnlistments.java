package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

import java.util.*;

public class StudentSemEnlistments {
	private final Student student;
	private final Semester semester;
	private final Collection<Section> sections = new HashSet<>();

	public StudentSemEnlistments(Student student, Semester semester) {
		notNull(student);
		notNull(semester);
		this.student = student;
		this.semester = semester;
	}
	
	public void checkIfSectionsHasNoConflict(Section newSection){
		for(Section enrolledSection : sections){
			enrolledSection.validateIfSectionHasConflict(newSection);
		}
	}
	
	public void checkIfSubjectsHasNoConflict(Section newSection){
		for(Section enrolledSection : sections){
			enrolledSection.validateIfSubjectHasConflict(newSection);
		}
	}
	
	public void checkIfScheduleHasNoConflict(Section newSection){
		for(Section enrolledSection : sections){
			enrolledSection.validateIfTimeHasConflict(newSection);
		}
	}
	
	public void checkIfSubjectHasNoPreRequisite(Section newSection){
		for(Section enrolledSection : sections){
			enrolledSection.validateIfSubjectHasPreRequisite(newSection);
		}
	}
	
	public void addNewSection(Section newSection){
		checkIfSectionsHasNoConflict(newSection);
		checkIfSubjectsHasNoConflict(newSection);
		checkIfScheduleHasNoConflict(newSection);
		checkIfSubjectHasNoPreRequisite(newSection);
		newSection.addEnrolledStudent();
		sections.add(newSection);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		StudentSemEnlistments other = (StudentSemEnlistments) obj;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	
}
