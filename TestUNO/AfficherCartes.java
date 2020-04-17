package com.TestUNO;

import com.JeuUNO.Joueur;
import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;
import com.JeuUNO.cartes.CarteJoker;

import java.util.ArrayList;

public class AfficherCartes {
    public static void main(String[] args) {

        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        Carte c1 = new CarteChiffre(0,"rouge");
        Carte c2 = new CarteJoker();
        mainJoueur1.add(c1); mainJoueur1.add(c2);
        Joueur joueur1 = new Joueur("Anaïs");

        afficherCartes(joueur1, mainJoueur1);
        afficherCartes(mainJoueur1);


    }
    public static void afficherCartes(Joueur joueur, ArrayList<Carte> mainJoueur){
        System.out.println("Affichage de la main de "+joueur.getNom());
        for (int i=0 ; i<mainJoueur.size(); i++){
            System.out.println("Carte n°"+(i+1)+" : " +mainJoueur.get(i));
        }
    }

    public static void afficherCartes(ArrayList<Carte> paquet){
        System.out.println("Affichage de la pioche");
        for (int i=0 ; i<paquet.size(); i++){
            System.out.println("Carte n°"+i+" : " +paquet.get(i));
        }
    }
}
