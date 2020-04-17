package com.TestUNO;

import com.JeuUNO.cartes.Carte;
import java.util.ArrayList;

public class Defausse {

    public static void main(String[] args) {

        ArrayList<Carte> paquet = new ArrayList<>();

        // ********** Initialisation de la défausse **********

        Carte defausse = paquet.get(0);
        paquet.remove(0);
        System.out.println("Défausse : " + defausse + "\n");
    }
}
