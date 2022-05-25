package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebUserController {

    private final WebUserService webUserService;

    @Autowired
    public WebUserController(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody WebUser webUser){
        webUserService.register(webUser);
        return new ResponseEntity<>(webUser.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/users")
    public ResponseEntity<Iterable<WebUser>> getUsers() {
        Iterable<WebUser> webUsers = webUserService.findAll();
        return new ResponseEntity<>(webUsers, HttpStatus.OK);
    }
}
