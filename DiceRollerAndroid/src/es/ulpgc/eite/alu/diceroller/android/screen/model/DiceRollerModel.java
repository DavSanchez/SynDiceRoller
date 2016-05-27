package es.ulpgc.eite.alu.diceroller.android.screen.model;

import es.ulpgc.eite.alu.diceroller.android.screen.data.DiceRollerData;
import es.ulpgc.eite.alu.diceroller.android.screen.presenter.I_DiceRollerPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerModel extends AndroidScreenModel implements I_DiceRollerModel {

    private final static String TXT_MSG = "?¿";
    private DiceRollerData _data;

    public DiceRollerModel() {
        setData(new DiceRollerData(TXT_MSG));
    }


    @Override
    public DiceRollerData getData() {
        return _data;
    }

    @Override
    public void setData(DiceRollerData data) {
        _data = data;
    }

    private I_DiceRollerPresenter getDiceRollerPresenter(){
        return (I_DiceRollerPresenter) getScreenPresenter();
    }
}
