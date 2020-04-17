package com.TestUNO;

import com.JeuUNO.Joueur;
import com.JeuUNO.cartes.Carte;

import java.util.ArrayList;

public class PasserTour {
    public static void main(String[] args) {

        Joueur joueur1=new Joueur("Joueur 1");
        Joueur joueur2=new Joueur("Joueur 2");

        ArrayList<Carte> paquet = new ArrayList<>();
        ArrayList<Carte> mainJoueur = new ArrayList<>();

        try {
            passerTour(joueur1, joueur2);
            passerTour(joueur1, joueur2, paquet, mainJoueur);
        } catch (java.lang.IndexOutOfBoundsException e){
            System.out.println("Test ok");
        }

    } // Fin main

        public static void passerTour(Joueur joueurQuiPasseTour, Joueur joueurSuivant){
            System.out.println(joueurQuiPasseTour.getNom()+" passe son tour. ");
            System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
        }

        public static void passerTour(Joueur joueurQuiPasseSonTour, Joueur joueurSuivant, ArrayList< Carte > pioche, ArrayList<Carte> mainJoueurQuiPioche){
            System.out.println(joueurQuiPasseSonTour.getNom()+" passe son tour et pioche une carte.");
            System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
            mainJoueurQuiPioche.add(pioche.get(0));
            pioche.remove(0);
        }



}
