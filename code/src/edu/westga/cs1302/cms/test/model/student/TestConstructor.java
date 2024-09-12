package edu.westga.cs1302.cms.test.model.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.Student;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Student(null, 70);});
	}

	@Test
	void testNameTooShort() {
		assertThrows(IllegalArgumentException.class, ()->{new Student("12", 80);});
	}
	
	@Test
	void testMinimumLengthName() {
		Student result = new Student("123", 98);
		
		assertEquals("123", result.getName(), "checking the name of the student");
	}

}
