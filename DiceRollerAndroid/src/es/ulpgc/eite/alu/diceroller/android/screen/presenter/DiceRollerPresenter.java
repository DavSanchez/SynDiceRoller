package es.ulpgc.eite.alu.diceroller.android.screen.presenter;

import es.ulpgc.eite.alu.diceroller.android.screen.model.I_DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.screen.view.I_DiceRollerView;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerPresenter extends AndroidScreenPresenter implements I_DiceRollerPresenter {

    private I_DiceRollerView getDiceRollerView(){
        return (I_DiceRollerView) getScreenView();
    }

    private I_DiceRollerModel getDiceRollerModel(){
        return (I_DiceRollerModel) getScreenModel();
    }

    @Override
    public void buttonClicked(){
        debug("buttonClicked");
        // FALTAN COSAS!!!!
    }
    @Override
    public void createScreen() {
        debug("createScreen");
        getDiceRollerView().setLayout();
        getDiceRollerView().setListener();
        getDiceRollerView().setData(getDiceRollerModel().getData());
    }

    @Override
    public void backScreen() {

    }

    @Override
    public void resumeScreen() {

    }

    @Override
    public void pauseScreen() {

    }

    @Override
    public void rotateScreen() {

    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

    }

    @Override
    public I_ScreenState getScreenState() {
        return null;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        return null;
    }
}
