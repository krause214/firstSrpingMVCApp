package my.babincev.spring.dao;

import my.babincev.spring.models.Animal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AnimalDAO {

    private static int ANIMAL_COUNT;

    private ArrayList<Animal> animals;
    {
        animals = new ArrayList<>();

        animals.add(new Animal("Tom", "cat", ++ANIMAL_COUNT));
        animals.add(new Animal("Jerry", "mouse", ++ANIMAL_COUNT));
        animals.add(new Animal("Bobik", "dog", ++ANIMAL_COUNT));
    }

    public ArrayList<Animal> index(){
        return animals;
    }

    public void addAnimal(Animal animal){
        animal.setType(animal.getType().toLowerCase());
        animal.setId(++ANIMAL_COUNT);
        animals.add(animal);
    }

    public Animal getAnimal(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id)
                return animal;
        }
        return null;
    }
}
