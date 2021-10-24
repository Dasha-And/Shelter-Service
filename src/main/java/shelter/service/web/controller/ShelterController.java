package shelter.service.web.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shelter.service.firebase.Firebase;
import shelter.service.model.Shelter;
import shelter.service.model.User;
import shelter.service.service.ShelterService;
import shelter.service.service.UserService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ShelterController {

    @Autowired
    ShelterService shelterService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/shelter_page")
    public ResponseEntity<Shelter> getShelter(@RequestParam String id) throws Exception {
        Shelter shelter = shelterService.getShelterDetailsById(id);
        return new ResponseEntity<Shelter>(shelter, HttpStatus.OK);
    }

    @GetMapping(path = "/shelters")
    public List<Shelter> sports() throws ExecutionException, InterruptedException {
        return shelterService.getShelterDetails();
    }

    @PostMapping(path = "/create_shelter")
    public ResponseEntity<Shelter> insertShelter(@RequestBody Shelter shelter, @RequestParam String email) throws ExecutionException, InterruptedException {
        shelterService.saveShelter(shelter);
        User user = userService.getUserDetailsByEmail(email);
        user.setShelterId(shelterService.getShelterIdByName(shelter.getName()));
        userService.updateUserShelterId(user);
        return new ResponseEntity<Shelter>(shelter, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update_shelter")
    public ResponseEntity<Shelter> updateShelter(@RequestBody Shelter shelter, @RequestParam String id) throws ExecutionException, InterruptedException {
        shelterService.updateShelter(shelter, id);
        return new ResponseEntity<>(shelter, HttpStatus.OK);
    }

}
