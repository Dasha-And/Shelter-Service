package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelter.service.model.Shelter;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    Shelter findShelterById(int id);
}
