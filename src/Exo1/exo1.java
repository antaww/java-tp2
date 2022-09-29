package Exo1;

import utils.utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class exo1 {
    public static void main(String[] args) {
        Archimede archimede = new Archimede();
        System.out.println("Cn");
        System.out.println(archimede.Cn(utils.getDouble("X"), utils.getDouble("Y")));
        System.out.println("Ln");
        System.out.println(archimede.Ln(utils.getDouble("X"), utils.getDouble("Y")));
        System.out.println("An");
        double[] array = archimede.An(5);
        System.out.println("["+String.join(", ", java.util.Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new))+"]");
        utils.Continue(utils.getExoNumber());
    }

    public static class Archimede {
        public static double Cn(double x, double y) {
            return  2 * x * y / (x + y);
        }

        public static double Ln(double x, double y) {
            return Math.sqrt(x * y);
        }
        public static double[] An(int n) {
            double x = 4;
            double y = (2*Math.sqrt(2));
            for (int i = 0; i < n; i++) {
                x = Archimede.Cn(x, y);
                y = Archimede.Ln(x, y);
            }
            return new double[]{x, y};
        }
    }

}
