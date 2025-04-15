package ru.project.website.dicehead.rest;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.dicehead.api.UserApi;
import ru.dicehead.api.model.UpdateUserRequest;
import ru.dicehead.api.model.UserResponse;
import ru.project.website.dicehead.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {
  private final UserService userService;

  @Override
  public ResponseEntity<UserResponse> getUser(UUID userId){
    if (userId == null){
      log.error("Передали null userId");
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok().body(userService.getUserById(userId));
  }

  @Override
  public ResponseEntity<UserResponse> updateUser(UpdateUserRequest updateUserRequest)
      throws Exception {
    if (updateUserRequest == null){
      log.error("Передали null updateUserRequest");
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok().body(userService.userUpdate(updateUserRequest));
  }
}
