package Exo1;

import utils.utils;

public class exo1 {
    public void main(String[] args) {
        Archimede archimede = new Archimede();
        System.out.println(archimede.Cn(utils.getDouble("X"), utils.getDouble("Y")));
        System.out.println(archimede.Ln(utils.getDouble("X"), utils.getDouble("Y")));
        double[] array = An(5);
        utils.Continue(utils.getExoNumber());
    }

    class Archimede {
        public static double Cn(double x, double y) {
            return  2 * x * y / (x + y);
        }

        public static double Ln(double x, double y) {
            return Math.sqrt(x * y);
        }
    }
    private double[] An(int n) {
        double x = 4;
        double y = (2*Math.sqrt(2));
        for (int i = 0; i < n; i++) {
            x = Archimede.Cn(x, y);
            y = Archimede.Ln(x, y);
        }
        return new double[]{x, y};
    }
}
