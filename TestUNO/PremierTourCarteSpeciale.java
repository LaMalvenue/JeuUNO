package com.TestUNO;

import com.JeuUNO.Joueur;
import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteJoker;
import com.JeuUNO.cartes.CartePlus2;
import com.JeuUNO.cartes.CartePlus4;

import java.util.ArrayList;

public class PremierTourCarteSpeciale {
    public static void main(String[] args) {

        Carte carte1 = new CartePlus2("rouge");
        Carte carte2 = new CarteJoker();
        Carte carte3 = new CartePlus4();
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur ("Joueur 2");
        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        ArrayList<Carte> paquet = new ArrayList();
        paquet.add(carte1);
        paquet.add(carte2);
        paquet.add(carte3);

        Carte defausse =  carte1;                 // Defausse = +2
      //  defausse =  carte2;                     // Defausse = Joker
      //  defausse =  carte3;                     // Defausse = +4

        int tour =0;

        // ***** PREMIER TOUR *****
        if (tour == 0) {                                                                                                // Si c'est le premier tour du jeu

            if (defausse.getCarteSpeciale()) {                                                                          // Si la défausse est une carte spéciale

                switch ((String) defausse.getValeur()) {
                    case "Joker":
                        changerCouleur(defausse);
                        break;

                    case "+2":
                        defausse.piocher(joueur1, paquet, mainJoueur1);
                        passerTour(joueur1, joueur2);
                        tour++;
                        break;

                    case "+4":
                        defausse.piocher(joueur1, paquet, mainJoueur1);
                        passerTour(joueur1, joueur2);
                        changerCouleur(defausse);
                        tour++;
                        break;
                }// Fin switch
            }                                                                                                           // Fin si défausse est une carte spéciale
    }
    } // Fin main

    private static void changerCouleur(Carte defausse) {
        System.out.println("Méthode changer couleur");
    }
    private static void passerTour(Joueur joueur1, Joueur joueur2) {
        System.out.println("Méthode passer son tour");
    }

}
