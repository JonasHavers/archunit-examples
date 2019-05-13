package com.company.app.adapters.primary.web;

import com.company.app.application.usecases.AddBookUseCase;
import com.company.app.application.usecases.FindBooksUseCase;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
  private final FindBooksUseCase findBooksUseCase;
  private final AddBookUseCase addBookUseCase;

  public BookController(FindBooksUseCase findBooksUseCase, AddBookUseCase addBookUseCase) {
    this.findBooksUseCase = findBooksUseCase;
    this.addBookUseCase = addBookUseCase;
  }

  @GetMapping("/")
  public Flux<FindBooksUseCase.BookDto> bookList() {
    FindBooksUseCase.Request request = new FindBooksUseCase.Request();
    FindBooksUseCase.Response response = findBooksUseCase.invoke(request);
    return response.books;
  }

  @PostMapping("/")
  public Mono<AddBookUseCase.BookDto> addBook(@RequestBody AddBookUseCase.BookDto bookDto) {
    AddBookUseCase.Request request = new AddBookUseCase.Request(bookDto);
    AddBookUseCase.Response response = addBookUseCase.invoke(request);
    return response.addBook.thenReturn(bookDto);
  }
}
