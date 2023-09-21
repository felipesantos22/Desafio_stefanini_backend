package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Author;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
  public Optional<Author> findByEmail(String email);
  public Optional<Author> findByCpf(String cpf);

}
