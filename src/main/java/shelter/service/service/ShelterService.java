package shelter.service.service;

import org.springframework.stereotype.Service;
import shelter.service.model.Shelter;
import shelter.service.repository.ShelterRepository;

import java.util.List;

@Service
public class ShelterService {

    final
    ShelterRepository shelterRepository;

    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public Shelter saveShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public Shelter getShelterDetailsById(int id) {
        return shelterRepository.findShelterById(id);
    }

    public List<Shelter> getShelterDetails() {
        return shelterRepository.findAll();
    }
    public Shelter updateShelter(Shelter shelter, int shelterId) {
        shelter.setId(shelterId);
        return shelterRepository.save(shelter);
    }
}
