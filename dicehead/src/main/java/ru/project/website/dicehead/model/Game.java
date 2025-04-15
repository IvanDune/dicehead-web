package ru.project.website.dicehead.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Game")
@ToString
public class Game {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  @Column(name = "title")
  private String title;

  @Column(name = "name")
  @Enumerated(EnumType.STRING)
  private String systemName;

  @Column(name = "description")
  private String description;

  @Column(name = "playersNumber")
  private Integer playersNumber;

  @ManyToOne
  @JoinColumn(name = "club_id", insertable = false, updatable = false)
  private Club club;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "game_player",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "player_id")
  )
  @ToString.Exclude
  Set<User> players = new HashSet<>();

}
