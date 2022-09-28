package Exo4;

import utils.utils;

public class exo4 {
    public static void main(String[] args) {
        System.out.println("Entrez votre nom :");
        String nom = utils.getString();
        System.out.println("Choisir le nombre d'allumette de départ ( > 15) :");
        int allumettes = utils.getInt();
        while (allumettes < 16) {
            System.out.println("Le nombre d'allumettes doit être supérieur ou égal à 16");
            allumettes = utils.getInt();
        }
        boolean tour = Math.random() < 0.5;
        System.out.println(tour ? "L'ordinateur commence" : nom + " commence");
        while (allumettes > 0) {
            if (tour) {
                int choix = (int) (Math.random() * 3) + 1;
                System.out.println("L'ordinateur enlève : " + choix + " reste " + (allumettes - choix));
                allumettes -= choix;
            } else {
                System.out.println(nom + " enlève : ");
                int choix = utils.getInt();
                while (choix < 1 || choix > 3) {
                    System.out.println("Vous devez enlever 1, 2 ou 3 allumettes");
                    choix = utils.getInt();
                }
                allumettes -= choix;
            }
            tour = !tour;
        }
        System.out.println(tour ? nom + " a gagné :-(" : "L'ordinateur a gagné :-(");
        System.out.println(tour ? "L'ordinateur a perdu :-(" : nom + " a perdu :-(");
        utils.Continue(utils.getExoNumber());
    }
}
