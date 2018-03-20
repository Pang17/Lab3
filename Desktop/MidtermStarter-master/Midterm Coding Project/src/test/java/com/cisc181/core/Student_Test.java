package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.*;

public class Student_Test {
	
	static ArrayList<Course> courseRecords = new ArrayList<Course>();
	static ArrayList<Semester> Semesters = new ArrayList<Semester>();
	static ArrayList<Student> studentList = new ArrayList<Student>();
	@BeforeClass
	public static void setup() {
		courseRecords.add(new Course(null, "CISC", 100, eMajor.COMPSI));
		courseRecords.add(new Course(null, "CHEM", 100, eMajor.CHEM));
		courseRecords.add(new Course(null, "PHYS", 100, eMajor.PHYSICS));
		
		
	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}
}