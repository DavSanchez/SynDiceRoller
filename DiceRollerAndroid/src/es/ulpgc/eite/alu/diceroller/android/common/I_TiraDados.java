package es.ulpgc.eite.alu.diceroller.android.common;

public interface I_TiraDados {
    /**
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @param carasDado numero de caras del dado a tirar
     */
    void roll(int carasDado);

    /**
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @param numDados numero de dados a tirar
     * @param carasDado numero de caras del dado a tirar
     * @param modificador numero entero que se suma a la tirada. Puede ser negativo
     */
    void complexRoll(int numDados, int carasDado, int modificador);
    int getResultadoTirada();
}
