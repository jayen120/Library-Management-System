package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.BookRepository;

@Service	
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public List<Book> getAllBooks() { return bookRepo.findAll(); }
    public Book addBook(Book book) { return bookRepo.save(book); }
    public Book updateBook(Long id, Book book) {
        Book existing = bookRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setCategory(book.getCategory());
        existing.setAvailable(book.isAvailable());
        return bookRepo.save(existing);
    }
    public void deleteBook(Long id) { bookRepo.deleteById(id); }
}
