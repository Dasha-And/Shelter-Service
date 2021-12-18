package shelter.service.service;

import org.springframework.stereotype.Service;
import shelter.service.model.AnimalVaccination;
import shelter.service.repository.AnimalVaccinationRepository;

import java.util.List;

@Service
public class AnimalVaccinationService {
    
    final
    AnimalVaccinationRepository animalVaccinationRepository;

    public AnimalVaccinationService(AnimalVaccinationRepository animalVaccinationRepository) {
        this.animalVaccinationRepository = animalVaccinationRepository;
    }

    public AnimalVaccination saveAnimalVaccination(AnimalVaccination animalVaccination) {
        return animalVaccinationRepository.save(animalVaccination);
    }

    public AnimalVaccination getAnimalVaccinationDetailsById(int id) {
        return animalVaccinationRepository.findAnimalVaccinationById(id);
    }

    public List<AnimalVaccination> getAnimalVaccinationDetails() {
        return animalVaccinationRepository.findAll();
    }

    public AnimalVaccination updateAnimalVaccination(AnimalVaccination animalVaccination) {
        return animalVaccinationRepository.save(animalVaccination);
    }

    public void deleteAnimalVaccination(int id) {
        animalVaccinationRepository.deleteById(id);
    }

    public List<AnimalVaccination> findByAnimal(int animalId) {
        return animalVaccinationRepository.findAnimalVaccinationByAnimalId(animalId);
    }
}
