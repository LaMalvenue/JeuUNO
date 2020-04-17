package com.TestUNO;

import java.util.Scanner;

public class CommencerPartie {
    public static void main(String[] args) {

        Scanner lcString = new Scanner(System.in);

        System.out.println("Voulez-vous commencer la partie ? (Y/N)");
        char debutPartie = lcString.nextLine().toUpperCase().charAt(0);

        while (debutPartie=='Y') {

            System.out.println("Voulez-vous rejouer ? (Y/N)");
            debutPartie=lcString.nextLine().toUpperCase().charAt(0);
        }

        System.out.println("Au revoir !...");
    }
}
