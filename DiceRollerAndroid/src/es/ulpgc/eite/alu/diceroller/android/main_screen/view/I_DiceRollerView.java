package es.ulpgc.eite.alu.diceroller.android.main_screen.view;

/**
 * Created by David on 12/4/16.
 */
public interface I_DiceRollerView {
    int getDiceRollerLayout();

    void initDiceRoller();

    //void display(int numero);

    void display(String numeroPantalla);
}