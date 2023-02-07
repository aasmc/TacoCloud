package ru.aasmc.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.aasmc.tacocloud.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
