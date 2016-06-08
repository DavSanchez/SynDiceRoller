package es.ulpgc.eite.alu.diceroller.android.master.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;

public class MasterState implements I_ScreenState {

    private int position;

    public MasterState() {
        setPosition(0);
    }

    public MasterState(int pos) {
        position = pos;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int pos) {
        position = pos;
    }
}
