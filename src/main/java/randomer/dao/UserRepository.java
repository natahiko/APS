package randomer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import randomer.model.User;


import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    ArrayList<User> findAll();

    User save(User user);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);
}
