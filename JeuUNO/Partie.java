package com.JeuUNO;

import com.JeuUNO.cartes.*;
import java.util.*;

public class Partie {
    public static void main(String[] args) {

        Scanner lcString = new Scanner(System.in);
        Scanner lcInt = new Scanner(System.in);

        System.out.println("Voulez-vous commencer la partie ? (Y/N)");
        char debutPartie = lcString.nextLine().toUpperCase().charAt(0);

        while (debutPartie=='Y') {

            Joueur joueur1 = new Joueur();
            System.out.print("\nNom du Joueur 1 : ");
            joueur1.setNom(lcString.nextLine());

            Joueur joueur2 = new Joueur();
            System.out.print("Nom du Joueur 2 : ");
            joueur2.setNom(lcString.nextLine());
            System.out.println("\nBienvenue " + joueur1.getNom() + " et " + joueur2.getNom() + "\n");

            // ********** Initialisation du paquet de cartes **********

            ArrayList<Carte> paquet = new ArrayList<>(); // On ne peut stocker que des cartes
            CarteChiffre carteReference = new CarteChiffre();
            carteReference.setCouleur("bleu");
            while (carteReference.getCouleur().equals("bleu")) {                  // Cartes bleues
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin si
                    else {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin  sinon
                } // Fin boucle for
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                carteReference.setCouleur("rouge");
            }  // Cartes bleues !
            while (carteReference.getCouleur().equals("rouge")) {                  // Cartes rouges
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin si
                    else {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin  sinon
                } // Fin boucle for
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                carteReference.setCouleur("jaune");
            } // Cartes rouges !
            while (carteReference.getCouleur().equals("jaune")) {                  // Cartes jaunes
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin si
                    else {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin  sinon
                } // Fin boucle for
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                carteReference.setCouleur("vert");
            } // Cartes jaunes !
            while (carteReference.getCouleur().equals("vert")) {                  // Cartes vertes
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin si
                    else {
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                        paquet.add(new CarteChiffre(i, carteReference.getCouleur()));
                    } // Fin  sinon
                } // Fin boucle for
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                paquet.add(new CartePlus2(carteReference.getCouleur()));
                carteReference.setCouleur(" ");
            }  // Cartes vertes !
            for (int i = 0; i < 5; i++) {                                  // Cartes +4 et Joker
                paquet.add(new CartePlus4());
                paquet.add(new CarteJoker());
            }                         // Cartes +4 et Joker !
            Collections.shuffle(paquet);


            // ********** Initialisation de la main des joueurs **********

            // Main joueur 1
            ArrayList<Carte> mainJoueur1 = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                mainJoueur1.add(paquet.get(i));
                paquet.remove(i);
            }
            // Main joueur 2
            ArrayList<Carte> mainJoueur2 = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                mainJoueur2.add(paquet.get(i));
                paquet.remove(i);
            }


            // ********** Initialisation de la défausse **********

            Carte defausse = paquet.get(0);
            paquet.remove(0);
            System.out.println("Défausse : " + defausse + "\n");


            // ********** JEU **********

            // ********** TOUR JOUEUR 1 **********

            int tour = 0;

            while (!mainJoueur1.isEmpty() && !mainJoueur2.isEmpty()) {

                if (tour % 2 == 0) {                             // Tour de joueur 1

                    System.out.println("\tTour de " + joueur1.getNom() + "\n");
                    System.out.println("Défausse : " + defausse + "\n");

                    afficherCartes(joueur1, mainJoueur1);

                    // ***** PREMIER TOUR *****
                    if (tour == 0) {                                                                                    // Si c'est le premier tour du jeu

                        if (defausse.getCarteSpeciale()) {                                                              // Si la défausse est une carte spéciale

                            switch ((String) defausse.getValeur()) {
                                case "Joker":
                                    effetCarteJoker(defausse);
                                    break;

                                case "+2":
                                    effetCartePlus2(joueur1,mainJoueur1,paquet,joueur2);
                                    tour++;
                                    break;

                                case "+4":
                                    effetCartePlus4(joueur1,mainJoueur1,paquet,joueur2,defausse);
                                    tour++;
                                    break;
                            }// Fin switch
                        }                                                                                                           // Fin si défausse est une carte spéciale
                    }                                                                                           // Fin si c'est le premier tour


                    // ***** TOURS SUIVANTS *****

                    if (tour==0 || tour>=2){

                    int choixJoueur = 0;
                    boolean validation = false;

                    while (!validation) {                                                                                            // TANT QUE le joueur n'a pas fait d'action autorisée

                        System.out.println("\nVoulez-vous 1-jouer ou 2-passer votre tour ?");
                        choixJoueur = lcInt.nextInt();

                        switch (choixJoueur) {
                            case 1:                                                                                                   // Si le joueur 1 veut jouer
                                System.out.println("Quelle carte voulez-vous jouer ? (n°)");
                                int carteChoisie = lcInt.nextInt() - 1;
                                while (carteChoisie<0 || carteChoisie>mainJoueur1.size()){
                                    System.out.println("Cette carte n'existe pas");
                                    System.out.println("Quelle carte voulez-vous jouer ? (n°)");
                                    carteChoisie = lcInt.nextInt() - 1;
                                }

                                if (mainJoueur1.get(carteChoisie).getCarteSpeciale()) {                                               // Si le joueur 1 joue une carte spéciale

                                    switch ((String) mainJoueur1.get(carteChoisie).getValeur()) {

                                        case "Joker":
                                            defausse = mainJoueur1.get(carteChoisie);
                                            effetCarteJoker(defausse,mainJoueur1,carteChoisie);
                                            validation = true;
                                            break;

                                        case "+2":
                                            if (mainJoueur1.get(carteChoisie).getCouleur().equals(defausse.getCouleur())
                                                    || mainJoueur1.get(carteChoisie).getValeur().equals(defausse.getValeur())) {
                                                defausse = mainJoueur1.get(carteChoisie);
                                                effetCartePlus2(mainJoueur1,carteChoisie,joueur2,mainJoueur2,paquet,joueur1);
                                                validation = true;
                                                tour++;

                                            } else System.out.println("Vous ne pouvez pas poser cette carte");
                                            break;

                                        case "+4":
                                            defausse = mainJoueur1.get(carteChoisie);
                                            effetCartePlus4(mainJoueur1,joueur1,carteChoisie,joueur2,mainJoueur2,paquet,joueur1,defausse);
                                            validation = true;
                                            tour++;
                                            break;

                                    }// Fin switch

                                } else if (mainJoueur1.get(carteChoisie).getCouleur().equals(defausse.getCouleur())                   // Si le joueur joue une carte classique
                                        || mainJoueur1.get(carteChoisie).getValeur() == defausse.getValeur()) {
                                    defausse = mainJoueur1.get(carteChoisie);
                                    mainJoueur1.remove(carteChoisie);
                                    validation = true;

                                } else
                                    System.out.println("Vous ne pouvez pas jouer cette carte");                                       // Si la carte choisie n'est pas valide

                                break;

                            case 2:                                                                                                    // Si le joueur veut passer son tour
                                defausse.piocher(joueur1, paquet, mainJoueur1);
                                passerTour(joueur1, joueur2, paquet, mainJoueur1);
                                validation = true;
                                break;

                            default:                                                                                                    // Si le joueur a mal répondu pour le choix
                                System.out.println("Veuillez répondre par 1 ou 2");

                        } // Fin switch
                    }                                                                                                               // Le joueur a joué une option valide
                    tour++;
                }                                                                                                   // Fin tour joueur 1
                }

                // ********** TOUR JOUEUR 2 **********

                if (tour % 2 != 0) {                                                                                                 // Tour de joueur 2

                    System.out.println("\tTour de " + joueur2.getNom() + "\n");
                    System.out.println("Défausse : " + defausse + "\n");

                    afficherCartes(joueur2, mainJoueur2);

                    int choixJoueur = 0;
                    boolean validation = false;

                    while (!validation) {                                                                                          // TANT QUE le joueur n'a pas fait d'action autorisée

                        System.out.println("\nVoulez-vous 1-jouer ou 2-passer votre tour ?");
                        choixJoueur = lcInt.nextInt();

                        switch (choixJoueur) {
                            case 1:                                                                                     // Si le joueur 2 veut jouer
                                System.out.println("Quelle carte voulez-vous jouer ? (n°)");
                                int carteChoisie = lcInt.nextInt() - 1;
                                while (carteChoisie<0 || carteChoisie>mainJoueur2.size()){
                                    System.out.println("Cette carte n'existe pas");
                                    System.out.println("Quelle carte voulez-vous jouer ? (n°)");
                                    carteChoisie = lcInt.nextInt() - 1;
                                }

                                if (mainJoueur2.get(carteChoisie).getCarteSpeciale()) {                                 // Si le joueur 2 joue une carte spéciale

                                    switch ((String) mainJoueur2.get(carteChoisie).getValeur()) {

                                        case "Joker":
                                            defausse = mainJoueur2.get(carteChoisie);
                                            effetCarteJoker(defausse,mainJoueur2,carteChoisie);
                                            validation = true;
                                            break;

                                        case "+2":
                                            if (mainJoueur2.get(carteChoisie).getCouleur().equals(defausse.getCouleur())
                                                    || mainJoueur2.get(carteChoisie).getValeur().equals(defausse.getValeur())) {
                                                defausse = mainJoueur2.get(carteChoisie);
                                                effetCartePlus2(mainJoueur2,carteChoisie,joueur1,mainJoueur1,paquet,joueur2);
                                                validation = true;
                                                tour++;

                                            } else System.out.println("Vous ne pouvez pas poser cette carte");
                                            break;

                                        case "+4":
                                            defausse = mainJoueur2.get(carteChoisie);
                                            effetCartePlus4(mainJoueur2,joueur2,carteChoisie,joueur1,mainJoueur1,paquet,joueur2,defausse);
                                            validation = true;
                                            tour++;
                                            break;

                                    }// Fin switch

                                } else if (mainJoueur2.get(carteChoisie).getCouleur().equals(defausse.getCouleur())     // Si le joueur joue une carte classique
                                        || mainJoueur2.get(carteChoisie).getValeur() == defausse.getValeur()) {
                                    defausse = mainJoueur2.get(carteChoisie);
                                    mainJoueur2.remove(carteChoisie);
                                    validation = true;

                                } else
                                    System.out.println("Vous ne pouvez pas jouer cette carte");                         // Si la carte choisie n'est pas valide

                                break;

                            case 2:                                                                                    // Si le joueur veut passer son tour
                                defausse.piocher(joueur2, paquet, mainJoueur2);
                                passerTour(joueur2, joueur1, paquet, mainJoueur2);
                                validation = true;
                                break;

                            default:                                                                                    // Si le joueur a mal répondu pour le choix
                                System.out.println("Veuillez répondre par 1 ou 2");

                        } // Fin switch
                    }                                                                                                   // Le joueur a joué une option valide
                    tour++;
                }                                                                                                       // Fin tour joueur 2

            }                                                                                                           // Un des joueurs n'a plus de cartes

            int scoreJoueur1 = 0, scoreJoueur2=0;

            if(mainJoueur1.isEmpty()) {
                System.out.println("Bravo ! "+joueur1.getNom()+" a remporté la victoire !");                            // Victoire du joueur 1
                scoreJoueur1++;
            }
            else if(mainJoueur2.isEmpty()) {
                System.out.println("Bravo ! "+joueur2.getNom()+" a remporté la victoire !");                            // Victoire du joueur 2
                scoreJoueur2++;
            }

            System.out.println("Score de "+joueur1.getNom()+" : "+scoreJoueur1);
            System.out.println("Score de "+joueur2.getNom()+" : "+scoreJoueur2);
            System.out.println("Voulez-vous rejouer ? (Y/N)");
            debutPartie=lcString.nextLine().toUpperCase().charAt(0);

        }                                                                                                               // Fin du jeu (si on ne répond pas "Y")
        System.out.println("Au revoir !...");

    }                                                                                                                   // Fin main

    // ********** AFFICHER LA MAIN **********

    public static void afficherCartes(Joueur joueur, ArrayList<Carte> mainJoueur){
        System.out.println("Affichage de la main de "+joueur.getNom());
        for (int i=0 ; i<mainJoueur.size(); i++){
            System.out.println("Carte n°"+(i+1)+" : " +mainJoueur.get(i));
        }
    }


    // ********** PASSER SON TOUR **********

    public static void passerTour(Joueur joueurQuiPasseTour, Joueur joueurSuivant){
        System.out.println(joueurQuiPasseTour.getNom()+" passe son tour. ");
        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
    }
    public static void passerTour(Joueur joueurQuiPasseSonTour, Joueur joueurSuivant,
                                  ArrayList<Carte> pioche,
                                  ArrayList<Carte> mainJoueurQuiPioche){
        System.out.println(joueurQuiPasseSonTour.getNom()+" passe son tour et pioche une carte.");
        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");
        mainJoueurQuiPioche.add(pioche.get(0));
        pioche.remove(0);
    }


    // ********** CARTE +2 **********

    public static void effetCartePlus2 (Joueur joueur1,ArrayList<Carte> mainJoueur1,
                                        ArrayList<Carte> pioche, Joueur joueurSuivant){
        // Le joueur qui joue pioche et passe son tour

        System.out.println("Aie "+joueur1.getNom()+" ! Vous piochez 2 cartes !");
        for (int i = 0; i < 2; i++) {
            mainJoueur1.add(pioche.get(i));
            pioche.remove(i);
        }

        System.out.println(joueur1.getNom()+" passe son tour. ");
        System.out.println("C'est à "+joueurSuivant.getNom()+" de jouer !\n");

    }                             // Si défausse = carte +2 au premier tour
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
    }                                                      // Effet carte +2


    // ********** CARTE +4 **********

    public static void effetCartePlus4 (Joueur joueur1,                                                                 // Si défausse = carte +4 au premier tour
                                        ArrayList<Carte> mainJoueur1,
                                        ArrayList<Carte> pioche,
                                        Joueur joueurSuivant,
                                        Carte defausse){

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
    }                                                            // Effet carte +4


    // ********** CARTE JOKER **********

    public static void effetCarteJoker(Carte defausse) {
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
    }                                                            // Si défausse = carte Joker au premier tour
    public static void effetCarteJoker(Carte defausse, ArrayList<Carte> mainJoueur, int indexCarteChoisie){

        mainJoueur.remove(indexCarteChoisie);

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
    }         // Effet carte Joker


} // Fin class
