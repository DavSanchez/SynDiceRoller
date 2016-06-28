package es.ulpgc.eite.alu.diceroller.android.common;

public class DiceFactory {

    private static DiceFactory instance;
    private DiceFactory() { }

    public static synchronized DiceFactory getFactory()
    {
        if (instance == null)
            instance = new DiceFactory();
        return instance;
    }

    public I_TiraDados createDice(){
        return new TiraDados();
    }

    public I_NumerosAStringBridge createBridge(){
        return new NumerosAStringBridge();
    }
}
