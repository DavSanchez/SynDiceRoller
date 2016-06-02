package es.ulpgc.eite.alu.diceroller.android.main_screen.model;

/**
 * Created by David on 12/4/16.
 */
public interface I_DiceRollerModel {

    void roll(int carasDado);

    int getResultadoTirada();

    void setResultadoTirada(int resultadoTirada);
}
