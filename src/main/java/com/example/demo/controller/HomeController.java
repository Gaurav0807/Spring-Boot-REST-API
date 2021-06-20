package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BookService;
import com.example.demo.entity.*;

@RestController
public class HomeController {
	
	@Autowired
	private BookService BookService;
	
	@GetMapping("/home")
	public String home()
	{
		return "this is home page";
	}
	
	//Get the Books
	@GetMapping("/Books")
	public List<Book> getBooks()
	{
		return this.BookService.getBooks();
	}
	
	@GetMapping("/Books/{id}")
	public Book getBooks(@PathVariable int id)
	{
		return this.BookService.getBooks(id);
	}
	
	@PostMapping(path="/Books")
	public Book addBook(@RequestBody Book c)
	{
		return this.BookService.addBook(c);
	}
	
	@PutMapping("/Books")
	public Book UpdateBook(@RequestBody Book c)
	{
		return this.BookService.updateBook(c);
	}
	
	@DeleteMapping("/Books/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable int id)
	{
		try {
			this.BookService.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}



























