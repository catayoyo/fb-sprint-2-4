package com.angus.futurebuilders.sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Book getBook(@PathParam("title") Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) return book.get();
        else return new Book();
    }

    @RequestMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
