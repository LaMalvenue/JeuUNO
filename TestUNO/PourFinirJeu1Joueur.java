package com.TestUNO;

import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;
import com.JeuUNO.cartes.CarteJoker;

import java.util.ArrayList;

public class PourFinirJeu1Joueur {
    public static void main(String[] args) {

        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        CarteChiffre c1 = new CarteChiffre(0,"rouge");
        CarteJoker c2 = new CarteJoker();
        mainJoueur1.add(c1); mainJoueur1.add(c2);

        System.out.println("Le jeu commence");

        while (!mainJoueur1.isEmpty()){
            System.out.println("\nLe jeu continue");
            afficherCartes(mainJoueur1);
            mainJoueur1.remove(0);
        }

        afficherCartes(mainJoueur1);
        System.out.println("\nLe jeu est terminé");


    } // Fin main


    public static void afficherCartes(ArrayList<Carte> paquet){
        System.out.println("Affichage des cartes");
        for (int i=0 ; i<paquet.size(); i++){
            System.out.println("Carte n°"+i+" : " +paquet.get(i));
        }
    }
}
