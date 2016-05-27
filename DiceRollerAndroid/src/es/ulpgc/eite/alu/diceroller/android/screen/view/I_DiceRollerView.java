package es.ulpgc.eite.alu.diceroller.android.screen.view;

import es.ulpgc.eite.alu.diceroller.android.screen.data.DiceRollerData;

/**
 * Created by David on 12/4/16.
 */
public interface I_DiceRollerView {
    void setLayout();

    void roll();

    void setData(DiceRollerData data);

    void setListener();
}
