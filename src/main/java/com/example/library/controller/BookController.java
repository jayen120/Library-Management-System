package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.entity.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired private BookService bookService;

    @GetMapping
    public List<Book> getBooks() { return bookService.getAllBooks(); }

    @PostMapping
    public Book addBook(@RequestBody Book book) { return bookService.addBook(book); }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) { bookService.deleteBook(id); }

}
