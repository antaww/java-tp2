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
        double impots = 0;
        if (gains < 10225){
            impots = 0;
        } else if (gains >= 10226 && gains <= 26070){
            impots = 0.11 * (gains - 10225);
        } else if (gains >= 26071 && gains <= 74545){
            impots = 0.3 * (gains - 26070) + 0.11 * (26070 - 10225);
        } else if (gains >= 74546 && gains <= 160336){
            impots = 0.41 * (gains - 74545) + 0.3 * (74545 - 26070) + 0.11 * (26070 - 10225);
        } else if (gains >= 160337){
            impots = 0.45 * (gains - 160336) + 0.41 * (160336 - 74545) + 0.3 * (74545 - 26070) + 0.11 * (26070 - 10225);
        }
        return impots;
    }
}
