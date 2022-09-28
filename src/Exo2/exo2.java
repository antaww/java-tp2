package Exo2;

import utils.utils;

public class exo2 {
    public static void main(String[] args){
        double gains = utils.getDouble("gains");
        MesImpots(gains);
        utils.Continue(utils.getExoNumber());
    }

    private static void  MesImpots(double gains){
        double taux = (gains <= 10225) ? 0 : (gains <= 26070) ? 0.11 : (gains <= 74545) ? 0.3 : (gains <= 160336) ? 0.41 : 0.45;
        System.out.println("Vous devez payer " + taux * gains + "€ d'impôts");
    }
}
