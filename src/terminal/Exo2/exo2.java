// Réalisé par :
// - Olivier MISTRAL
// - Antoine PIZZETTA

package terminal.Exo2;

import utils.utils;

public class exo2 {
    /**
     * Il calcule le montant des taxes que vous devez payer.
     */
    public static void main(String[] args){
        double gains = utils.getDouble("vos gains annuels");
        System.out.printf("Vous devez payer %.2f euros d'impôts", MesImpots(gains));
        utils.Continue(utils.getExoNumber());
    }

    /**
     * > Si les gains sont inférieurs à 10225, les taxes sont de 0. Si les gains sont compris entre 10225 et 26070, les
     * taxes sont de 11 % des gains moins 10225. Si les gains sont compris entre 26071 et 74545, les taxes sont de 30 % du
     * gains moins 26070 plus 11% de 26070 moins 10225. Si les gains sont compris entre 74546 et 160336, les impôts sont de
     * 41% des gains moins 74545 plus 30% de 74545 moins 26070 plus 11% de 26070 moins 10225. Si les gains sont supérieurs
     * que 160337, les impôts sont de 45% des gains moins 160336 plus 41% de 160336 moins 74545 plus 30% de 74545 moins
     * 26070 plus 11% de 26070 moins 10225
     *
     * @param gains le montant d'argent que vous avez gagné en un mois
     * @return Le montant des impôts que la personne doit payer.
     */
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
