package shelter.service.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shelter.service.model.Animal;
import shelter.service.service.AnimalService;
import shelter.service.service.ShelterService;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@RestController
public class AnimalController {

    final
    AnimalService animalService;

    final ShelterService shelterService;

    public AnimalController(AnimalService animalService, ShelterService shelterService) {
        this.animalService = animalService;
        this.shelterService = shelterService;
    }

    @GetMapping(path = "/animal_page")
    public ResponseEntity<Animal> getAnimal(@RequestParam int id) {
        Animal animal = animalService.getAnimalDetailsById(id);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @GetMapping(path = "/animals")
    public List<Animal> allAnimals() {
        return animalService.getAnimalDetails();
    }

    @GetMapping(path = "/animals/{id}")
    public List<Animal> animalsByShelter(@PathVariable int id) {
        return animalService.getAnimalsByShelterId(id);
    }

    @PostMapping(path = "/create_animal")
    public ResponseEntity<Animal> insertAnimal(@RequestBody Animal animal) {
        Animal insertedAnimal = animalService.saveAnimal(animal);
        return new ResponseEntity<>(insertedAnimal, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update_animal")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal) {
        Animal updatedAnimal = animalService.updateAnimal(animal);
        return new ResponseEntity<>(updatedAnimal, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_animal")
    public void delete(@RequestParam int id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping(path = "/age")
    public int getAge(@PathVariable int animalId) {
        Animal animal = animalService.getAnimalDetailsById(animalId);
        LocalDate now = LocalDate.now();
        Period period = Period.between(animal.getDateOfBirth().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), now);
        if (period.getYears() >= 1) {
            return period.getYears();
        } else {
            return period.getMonths();
        }

    }

}
