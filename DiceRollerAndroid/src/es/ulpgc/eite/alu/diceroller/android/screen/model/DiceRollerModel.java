package es.ulpgc.eite.alu.diceroller.android.screen.model;

import es.ulpgc.eite.framework.android.AndroidScreenModel;

import java.util.Random;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerModel extends AndroidScreenModel implements I_DiceRollerModel {

    @Override
    public int roll(int carasDado) {
        Random tirada = new Random();
        int resultado = tirada.nextInt(carasDado)+1;
        return resultado;
    }
}
