package es.ulpgc.eite.alu.diceroller.android.common;

public class DiceFactory {

    private static DiceFactory instance;
    private DiceFactory() { }

    /**
     * Instancia un objeto de esta misma clase
     *
     * Ver http://www.oodesign.com/singleton-pattern.html para detalles sobre Singleton
     * Ver http://www.oodesign.com/factory-pattern.html para detalles sobre Factory
     *
     * @return objeto de la clase DiceFactory
     */
    public static synchronized DiceFactory getFactory()
    {
        if (instance == null)
            instance = new DiceFactory();
        return instance;
    }

    /**
     * Instancia un objeto de la clase TiraDados, que implementa la interfaz I_TiraDados
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @return objeto de la clase TiraDados
     */
    public I_TiraDados createDice(){
            return new TiraDados();
    }

    /**
     * Instancia un objeto de la clase NumerosAStringBridge que implementa la interfaz I_NumerosAStringBridge
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.NumerosAStringBridge
     *
     * @return objeto de la clase NumerosAStringBridge
     */
    public I_NumerosAStringBridge createBridge(){
            return new NumerosAStringBridge();
    }
}
