package ru.project.website.dicehead.model;

import lombok.Getter;

@Getter
public enum GameSystem {
  DUNGEONS_AND_DRAGONS_5E("Dungeons and Dragons 5E"),
  DUNGEONS_AND_DRAGONS_4E("Dungeons and Dragons 4E"),
  DUNGEONS_AND_DRAGONS_35E("Dungeons and Dragons 3.5E"),
  CYBERPUNK_2020("Cyberpunk 2020"),
  CYBERPUNK_RED("Cyberpunk RED"),
  PATHFINDER_1E("Pathfinder 1E"),
  PATHFINDER_2E("Pathfinder 2E"),
  VAMPIRE_THE_MASQUERADE("Vampire The Masquerade"),
  MOTHERSHIP("Mothership"),
  DEATH_IN_SPACE("Death In Space"),
  DELTA_GREEN("Delta Green"),
  WARHAMMER_FANTASY_ROLEPLAY("Warhammer Fantasy Roleplay"),
  SPIRE("Spire"),
  HEART("Heart");


  private final String description;

  GameSystem(String description) {
    this.description = description;
  }

  public static GameSystem getNameByDescription(String description) {
    for (GameSystem e : GameSystem.values()) {
      if (e.description.equals(description)) {
        return e;
      }
    }
    return null;
  }
}
