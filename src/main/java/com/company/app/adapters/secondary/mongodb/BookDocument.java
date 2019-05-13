package com.company.app.adapters.secondary.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class BookDocument {
  public String isbn;
  public String title;
  public String author;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BookDocument that = (BookDocument) o;
    return Objects.equals(isbn, that.isbn) &&
      Objects.equals(title, that.title) &&
      Objects.equals(author, that.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, title, author);
  }
}
