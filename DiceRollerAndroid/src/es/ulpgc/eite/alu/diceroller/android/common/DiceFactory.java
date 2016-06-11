package es.ulpgc.eite.alu.diceroller.android.common;

/**
 * Created by David on 11/6/16.
 */
public class DiceFactory {

    private static DiceFactory instance;
    private I_TiraDados dado;
    private I_NumerosAStringBridge bridge;
    private DiceFactory() { }

    public static synchronized DiceFactory getFactory()
    {
        if (instance == null)
            instance = new DiceFactory();
        return instance;
    }

    public I_TiraDados spawnDice(){
        {
            if (dado == null)
                dado = new TiraDados();
            return dado;
        }
    }

    public I_NumerosAStringBridge createBridge(){
        {
            if (bridge == null)
                bridge =  new NumerosAStringBridge();
            return bridge;
        }
    }
}
