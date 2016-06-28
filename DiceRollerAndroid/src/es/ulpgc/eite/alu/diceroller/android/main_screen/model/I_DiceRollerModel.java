package es.ulpgc.eite.alu.diceroller.android.main_screen.model;

public interface I_DiceRollerModel {
    void roll(int carasDado);
    int getResultadoTirada();
    void setResultadoTirada(int resultadoTirada);
}
