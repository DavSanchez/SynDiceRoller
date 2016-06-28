package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

/**
 * Created by David on 12/4/16.
 */
public interface I_DiceRollerPresenter {
    void dicePressed(int carasDado);
    void botonListaPressed();
    String getDisplay();
    void setDisplay(String display);
}
