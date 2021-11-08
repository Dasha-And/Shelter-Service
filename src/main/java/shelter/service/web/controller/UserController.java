package shelter.service.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shelter.service.converter.UserConverter;
import shelter.service.exceptions.UserIsNotRegistered;
import shelter.service.exceptions.WrongPasswordException;
import shelter.service.model.Shelter;
import shelter.service.model.User;
import shelter.service.service.UserService;
import shelter.service.web.form.UserLoginForm;
import shelter.service.web.model.UserDto;

import java.util.List;

@RestController
public class UserController {

    final
    UserService userService;

    final
    UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping(path = "/registration")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) throws JsonProcessingException {
        User user = userConverter.toDomainModel(userDto);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));
        User insertedUser = userService.insertUser(user);
        return new ResponseEntity<>(insertedUser, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> login(@RequestBody UserLoginForm userLoginForm) throws WrongPasswordException, UserIsNotRegistered {
        User user = userService.getUserDetailsByEmail(userLoginForm.getEmail());
        if (user != null && user.getPassword().equals(userLoginForm.getPassword())) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } if (user != null && !user.getPassword().equals(userLoginForm.getPassword())) {
            throw new WrongPasswordException("Невірний пароль");
        } else {
            throw new UserIsNotRegistered("Користувача з таким логіном не існує");
        }
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserById(@RequestParam int userId) {
        User user = userService.getUserDetailsById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/users")
    public List<User> users() {
        return userService.getAllUsers();
    }

    @PutMapping(path = "/update_user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
