package my.babincev.spring.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Animal {
    String name;
    String type;
    int id;

    public Animal() {
    }

    public Animal(String name, String type, int id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type.toLowerCase();
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
