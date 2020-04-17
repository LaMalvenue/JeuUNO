package com.TestUNO;

import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;
import com.JeuUNO.cartes.CarteJoker;

import java.util.ArrayList;
import java.util.Scanner;

public class EffetJoker {
    public static void main(String[] args) {

        Carte defausse=new CarteChiffre(2,"rouge");
        System.out.println(defausse.toString());

        ArrayList<Carte> mainJoueur = new ArrayList<>();
        CarteJoker carteJoker = new CarteJoker();
        mainJoueur.add(carteJoker);

        defausse=mainJoueur.get(0);
        effetCarteJoker(defausse,mainJoueur,0);


        System.out.println(defausse.toString());

    } // Fin main

    public static void effetCarteJoker(Carte defausse, ArrayList<Carte> mainJoueur, int index){

        mainJoueur.remove(index);

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
    }                           // Effet carte Joker


} // Fin class
