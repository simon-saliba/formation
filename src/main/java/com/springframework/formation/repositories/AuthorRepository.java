package com.springframework.formation.repositories;

import com.springframework.formation.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
