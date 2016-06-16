package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_NumerosAStringBridge;
import es.ulpgc.eite.alu.diceroller.android.common.NumerosAStringBridge;
import es.ulpgc.eite.alu.diceroller.android.main_screen.model.I_DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.main_screen.view.I_DiceRollerView;
import es.ulpgc.eite.alu.diceroller.android.main_screen.state.DiceRollerState;
import es.ulpgc.eite.alu.diceroller.android.mediator.DiceRollerMediatorCode;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerPresenter
        //extends AndroidScreenPresenter implements I_DiceRollerPresenter, I_ScreenObserver {
        extends AndroidScreenPresenter implements I_DiceRollerPresenter {

    private String _display;
    private String _resultadoTiradaString;

    private I_DiceRollerView getDiceRollerView(){ return (I_DiceRollerView) getScreenView(); }

    private I_DiceRollerModel getDiceRollerModel(){ return (I_DiceRollerModel) getScreenModel(); }

    // REVISAR ESTAS TRES LÍNEAS POR SI CÓDIGO MUERTO. TODO

    private I_DiceRollerPresenter _presenter;

    private void setDiceRoller (I_DiceRollerPresenter presenter) { _presenter = presenter; }

    private I_DiceRollerPresenter getDiceRoller() { return _presenter; }


    private DiceFactory factory;

    private DiceFactory getDiceFactory(){
        factory = DiceFactory.getFactory();
        return factory;
    }

    @Override
    public void dicePressed(int caras){
        getDiceRollerModel().roll(caras);
        I_NumerosAStringBridge bridge = getDiceFactory().createBridge();
        bridge.numberToString(getDiceRollerModel().getResultadoTirada());
        _resultadoTiradaString = bridge.getResultadoTiradaString();
        getDiceRollerView().display(_resultadoTiradaString);
    }

    @Override
    public void botonListaPressed(){
        //startNextScreenWithObserver(this, DiceRollerMediatorCode.LISTA);
        startNextScreenWithFinish(DiceRollerMediatorCode.LISTA, false);
    }


    @Override
    public void createScreen() {
        debug("createScreen");

        getDiceRollerView().initDiceRoller();
    }

    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");
        getDiceRollerView().display(_resultadoTiradaString);

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
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        if (state!=null) {
            DiceRollerState _state = (DiceRollerState) state;

            debug("setCurrentState", "display", _state.getDisplay());
            setDisplay(_state.getDisplay());
        }
    }

    @Override
    public I_ScreenState getScreenState() {
        DiceRollerState _state = new DiceRollerState();
        _state.setDisplay(getDisplay());
        debug("getScreenState", "display", _state.getDisplay());
        return _state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        return new DiceRollerState(_display);
    }

    @Override
    public String getDisplay() {
        return _display;
    }

    @Override
    public void setDisplay(String display) {
        _display = display;
    }

    /*
    @Override
    public I_ScreenState updateObserverState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        return null;
    }
    */
}
