package com.orangeandbronze.enlistment.domain;

public class Section {
	private String sectionId;
	private Subject subject;
	private Time sched;
	private Room room;
	private int currentNumberOfEnrolledStudents = 0;
	
	
	public Section(String sectionId, Subject subject, Room room, Time sched) {
		this.sectionId = sectionId;
		this.subject = subject;
		this.room = room;
		this.sched = sched;
	}
	
	void addEnrolledStudent(){
		if(room.getCapacity() > currentNumberOfEnrolledStudents){
			this.currentNumberOfEnrolledStudents++;
		}else{
			throw new MaxCapacityException("Failed adding subject to student. Room capacity is full. Maximum capacity is: " + room.getCapacity());
		}
	}

	void validateIfSubjectHasConflict(Section otherSection){
		if(this.subject.equals(otherSection.subject)){
			throw new SameSectionException("Cannot enlist subject " + otherSection.subject + " more than once");
		}
	}
	
	void validateIfSectionHasConflict(Section otherSection){
		if(this.sectionId.equals(otherSection.sectionId)){
			throw new SameSectionException("Cannot enlist same sections " + otherSection.sectionId + " more than once");
		}
	}
	
	void validateIfTimeHasConflict(Section otherSection){
		if(this.sched.equals(otherSection.sched)){
			throw new SameScheduleException("Cannot enlist section " + otherSection.sectionId + ". Has conflict with schedule: " + sched);
		}
	}
	
	void validateIfSubjectHasPreRequisite(Section newSection){
		if(newSection.getSubject().getPreReq().equals(Subject.PreReq.NONE)){
			return;
		}
		if(newSection.getSubject().getPreReq().equals(Subject.PreReq.PREREQ) && (this.getSubject()!=Subject.ENGLISH)){
			throw new PreRequisiteException("Cannot enlist subject "+ newSection.getSubject() +" without taking first its prereq");
		}
	}
	
	public Time getSched() {
		return sched;
	}

	public Room getRoom() {
		return room;
	}

	public String getSectionId() {
		return sectionId;
	}

	public Subject getSubject() {
		return subject;
	}

	@Override
	public String toString() {
		return sectionId + " " + subject + " " + room.getRoomId() + " " + sched;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((sched == null) ? 0 : sched.hashCode());
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Section other = (Section) obj;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (sched != other.sched)
			return false;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		if (subject != other.subject)
			return false;
		return true;
	}
}