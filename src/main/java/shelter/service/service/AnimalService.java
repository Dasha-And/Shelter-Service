package shelter.service.service;

import org.springframework.stereotype.Service;
import shelter.service.model.Animal;
import shelter.service.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {

    final
    AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal getAnimalDetailsById(int id) {
        return animalRepository.findAnimalById(id);
    }

    public List<Animal> getAnimalDetails() {
        return animalRepository.findAll();
    }
    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}
