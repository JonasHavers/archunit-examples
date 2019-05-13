package com.company.app.adapters.secondary.mongodb;

import com.company.app.application.usecases.AddBookUseCase;
import com.company.app.application.usecases.FindBooksUseCase;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BooksRepository implements FindBooksUseCase.FindBooksPort, AddBookUseCase.AddBookPort {
  private final MongoBooksRepository delegateRepository;

  public BooksRepository(MongoBooksRepository delegateRepository) {
    this.delegateRepository = delegateRepository;
  }

  @Override
  public Flux<FindBooksUseCase.BookDto> findAllBooks() {
    return delegateRepository
      .findAll()
      .map(bookDocument -> {
        FindBooksUseCase.BookDto bookDto = new FindBooksUseCase.BookDto();
        bookDto.isbn = bookDocument.isbn;
        bookDto.title = bookDocument.title;
        bookDto.author = bookDocument.author;
        return bookDto;
      });
  }

  @Override
  public Mono<Void> addBook(AddBookUseCase.BookDto bookDto) {
    BookDocument bookDocument = new BookDocument();
    bookDocument.isbn = bookDto.isbn;
    bookDocument.title = bookDto.title;
    bookDocument.author = bookDto.author;
    return delegateRepository
      .save(bookDocument)
      .thenEmpty(Mono.empty());
  }
}
