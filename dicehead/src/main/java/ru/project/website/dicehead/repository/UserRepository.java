package ru.project.website.dicehead.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.website.dicehead.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

}
