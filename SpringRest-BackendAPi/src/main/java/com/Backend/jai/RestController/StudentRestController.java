package com.Backend.jai.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.jai.Exception.StudentNotfoundException;
import com.Backend.jai.Model.Student;
import com.Backend.jai.Service.IStudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("v1/api/student")
public class StudentRestController {
	
	
	@Autowired
    private IStudentService service;
	
	
	
	/*
	 * Method : POST
	 * PATH   :/Create
	 * Input  : student Object
	 * RT     : ResponseEntity<String>
	 */
	@Operation(summary = "Save Object")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "201", 
	        description = "Created",
	        content = @Content(mediaType = "text/plain")
	    ),
	    @ApiResponse(
	        responseCode = "500", 
	        description = "Bad Request",
	        content = @Content(mediaType = "application/json")
	    )
	})
	@PostMapping("/create")
	public ResponseEntity<String>createStudent(@RequestBody @Valid Student student) {
		
		
		Integer id  = service.SaveStudent(student);
		String msg = "Studetn:"+id+" Created";
		ResponseEntity<String> response =  new ResponseEntity<String>(msg,HttpStatus.CREATED);//201
		
		return response;
	}
	
	
	
	@Operation(summary = "Find all student")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200", 
	        description = "Traced",
	        content = @Content(mediaType = "text/plain")
	    ),
	    @ApiResponse(
	        responseCode = "404", 
	        description = "Not Found",
	        content = @Content(mediaType = "application/json")
	    )
	})
	@GetMapping("/all")
	public ResponseEntity<List<Student>> allStudents() {

	    List<Student> body = service.getAllStudent();

	    ResponseEntity<List<Student>> response1 = new ResponseEntity<>(body, HttpStatus.OK); // 201
	    return response1;

	}
	
	
	@Operation(summary = "Find student")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200", 
	        description = "Traced",
	        content = @Content(mediaType = "text/plain")
	    ),
	    @ApiResponse(
	        responseCode = "404", 
	        description = "Not Found",
	        content = @Content(mediaType = "application/json")
	    )
	})
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id){
		
		
		ResponseEntity<Student> response2 = null; // 201
		try {
			
			Student s = service.getOneStudent(id);
			response2 = ResponseEntity.ok(s);	
			
		} catch (StudentNotfoundException e) {
			e.getMessage();
			e.getStackTrace();
			throw e;
			
		}
		return response2;
		
	}
	
	@Operation(summary = "Delete Stduent")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200", 
	        description = "Deleted",
	        content = @Content(mediaType = "text/plain")
	    ),
	    @ApiResponse(
	        responseCode = "404", 
	        description = "Student Not Fond",
	        content = @Content(mediaType = "application/json")
	    )
	})
@DeleteMapping("/remove/{id}")
	public ResponseEntity<String>DeleteStudent(@PathVariable Integer id){
		
		try {
			service.DeleteStudent(id);
			String msg = "Student"+id+"Deleted";
			 ResponseEntity<String> responsefound = new ResponseEntity<>(msg, HttpStatus.ACCEPTED); 
			
			return responsefound;
		} catch (StudentNotfoundException e) {
			
			e.getMessage();
			e.getStackTrace();
			throw e;
			 
		}	
	}
	@Operation(summary = "Update Student")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200",
	        description = "Student updated successfully",
	        content = @Content(mediaType = "text/plain")
	    ),
	    @ApiResponse(
	        responseCode = "404",
	        description = "Student not found",
	        content = @Content(mediaType = "application/json")
	    )
	})
	
	@PutMapping("/modify")
	public ResponseEntity<String> putMethodName(@RequestBody Student s) {
		ResponseEntity<String> response3 = null; // 201
	  try {
		  service.updateStudent(s);
		  response3 = ResponseEntity.ok("Student updated" + s.getStdName());
		  
		
	} catch (StudentNotfoundException e) {
		e.getMessage();
		e.getStackTrace();
		throw e;
	}
	  return response3;
}
	@PostMapping("/createList")
	public ResponseEntity<String> createStudentList(@RequestBody List<Student> students) {
	    
	    List<Integer> ids = service.saveAllStudents(students); // Assuming you have a service method to save all students
	    String msg = "Students with IDs: " + ids + " created successfully.";
	    
	    ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.CREATED); // 201
	    return response;
	}

	

	
	
	
	
	
	
   
   
   
}
