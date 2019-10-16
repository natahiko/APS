package randomer.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import randomer.functionality.Randomizer;
import randomer.model.ProxyRequest;
import randomer.model.ProxyUser;
import randomer.model.Request;
import randomer.service.RequestService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class RandomRequestController {
    private RequestService requestService;

    @Autowired
    public RandomRequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/random")
    public String getRandom(@RequestParam(name = "username") String username, @RequestParam(name = "start", required = true) int start, @RequestParam(name = "end", required = true) int end) {
        requestService.save(new Request(start, end, username));
        String ret = (new Randomizer()).generate(start, end).toString();
        return new StringBuffer(ret).deleteCharAt(ret.length()-1).deleteCharAt(0).toString();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getAllRequests")
    public ArrayList<ProxyRequest> getAll(@RequestParam(name="username") String username){
        return new ArrayList<>(requestService
                .getAllByUsername(username)
                .stream()
                .map(ProxyRequest::new)
                .collect(Collectors.toList()));
    }
}
