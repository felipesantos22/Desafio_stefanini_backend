package com.stefanini.desafio.controller;

import com.stefanini.desafio.model.Author;
import com.stefanini.desafio.service.AuthorService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Author author) {
    Optional<Author> optionalAuthor = authorService.getByEmail(author.getEmail());
    Optional<Author> optionalCpf = authorService.getByCpf(author.getCpf());
    if (author.getName().isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nome obrigatorio!");
    }
    if (optionalAuthor.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email já existe!");
    }
    if (author.getDate() == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data de nascimento não informada!");
    }
    if (author.getCountry().isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("País não informado!");
    }
    if (author.getCountry().equalsIgnoreCase("Brasil") && author.getCpf().isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF obrigatorio!");
    }
    if (optionalCpf.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf já existe!");
    } else {
      Author authors = authorService.create(author);
      return ResponseEntity.status(HttpStatus.CREATED).body(authors);
    }
  }

  @GetMapping
  public List<Author> read() {
    return authorService.read();
  }


}
