package com.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplimentRepository extends MongoRepository<Compliment, String> {}