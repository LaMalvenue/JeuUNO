package com.TestUNO;

import com.JeuUNO.Joueur;
import java.util.Scanner;

public class PresentationJoueurs {
    public static void main(String[] args) {

        Scanner lcString = new Scanner(System.in);

        Joueur joueur1 = new Joueur();
        System.out.print("\nNom du Joueur 1 : ");
        joueur1.setNom(lcString.nextLine());

        Joueur joueur2 = new Joueur();
        System.out.print("Nom du Joueur 2 : ");
        joueur2.setNom(lcString.nextLine());
        System.out.println("\nBienvenue " + joueur1.getNom() + " et " + joueur2.getNom() + "\n");
    }
}
