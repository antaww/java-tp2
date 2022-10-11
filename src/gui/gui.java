// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package gui;

import terminal.Exo1.exo1;
import terminal.Exo2.exo2;
import terminal.Exo3.exo3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;


public class gui {
    /**
     * Il crée une interface graphique avec une barre de menus, et ajoute un menu avec un sous-menu
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("TP2 - JAVA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Menu");
        JMenu m2 = new JMenu("Credits");
        mb.add(m1);
        mb.add(m2);
        JMenuItem author1 = new JMenuItem("MISTRAL Olivier");
        JMenuItem author2 = new JMenuItem("PIZZETTA Antoine");
        JMenuItem terminalMode = new JMenuItem("Mode terminal");
        JMenuItem exercice1 = new JMenuItem("Exercice 1");
        JMenuItem exercice2 = new JMenuItem("Exercice 2");
        JMenuItem exercice3 = new JMenuItem("Exercice 3");
        JMenuItem exercice4 = new JMenuItem("Exercice 4");
        JMenuItem quitter = new JMenuItem("Quitter");
        m1.add(terminalMode);
        m1.add(exercice1);
        m1.add(exercice2);
        m1.add(exercice3);
        m1.add(exercice4);
        m1.add(quitter);
        m2.add(author1);
        m2.add(author2);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        JLabel label = new JLabel("TP2 - JAVA");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Poppins", Font.PLAIN, 40));
        label.setForeground(Color.BLACK);
        frame.add(label);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        try {
            frame.setVisible(true);
            System.out.println("GUI chargé ! \n(Pour revenir en mode terminal, choisissez le mode terminal dans le menu graphique)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton cnBtn = new JButton("Cn");
        JButton lnBtn = new JButton("Ln");
        JButton anBtn = new JButton("An");
        JButton impotsBtn = new JButton("Impôts");
        JButton factorielBtn = new JButton("Factoriel");
        JButton cnpBtn = new JButton("Cn (P)");
        JButton nimBtn = new JButton("Nim");

        // Création d'un nouvel écouteur d'action pour le bouton quitter.
        quitter.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ObjButtons = {"Oui", "Non"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de vouloir quitter ?", "Alerte", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    utils.utils.SystemOut();
                }
            }
        });

        displayEx1(frame, exercice1, label, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
        displayEx2(frame, exercice2, label, impotsBtn, cnBtn, lnBtn, anBtn, factorielBtn, cnpBtn, nimBtn);
        displayEx3(frame, exercice3, label, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
        displayEx4(frame, exercice4, label, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
        displayTerminalMode(args, frame, terminalMode);
    }

    /**
     * Il affiche une boîte de dialogue demandant à l'utilisateur s'il veut quitter l'interface graphique et revenir au
     * mode terminal
     *
     * @param args les arguments passés au programme
     * @param frame le cadre de l'interface graphique
     * @param terminalMode le JMenuItem qui sera utilisé pour afficher le JOptionPane
     */
    private static void displayTerminalMode(String[] args, JFrame frame, JMenuItem terminalMode) {
        terminalMode.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ObjButtons = {"Oui", "Non"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de vouloir quitter le GUI \npour revenir au mode terminal ?", "Alerte", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    utils.utils.SystemOut();
                }
            }
        });
    }

    /**
     * Il affiche les boutons du premier exercice et leur ajoute les écouteurs d'action
     *
     * @param frame le JFrame
     * @param exercice1 le JMenuItem qui sera utilisé pour afficher les boutons
     * @param label L'étiquette qui affiche l'exercice en cours
     * @param cnBtn Le bouton de la première méthode du premier exercice.
     * @param lnBtn Le bouton qui sera utilisé pour appeler la fonction
     * @param anBtn Le bouton qui s'affichera à l'écran
     * @param impotsBtn Le bouton qui servira à afficher la fonction impots
     * @param factorielBtn Le bouton qui servira à appeler la fonction factorielle
     * @param cnpBtn Le bouton qui sera utilisé pour appeler la fonction Cnp.
     * @param nimBtn Le bouton qui sera utilisé pour afficher le jeu Nim.
     */
    private static void displayEx1(JFrame frame, JMenuItem exercice1, JLabel label, JButton cnBtn, JButton lnBtn, JButton anBtn, JButton impotsBtn, JButton factorielBtn, JButton cnpBtn, JButton nimBtn) {
        exercice1.addActionListener((ActionEvent e) -> {
            label.setVerticalAlignment(JLabel.TOP);
            label.setText("Exercice 1");
            cnBtn.setBounds(150, 100, 100, 50);
            lnBtn.setBounds(150, 170, 100, 50);
            anBtn.setBounds(150, 240, 100, 50);
            removeEveryBtns(frame, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
            frame.add(cnBtn);
            frame.add(lnBtn);
            frame.add(anBtn);
            frame.setLayout(null);
            frame.setVisible(true);
        });
        // Création d'un bouton qui demandera à l'utilisateur deux valeurs, x et y, puis affichera le résultat de la
        // fonction Cn.
        cnBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            if (cancel(frame, x)) return;
            while (!isDouble(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
                if (cancel(frame, x)) return;
            }
            String y = JOptionPane.showInputDialog("Entrez la valeur de y :");
            if (cancel(frame, y)) return;
            while (!isDouble(y)) {
                y = JOptionPane.showInputDialog("Entrez la valuer de y :");
                if (cancel(frame, y)) return;
            }
            var result = exo1.Archimede.Cn(Double.parseDouble(x), Double.parseDouble(y));
            JOptionPane.showMessageDialog(null, "Cn = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });

        // Création d'un bouton qui affichera une boîte de dialogue demandant à l'utilisateur d'entrer une valeur pour x et
        // y. Il vérifiera alors si la valeur entrée est un double et si ce n'est pas le cas, il affichera une autre boîte
        // de dialogue demandant à l'utilisateur d'entrer une valeur pour x et y. Si la valeur saisie est un double, il
        // affichera le résultat de la fonction Ln.
        lnBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            if (cancel(frame, x)) return;
            while (!isDouble(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
                if (cancel(frame, x)) return;
            }
            String y = JOptionPane.showInputDialog("Entrez la valeur de y :");
            if (cancel(frame, y)) return;
            while (!isDouble(y)) {
                y = JOptionPane.showInputDialog("Entrez la valuer de y :");
                if (cancel(frame, y)) return;
            }
            var result = exo1.Archimede.Ln(Double.parseDouble(x), Double.parseDouble(y));
            JOptionPane.showMessageDialog(null, "Ln = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        });

        // Création d'un bouton qui affichera une boîte de dialogue demandant une valeur de x. Si l'utilisateur annule la
        // boîte de dialogue, le programme reviendra. Si l'utilisateur saisit une valeur, le programme vérifiera s'il
        // s'agit d'un nombre entier. Si ce n'est pas le cas, le programme redemandera une valeur. S'il s'agit d'un nombre
        // entier, le programme calculera la valeur de An et l'affichera dans une boîte de dialogue.
        anBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            if (cancel(frame, x)) return;
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
                if (cancel(frame, x)) return;
            }
            var result = exo1.Archimede.An(Integer.parseInt(x));
            JOptionPane.showMessageDialog(null, "An = [" + result[0] + ", " + result[1] + "]", "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        });
    }

    /**
     * Il affiche les boutons du deuxième exercice et leur ajoute les écouteurs d'action
     *
     * @param frame le JFrame
     * @param exercice2 le JMenuItem qui sera utilisé pour afficher les boutons
     * @param label L'étiquette qui affiche l'exercice en cours
     * @param cnBtn Le bouton de la première méthode du premier exercice.
     * @param lnBtn Le bouton qui sera utilisé pour appeler la fonction
     * @param anBtn Le bouton qui s'affichera à l'écran
     * @param impotsBtn Le bouton qui servira à afficher la fonction impots
     * @param factorielBtn Le bouton qui servira à appeler la fonction factorielle
     * @param cnpBtn Le bouton qui sera utilisé pour appeler la fonction Cnp.
     * @param nimBtn Le bouton qui sera utilisé pour afficher le jeu Nim.
     */
    private static void displayEx2(JFrame frame, JMenuItem exercice2, JLabel label, JButton impotsBtn, JButton cnBtn, JButton lnBtn, JButton anBtn, JButton factorielBtn, JButton cnpBtn, JButton nimBtn) {
        exercice2.addActionListener((ActionEvent e) -> {
            label.setVerticalAlignment(JLabel.TOP);
            label.setText("Exercice 2");
            impotsBtn.setBounds(150, 170, 100, 50);
            removeEveryBtns(frame, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
            frame.add(impotsBtn);
            frame.setLayout(null);
            frame.setVisible(true);
        });
        impotsBtn.addActionListener((ActionEvent e) -> {
            String gains = JOptionPane.showInputDialog("Entrez la valeur de vos gains annuels : ");
            if (cancel(frame, gains)) return;
            while (!isDouble(gains)) {
                gains = JOptionPane.showInputDialog("Entrez la valeur de vos gains annuels : ");
                if (cancel(frame, gains)) return;
            }
            var result = exo2.MesImpots(Double.parseDouble(gains));
            JOptionPane.showMessageDialog(frame, "Vous devez payer " + String.format("%.2f", result) + " euros d'impôts", "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    /**
     * Il affiche les boutons du troisième exercice et leur ajoute les écouteurs d'action
     *
     * @param frame le JFrame
     * @param exercice3 le JMenuItem qui sera utilisé pour afficher les boutons
     * @param label L'étiquette qui affiche l'exercice en cours
     * @param cnBtn Le bouton de la première méthode du premier exercice.
     * @param lnBtn Le bouton qui sera utilisé pour appeler la fonction
     * @param anBtn Le bouton qui s'affichera à l'écran
     * @param impotsBtn Le bouton qui servira à afficher la fonction impots
     * @param factorielBtn Le bouton qui servira à appeler la fonction factorielle
     * @param cnpBtn Le bouton qui sera utilisé pour appeler la fonction Cnp.
     * @param nimBtn Le bouton qui sera utilisé pour afficher le jeu Nim.
     */
    private static void displayEx3(JFrame frame, JMenuItem exercice3, JLabel label, JButton cnBtn, JButton lnBtn, JButton anBtn, JButton impotsBtn, JButton factorielBtn, JButton cnpBtn, JButton nimBtn) {
        exercice3.addActionListener((ActionEvent e) -> {
            label.setVerticalAlignment(JLabel.TOP);
            label.setText("Exercice 3");
            factorielBtn.setBounds(150, 100, 100, 50);
            cnpBtn.setBounds(150, 170, 100, 50);
            removeEveryBtns(frame, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
            frame.add(factorielBtn);
            frame.add(cnpBtn);
            frame.setLayout(null);
            frame.setVisible(true);
        });
        factorielBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            if (cancel(frame, x)) return;
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
                if (cancel(frame, x)) return;
            }
            var result = exo3.factoriel(BigInteger.valueOf(Integer.parseInt(x)));
            JOptionPane.showMessageDialog(frame, x + "! = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });
        cnpBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            if (cancel(frame, x)) return;
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
                if (cancel(frame, x)) return;
            }
            String y = JOptionPane.showInputDialog("Entrez la valeur de y :");
            if (cancel(frame, y)) return;
            while (!isInt(y)) {
                y = JOptionPane.showInputDialog("Entrez la valuer de y :");
                if (cancel(frame, y)) return;
            }
            var result = exo3.cnp(BigInteger.valueOf(Integer.parseInt(x)), BigInteger.valueOf(Integer.parseInt(y)));
            JOptionPane.showMessageDialog(frame, x + " parmi " + y + " = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    /**
     * Il affiche les boutons du quatrième exercice et leur ajoute les écouteurs d'action
     *
     * @param frame le JFrame
     * @param exercice4 le JMenuItem qui sera utilisé pour afficher les boutons
     * @param label L'étiquette qui affiche l'exercice en cours
     * @param cnBtn Le bouton de la première méthode du premier exercice.
     * @param lnBtn Le bouton qui sera utilisé pour appeler la fonction
     * @param anBtn Le bouton qui s'affichera à l'écran
     * @param impotsBtn Le bouton qui servira à afficher la fonction impots
     * @param factorielBtn Le bouton qui servira à appeler la fonction factorielle
     * @param cnpBtn Le bouton qui sera utilisé pour appeler la fonction Cnp.
     * @param nimBtn Le bouton qui sera utilisé pour afficher le jeu Nim.
     */
    private static void displayEx4(JFrame frame, JMenuItem exercice4, JLabel label, JButton cnBtn, JButton lnBtn, JButton anBtn, JButton impotsBtn, JButton factorielBtn, JButton cnpBtn, JButton nimBtn) {
        exercice4.addActionListener((ActionEvent e) -> {
            label.setVerticalAlignment(JLabel.TOP);
            label.setText("Exercice 4");
            nimBtn.setBounds(150, 100, 100, 50);
            removeEveryBtns(frame, cnBtn, lnBtn, anBtn, impotsBtn, factorielBtn, cnpBtn, nimBtn);
            frame.add(nimBtn);
            frame.setLayout(null);
            frame.setVisible(true);
        });
        nimBtn.addActionListener((ActionEvent e) -> {
            String name = JOptionPane.showInputDialog("Entrez votre nom : ");
            if (cancel(frame, name)) return;
            while (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Vous n'avez pas entré de nom", "Erreur", JOptionPane.ERROR_MESSAGE);
                name = JOptionPane.showInputDialog("Entrez votre nom : ");
                if (cancel(frame, name)) return;
            }
            String x = JOptionPane.showInputDialog("Entrez le nombre d'allumettes ( > 15 ) :");
            if (cancel(frame, x)) return;
            while (!isInt(x) || Integer.parseInt(x) < 16) {
                x = JOptionPane.showInputDialog("Entrez le nombre d'allumettes ( > 15 ) :");
                if (cancel(frame, x)) return;
            }
            int allumettes = Integer.parseInt(x);
            boolean tour = Math.random() < 0.5;
            System.out.println(tour);
            JOptionPane.showMessageDialog(frame, "C'est au tour de " + (tour ? name : "l'ordinateur") + " de jouer", "Tour", JOptionPane.INFORMATION_MESSAGE);
            while (allumettes > 0) {
                if (tour) {
                    String y = JOptionPane.showInputDialog("Entrez le nombre d'allumettes à prendre (1, 2 ou 3) :");
                    if (cancel(frame, y)) return;
                    while (!isInt(y) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > 3) {
                        y = JOptionPane.showInputDialog("Entrez le nombre d'allumettes à prendre (1, 2 ou 3) :");
                        if (cancel(frame, y)) return;
                    }
                    int allumettesPrises = Integer.parseInt(y);
                    allumettes = allumettes - allumettesPrises;
                    tour = false;
                    JOptionPane.showMessageDialog(frame, "Vous avez pris " + allumettesPrises + (allumettesPrises > 1 ? " allumettes" : " allumette") + ", il en reste " + allumettes + "\n" + "|".repeat(allumettes), "Tour", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int nim = allumettes % 4;
                    int nbAllumettes = (nim == 0) ? 1 : nim;
                    allumettes -= nbAllumettes;
                    JOptionPane.showMessageDialog(frame, "L'ordinateur a pris " + nbAllumettes + (nbAllumettes > 1 ? " allumettes" : " allumette") + ", il en reste " + allumettes + "\n" + "|".repeat(allumettes), "Tour", JOptionPane.INFORMATION_MESSAGE);
                    tour = true;
                }
            }
            JOptionPane.showMessageDialog(frame, "Le gagnant est " + (tour ? "l'ordinateur" : name), "Gagnant", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private static boolean cancel(JFrame frame, String name) {
        if (name == null) {
            String[] ObjButtons = {"Oui", "Non"};
            int PromptResult = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de vouloir quitter ?", "Alerte", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
            return PromptResult == JOptionPane.YES_OPTION;
        }
        return false;
    }


    /**
     * Il supprime chaque bouton du cadre
     *
     * @param frame le cadre qui contient les boutons
     * @param cnBtn Le bouton qui servira à appeler la fonction qui calculera le nombre de combinaisons.
     * @param lnBtn Le bouton qui sera utilisé pour calculer le logarithme naturel d'un nombre.
     * @param anBtn le bouton qui servira à afficher la fenêtre "Année bissextile"
     * @param impotsBtn Le bouton qui servira à calculer les taxes
     * @param factorielBtn Le bouton qui sera utilisé pour calculer la factorielle d'un nombre.
     * @param cnpBtn Le bouton qui sera utilisé pour revenir au menu principal.
     * @param nimBtn le bouton qui servira à revenir au menu principal
     */
    private static void removeEveryBtns(JFrame frame, JButton cnBtn, JButton lnBtn, JButton anBtn, JButton impotsBtn, JButton factorielBtn, JButton cnpBtn, JButton nimBtn) {
        frame.remove(impotsBtn);
        frame.remove(factorielBtn);
        frame.remove(cnpBtn);
        frame.remove(cnBtn);
        frame.remove(lnBtn);
        frame.remove(anBtn);
        frame.remove(nimBtn);
    }

    /**
     * Si l'entrée peut être analysée comme un double, renvoie vrai, sinon renvoie faux
     *
     * @param input La chaîne à vérifier
     * @return Une valeur booléenne.
     */
    private static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Si l'entrée peut être analysée comme un entier, renvoie vrai, sinon renvoie faux.
     *
     * @param input La chaîne à vérifier
     * @return Une valeur booléenne.
     */
    private static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
