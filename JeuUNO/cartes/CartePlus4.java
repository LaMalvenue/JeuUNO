package com.JeuUNO.cartes;

import com.JeuUNO.Joueur;
import java.util.ArrayList;

public class CartePlus4 extends Carte  {

    public CartePlus4(){
        this.valeur = "+4";
        this.couleur=" ";
        this.carteSpeciale=true;
    }

    public boolean getCarteSpeciale(){
        return carteSpeciale;
    }

    public void piocher(Joueur joueurQuiPioche, ArrayList pioche, ArrayList mainJoueurQuiPioche) {
        System.out.println("Aie "+joueurQuiPioche.getNom()+" ! Vous piochez 4 cartes !");
        for (int i = 0; i < 4; i++) {
            mainJoueurQuiPioche.add(pioche.get(i));
            pioche.remove(i);
        }
    }


} // Fin class