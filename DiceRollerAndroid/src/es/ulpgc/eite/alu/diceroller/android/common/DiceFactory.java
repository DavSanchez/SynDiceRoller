package es.ulpgc.eite.alu.diceroller.android.common;

/**
 * Created by David on 11/6/16.
 */
public class DiceFactory {
    public I_Tiradados spawnDice(){
        return new TiraDados();
    }

    public I_NumerosAStringBridge createBridge(){
        return new NumerosAStringBridge();
    }
}
