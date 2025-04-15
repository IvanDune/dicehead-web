package ru.project.website.dicehead.mapper;

import org.mapstruct.Mapper;
import ru.dicehead.api.model.UserResponse;
import ru.project.website.dicehead.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserResponse userToUserResponse(User user);
}
