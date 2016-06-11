package es.ulpgc.eite.alu.diceroller.android.common;

/**
 * Created by David on 10/6/16.
 */
public interface I_TiraDados {
    void roll(int carasDado);

    void rollConMods(int carasDado, int modificador);

    int getResultadoTirada();

    void setResultadoTirada(int resultadoTirada);
}
