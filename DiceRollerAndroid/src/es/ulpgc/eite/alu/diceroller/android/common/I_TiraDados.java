package es.ulpgc.eite.alu.diceroller.android.common;

public interface I_TiraDados {
    void roll(int carasDado);
    void complexRoll(int numDados, int carasDado, int modificador);
    int getResultadoTirada();
}
