package shelter.service.web.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shelter.service.converter.UserConverter;
import shelter.service.model.User;
import shelter.service.service.UserService;
import shelter.service.web.form.UserLoginForm;
import shelter.service.web.model.UserDto;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @PostMapping(path = "/registration")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) throws ExecutionException, InterruptedException, FirebaseAuthException {
        User user = userConverter.toDomainModel(userDto);
        userService.insertUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> login(@RequestBody UserLoginForm userLoginForm) throws ExecutionException, InterruptedException {
        User user = userService.getUserDetailsByEmail(userLoginForm.getEmail());
        if (user != null && user.getPassword().equals(userLoginForm.getPassword())) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } if (user != null && !user.getPassword().equals(userLoginForm.getPassword())) {
            throw new IndexOutOfBoundsException();
        } else {
            throw new RuntimeException();
        }
    }
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

}
