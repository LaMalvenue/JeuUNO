package com.TestUNO;

import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;
import com.JeuUNO.cartes.CarteJoker;

import java.util.ArrayList;

public class PourFinirJeu2Joueurs {
    public static void main(String[] args) {

        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        ArrayList<Carte> mainJoueur2 = new ArrayList<>();
        CarteChiffre c1 = new CarteChiffre(0,"rouge");
        CarteJoker c2 = new CarteJoker();
        CarteChiffre c3 = new CarteChiffre(0,"rouge");
        CarteJoker c4 = new CarteJoker();
        mainJoueur1.add(c1); mainJoueur1.add(c2);
        mainJoueur2.add(c3); mainJoueur2.add(c4);

        System.out.println("Le jeu commence");

        System.out.println("\nMain initiale du joueur 1");
        afficherCartes(mainJoueur1);
        System.out.println("Main initiale du joueur 2");
        afficherCartes(mainJoueur2);

        int tour = 0;

        while (!mainJoueur1.isEmpty() && !mainJoueur2.isEmpty()){

            if (tour%2==0){
                System.out.println("\nLe jeu continue (joueur 1 - 1 carte)");
                mainJoueur1.remove(0);
                afficherCartes(mainJoueur1);
                tour++;
            }

            else {
                System.out.println("\nLe jeu continue (joueur 2 - 1 carte)");
                mainJoueur2.remove(0);
                afficherCartes(mainJoueur2);
                tour++;
            }

        }

        System.out.println("\nLe jeu est terminé");
        if (mainJoueur1.isEmpty()) System.out.println("Le joueur 1 a gagné");
        if (mainJoueur2.isEmpty()) System.out.println("Le joueur 2 a gagné");


    } // Fin main


    public static void afficherCartes(ArrayList<Carte> paquet){
        System.out.println("Affichage des cartes");
        for (int i=0 ; i<paquet.size(); i++){
            System.out.println("Carte n°"+i+" : " +paquet.get(i));
        }
    }
}
