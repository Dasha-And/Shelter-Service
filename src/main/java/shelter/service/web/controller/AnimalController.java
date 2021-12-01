package shelter.service.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shelter.service.converter.AnimalConverter;
import shelter.service.model.Animal;
import shelter.service.service.AnimalService;
import shelter.service.service.ShelterService;
import shelter.service.web.model.AnimalDto;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AnimalController {

    final
    AnimalService animalService;

    final ShelterService shelterService;

    final AnimalConverter animalConverter;

    public AnimalController(AnimalService animalService, ShelterService shelterService, AnimalConverter animalConverter) {
        this.animalService = animalService;
        this.shelterService = shelterService;
        this.animalConverter = animalConverter;
    }

    @GetMapping(path = "/animal_page")
    public ResponseEntity<AnimalDto> getAnimal(@RequestParam int id) {
        AnimalDto animalDto = animalConverter.toDto(animalService.getAnimalDetailsById(id));
        return new ResponseEntity<>(animalDto, HttpStatus.OK);
    }

    @GetMapping(path = "/animals")
    public List<AnimalDto> allAnimals() {
        return animalService.getAnimalDetails().stream().map(
                animalConverter::toDto).collect(
                Collectors.toList());
    }

    @GetMapping(path = "/animals/{id}")
    public List<AnimalDto> animalsByShelter(@PathVariable int id, @RequestParam(required = false) Optional<Boolean> sterilized,
            @RequestParam(required = false) Optional<String> species) {
        return animalService.getAnimalsByShelterId(id, species, sterilized).stream().map(
                animalConverter::toDto).collect(
                Collectors.toList());
    }

    @PostMapping(path = "/create_animal")
    public ResponseEntity<AnimalDto> insertAnimal(@RequestBody AnimalDto animalDto) {
        AnimalDto insertedAnimal = animalConverter.toDto(animalService.saveAnimal(animalConverter.toDomainModel(animalDto)));
        return new ResponseEntity<>(insertedAnimal, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update_animal")
    public ResponseEntity<AnimalDto> updateAnimal(@RequestBody AnimalDto animalDto) {
        AnimalDto updatedAnimal = animalConverter.toDto(animalService.updateAnimal(animalConverter.toDomainModel(animalDto)));
        return new ResponseEntity<>(updatedAnimal, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_animal")
    public void delete(@RequestParam int id) {
        animalService.deleteAnimal(id);
    }

}
