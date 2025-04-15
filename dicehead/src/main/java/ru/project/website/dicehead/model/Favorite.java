package ru.project.website.dicehead.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Favorite")
@ToString
public class Favorite {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  @ElementCollection
  @Enumerated(EnumType.STRING)  // Сохраняем как строку, например, DUNGEONS_AND_DRAGONS_5E
  @CollectionTable(name = "favorite_game_systems", joinColumns = @JoinColumn(name = "favorite_id"))
  private Set<GameSystem> gameSystems = new HashSet<>();

  // Избранные клубы
  @ManyToMany
  @JoinTable(
      name = "favorite_clubs",
      joinColumns = @JoinColumn(name = "favorite_id"),
      inverseJoinColumns = @JoinColumn(name = "club_id")
  )
  private Set<Club> clubs = new HashSet<>();

  // Избранные мастера
  @ManyToMany
  @JoinTable(
      name = "favorite_masters",
      joinColumns = @JoinColumn(name = "favorite_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private Set<User> masters = new HashSet<>();

}
