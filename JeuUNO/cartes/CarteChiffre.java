package com.JeuUNO.cartes;

import com.JeuUNO.Joueur;
import java.util.ArrayList;

public class CarteChiffre extends Carte {

    public CarteChiffre() {
        valeur=0;
        couleur=" ";
        carteSpeciale=false; }

    public CarteChiffre(int valeur, String couleur) {
        this.valeur=valeur;
        this.couleur=couleur;
    }                 // Constructeur valeur / couleur

    // ********** ACCESSEURS **********
    public String getCouleur() {
        return couleur;
    }                        // Retourne la couleur
    public boolean getCarteSpeciale(){
        return carteSpeciale;
    }           // Retourne le type Carte chiffre

    public String toString(){
        String str = "Carte "+this.valeur+" "+this.couleur;
        return str;
    }                                         // Affichage de la carte


    public void piocher(Joueur joueurSuivant, ArrayList pioche, ArrayList mainJoueurSuivant) { }


} // Fin class
