package shelter.service.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import shelter.service.model.Animal;
import shelter.service.repository.AnimalRepository;
import shelter.service.web.model.AnimalDto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Animal> getAnimalsByShelterId(int id, Optional<String> species, Optional<Boolean> sterilized) {
        Specification<Animal> spec =
                Specification.where(speciesIn(species))
                        .and(sterilizedIn(sterilized));
        return animalRepository.findAll(spec).stream().filter(el -> el.getShelterId() == id).collect(
                Collectors.toList());
    }

    public int getByShelter(int id) {
        return animalRepository.findAnimalsByShelterId(id).size();
    }

    public String getAge(Animal animal) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(animal.getDateOfBirth()
                .toLocalDate(), now);
        if (period.getYears() >= 1) {
            return period.getYears() + " рок";
        } else {
            return period.getMonths() + " мiс";
        }
    }

    public Date getDateOfBirth(AnimalDto animalDto) {
        return getAnimalDetailsById(animalDto.getId()).getDateOfBirth();
    }

    public static Specification<Animal> sterilizedIn(Optional<Boolean> sterilized) {
        return (root, query, builder) ->
                sterilized.isPresent() ?
                        root.get("sterilized").in(sterilized.get()) :
                        builder.conjunction(); // to ignore this clause
    }

    public static Specification<Animal> speciesIn(Optional<String> species) {
        return (root, query, builder) ->
                species.isPresent() ?
                        root.get("species").in(species.get()) :
                        builder.conjunction(); // to ignore this clause
    }
}
