package com.springwithmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithmongo.model.BooksInfo;
import com.springwithmongo.repository.BooksInfoRepository;

@Service
public class BookInfoService {
	
	@Autowired
	BooksInfoRepository bookInfoRepository;
		
	public String addBook(BooksInfo bookInfo)
	{
		try {
			bookInfoRepository.save(bookInfo);
			return "Book saved!";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not Saved!";
		}
	}
}
