package com.company.app.domain.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Book {
  private final Isbn isbn;
  private final Title title;
  private final Author author;

  public Book(Isbn isbn, Title title, Author author) {
    if (isbn == null) {
      throw new IllegalArgumentException("The book's ISBN is required.");
    }
    if (title == null) {
      throw new IllegalArgumentException("The book's title is required.");
    }
    if (author == null) {
      throw new IllegalArgumentException("The book's author is required.");
    }
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }

  public Isbn isbn() {
    return isbn;
  }

  public Title title() {
    return title;
  }

  public Author author() {
    return author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(isbn, book.isbn) &&
      Objects.equals(title, book.title) &&
      Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, title, author);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
      .add("isbn=" + isbn)
      .add("title=" + title)
      .add("author=" + author)
      .toString();
  }
}
