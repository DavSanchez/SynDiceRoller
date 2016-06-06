package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

/**
 * Created by David on 12/4/16.
 */
public interface I_DiceRollerPresenter {

    void dicePressed(int carasDado);

    void botonListaPressed();

    void numberToString(Integer numero);

    String getResultadoTiradaString();

    void setResultadoTiradaString(String resultadoTiradaString);

    String getDisplay();

    void setDisplay(String display);
}
