package com.TestUNO;

import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;

import java.util.Scanner;

public class ChangerCouleur {
    public static void main(String[] args) {


        Carte carte = new CarteChiffre(5, "bleu");

        System.out.println(carte.toString());

        changerCouleur(carte);

        System.out.println(carte.toString());
    }
    public static void changerCouleur(Carte defausse) {
        Scanner quelChoix = new Scanner(System.in);

        System.out.println("Vous pouvez choisir une nouvelle couleur :");
        System.out.println("1- Rouge    2-Vert    3-Bleu    4-Jaune");
        int choixCouleur=quelChoix.nextInt();

        do{
            switch (choixCouleur){
                case 1: defausse.setCouleur("rouge");
                    break;
                case 2: defausse.setCouleur("vert");
                    break;
                case 3: defausse.setCouleur("bleu");
                    break;
                case 4: defausse.setCouleur("jaune");
                    break;
                default:
                    System.out.println("Choix non-valide");
                    choixCouleur=quelChoix.nextInt();
            } // Fin switch
        } while (defausse.getCouleur().equals(" "));
    }                           // Changer la couleur de la défausse
}
