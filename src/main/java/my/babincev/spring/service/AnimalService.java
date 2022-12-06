package my.babincev.spring.service;

import my.babincev.spring.dao.AnimalDAO;
import my.babincev.spring.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AnimalService {
    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalService(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public Animal getAnimal(int id) {
        return animalDAO.getAnimal(id);
    }

    public void addAnimal(Animal animal) {
        animalDAO.addAnimal(animal);
    }

    public void updateAnimal(int id, Animal animal) {
        animalDAO.updateAnimal(id, animal);
    }

    public void deleteAnimal(int id) {
        animalDAO.deleteAnimal(id);
    }

    public ArrayList<Animal> getAnimals() {
        return animalDAO.getAnimals();
    }
}
