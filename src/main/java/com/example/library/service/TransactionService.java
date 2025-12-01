package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.Transaction;
import com.example.library.entity.User;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.BookRepository;
import com.example.library.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository txRepo;

    @Autowired
    private BookRepository bookRepo;

    // Issue a book to a user
    public Transaction issueBook(User user, Book book) {
        if (!book.isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        book.setAvailable(false);
        bookRepo.save(book);

        Transaction tx = new Transaction();   // ✅ now using your entity
        tx.setUser(user);
        tx.setBook(book);
        tx.setIssueDate(LocalDate.now());
        tx.setDueDate(LocalDate.now().plusDays(14));

        return txRepo.save(tx);
    }

    // Return a book
    public Transaction returnBook(Long txId) {
        Transaction tx = txRepo.findById(txId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        tx.setReturnDate(LocalDate.now());

        if (tx.getReturnDate() != null && tx.getDueDate() != null && tx.getReturnDate().isAfter(tx.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(tx.getDueDate(), tx.getReturnDate());
            tx.setFine(daysLate * 10.0);
        }

        Book book = tx.getBook();
        book.setAvailable(true);
        bookRepo.save(book);

        return txRepo.save(tx);
    }
}
