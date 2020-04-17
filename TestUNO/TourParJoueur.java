package com.TestUNO;

import com.JeuUNO.Joueur;

public class TourParJoueur {
    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        int tour = 0;

        // ********** TOUR JOUEUR 1 **********

            while (tour % 2 == 0 ) {                                                                                    // Tour de joueur 1

                System.out.println("\tTour de " + joueur1.getNom() + "\n");
                tour++;
            }                                                                                                           // Fin tour joueur 1

            // ********** TOUR JOUEUR 2 **********

            while (tour % 2 != 0 ) {                                                                                    // Tour de joueur 2

                System.out.println("\tTour de " + joueur2.getNom() + "\n");
                tour++;
            }                                                                                                           // Fin tour joueur 2


        }
}
