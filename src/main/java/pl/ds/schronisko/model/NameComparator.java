package pl.ds.schronisko.model;

import java.util.Comparator;

public class NameComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}