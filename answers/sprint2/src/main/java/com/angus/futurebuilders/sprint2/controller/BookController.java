package com.angus.futurebuilders.sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

import com.angus.futurebuilders.sprint2.model.Book;
import com.angus.futurebuilders.sprint2.repository.BookRepository;


/**
 * REST controller for Book objects
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("")
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping("/find")
    public Iterable<Book> find(@RequestParam("id") Optional<Integer> id,
                               @RequestParam("title") Optional<String> title) {
        if (id.isPresent())
            if (bookRepository.existsById(id.get()))
                return Collections.singleton(bookRepository.findById(id.get()).get());
        if (title.isPresent())
            return bookRepository.findByTitle(title.get());
        return null;
    }

    @RequestMapping("/create")
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @RequestMapping("/update")
    @PostMapping
    public Book updateBook(@RequestBody Book book) {
        if (book.getId() != null && bookRepository.existsById(book.getId()))    // don't save unknown books
            return bookRepository.save(book);
        else return null;
    }

    @RequestMapping("/delete/{id}")
    public boolean deleteBookById(@PathVariable("id") Integer id) {
        if (id != null) {
            if (bookRepository.existsById(id)) {
                bookRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/delete")
    @DeleteMapping
    public boolean deleteBook(@RequestBody Book book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }
}
