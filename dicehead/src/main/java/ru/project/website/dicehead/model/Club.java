package ru.project.website.dicehead.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Data
@Table(name = "Club")
@ToString
public class Club {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "club_id")  // Создаст колонку club_id в таблице Game
  private Set<Game> games = new HashSet<>();

}
