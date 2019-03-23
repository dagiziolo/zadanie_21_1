package pl.ds.schronisko.repository;

import org.springframework.stereotype.Repository;
import pl.ds.schronisko.model.Animal;


import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {
    private List<Animal> animals = new ArrayList<>();

    public AnimalRepository() {
        animals.add(new Animal(1, "Azor", "Azor to bardzo spokojny, towarzyski i uwielbiajacy pieszczoty psiak. " +
                "Jest łagodny w stosunku do dzieci, jak i do innych psiaków. Lubi przebywac blisko człowieka, czy to tylko poleżeć," +
                " czy się przytulić. Azor to bardzo grzeczny i kochany psiak średniej wielkości dla każdego. :)",
                "https://scontent.xx.fbcdn.net/v/t1.0-9/37884668_1799094730166854_3441972866730426368_o.jpg?_nc_cat=103&_nc_ht=scontent.xx&oh=6cbdd58092c2f012fde48c8939a9e820&oe=5D020E16",
                "Psy"));

        animals.add(new Animal(2, "Rudy", "Rudy to dla nas ciężki orzech do zgryzienia. Do tej pory żył na wolności" +
                " jako kot wolno bytujący. Trafił do schroniska ciężko chory, niestety bez możliwości powrotu na wolność. " +
                "Bardzo szybko zaaklimatyzował się w schroniskowych warunkach: przyzwyczaił do ciepła, pełnej miseczki z jedzeniem, " +
                "czystej kuwety czy miękkiej poduszeczki. mTeraz zdrowy i wykarstowany czeka na swojego Pana.", "https://apollo-ireland.akamaized.net/v1/files/i8czpum6fczw2-PL/image;s=644x461",
                "Koty"));

        animals.add(new Animal(3, "Rudieś", "Rudieś to radosny pies, uwielbia biegać,jednak do innych psów wykazuje oznaki dominacji. " +
                "Raczej nie nadaje sie do dzieci, ale jest z niego świetny pies stróżujący. Rudieś jest zaczipowany i odrobaczony.", "https://scontent.xx.fbcdn.net/v/t31.0-8/24879513_1540901235986206_8147786942416000868_o.jpg?_nc_cat=103&_nc_ht=scontent.xx&oh=015f5f04908a26acdd1e7fe05de4fc52&oe=5D4D7875",
                "Psy"));
   }

    public List<Animal> findAll() {
        return animals;
    }

    public Animal findById(int id) {
        return animals.get(id - 1);
    }

    public List<Animal> getAnimalInCategory(String category) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            String tmp = "Zwierzęta";
            if(tmp.equals(category)) {
                result.add(animal);
            } else if (animal.getCategory().equals(category)) {
                result.add(animal);
            }
        }
        return result;
    }

    public void add(Animal animal) {
        animal.setId(animals.size() + 1);
        animals.add(animal);
    }

}
