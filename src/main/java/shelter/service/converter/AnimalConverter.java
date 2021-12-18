package shelter.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.service.model.Animal;
import shelter.service.service.AnimalService;
import shelter.service.web.model.AnimalDto;

import java.sql.Date;

@Component
public class AnimalConverter {

    @Autowired
    AnimalService animalService;

    public Animal toDomainModel(AnimalDto animalDto) {
        Date dateOfBirth = animalService.getDateOfBirth(animalDto);
        return new Animal(animalDto.getId(), animalDto.getName(), animalDto.getDescription(),
                animalDto.getGender(), dateOfBirth, animalDto.isSterilized(),
                animalDto.getImageUrl(), animalDto.getSpecies(), animalDto.getShelterId(), animalDto.getStatus());
    }

    public AnimalDto toDto(Animal animal) {
        String age = animalService.getAge(animal);
        return new AnimalDto(animal.getId(), animal.getName(),
                animal.getDescription(), animal.getGender(), age, animal.isSterilized(),
                animal.getImageUrl(), animal.getSpecies(), animal.getShelterId(), animal.getStatus());
    }
}
