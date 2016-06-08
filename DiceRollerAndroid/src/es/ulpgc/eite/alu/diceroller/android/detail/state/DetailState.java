package es.ulpgc.eite.alu.diceroller.android.detail.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

public class DetailState implements I_ScreenState {

    private DetailData _data;

    public DetailState() {
        setData(new DetailData());
    }

    public DetailState(DetailData data) {
        _data = data;
    }

    public DetailData getData() {
        return _data;
    }

    public void setData(DetailData data) {
        _data = data;
    }

}
