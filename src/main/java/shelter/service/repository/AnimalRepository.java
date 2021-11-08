package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelter.service.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Animal findAnimalById(int id);
}
