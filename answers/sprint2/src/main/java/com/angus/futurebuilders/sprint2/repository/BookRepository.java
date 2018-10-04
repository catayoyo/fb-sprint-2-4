package com.angus.futurebuilders.sprint2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.angus.futurebuilders.sprint2.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
