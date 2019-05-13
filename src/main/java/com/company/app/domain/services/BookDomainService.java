package com.company.app.domain.services;

import com.company.app.domain.model.Author;
import com.company.app.domain.model.Book;

public class BookDomainService {

  public void complexBusinessTransaction(Book book) {
    Author author = book.author();
    String firstName = author.firstName();
    String lastName = author.lastName();
    // no-op
  }
}
