package com.TestUNO;

import com.JeuUNO.cartes.*;

import java.util.ArrayList;
import java.util.Collections;

public class GenererCartes {
    public static void main(String[] args) {

    // ********** Initialisation du paquet de cartes UNO **********

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
}
}