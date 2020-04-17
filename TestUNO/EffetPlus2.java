package com.TestUNO;

import com.JeuUNO.Joueur;
import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;

import java.util.ArrayList;

public class EffetPlus2 {
    public static void main(String[] args) {

        ArrayList<Carte> paquet = new ArrayList<>();
        Carte carte1 = new CarteChiffre(5,"bleu");Carte carte2 = new CarteChiffre(0, "rouge");
        paquet.add(carte1); paquet.add(carte2);
        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        mainJoueur1.add(carte1); paquet.add(carte2);
        ArrayList<Carte> mainJoueur2 = new ArrayList<>();
        mainJoueur2.add(carte1); paquet.add(carte2);
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        effetCartePlus2(mainJoueur1,0,joueur2,mainJoueur2,paquet,joueur1);



    } // Fin main


    public static void effetCartePlus2 (Joueur joueur1,ArrayList<Carte> mainJoueur1,ArrayList<Carte> pioche, Joueur joueurSuivant){
        // Le joueur qui joue pioche et passe son tour

        System.out.println("Aie "+joueur1.getNom()+" ! Vous piochez 2 cartes !");
        for (int i = 0; i < 2; i++) {
            mainJoueur1.add(pioche.get(i));
            pioche.remove(i);
        }

        System.out.println(joueur1.getNom()+" passe son tour. ");
        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");

    }

    public static void effetCartePlus2 (ArrayList<Carte> mainJoueurQuiJoue,
                                        int indexCarteChoisie,
                                        Joueur joueurQuiPioche,
                                        ArrayList <Carte> mainJoueurQuiPioche,
                                        ArrayList<Carte> pioche,
                                        Joueur joueurSuivant){

        mainJoueurQuiJoue.remove(indexCarteChoisie);

        System.out.println("Aie "+joueurQuiPioche.getNom()+" ! Vous piochez 2 cartes !");
        for (int i = 0; i < 2; i++) {
            mainJoueurQuiPioche.add(pioche.get(i));
            pioche.remove(i);
        }

        System.out.println(joueurQuiPioche.getNom()+" passe son tour. ");
        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
    }

} // Fin class
