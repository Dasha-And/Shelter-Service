package shelter.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shelter.service.model.Shelter;
import shelter.service.service.ShelterService;

import java.util.List;
import java.util.Optional;

@RestController
public class ShelterController {

    @Autowired
    ShelterService shelterService;

    @GetMapping(path = "/shelters")
    public List<Shelter> findAll() {
        return shelterService.findAll();
    }

    @GetMapping(path = "/shelter/{id}")
    public Optional<Shelter> findById(@PathVariable Integer id) {
        return shelterService.findById(id);
    }

    @PostMapping(path = "/create_shelter")
    public Shelter insertShelter(@RequestBody Shelter shelter) {
        return shelterService.insertShelter(shelter);
    }

    @PutMapping(path = "/update_shelter")
    public Shelter updateShelter(@RequestBody Shelter shelter) {
        Integer id = shelter.getId();
        return shelterService.updateShelter(id, shelter);
    }

    @DeleteMapping(path = "/delete_shelter/{id}")
    public void deleteShelter(@PathVariable Integer id) {
        shelterService.deleteShelter(id);
    }
}
