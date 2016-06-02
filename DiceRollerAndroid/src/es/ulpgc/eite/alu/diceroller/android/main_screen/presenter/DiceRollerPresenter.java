package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

import es.ulpgc.eite.alu.diceroller.android.main_screen.model.I_DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.main_screen.view.I_DiceRollerView;
import es.ulpgc.eite.alu.diceroller.android.main_screen.state.DiceRollerState;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerPresenter extends AndroidScreenPresenter implements I_DiceRollerPresenter {

    private I_DiceRollerPresenter _presenter;
    private String _display;

    private I_DiceRollerView getDiceRollerView(){ return (I_DiceRollerView) getScreenView(); }

    private I_DiceRollerModel getDiceRollerModel(){ return (I_DiceRollerModel) getScreenModel(); }

    private void setDiceRoller (I_DiceRollerPresenter presenter) { _presenter = presenter; }

    private I_DiceRollerPresenter getDiceRoller() { return _presenter; }

    @Override
    public void dicePressed(int caras){
        getDiceRollerModel().roll(caras);
        getDiceRollerModel().numberToString(getDiceRollerModel().getResultadoTirada());
        getDiceRollerView().display(getDiceRollerModel().getResultadoTiradaString());
    }

    @Override
    public void botonListaPressed(){ }


    @Override
    public void createScreen() {
        debug("createScreen");

        getDiceRollerView().initDiceRoller();
        //   setDiceRoller(new DiceRollerPresenter(
        //           getDiceRollerView(), getDiceRollerModel()));
    }

    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");
        getDiceRollerView().display(getDiceRollerModel().getResultadoTiradaString());

    }

    @Override
    public void pauseScreen() {
        debug("pauseScren");
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

        //debug("getNextState", "data", data);

        return new DiceRollerState(_display);

        //return getScreenState();
    }

    @Override
    public String getDisplay() {
        return _display;
    }

    @Override
    public void setDisplay(String display) {
        _display = display;
    }
}
