package shelter.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shelter.service.model.AnimalVaccination;
import shelter.service.service.AnimalVaccinationService;

import java.util.List;

@RestController
public class AnimalVaccinationController {

    @Autowired
    AnimalVaccinationService animalVaccinationService;

    @GetMapping("/animal_vaccinations")
    public List<AnimalVaccination> getByAnimal(@RequestParam int animalId) {
        return animalVaccinationService.findByAnimal(animalId);
    }

    @PostMapping("/create_animal_vaccination")
    public ResponseEntity<AnimalVaccination> createAnimalVaccination(@RequestBody AnimalVaccination animalVaccination) {
        return new ResponseEntity<>(animalVaccinationService.saveAnimalVaccination(animalVaccination), HttpStatus.CREATED);
    }

    @PutMapping("/update_animal_vaccination")
    public ResponseEntity<AnimalVaccination> updateAnimalVaccination(@RequestBody AnimalVaccination animalVaccination) {
        return new ResponseEntity<>(animalVaccinationService.updateAnimalVaccination(animalVaccination), HttpStatus.OK);
    }

    @DeleteMapping("/delete_animal_vaccination")
    public void delete(@RequestParam int id) {
        animalVaccinationService.deleteAnimalVaccination(id);
    }
}
