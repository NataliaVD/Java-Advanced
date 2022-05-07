package Exam.Parrots;

import Exam.Parrots.Parrot;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot){
        if(capacity > data.size()){
            data.add(parrot);
        }
    }

    public boolean remove(String name){
        for (Parrot parrot : data) {
            if(parrot.getName().equals(name)){
              data.remove(parrot);
              return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name){
        Parrot parrot = null;
        for (Parrot p : data) {
            if(p.getName().equals(name)) {
                p.setAvailable(false);
                parrot = p;
            }
        }return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> parrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if(parrot.getSpecies().equals(species)){
                parrots.add(parrot);
            }
        }
        parrots.forEach(parrot -> data.remove(parrot));
        return parrots;
    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s", name)).append(System.lineSeparator());
        data.forEach(parrot  -> {
            if(parrot.isAvailable()) {
                builder.append(parrot).append(System.lineSeparator());
            }
        });
        return builder.toString();
    }
}
