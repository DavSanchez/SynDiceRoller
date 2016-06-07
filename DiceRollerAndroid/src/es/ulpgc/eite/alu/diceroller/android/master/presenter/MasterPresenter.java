package es.ulpgc.eite.alu.diceroller.android.master.presenter;

import es.ulpgc.eite.alu.diceroller.android.detail.state.DetailState;
import es.ulpgc.eite.alu.diceroller.android.master.model.I_MasterModel;
import es.ulpgc.eite.alu.diceroller.android.master.view.I_MasterView;
import es.ulpgc.eite.alu.diceroller.android.mediator.DiceRollerMediatorCode;
import es.ulpgc.eite.alu.diceroller.android.master.state.MasterState;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

/**
 * Created by David on 2/6/16.
 */
public class MasterPresenter extends AndroidScreenPresenter implements I_MasterPresenter {

    private I_MasterModel getMasterModel(){
        return (I_MasterModel) getScreenModel();
    }

    private I_MasterView getMasterView(){
        return (I_MasterView) getScreenView();
    }

    @Override
    public void setListPosition(int position) {
        getMasterModel().setPosition(position);

        debug("setListPosition", "position", position);
        debug("setListPosition", "data", getMasterModel().getData());

        startNextScreenWithFinish(DiceRollerMediatorCode.CLICK_MASTERDETAIL, false);

    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getMasterView().setMasterScreen();
    }

    @Override
    public void backScreen() {

    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");
        getMasterView().setMasterCollection(getMasterModel().getCollection());
        getMasterView().setListPosition(getMasterModel().getPosition());

    }

    @Override
    public void pauseScreen() {

    }

    @Override
    public void rotateScreen() {

    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if (state != null) { //TODO
            MasterState _state = (MasterState) state;
            getMasterModel().setPosition(_state.getPosition());
        }
    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        MasterState state = new MasterState(getMasterModel().getPosition());

        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        DetailState state = new DetailState(getMasterModel().getData()); //TODO
        return state;
    }

}
