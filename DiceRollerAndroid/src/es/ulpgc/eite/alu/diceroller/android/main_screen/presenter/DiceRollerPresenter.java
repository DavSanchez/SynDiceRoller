package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_NumerosAStringBridge;
import es.ulpgc.eite.alu.diceroller.android.main_screen.model.I_DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.main_screen.view.I_DiceRollerView;
import es.ulpgc.eite.alu.diceroller.android.main_screen.state.DiceRollerState;
import es.ulpgc.eite.alu.diceroller.android.mediator.DiceRollerMediatorCode;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

public class DiceRollerPresenter extends AndroidScreenPresenter implements I_DiceRollerPresenter {

    private String _display;
    private String _resultadoTiradaString;

    private I_DiceRollerView getDiceRollerView(){ return (I_DiceRollerView) getScreenView(); }

    private I_DiceRollerModel getDiceRollerModel(){ return (I_DiceRollerModel) getScreenModel(); }

    private DiceFactory getDiceFactory(){
        return DiceFactory.getFactory();
    }

    /**
     * Define la accion a realizar al pulsar un boton de dado de la pantalla principal
     * <p>
     *     Llama a la factory para crear una instancia de NumerosAStringBridge
     *     con la que convertir a string el numero almacenado en el modelo al
     *     realizar la tirada de dados con el metodo roll(), obtenido con
     *     getResultadoTirada(). Tras esto, usa el display() de la vista para
     *     mostrarlo en pantalla.
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     * @see es.ulpgc.eite.alu.diceroller.android.main_screen.model.DiceRollerModel
     *
     * @param carasDado numero de caras del dado a tirar
     */
    @Override
    public void dicePressed(int carasDado){
        getDiceRollerModel().roll(carasDado);
        I_NumerosAStringBridge bridge = getDiceFactory().createBridge();
        bridge.numberToString(getDiceRollerModel().getResultadoTirada());
        _resultadoTiradaString = bridge.getResultadoTiradaString();
        getDiceRollerView().display(_resultadoTiradaString);
    }

    /**
     * Define la accion a realizar al pulsar el boton Lista de la pantalla principal
     * <p>
     *     Llama al metodo startNextScreenWithFinish para pasar a la siguiente pantalla
     */
    @Override
    public void botonListaPressed(){
        startNextScreenWithFinish(DiceRollerMediatorCode.LISTA, false);
    }

    /**
     * Llama al metodo initDiceRoller() de la vista para crear la pantalla
     */
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

    /**
     * Almacena el estado de la pantalla principal para la vista
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     * @param state objeto del estado de la aplicacion
     */
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

    /**
     * Obtiene los datos del estado de la pantalla principal
     *
     * @return objeto DiceRollerState con los datos del estado
     */
    @Override
    public I_ScreenState getScreenState() {
        DiceRollerState _state = new DiceRollerState();
        _state.setDisplay(getDisplay());
        debug("getScreenState", "display", _state.getDisplay());
        return _state;
    }

    /**
     * Obtiene el estado siguiente para la vista
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     * @return objeto DiceRollerState con los datos del estado
     */
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
}
