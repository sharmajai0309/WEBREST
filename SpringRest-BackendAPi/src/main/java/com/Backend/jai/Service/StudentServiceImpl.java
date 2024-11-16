package com.Backend.jai.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.jai.Exception.StudentNotfoundException;
import com.Backend.jai.Model.Student;
import com.Backend.jai.Repo.IStudentRepo;


@Service
public class StudentServiceImpl implements IStudentService {

	
	@Autowired
	 private IStudentRepo repo;
	 
	@Override
	public Integer SaveStudent(Student s) {
		s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		if(s.getStdId() == null || !repo.existsById(s.getStdId()) )
			throw new StudentNotfoundException("Student" + s.getStdId() + "Not Exist");
		else repo.save(s);

	}

	@Override
	public void DeleteStudent(Integer id) {
		repo.delete(getOneStudent(id) );

	}

	@Override
	public Student getOneStudent(Integer id) {
		
		return repo.findById(id).
				orElseThrow(() -> 
				new StudentNotfoundException("Student :" + id + "Not Exist"));
	}

	@Override
	public List<Student> getAllStudent() {
		
		return repo.findAll();
		
	}
	public List<Integer> saveAllStudents(List<Student> students) {
	    List<Integer> ids = new ArrayList<>();
	    for (Student student : students) {
	        Integer id = repo.save(student).getStdId(); 
	        ids.add(id);
	    }
	    return ids;
	}


	

}
