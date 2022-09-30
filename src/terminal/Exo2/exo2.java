// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package terminal.Exo2;

import utils.utils;

public class exo2 {
    public static void main(String[] args){
        double gains = utils.getDouble("vos gains annuels");
        System.out.printf("Vous devez payer %.2f euros d'impôts", MesImpots(gains));
        utils.Continue(utils.getExoNumber());
    }

    public static double MesImpots(double gains){
        double taux = (gains <= 10225) ? 0 : (gains <= 26070) ? 0.11 : (gains <= 74545) ? 0.3 : (gains <= 160336) ? 0.41 : 0.45;
        return taux * gains;
    }
}
