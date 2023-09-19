package com.stefanini.desafio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import validations.Sexo;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "auhor")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private Sexo sexo;

  @Column
  private String email;

  @Column
  private LocalDate date;

  @Column
  private String country;

  @Column
  private String cpf;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "Author_ArtWork",
      joinColumns = { @JoinColumn(name = "author_id") },
      inverseJoinColumns = { @JoinColumn(name = "artwork_id") }
  )
  private List<Art> artWorks = new ArrayList<>();

}
