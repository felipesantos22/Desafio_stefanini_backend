package com.stefanini.desafio.repository;

import com.stefanini.desafio.model.Art;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtRepository extends JpaRepository<Art, Integer> {

}
