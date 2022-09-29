package gui;

import Exo1.exo1;
import menu.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


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
        m1.add(terminalMode);
        m1.add(exercice1);
        m1.add(exercice2);
        m1.add(exercice3);
        m1.add(exercice4);
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
            System.out.println("GUI loaded"); //DEBUG
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton cnBtn = new JButton("Cn");
        JButton lnBtn = new JButton("Ln");
        JButton anBtn = new JButton("An");


        displayEx1(frame, exercice1, label, cnBtn, lnBtn, anBtn);
        displayTerminalMode(args, frame, terminalMode);
    }

    private static void displayTerminalMode(String[] args, JFrame frame, JMenuItem terminalMode) {
        terminalMode.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ObjButtons[] = {"Oui", "Non"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de vouloir quitter ?", "Alerte", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    menu.main(args);
                }
            }
        });
    }

    private static void displayEx1(JFrame frame, JMenuItem exercice1, JLabel label, JButton cnBtn, JButton lnBtn, JButton anBtn) {
        exercice1.addActionListener((ActionEvent e) -> {
            label.setVerticalAlignment(JLabel.TOP);
            label.setText("Exercice 1");
            cnBtn.setBounds(150, 100, 100, 50);
            lnBtn.setBounds(150, 170, 100, 50);
            anBtn.setBounds(150, 240, 100, 50);
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
            System.out.println(result);
            JOptionPane.showMessageDialog(null, "Cn = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
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
            System.out.println(result);
            JOptionPane.showMessageDialog(null, "Ln = " + result, "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        });

        anBtn.addActionListener((ActionEvent e) -> {
            String x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            while (!isInt(x)) {
                x = JOptionPane.showInputDialog("Entrez la valeur de x :");
            }
            var result = exo1.Archimede.An(Integer.parseInt(x));
            System.out.println(result[0] + " " + result[1]);
            JOptionPane.showMessageDialog(null, "An = [" + result[0] + ", " + result[1] + "]", "Résultat", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        });
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
