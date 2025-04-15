package ru.project.website.dicehead.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "User")
@ToString
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  @Column(name ="nickname")
  private String nickname;

  @Column(name ="mail")
  private String mail;

  @Column(name ="mobile")
  private String mobile;

  @OneToOne
  @JoinColumn(name = "favorite_id")
  private Favorite favorite;

  @ManyToMany(mappedBy = "players")
  private Set<Game> games;




}
