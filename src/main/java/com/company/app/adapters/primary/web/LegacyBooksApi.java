package com.company.app.adapters.primary.web;

import com.company.app.adapters.secondary.mongodb.BookDocument;
import com.company.app.adapters.secondary.mongodb.MongoBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/api/books")
public class LegacyBooksApi {
  @Autowired
  private MongoBooksRepository mongoBooksRepository;

  @RequestMapping("/")
  @ResponseBody
  public Flux<BookDocument> findAll() {
    return mongoBooksRepository.findAll();
  }
}
