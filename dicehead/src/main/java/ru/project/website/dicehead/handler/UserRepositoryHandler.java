package ru.project.website.dicehead.handler;

import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.website.dicehead.model.User;
import ru.project.website.dicehead.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserRepositoryHandler {
  private final UserRepository userRepository;

  public User findById(UUID userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new EntityNotFoundException(String.format("User with id: %s not found", userId)));
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
