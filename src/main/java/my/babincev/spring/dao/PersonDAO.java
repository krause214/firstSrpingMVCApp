package my.babincev.spring.dao;

import my.babincev.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//класс общается с БД по CRUD
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        for (Person person:
             people) {
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void updatePerson(int id, Person person){
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id){
                person.setId(id);
                people.set(i, person);
                return;
            }
        }
    }

    public void deletePerson(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
