package com.company.app.adapters.secondary.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface MongoBooksRepository extends ReactiveMongoRepository<BookDocument, String> {
}
