package shelter.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shelter.service.model.Shelter;
import shelter.service.repository.ShelterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    @Autowired
    ShelterRepository shelterRepository;

    public Shelter insertShelter(Shelter shelter) {
         return shelterRepository.save(shelter);
    }

    public void deleteShelter(Integer id) {
        shelterRepository.deleteById(id);
    }

    public Shelter updateShelter(Integer id, Shelter shelter) {
        shelter.setId(id);
        return shelterRepository.save(shelter);
    }

    public List<Shelter> findAll() {
        return shelterRepository.findAll();
    }

    public Optional<Shelter> findById(Integer id) {
        return shelterRepository.findById(id);
    }
}
