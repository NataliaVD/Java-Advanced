package Exam.Parrots;

import Exam.Parrots.Cage;
import Exam.Parrots.Parrot;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository (Exam.Parrots.Cage)
        Cage cage = new Cage("Wildness", 20);
        //Initialize entity
        Parrot parrot = new Parrot("Fluffy", "Loriinae");
        //Print Exam.Parrots.Parrot
        System.out.println(parrot); // Exam.Parrots.Parrot (Loriinae): Fluffy

//Add Exam.Parrots.Parrot
        cage.add(parrot);
        System.out.println(cage.count()); //1
//Remove Exam.Parrots.Parrot
        cage.remove("Exam.Parrots.Parrot Name"); //false

        Parrot secondParrot = new Parrot("Bunny", "Cacatuidae");
        Parrot thirdParrot = new Parrot("Jumpy", "Strigopoidea");
        Parrot fourthParrot = new Parrot("Puffy", "Strigopoidea");
        Parrot fifthParrot = new Parrot("Marlin", "Arinae");

//Add Parrots
        cage.add(secondParrot);
        cage.add(thirdParrot);
        cage.add(fourthParrot);
        cage.add(fifthParrot);

//Sell Exam.Parrots.Parrot by name
        System.out.println(cage.sellParrot("Bunny")); //Exam.Parrots.Parrot (Cacatuidae): Bunny
//Sell Exam.Parrots.Parrot by species
        List<Parrot> soldSpecies = cage.sellParrotBySpecies("Strigopoidea");

        soldSpecies.forEach(f-> {
            System.out.println(f.getName());
        });
        //Jumpy
        //Puffy

        System.out.println(cage.report());
//Parrots available at Wildness:
//Exam.Parrots.Parrot (Loriinae): Fluffy
//Exam.Parrots.Parrot (Arinae): Marlin
    }
}
