package randomer.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import randomer.functionality.Randomizer;

import java.util.ArrayList;

@RestController
public class RandomRequestController {

//    @Autowired
//    public RandomRequestController(){
//    }

    @PostMapping("/random")
    public ArrayList<Integer> getUser(@RequestParam(name = "start", required = true) int start, @RequestParam(name = "end", required = true) int end) {
        return (new Randomizer()).generate(start, end);
    }
}
