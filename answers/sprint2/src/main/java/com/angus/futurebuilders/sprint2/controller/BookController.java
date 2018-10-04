package com.angus.futurebuilders.sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.websocket.server.PathParam;
import java.util.Optional;

import com.angus.futurebuilders.sprint2.model.Book;
import com.angus.futurebuilders.sprint2.repository.BookRepository;


/**
 * REST controller for Book objects
 * */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        if (id != null) {
            Optional<Book> book = bookRepository.findById(id);
            if (book.isPresent()) return book.get();
        }
        return null;
    }

    @RequestMapping("/create")
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
