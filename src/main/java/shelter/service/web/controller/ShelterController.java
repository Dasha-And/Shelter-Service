package shelter.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shelter.service.converter.ShelterConverter;
import shelter.service.model.Shelter;
import shelter.service.model.User;
import shelter.service.service.AnimalService;
import shelter.service.service.ShelterService;
import shelter.service.service.UserService;
import shelter.service.web.model.ShelterDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShelterController {

    final
    ShelterService shelterService;

    final
    UserService userService;

    final AnimalService animalService;

    final
    ShelterConverter shelterConverter;

    public ShelterController(ShelterService shelterService, UserService userService, AnimalService animalService, ShelterConverter shelterConverter) {
        this.shelterService = shelterService;
        this.userService = userService;
        this.animalService = animalService;
        this.shelterConverter = shelterConverter;
    }

    @GetMapping(path = "/shelter_page")
    public ResponseEntity<ShelterDto> getShelter(@RequestParam int id) {
        ShelterDto shelterDto = shelterConverter.toDto(shelterService.getShelterDetailsById(id));
        return new ResponseEntity<>(shelterDto, HttpStatus.OK);
    }

    @GetMapping(path = "/shelters")
    public List<ShelterDto> sports() {
        return shelterService.getShelterDetails().stream().map(shelterConverter::toDto).collect(Collectors.toList());
    }

    @PostMapping(path = "/create_shelter")
    public ResponseEntity<Shelter> insertShelter(@RequestBody Shelter shelter, @RequestParam int userId) {
        Shelter insertedShelter = shelterService.saveShelter(shelter);
        User user = userService.getUserDetailsById(userId);
        user.setShelterId(insertedShelter.getId());
        userService.updateUser(user);
        return new ResponseEntity<>(insertedShelter, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update_shelter")
    public ResponseEntity<Shelter> updateShelter(@RequestBody Shelter shelter) {
        Shelter updatedShelter = shelterService.updateShelter(shelter);
        return new ResponseEntity<>(updatedShelter, HttpStatus.OK);
    }

}
