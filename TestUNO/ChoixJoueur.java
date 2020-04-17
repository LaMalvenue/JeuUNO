package com.TestUNO;

import java.util.Scanner;

public class ChoixJoueur {
    public static void main(String[] args) {

        Scanner lcInt = new Scanner(System.in);

        int choixJoueur = 0;
        boolean validation = false;

        while (!validation) {

            System.out.println("\nVoulez-vous 1-jouer ou 2-passer votre tour ?");
            choixJoueur = lcInt.nextInt();

        switch (choixJoueur) {
            case 1:                                                                                                   // Si le joueur 1 veut jouer
                System.out.println("Quelle carte voulez-vous jouer ? (n°)");
                validation=true;
                break;

            case 2:                                                                                                    // Si le joueur veut passer son tour
                System.out.println("Méthodes piocher + passer son tour");
                validation=true;
                break;

            default:                                                                                                    // Si le joueur a mal répondu pour le choix
                System.out.println("Veuillez répondre par 1 ou 2");

        } // Fin switch
    }                                                                                                               // Le joueur a joué une option valide
    }
}
