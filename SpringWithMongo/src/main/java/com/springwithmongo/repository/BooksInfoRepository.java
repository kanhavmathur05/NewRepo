package com.springwithmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springwithmongo.model.BooksInfo;

@Repository
public interface BooksInfoRepository extends MongoRepository<BooksInfo, String>{

}
