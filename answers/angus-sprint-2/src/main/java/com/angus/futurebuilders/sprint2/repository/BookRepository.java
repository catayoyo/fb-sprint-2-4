package com.angus.futurebuilders.sprint2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.angus.futurebuilders.sprint2.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    public Iterable<Book> findByAuthor(String author);
    public Iterable<Book> findByTitle(String title);
    public Iterable<Book> findByReleaseDate(Date releaseDate);

    public boolean existsByTitle(String title);
}
