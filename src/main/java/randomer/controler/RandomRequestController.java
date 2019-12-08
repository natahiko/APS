package randomer.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import randomer.functionality.Randomizer;
import randomer.model.ProxyRequest;
import randomer.model.Request;
import randomer.model.User;
import randomer.service.RequestService;
import randomer.service.UserService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class RandomRequestController {
    private RequestService requestService;
    private UserService userService;

    @Autowired
    public RandomRequestController(RequestService requestService
            , UserService userService
    ) {
        this.requestService = requestService;
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/random")
    public String getRandom(@RequestParam(name = "username") String username, @RequestParam(name = "start", required = true) int start, @RequestParam(name = "end", required = true) int end) {
        User user = userService.getUserByUsername(username).get();
        requestService.save(new Request(start, end, user.getId()));
        String ret = (new Randomizer()).generate(start, end).toString();
        return new StringBuffer(ret).deleteCharAt(ret.length()-1).deleteCharAt(0).toString();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getAllRequests")
    public ArrayList<ProxyRequest> getAll(@RequestParam(name="username") String username){
        User user = userService.getUserByUsername(username).get();
        return new ArrayList<>(requestService
                .getAllByUser(user.getId())
                .stream()
                .map(ProxyRequest::new)
                .collect(Collectors.toList()));
    }
}
