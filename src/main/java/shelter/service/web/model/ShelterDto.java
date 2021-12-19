package shelter.service.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShelterDto {
    private int id;

    private String name;

    private double longitude;

    private double latitude;

    private String phone;

    private String email;

    private String siteUrl;

    private int capacity;

    private int freePlaces;
}
