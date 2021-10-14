package shelter.service.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    private String role;

    private String shelterId;

}
