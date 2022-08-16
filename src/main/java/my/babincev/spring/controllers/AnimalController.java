package my.babincev.spring.controllers;

import my.babincev.spring.dao.AnimalDAO;
import my.babincev.spring.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalController(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("animal", animalDAO.getAnimal(id));
        return "animals/show";
    }

    @GetMapping("/new")
    public String newAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "animals/new";
    }

    @PostMapping()
    public String createAnimal(@ModelAttribute("animal") Animal animal){
        animalDAO.addAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("animals", animalDAO.index());
        return "animals/index";
    }
}
