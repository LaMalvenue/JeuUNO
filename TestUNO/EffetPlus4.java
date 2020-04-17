package com.TestUNO;

import com.JeuUNO.Joueur;
import com.JeuUNO.cartes.Carte;
import com.JeuUNO.cartes.CarteChiffre;
import com.JeuUNO.cartes.CartePlus4;

import java.util.ArrayList;
import java.util.Scanner;

public class EffetPlus4 {
    public static void main(String[] args) {

        ArrayList<Carte> paquet = new ArrayList<>();
        CartePlus4 carte1 = new CartePlus4();CartePlus4 carte2 = new CartePlus4(); CartePlus4 carte3 = new CartePlus4(); CartePlus4 carte4 = new CartePlus4();
        CartePlus4 carte5 = new CartePlus4(); CartePlus4 carte6 = new CartePlus4();
        paquet.add(carte1); paquet.add(carte2); paquet.add(carte3); paquet.add(carte4);paquet.add(carte5); paquet.add(carte6);


        ArrayList<Carte> mainJoueur1 = new ArrayList<>();
        CartePlus4 carte = new CartePlus4();
        mainJoueur1.add(carte);
        ArrayList<Carte> mainJoueur2 = new ArrayList<>();
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        CarteChiffre defausse= new CarteChiffre(6,"jaune");

        afficherCartes(paquet);
        afficherCartes(joueur1,mainJoueur1);

        effetCartePlus4(mainJoueur1,joueur1, 0,joueur2,mainJoueur2,paquet,joueur1, defausse);

    } // Fin main

    public static void effetCartePlus4 (ArrayList<Carte> mainJoueurQuiJoue,
                                        Joueur joueurQuiJoue,
                                        int indexCarteChoisie,
                                        Joueur joueurQuiPioche,
                                        ArrayList <Carte> mainJoueurQuiPioche,
                                        ArrayList<Carte> pioche,
                                        Joueur joueurSuivant,
                                        Carte defausse){

        mainJoueurQuiJoue.remove(indexCarteChoisie);

        System.out.println("Aie "+joueurQuiPioche.getNom()+" ! Vous piochez 4 cartes !");
        for (int i = 0; i <4; i++) {
            mainJoueurQuiPioche.add(pioche.get(i));
            pioche.remove(i);
        }

        Scanner quelChoix = new Scanner(System.in);

        System.out.println(joueurQuiJoue.getNom()+", vous pouvez choisir une nouvelle couleur :");
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

        System.out.println(joueurQuiPioche.getNom()+" passe son tour. ");
        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
    }


    public static void effetCartePlus4 (Joueur joueur1,ArrayList<Carte> mainJoueur1,ArrayList<Carte> pioche, Joueur joueurSuivant, Carte defausse){

        System.out.println("Pas de chance "+joueur1.getNom()+" ! Vous piochez 4 cartes dès le premier tour :( !");
        System.out.println("Et en plus, vous passez votre tour...");
        for (int i = 0; i <4; i++) {
            mainJoueur1.add(pioche.get(i));
            pioche.remove(i);
        }

        Scanner quelChoix = new Scanner(System.in);

        System.out.println("Dieu merci "+joueur1.getNom()+", vous pouvez quand même choisir la couleur :");
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

        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
    }


    public static void changerCouleur(Carte defausse) {

    }                           // Changer la couleur de la défausse



    public static void afficherCartes(ArrayList<Carte> paquet){
        System.out.println("Affichage de la pioche");
        for (int i=0 ; i<paquet.size(); i++){
            System.out.println("Carte n°"+i+" : " +paquet.get(i));
        }
    }
    public static void afficherCartes(Joueur joueur, ArrayList<Carte> mainJoueur){
        System.out.println("Affichage de la main de "+joueur.getNom());
        for (int i=0 ; i<mainJoueur.size(); i++){
            System.out.println("Carte n°"+(i+1)+" : " +mainJoueur.get(i));
        }
    }
}
