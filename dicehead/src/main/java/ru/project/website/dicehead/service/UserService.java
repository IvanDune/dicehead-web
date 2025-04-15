package ru.project.website.dicehead.service;

import jakarta.transaction.Transactional;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.dicehead.api.model.UpdateUserRequest;
import ru.dicehead.api.model.UserResponse;
import ru.project.website.dicehead.handler.UserRepositoryHandler;
import ru.project.website.dicehead.mapper.UserMapper;
import ru.project.website.dicehead.model.User;
import ru.project.website.dicehead.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepositoryHandler userRepositoryHandler;
  private final UserMapper userMapper;
  private final RedisTemplate<String, String> redisTemplate;

  @Transactional
  public UserResponse getUserById(UUID userId) {
    User user = new User();
    String userJson = redisTemplate.opsForValue().get(userId.toString());
    if (userJson == null) {
      user = userRepositoryHandler.findById(userId);
      redisTemplate.opsForValue().set(userId.toString(), userJson);
      log.info("Сохранение пользователя с {} в Redis.", userId);
    }
    return userMapper.userToUserResponse(user);
  }

  @Transactional
  public UserResponse userUpdate(UpdateUserRequest updateUserRequest) {
    User user = userRepositoryHandler.findById(updateUserRequest.getUserId());
    user.setMobile(updateUserRequest.getMobile());
    user.setNickname(updateUserRequest.getNickname());
    userRepositoryHandler.save(user);
    return userMapper.userToUserResponse(user);
  }

}
