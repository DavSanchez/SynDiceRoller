package es.ulpgc.eite.alu.diceroller.android.master.presenter;

import es.ulpgc.eite.alu.diceroller.android.master.model.I_MasterModel;
import es.ulpgc.eite.alu.diceroller.android.master.view.I_MasterView;
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
    public void createScreen() {

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
