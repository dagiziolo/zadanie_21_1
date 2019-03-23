package pl.ds.schronisko.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private List<String> categories = new ArrayList<>();

    public CategoryRepository() {
        categories.add("Psy");
        categories.add("Koty");
        categories.add("Inne");
    }

    public List<String> findAll() {
        return categories;
    }


}
