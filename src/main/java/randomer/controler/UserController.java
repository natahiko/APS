package randomer.controler;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import randomer.model.User;
import randomer.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public MyError register (@RequestBody User user){
        userService.save(user);
        System.out.println(user);
        return new MyError("ok");
    }

    @CrossOrigin(origins = "http://localhost:63343")
    @PostMapping("/login")
    public MyError login (@RequestBody String jsonUser, HttpServletResponse response) throws JSONException {
     System.out.println(jsonUser);
        JSONObject json = new JSONObject(new JSONTokener(jsonUser));
        Optional<User> optionalUser = userService.getUserByUsername(json.getString("username"));
        if (!optionalUser.isPresent()) {
            response.setStatus(418);
            return new MyError("no user registered under this usename");
        }
        User user = optionalUser.get();
        if (!user.getPassword().equals(json.getString("password"))) {
            response.setStatus(418);
            return new MyError("your password is incorrect");
        }
        response.setStatus(200);
        return new MyError("ok");
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


    private class SimpleUser{
        private String username;
        private String password;

        SimpleUser(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "SimpleUser{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
