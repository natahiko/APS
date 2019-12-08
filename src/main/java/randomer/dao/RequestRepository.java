package randomer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import randomer.model.Request;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {

    Request save (Request request);

//    List<Request> getAllByUsername(String username);
    List<Request> getAllByUser(int user);
}
