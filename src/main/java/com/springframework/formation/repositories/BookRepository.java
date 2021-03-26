package com.springframework.formation.repositories;

import com.springframework.formation.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
