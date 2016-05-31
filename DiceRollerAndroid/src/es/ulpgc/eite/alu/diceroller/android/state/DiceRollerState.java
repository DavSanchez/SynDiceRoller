package es.ulpgc.eite.alu.diceroller.android.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;

/**
 * Created by David on 31/5/16.
 */
public class DiceRollerState implements I_ScreenState {
    private String _display;

    public DiceRollerState() {
        setDisplay("0");
    }

    public String getDisplay() {
        return _display;
    }

    public void setDisplay(String display) {
        _display = display;
    }
}
