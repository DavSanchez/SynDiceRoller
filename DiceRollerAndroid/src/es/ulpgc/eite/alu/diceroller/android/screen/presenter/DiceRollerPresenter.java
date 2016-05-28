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

    private I_DiceRollerPresenter _presenter;

    private void setDiceRoller(I_DiceRollerPresenter presenter) {
        _presenter = presenter;
    }

    private I_DiceRollerPresenter getDiceRoller() {
        return _presenter;
    }

    @Override
    public void dicePressed(int caras){
        Integer resultado = getDiceRollerModel().roll(caras);
        getDiceRollerView().display(resultado.toString());
    }

    @Override
    public void botonListaPressed(){

    }


    @Override
    public void createScreen() {
        debug("createScreen");

        getDiceRollerView().initDiceRoller();
     //   setDiceRoller(new DiceRollerPresenter(
     //           getDiceRollerView(), getDiceRollerModel()));
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
