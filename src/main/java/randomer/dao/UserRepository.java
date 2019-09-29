package randomer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import randomer.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();

    User save(User user);

    User getUserByUsername(String username);
}
