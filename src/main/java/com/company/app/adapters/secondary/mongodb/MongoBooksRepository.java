package com.company.app.adapters.secondary.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoBooksRepository extends ReactiveMongoRepository<BookDocument, String> {
}
