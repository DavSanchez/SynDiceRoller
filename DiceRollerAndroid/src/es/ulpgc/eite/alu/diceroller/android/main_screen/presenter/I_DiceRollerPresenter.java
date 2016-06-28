package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

public interface I_DiceRollerPresenter {
    void dicePressed(int carasDado);
    void botonListaPressed();
    String getDisplay();
    void setDisplay(String display);
}
