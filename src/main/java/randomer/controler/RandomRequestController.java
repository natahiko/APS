package randomer.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import randomer.functionality.Randomizer;
import randomer.model.Request;
import randomer.service.RequestService;

import java.util.ArrayList;

@RestController
public class RandomRequestController {
    private RequestService requestService;

    @Autowired
    public RandomRequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @PostMapping("/random")
    public ArrayList<Integer> getRandom(@RequestParam(name = "username") String username, @RequestParam(name = "start", required = true) int start, @RequestParam(name = "end", required = true) int end) {
        requestService.save(new Request(start, end, username));
        return (new Randomizer()).generate(start, end);
    }

}
