package com.TestUNO;

import com.JeuUNO.Joueur;
import com.JeuUNO.cartes.*;
import com.JeuUNO.cartes.CartePlus4;

import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionChoixCarteJoueur {
    public static void main(String[] args) {

        Scanner lcInt = new Scanner(System.in);
        Joueur joueur = new Joueur();
        ArrayList<Carte> mainJoueur = new ArrayList<>();
        CartePlus4 carte1 = new CartePlus4();CartePlus4 carte2 = new CartePlus4();
        mainJoueur.add(carte1); mainJoueur.add(carte2);

        afficherCartes(joueur, mainJoueur);

        System.out.println("Quelle carte voulez-vous jouer ? (n°)");
        int carteChoisie = lcInt.nextInt() - 1;

        while (carteChoisie<0 || carteChoisie>mainJoueur.size()){
            System.out.println("Cette carte n'existe pas");
            System.out.println("Quelle carte voulez-vous jouer ? (n°)");
            carteChoisie = lcInt.nextInt() - 1;
        }

        System.out.println(mainJoueur.get(carteChoisie).toString());

        try {
            System.out.println(mainJoueur.get(carteChoisie).toString());
        } catch (java.lang.IndexOutOfBoundsException e){
            System.out.println("Cette carte n'existe pas");
        }







    } // Fin main

    public static void afficherCartes(Joueur joueur, ArrayList<Carte> mainJoueur){
        System.out.println("Affichage de la main de "+joueur.getNom());
        for (int i=0 ; i<mainJoueur.size(); i++){
            System.out.println("Carte n°"+(i+1)+" : " +mainJoueur.get(i));
        }
    }


}
