// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package terminal.Exo1;

import utils.utils;

public class exo1 {
    /**
     * Il calcule la valeur de Cn, Ln et An.
     */
    public static void main(String[] args) {
        Archimede archimede = new Archimede();
        System.out.println("Calcul de Cn");
        System.out.println(Archimede.Cn(utils.getDouble("X"), utils.getDouble("Y")));
        System.out.println("Calcul de Ln");
        System.out.println(Archimede.Ln(utils.getDouble("X"), utils.getDouble("Y")));
        System.out.println("Calcul de An");
        System.out.println("Entrer la valeur de N :");
        double[] array = Archimede.An(utils.getInt());
        System.out.println("["+String.join(", ", java.util.Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new))+"]");
        utils.Continue(utils.getExoNumber());
    }

    /**
     * La classe Archimede contient deux méthodes statiques, Cn et Ln, qui permettent de calculer la circonférence et la
     * longueur d'un polygone à n côtés inscrits dans un cercle. La méthode An renvoie la circonférence et la longueur d'un
     * polygone à n côtés inscrits dans un cercle
     */
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
