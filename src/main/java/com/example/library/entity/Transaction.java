package com.example.library.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne private User user;
    @ManyToOne private Book book;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Double fine;
    
 // getters and setters

}
