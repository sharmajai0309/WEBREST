package com.Backend.jai.Service;

import java.util.List; 

import com.Backend.jai.Model.Student;

public interface IStudentService {
	
	
	
	
	/*
	 * Input : Student Object
	 * Output : PK value of the student Object
	 */
	Integer SaveStudent(Student s);
	
	

	/*
	 * Input : Student Object
	 * Output : No return Type
	 */
	
	
	
	void updateStudent(Student s);

	/*
	 * Input : Id of Student 
	 * Output : Output : No return Type
	 */
	
	
	void DeleteStudent(Integer id);

	/*
	 * Input : Id of Student for deletetion
	 * Output : Student Object if Present otherwise null
	 */
	
	Student getOneStudent(Integer id);
	
	

	/*
	 * Input : No input
	 * Output : List<Student>
	 */
	
	List<Student> getAllStudent();
	
	
	/*
	 * Input : List input
	 * Output : Output : No return Type
	 */
	
	public List<Integer> saveAllStudents(List<Student> students);



	


}
