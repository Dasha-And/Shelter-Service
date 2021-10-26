package shelter.service.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String password;

    private String role;

    private int shelterId;

}
