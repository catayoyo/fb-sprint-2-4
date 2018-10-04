package com.angus.futurebuilders.sprint2.repository;

import com.angus.futurebuilders.sprint2.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
