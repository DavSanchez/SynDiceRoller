package es.ulpgc.eite.alu.diceroller.android.screen.view;

import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.framework.android.AndroidScreenView;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerView extends AndroidScreenView implements I_DiceRollerView {

    @Override
    public void setLayout() {
        debug("setLayout");
        setContentView(R.layout.diceroller_main_view);
    }
}
