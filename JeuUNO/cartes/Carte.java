package com.JeuUNO.cartes;

import com.JeuUNO.Joueur;
import java.util.ArrayList;

public abstract class Carte <T> {
    protected T valeur;
    protected String couleur;
    protected boolean carteSpeciale;

    public Carte() {
    }                                                          // Constructeur par défaut

    public Carte(T valeur, String couleur, boolean carteSpeciale) {
        this.valeur = valeur;
        this.couleur = couleur;
        this.carteSpeciale = carteSpeciale;
    }        // Constructeur avec paramètres

    // ********** ACCESSEURS **********
    public boolean getCarteSpeciale() {
        return carteSpeciale;
    }                                   // Retourne si c'est une carte spéciale
    public T getValeur() {
        return valeur;
    }                                   // Retourne la valeur de la carte
    public String getCouleur() {
        return couleur;
    }                            // Retourne la couleur de la carte

    // ********* MUTATEURS **********
    public void setValeur(T valeur) {
        this.valeur = valeur;
    }                 // Change la valeur
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }        // Change la couleur

    public String toString() {
        String str = "Carte " + this.valeur + " " + this.couleur;
        return str;
    }                                             // Affichage de la carte

    public void piocher(Joueur joueurQuiPioche, ArrayList<Carte> pioche, ArrayList <Carte> mainJoueurQuiPioche){ }




}