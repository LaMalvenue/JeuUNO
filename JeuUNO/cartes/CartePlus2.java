package com.JeuUNO.cartes;

import com.JeuUNO.Joueur;
import java.util.ArrayList;

public class CartePlus2 extends Carte {

    public CartePlus2(String couleur){
        this.valeur = "+2";
        this.couleur= couleur;
        this.carteSpeciale=true;
    }

    public boolean getCarteSpeciale(){
        return carteSpeciale;
    }

    public void piocher(Joueur joueurQuiPioche, ArrayList pioche, ArrayList mainJoueurQuiPioche) {
        System.out.println("Aie "+joueurQuiPioche.getNom()+" ! Vous piochez 2 cartes !");
        for (int i = 0; i < 2; i++) {
            mainJoueurQuiPioche.add(pioche.get(i));
            pioche.remove(i);
        }
    }



} // Fin class