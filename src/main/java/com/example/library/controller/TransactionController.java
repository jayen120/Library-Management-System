package com.example.library.controller;

import com.example.library.dto.IssueRequest;
import com.example.library.entity.Book;
import com.example.library.entity.Transaction;   // ✅ correct import
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService txService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookRepository bookRepo;

    // Issue a book
    @PostMapping("/issue")
    public Transaction issueBook(@RequestBody IssueRequest req) {
        User user = userRepo.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepo.findById(req.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return txService.issueBook(user, book);
    }

    // Return a book
    @PostMapping("/return/{id}")
    public Transaction returnBook(@PathVariable Long id) {
        return txService.returnBook(id);
    }
}
