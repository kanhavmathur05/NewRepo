package com.springwithmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springwithmongo.model.BooksInfo;
import com.springwithmongo.service.BookInfoService;

@RestController
public class BookController {

	@Autowired
	BookInfoService bookInfoService;
	
	@RequestMapping(path="/addBook",method = RequestMethod.POST)
	public String addBook(@RequestBody BooksInfo bookInfo)
	{
		return bookInfoService.addBook(bookInfo);
	}
	
}
