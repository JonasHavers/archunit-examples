package com.company.app.application.usecases;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FindBooksUseCase {
  private final FindBooksPort findBooksPort;

  public FindBooksUseCase(FindBooksPort findBooksPort) {
    this.findBooksPort = findBooksPort;
  }

  public Response invoke(Request request) {
    Flux<BookDto> allBooks = findBooksPort.findAllBooks();
    return new Response(allBooks);
  }

  public interface FindBooksPort {
    Flux<BookDto> findAllBooks();
  }

  public static class Request {
  }

  public static class Response {
    public final Flux<BookDto> books;

    Response(Flux<BookDto> books) {
      this.books = books;
    }
  }

  public static class BookDto {
    public String isbn;
    public String title;
    public String author;
  }
}
