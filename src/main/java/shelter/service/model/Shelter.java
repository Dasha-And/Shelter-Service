package shelter.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shelter {

    private String name;

    private double longitude;

    private double latitude;

    private String phone;

    private String email;

    private String siteUrl;

}
