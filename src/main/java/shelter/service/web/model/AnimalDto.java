package shelter.service.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {

    private int id;
    private String name;
    private String description;
    private String gender;
    private String age;
    private boolean sterilized;
    private String imageUrl;
    private String species;
    private int shelterId;
    private String status;
}
