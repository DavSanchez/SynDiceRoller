package es.ulpgc.eite.alu.diceroller.android.master.presenter;

import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.alu.diceroller.android.detail.state.DetailState;
import es.ulpgc.eite.alu.diceroller.android.detail.view.DetailView;
import es.ulpgc.eite.alu.diceroller.android.master.model.I_MasterModel;
import es.ulpgc.eite.alu.diceroller.android.master.state.MasterState;
import es.ulpgc.eite.alu.diceroller.android.master.view.I_MasterView;
import es.ulpgc.eite.alu.diceroller.android.master.view.MasterView;
import es.ulpgc.eite.alu.diceroller.android.mediator.DiceRollerMediatorCode;

public class MasterPresenter extends AndroidScreenPresenter implements I_MasterPresenter, I_ScreenObserver {

    private I_MasterModel getMasterModel() {
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

        startNextScreenWithObserver(this, DiceRollerMediatorCode.SELECT);
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getMasterView().setMasterScreen();
    }

    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getMasterView().setMasterCollection(getMasterModel().getCollection());
        getMasterView().setListPosition(getMasterModel().getPosition());
    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    /**
     * Almacena el estado de la pantalla de maestro
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     * @param state objeto del estado de la aplicacion
     */
    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null) {
            if(view.equals(MasterView.class) && code == DiceRollerMediatorCode.NULL) {
                MasterState _state = (MasterState) state;
                getMasterModel().setPosition(_state.getPosition());
            }
        }
    }

    /**
     * Obtiene los datos del estado de la pantalla maestro
     *
     * @return objeto MasterState con los datos del estado
     */
    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        return new MasterState(getMasterModel().getPosition());
    }

    /**
     * Al seleccionarse un elemento, se obtiene el estado de su vista detalle
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     *
     * @return objeto DetailState con el estado del detalle
     */
    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        if(view.equals(DetailView.class) && code == DiceRollerMediatorCode.SELECT) {
            return new DetailState(getMasterModel().getData());
        }
        return null;
    }

    /**
     * Actualiza la pantalla maestro si se ha borrado el elemento de la lista detalle
     * <p>
     *     Si el codigo del mediador es el de borrado, se borra el elemento de la lista y se recarga la pantalla maestro
     *     Si el codigo del mediador es el de ir hacia atras, no ocurre nada.
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     * @param state objeto del estado de la aplicacion
     */
    @Override
    public I_ScreenState updateObserverState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        debug("updateObserverState", "view", view.getSimpleName());
        debug("updateObserverState", "code", code);

        if(view.equals(DetailView.class) && code == DiceRollerMediatorCode.DELETE) {
            debug("updateObserverState", "position", getMasterModel().getPosition());

            getMasterModel().removeData();
            resumeScreen();
            return new DetailState();
        }

        if(view.equals(DetailView.class) && code == DiceRollerMediatorCode.BACK) {
            return null;
        }
        return null;
    }
}
