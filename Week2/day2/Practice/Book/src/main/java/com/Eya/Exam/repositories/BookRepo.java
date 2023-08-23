package com.Eya.Exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eya.Exam.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> ,PagingAndSortingRepository{
	
	// Read All
	List<Book> findAll();
}



