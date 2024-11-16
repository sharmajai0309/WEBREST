package com.Backend.jai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.jai.Repository.BookRepository;
import com.Backend.jai.entity.Book;

@RestController
@RequestMapping("/v1/api/model")
public class Controller {
	
	@Autowired
	private BookRepository repo;
	
	
	/*Method :post
	Path   :/save
	Input  : Book @ResquestBody
	Output : R.E<String>
	*/
	
	@PostMapping("/save")
	public ResponseEntity<String>saveBook(@RequestBody Book
			m){
		
		Book M = repo.save(m);
		String Body = "Book"+M.getBid()+"CREATED";
		
		return new ResponseEntity<>(Body,HttpStatus.CREATED);
	}

}
