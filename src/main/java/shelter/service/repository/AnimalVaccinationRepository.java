package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelter.service.model.AnimalVaccination;

import java.util.List;

@Repository
public interface AnimalVaccinationRepository extends JpaRepository<AnimalVaccination, Integer> {
    AnimalVaccination findAnimalVaccinationById(int id);
    List<AnimalVaccination> findAnimalVaccinationByAnimalId(int animalId);
}
