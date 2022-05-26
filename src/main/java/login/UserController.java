package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        userService.register(user);
        return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        Boolean auth = userService.findByUsernameAndPassword(user);
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }
}
