package es.ulpgc.eite.alu.diceroller.android.detail.presenter;

import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObservable;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.detail.model.I_DetailModel;
import es.ulpgc.eite.alu.diceroller.android.detail.state.DetailState;
import es.ulpgc.eite.alu.diceroller.android.detail.view.I_DetailView;
import es.ulpgc.eite.alu.diceroller.android.master.view.MasterView;
import es.ulpgc.eite.alu.diceroller.android.mediator.DiceRollerMediatorCode;


public class DetailPresenter
        extends AndroidScreenPresenter implements I_DetailPresenter, I_ScreenObservable {


    private I_DetailModel getDetailModel(){
        return (I_DetailModel) getScreenModel();
    }

    private I_DetailView getDetailView(){
        return (I_DetailView) getScreenView();
    }


    @Override
    public void deleteData() {
        debug("deleteData");

        //DetailState state = new DetailState(getDetailModel().getData());
        //notifyScreenObservers(this, MasterDetailMediatorCode.DELETE, state);
        notifyScreenObservers(this, DiceRollerMediatorCode.DELETE, null);
        //finishScreen();
    }


    @Override
    public void createScreen() {
        debug("createScreen");

        getDetailView().setDetailLayout();
        getDetailView().setDetailBtnListener();
        getDetailModel().setData(new DetailData());
    }

    @Override
    public void backScreen() {
        debug("backScreen");

        notifyScreenObservers(this, DiceRollerMediatorCode.BACK, null);
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getDetailView().setDetailData(getDetailModel().getData());
    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null){

            if(view.equals(MasterView.class)
                    && code == DiceRollerMediatorCode.SELECT) {

                DetailState _state = (DetailState) state;
                getDetailModel().setData(_state.getData());
            }
        }
    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        DetailState state = new DetailState(getDetailModel().getData());
        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        return null;
    }


    @Override
    public void updateObservableState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObservableState", "view", view.getSimpleName());
        debug("updateObservableState", "code", code);


        if(view.equals(MasterView.class)
                && code == DiceRollerMediatorCode.DELETE) {

            finishScreen();
        }
    }
}
