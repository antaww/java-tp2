package Exo1;

import utils.utils;

public class exo1 {
    public static void main(String[] args) {
        class Archimede {
            public double Cn(double x, double y) {
                return  2 * x * y / (x + y);
            }

            public double Ln(double x, double y) {
                return Math.sqrt(x * y);
            }
        }

        Archimede archimede = new Archimede();
        archimede.Cn(utils.getDouble("X"), utils.getDouble("Y"));
        archimede.Ln(utils.getDouble("X"), utils.getDouble("Y"));
        utils.Continue(utils.getExoNumber());
    }
}
