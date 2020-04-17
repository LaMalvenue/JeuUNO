package com.JeuUNO.cartes;

public class CarteJoker extends Carte {

    public CarteJoker() {
        this.valeur = "Joker";
        this.couleur=" ";
        carteSpeciale=true;
    }                                                 // Constructeur

    // ********** ACCESSEURS **********
    public boolean getCarteSpeciale(){
        return carteSpeciale;
    }
    public String getValeur(){
        return (String) valeur;
    }



}
