package shelter.service.web.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shelter.service.firebase.Firebase;
import shelter.service.model.Shelter;
import shelter.service.model.User;
import shelter.service.service.ShelterService;
import shelter.service.service.UserService;

import java.util.concurrent.ExecutionException;

@RestController
public class ShelterController {

    @Autowired
    ShelterService shelterService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/shelter_page")
    public String getShelter(@RequestParam String id) throws ExecutionException, InterruptedException {
        User user = userService.getUserDetailsById(id);
        System.out.println(user.getPassword());
        System.out.println(user.getShelterId());

        if (user.getShelterId() != null) {
            Shelter shelter = shelterService.getShelterDetailsById(user.getShelterId());
            return shelter.getName();
        } else {
            return "this user have no shelter";
        }
    }

    @PostMapping(path = "/create_shelter")
    public String insertShelter(@RequestBody Shelter shelter) throws ExecutionException, InterruptedException {
        return shelterService.saveShelter(shelter);

    }

}
