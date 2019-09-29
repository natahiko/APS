package randomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import randomer.dao.RequestRepository;
import randomer.model.Request;

import java.util.List;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }


    public Request save(Request user) {
        return requestRepository.save(user);
    }

    public List<Request> getAllByUsername(String username) {
        return requestRepository.getAllByUsername(username);
    }
}
