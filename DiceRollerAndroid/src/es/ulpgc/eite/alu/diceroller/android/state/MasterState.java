package es.ulpgc.eite.alu.diceroller.android.state;

import es.ulpgc.eite.alu.diceroller.android.master.presenter.I_MasterPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;

/**
 * Created by David on 6/6/16.
 */
public class MasterState implements I_ScreenState {
    private int position;

    public MasterState() {
        setPosition(0);

    }

    public int getPosition() {
        return position;
    }


    public void setPosition(int pos) {
        position = pos;
    }
}
