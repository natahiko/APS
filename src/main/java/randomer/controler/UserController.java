package randomer.controler;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import randomer.model.ProxyUser;
import randomer.model.User;
import randomer.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/register")
    public MyError register (@RequestBody User user, HttpServletResponse response){
        Optional<User> optional = userService.getUserByUsername(user.getUsername());
        if (optional.isPresent()){
            response.setStatus(418);
            return new MyError("This username is already taken");
        }
        optional = userService.getUserByEmail(user.getEmail());
        if (optional.isPresent()){
            response.setStatus(418);
            return new MyError("This email is already taken");
        }

        userService.save(user);
        response.setStatus(200);
        return new MyError("ok");
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/login")
    public MyError login (@RequestBody String jsonUser, HttpServletResponse response) throws JSONException {
        System.out.println(jsonUser);
        JSONObject json = new JSONObject(new JSONTokener(jsonUser));
        Optional<User> optionalUser = userService.getUserByUsername(json.getString("username"));
        if (!optionalUser.isPresent()) {
            response.setStatus(418);
            System.out.println("username");
            return new MyError("no user registered under this usename");
        }
        User user = optionalUser.get();
        if (!user.getPassword().equals(json.getString("password"))) {
            response.setStatus(418);
            System.out.println("password");
            return new MyError("your password is incorrect");
        }
        response.setStatus(200);
        System.out.println("ok");
        return new MyError("ok");
    }

    @GetMapping("/getAllUsers")
    public ArrayList<ProxyUser> getAllUsers(){
       return new ArrayList<>(userService
               .findAll()
               .stream()
               .map(ProxyUser::new)
               .collect(Collectors.toList()));
    }

    private class MyError{
        private String error;

        MyError(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}