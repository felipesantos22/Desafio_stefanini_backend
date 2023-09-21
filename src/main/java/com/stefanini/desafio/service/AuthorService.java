package com.stefanini.desafio.service;

import com.stefanini.desafio.model.Author;
import com.stefanini.desafio.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author create(Author author) {
    return authorRepository.save(author);
  }

  public List<Author> read() {
    return authorRepository.findAll();
  }

  public Optional<Author> getByEmail(String email) {
    return authorRepository.findByEmail(email);
  }

  public Optional<Author> getByCpf(String cpf) {
    return authorRepository.findByCpf(cpf);
  }


}
