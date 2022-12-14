// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package terminal.menu;

import utils.utils;

import java.io.File;

public class menu {

    /**
     * Il imprime une liste de tous les exercices du dossier, puis exécute celui que l'utilisateur choisit
     */
    public static void main(String[] args) {
        System.out.println("Choisissez un exercice :");
        File folder = new File("src/terminal");
        File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().contains("exo"));
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println((i+1) + ". Exercice " + (i+1));
        }
        System.out.println("0. Quitter");
        System.out.println("G. GUI");
        String choix = utils.getString();
        if (choix.equals("0")) {
            utils.SystemOut();
        } else if(choix.equals("G") || choix.equals("g")) {
            gui.gui.main(args);
        } else if (choix.matches("[1-4]+")) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (choix.equals(String.valueOf(i+1))) {
                    try {
                        Class.forName("terminal.Exo" + (i+1) + ".exo" + (i+1)).getMethod("main", String[].class).invoke(null, (Object) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } else {
            System.out.println("Choix invalide");
            menu.main(args);
        }
    }
}