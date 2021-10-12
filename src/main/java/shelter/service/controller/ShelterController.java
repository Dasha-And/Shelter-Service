package shelter.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shelter.service.model.Shelter;
import shelter.service.service.ShelterService;

import java.util.concurrent.ExecutionException;

@RestController
public class ShelterController {

    @Autowired
    ShelterService shelterService;

    @PostMapping(path = "/create_shelter")
    public String insertShelter(@RequestBody Shelter shelter) throws ExecutionException, InterruptedException {
        return shelterService.saveShelter(shelter);
    }

}
