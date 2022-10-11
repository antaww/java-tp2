// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package terminal.Exo3;

import utils.utils;

import java.math.BigInteger;

public class exo3 {
    /**
     * Il calcule la factorielle d'un nombre
     */
    public static void main(String[] args) {
        System.out.println("Entrez un nombre positif :");
        BigInteger n = BigInteger.valueOf(utils.getPositiveInt());
        BigInteger nFact = factoriel(n);
        System.out.println(n + "! = " + nFact);

        System.out.println("Entrez deux nombres positifs :");
        BigInteger a = BigInteger.valueOf(utils.getPositiveInt());
        BigInteger b = BigInteger.valueOf(utils.getPositiveInt());
        BigInteger ab = cnp(a, b);
        System.out.println(a + " parmi " + b + " = " + ab);

        BigInteger test = cnp(BigInteger.valueOf(50), BigInteger.valueOf(5)).multiply(cnp(BigInteger.valueOf(11), BigInteger.valueOf(2)));
        System.out.println("\n50 parmi 5 * 11 parmi 2 = " + test);
        utils.Continue(utils.getExoNumber());
    }

    /**
     * Il calcule la factorielle d'un nombre
     *
     * @param n le nombre d'éléments dans l'ensemble
     * @return La factorielle du nombre n.
     */
    public static BigInteger factoriel(BigInteger n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * La fonction prend deux nombres BigInteger comme paramètres et renvoie le résultat de la formule de combinaison
     *
     * @param n le nombre d'éléments dans l'ensemble
     * @param p le nombre d'éléments dans l'ensemble
     * @return Le nombre de combinaisons de n choses prises p à la fois.
     */
    public static BigInteger cnp(BigInteger n, BigInteger p) {
        BigInteger result;
        result = factoriel(n).divide(factoriel(p).multiply(factoriel(n.subtract(p))));
        return result;
    }
}
