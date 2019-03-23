package pl.ds.schronisko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ds.schronisko.model.Animal;
import pl.ds.schronisko.repository.AnimalRepository;
import pl.ds.schronisko.repository.CategoryRepository;

import java.util.List;

@Controller
public class AnimalController {
    private AnimalRepository animalRepository;
    private CategoryRepository categoryRepository;

    public AnimalController(AnimalRepository animalRepository, CategoryRepository categoryRepository) {
        this.animalRepository = animalRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Animal> allAnimals = animalRepository.findAll();
        model.addAttribute("allAnimals",allAnimals);
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories",allCategories);
        return "home";
    }

    @GetMapping("/szczegoly")
    public String animalDetails(@RequestParam int id, Model model){
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);
        return "details";
    }

    @GetMapping("/rodzaj")
    public String printAnimalCategory(@RequestParam String category , Model model){
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories",allCategories);

        List<Animal> animalInCategory = animalRepository.getAnimalInCategory(category);
        model.addAttribute("animalCategory", animalInCategory);
        model.addAttribute("category", category);
        return "listcategory";
    }

    @GetMapping("/dodaj")
    public String showForm(Model model){
        model.addAttribute("animal", new Animal());
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "addform";
    }

    @PostMapping("/dodaj")
    public String saveForm(@RequestParam String name, String description, String category, String imgUrl){
        Animal animal = new Animal(name, description, imgUrl, category);
        animalRepository.add(animal);
        return "add";
    }

}
