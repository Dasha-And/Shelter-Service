package shelter.service.converter;

import org.springframework.stereotype.Component;
import shelter.service.model.User;
import shelter.service.web.model.UserDto;

@Component
public class UserConverter {

    public User toDomainModel(UserDto userDto) {
        String role = "admin";
        if (userDto.getRole() == null) {
            role = "user";
        }
        return new User(userDto.getName(), userDto.getLastName(), userDto.getPhone(), userDto.getEmail(), userDto.getPassword(), role, userDto.getShelterId());
    }
}
