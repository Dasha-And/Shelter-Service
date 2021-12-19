package shelter.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.service.model.Shelter;
import shelter.service.service.AnimalService;
import shelter.service.web.model.ShelterDto;

@Component
public class ShelterConverter {

    @Autowired
    AnimalService animalService;

    public ShelterDto toDto(Shelter shelter) {
        return new ShelterDto(shelter.getId(), shelter.getName(), shelter.getLongitude(), shelter.getLatitude(), shelter.getPhone(), shelter.getEmail(), shelter.getSiteUrl(), shelter.getCapacity(), shelter.getCapacity() - animalService.getByShelter(shelter.getId()));
    }
}
