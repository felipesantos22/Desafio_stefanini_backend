package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
