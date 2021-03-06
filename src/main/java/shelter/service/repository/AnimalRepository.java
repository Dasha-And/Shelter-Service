package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import shelter.service.model.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>,
        JpaSpecificationExecutor<Animal> {
    Animal findAnimalById(int id);
    List<Animal> findAnimalsByShelterId(int id);
}
