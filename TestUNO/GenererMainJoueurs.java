package com.TestUNO;

import com.JeuUNO.cartes.Carte;

import java.util.ArrayList;

public class GenererMainJoueurs {
    public static void main(String[] args) {

        ArrayList<Carte> paquet = new ArrayList<>();

        // ********** Initialisation de la main des joueurs **********

        // Main joueur 1
        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mainJoueur1.add(paquet.get(i));
            paquet.remove(i);
        }
        // Main joueur 2
        ArrayList<Carte> mainJoueur2 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mainJoueur2.add(paquet.get(i));
            paquet.remove(i);
        }


    }
}
