package gui;

import terminal.Exo1.exo1;
import terminal.Exo2.exo2;
import terminal.Exo3.exo3;
import terminal.menu.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;


public class gui {
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
        cnBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            while (!isDouble(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            }
            String y = JOptionPane.showInputDialog("Entrez la valeur de y :");
            while (!isDouble(y)) {
                y = JOptionPane.showInputDialog("Entrez la valuer de y :");
            }
            var result = exo1.Archimede.Cn(Double.parseDouble(x), Double.parseDouble(y));
            JOptionPane.showMessageDialog(null, "Cn = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });

        lnBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            while (!isDouble(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            }
            String y = JOptionPane.showInputDialog("Entrez la valeur de y :");
            while (!isDouble(y)) {
                y = JOptionPane.showInputDialog("Entrez la valuer de y :");
            }
            var result = exo1.Archimede.Ln(Double.parseDouble(x), Double.parseDouble(y));
            JOptionPane.showMessageDialog(null, "Ln = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        });

        anBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            }
            var result = exo1.Archimede.An(Integer.parseInt(x));
            JOptionPane.showMessageDialog(null, "An = [" + result[0] + ", " + result[1] + "]", "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        });
    }

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
            while (!isDouble(gains)) {
                gains = JOptionPane.showInputDialog("Entrez la valeur de vos gains annuels : ");
            }
            var result = exo2.MesImpots(Double.parseDouble(gains));
            JOptionPane.showMessageDialog(frame, "Vous devez payer " + String.format("%.2f", result) + " euros d'impôts", "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });
    }

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
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            }
            var result = exo3.factoriel(BigInteger.valueOf(Integer.parseInt(x)));
            JOptionPane.showMessageDialog(frame, x + "! = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });
        cnpBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            }
            String y = JOptionPane.showInputDialog("Entrez la valeur de y :");
            while (!isInt(y)) {
                y = JOptionPane.showInputDialog("Entrez la valuer de y :");
            }
            var result = exo3.cnp(BigInteger.valueOf(Integer.parseInt(x)), BigInteger.valueOf(Integer.parseInt(y)));
            JOptionPane.showMessageDialog(frame, x + " parmi " + y + " = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
        });
    }

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
            while (name.isEmpty() ) {
                JOptionPane.showMessageDialog(frame, "Vous n'avez pas entré de nom", "Erreur", JOptionPane.ERROR_MESSAGE);
                name = JOptionPane.showInputDialog("Entrez votre nom : ");
                if (cancel(frame, name)) return;
            }
            String x = JOptionPane.showInputDialog("Entrez le nombre d'allumettes ( > 15 ) :");
            if (cancel(frame, x)) return;
            while (!isInt(x) || Integer.parseInt(x) < 15) {
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
                    JOptionPane.showMessageDialog(frame, "Vous avez pris " + allumettesPrises + (allumettesPrises>1? " allumettes" : " allumette") + ", il en reste " + allumettes + "\n" +"|".repeat(allumettes), "Tour", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int nim = allumettes % 4;
                    int nbAllumettes = (nim == 0) ? 1 : nim;
                    allumettes -= nbAllumettes;
                    JOptionPane.showMessageDialog(frame, "L'ordinateur a pris " + nbAllumettes + (nbAllumettes>1? " allumettes" : " allumette") + ", il en reste " + allumettes + "\n" +"|".repeat(allumettes) , "Tour", JOptionPane.INFORMATION_MESSAGE);
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


    private static void removeEveryBtns(JFrame frame, JButton cnBtn, JButton lnBtn, JButton anBtn, JButton impotsBtn, JButton factorielBtn, JButton cnpBtn, JButton nimBtn) {
        frame.remove(impotsBtn);
        frame.remove(factorielBtn);
        frame.remove(cnpBtn);
        frame.remove(cnBtn);
        frame.remove(lnBtn);
        frame.remove(anBtn);
        frame.remove(nimBtn);
    }

    private static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
