package com.cisc181.core;
import java.util.*;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {
	}
	
	public Enrollment(UUID StudentID, UUID SectionID) {
		this.StudentID = StudentID;
		this.SectionID = SectionID;
	}
	
	public void SetGrade(double Grade) {
		this.Grade = Grade;
	}
}
