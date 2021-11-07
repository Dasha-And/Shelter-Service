package shelter.service.service;

import org.springframework.stereotype.Service;
import shelter.service.model.User;
import shelter.service.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public User getUserDetailsById(int id) {
        return userRepository.findUserById(id);
    }

    public User updateUser(User user, int userId) {
         user.setId(userId);
         return userRepository.save(user);
    }

    public User getUserDetailsByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
