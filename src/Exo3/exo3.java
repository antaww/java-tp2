package Exo3;

import utils.utils;

public class exo3 {
    public static void main(String[] args) {
//        int n = utils.getPositiveInt();
//        n = factoriel(n);
//        System.out.println(n);
//        n = utils.getPositiveInt();
//        int p = utils.getPositiveInt();
//        int x = Cnp(n, p);
//        System.out.println(x);
        System.out.println("Cn");
        System.out.println(Cnp(50,5) * Cnp(11,2));
        System.out.println("Ln");

    }
    static int factoriel(int n) {
        for (int i = 1; i < n; i++) {
            n *= i;
        }
        return n;
    }
    static int Cnp(int n, int p) {
        System.out.println("n: " + n + " p: " + p);
        System.out.println(factoriel(n) / (factoriel(p) * factoriel(n - p)));
        return factoriel(n) / (factoriel(p) * factoriel(n - p));
    }
}
