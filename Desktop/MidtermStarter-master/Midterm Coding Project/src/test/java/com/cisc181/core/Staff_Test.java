package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	static ArrayList<Staff> staffArray = new ArrayList<Staff>();
	@BeforeClass
	public static void setup() {
		Date d = new Date();
		staffArray.add(new Staff("name","mName","lName",d,"(555)-555-5555","name@email.com","1-2",null, 1,60000.0,d,eTitle.MR));
		staffArray.add(new Staff("name","mName","lName",d,"(555)-555-5555","name@email.com","1-2",null, 1,70000.0,d,eTitle.MR));
		staffArray.add(new Staff("name","mName","lName",d,"(555)-555-5555","name@email.com","1-2",null, 1,45000.0,d,eTitle.MR));
		staffArray.add(new Staff("name","mName","lName",d,"(555)-555-5555","name@email.com","1-2",null, 1,62000.0,d,eTitle.MR));
		staffArray.add(new Staff("name","mName","lName",d,"(555)-555-5555","name@email.com","1-2",null, 1,34000.0,d,eTitle.MR));
	}
	
	@Test
	public void test() {
		double sum = 0;
		for (Staff s : staffArray) {
			sum += s.getSalary();
		}
		double avg = sum/5;
		assertEquals(54200.0,avg,.001);
			
	}	

}
