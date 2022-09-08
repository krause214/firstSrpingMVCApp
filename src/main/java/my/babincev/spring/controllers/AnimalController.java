package my.babincev.spring.controllers;

import my.babincev.spring.dao.AnimalDAO;
import my.babincev.spring.models.Animal;
import my.babincev.spring.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalDAO) {
        this.animalService = animalDAO;
    }

    @GetMapping("/{id}")
    public String getAnimal(@PathVariable("id") int id, Model model){
        model.addAttribute("animal", animalService.getAnimal(id));
        return "animals/show";
    }

    @GetMapping("/{id}/edit")
    public String editAnimal(@PathVariable("id") int id, Model model){
        model.addAttribute("animal", animalService.getAnimal(id));
        return "animals/edit";
    }

    @GetMapping("/new")
    public String newAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "animals/new";
    }

    @PostMapping()
    public String createAnimal(@ModelAttribute("animal") Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animals";
    }

    @PatchMapping ("/{id}")
    public String editAnimal(@PathVariable("id") int id, @ModelAttribute("animal") Animal animal){
        animalService.updateAnimal(id, animal);
        return "redirect:/animals";
    }

    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable("id") int id){
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }

    @GetMapping()
    public String getAllAnimalPage(Model model){
        model.addAttribute("animals", animalService.getAnimals());
        return "animals/index";
    }
}
