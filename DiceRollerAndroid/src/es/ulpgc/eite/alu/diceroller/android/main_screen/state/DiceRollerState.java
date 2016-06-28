package es.ulpgc.eite.alu.diceroller.android.main_screen.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;

public class DiceRollerState implements I_ScreenState {
    private String _display;

    public DiceRollerState() {
        setDisplay("");
    }

    public DiceRollerState(String display) {
        setDisplay(display);
    }

    public String getDisplay() {
        return _display;
    }

    public void setDisplay(String display) {
        _display = display;
    }
}
