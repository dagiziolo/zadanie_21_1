package pl.ds.schronisko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ds.schronisko.model.Animal;
import pl.ds.schronisko.model.NameComparator;
import pl.ds.schronisko.repository.AnimalRepository;
import pl.ds.schronisko.repository.CategoryRepository;

import java.util.Collections;
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
        model.addAttribute("allAnimals", allAnimals);
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        return "home";
    }

    @GetMapping("/szczegoly")
    public String animalDetails(@RequestParam int id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);
        return "details";
    }

    @GetMapping("/rodzaj")
    public String printAnimalCategory(@RequestParam String category, Model model) {
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);

        List<Animal> animalInCategory = animalRepository.getAnimalInCategory(category);
        model.addAttribute("animalCategory", animalInCategory);
        model.addAttribute("category", category);
        return "listcategory";
    }

    @GetMapping("/dodaj")
    public String showForm(Model model) {
        model.addAttribute("animal", new Animal());
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "addform";
    }

    @PostMapping("/szczegoly")
    public String saveForm(@RequestParam String name, String description, String category, String imgUrl, Model model) {
        Animal animal = new Animal(name, description, imgUrl, category);
        animalRepository.add(animal);
        model.addAttribute("animal", animal);
        return "details";
    }

    @GetMapping("/edycja")
    public String animalEdit(@RequestParam int id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "edit";
    }

//    @PostMapping("/dodaj")
//    public String saveForm(@RequestParam String name, String description, String category, String imgUrl){
//        Animal animal = new Animal(name, description, imgUrl, category);
//        animalRepository.add(animal);
//        return "add";
//    }

    @PostMapping("/edycja")
    public String saveForm(@RequestParam int id, String name, String description, String category, String imgUrl, Model model) {
        Animal newAnimal = new Animal(id, name, description, imgUrl, category);
        animalRepository.change(newAnimal, animalRepository.findById(newAnimal.id));
        return "addedit";
    }

    @GetMapping("/listsort")
    public String homeSort(Model model) {
        List<Animal> allAnimals = animalRepository.findAll();
        NameComparator nameComparator = new NameComparator();
        Collections.sort(allAnimals, nameComparator);
        model.addAttribute("allAnimals", allAnimals);
        List<String> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        return "sort";
    }

    @GetMapping("/dodajkategorie")
    public String showFormCat(Model model) {
        model.addAttribute("categories", new CategoryRepository());
        return "addformcat";
    }


    @PostMapping("/dodajkategorie")
    public String saveFormCat(@RequestParam String name) {
        List<String> allCategories = categoryRepository.findAll();
        int i =0 ;
        for(String allCategory: allCategories){
            if(name.equalsIgnoreCase(allCategory)){
                i+=1;
            }
        }

        if (i>0) {
            return "error";
        } else {
            categoryRepository.add(name);
            return "add";
        }
    }

//    @GetMapping("/rodzaj/listsort")
//    public String printAnimalCategorySort(Model model) {
//        List<Animal> allAnimals = animalRepository.findAll();
//        NameComparator nameComparator = new NameComparator();
//        Collections.sort(allAnimals,nameComparator );
//        model.addAttribute("allAnimals",allAnimals);
//        List<String> allCategories = categoryRepository.findAll();
//        model.addAttribute("allCategories",allCategories);
//        return "sort";
//    }
//

}