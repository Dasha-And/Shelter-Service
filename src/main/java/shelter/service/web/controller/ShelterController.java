package shelter.service.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shelter.service.model.Shelter;
import shelter.service.model.User;
import shelter.service.service.AnimalService;
import shelter.service.service.ShelterService;
import shelter.service.service.UserService;

import java.util.List;

@RestController
public class ShelterController {

    final
    ShelterService shelterService;

    final
    UserService userService;

    final AnimalService animalService;

    public ShelterController(ShelterService shelterService, UserService userService, AnimalService animalService) {
        this.shelterService = shelterService;
        this.userService = userService;
        this.animalService = animalService;
    }

    @GetMapping(path = "/shelter_page")
    public ResponseEntity<Shelter> getShelter(@RequestParam int id) {
        Shelter shelter = shelterService.getShelterDetailsById(id);
        return new ResponseEntity<>(shelter, HttpStatus.OK);
    }

    @GetMapping(path = "/shelters")
    public List<Shelter> sports() {
        return shelterService.getShelterDetails();
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

    @GetMapping("get_taken_places")
    public int getTakenPlacesInShelter(int id) {
        return animalService.getByShelter(id);
    }

}
