package fr.diginamic.recensement.services;

import fr.diginamic.recensement.entites.Ville;

import java.util.ArrayList;

public class TestAnnotation {
    public static void main(String[] args) {

        ArrayList<Ville> villes = new ArrayList<>();
        Ville v1 = new Ville("01", "Ile-de-France", "75", "75000", "Paris", 56);
        Ville v2 = new Ville("02", "Rhône", "69", "69150", "Lyon", 63);
        Ville v3 = new Ville("03", "Val de Loire", "37", "37600", "Tours", 22);
        villes.add(v1);
        villes.add(v2);
        villes.add(v3);
        for(Ville v: villes){
            System.out.println(v);
        }
    }
}
