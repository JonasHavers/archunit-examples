package com.company.app.application.usecases;

import com.company.app.domain.model.Author;
import com.company.app.domain.model.Book;
import com.company.app.domain.model.Isbn;
import com.company.app.domain.model.Title;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddBookUseCase {
  private final AddBookPort addBookPort;

  public AddBookUseCase(AddBookPort addBookPort) {
    this.addBookPort = addBookPort;
  }

  public Response invoke(Request request) {
    BookDto bookDto = request.book;
    validateBook(bookDto);
    Mono<Void> addBook = addBookPort.addBook(bookDto);
    return new Response(addBook);
  }

  private void validateBook(BookDto bookDto) {
    Isbn isbn = new Isbn(bookDto.isbn);
    Title title = new Title(bookDto.title);
    Author author = new Author(bookDto.author);
    new Book(isbn, title, author);
  }

  public interface AddBookPort {
    Mono<Void> addBook(BookDto bookDto);
  }

  public static class Request {
    final BookDto book;

    public Request(BookDto book) {
      this.book = book;
    }
  }

  public static class Response {
    public final Mono<Void> addBook;

    Response(Mono<Void> addBook) {
      this.addBook = addBook;
    }
  }

  public static class BookDto {
    public String isbn;
    public String title;
    public String author;
  }
}
