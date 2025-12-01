package com.example.library.dto;

import jakarta.validation.constraints.NotNull;

public class IssueRequest {
  @NotNull private Long userId;
  @NotNull private Long bookId;

  public Long getUserId() 
  { 
	  return userId;
  }
  public void setUserId(Long userId) 
  { 
	  this.userId = userId; 
  }
  public Long getBookId() 
  { 
	  return bookId; 
  }
  public void setBookId(Long bookId) 
  { 
	  this.bookId = bookId; 
  }
}
