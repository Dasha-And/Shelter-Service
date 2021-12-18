package shelter.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animal_vaccination")
public class AnimalVaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "animal_id")
    private int animalId;

    @Column(name = "vaccine_name")
    private String vaccine_name;

    @Column(name = "doze")
    private String doze;

    @Column(name = "date")
    private Date date;

    @Column(name = "disease")
    private String disease;
}
