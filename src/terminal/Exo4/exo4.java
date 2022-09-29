// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package terminal.Exo4;

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
        int space = 0;
        boolean tour = Math.random() < 0.5;
        System.out.println(tour ? "L'ordinateur commence (" + allumettes + " allumettes)" : nom + " commence(" + allumettes + " allumettes)");
        while (allumettes > 0) {
            if (tour) {
                System.out.print(" ".repeat(space) + "|".repeat(allumettes));
                int nim = allumettes % 4;
                int nbAllumettes = (nim == 0) ? 1 : nim;
                allumettes -= nbAllumettes;
                space += nbAllumettes;
                System.out.println(nbAllumettes > 1 ? " L'ordinateur prend " + nbAllumettes + " allumettes (" + allumettes + (allumettes > 1 ? " restantes)" : "restante"): " L'ordinateur prend 1 allumette (" + allumettes + (allumettes > 1 ? " restantes)" : "restante"));
            } else {
                System.out.print(" ".repeat(space) + "|".repeat(allumettes) + " " + nom + " enlève : ");
                int choix = utils.getInt();
                while (allumettes - choix < 0) {
                    System.out.println(" ".repeat(space+allumettes) + " Vous ne pouvez pas enlever plus d'allumettes que le nombre d'allumettes restantes");
                    System.out.print(" ".repeat(space) + "|".repeat(allumettes) + " " + nom + " enlève : ");
                    choix = utils.getInt();
                }
                while (choix < 1 || choix > 3) {
                    System.out.println(" ".repeat(space+allumettes) + " Vous devez enlever 1, 2 ou 3 allumettes");
                    System.out.print(" ".repeat(space) + "|".repeat(allumettes) + " " + nom + " enlève : ");
                    choix = utils.getInt();
                }
                System.out.println(" ".repeat(space+allumettes) + " Il reste " + (allumettes - choix) + " allumette(s)");
                allumettes -= choix;
                space += choix;
            }
            tour = !tour;
        }
        System.out.println(!tour ? nom + " a perdu\nL'ordinateur a gagné" : "L'ordinateur a perdu\n" + nom + " a gagné");
        utils.Continue(utils.getExoNumber());
    }
}
