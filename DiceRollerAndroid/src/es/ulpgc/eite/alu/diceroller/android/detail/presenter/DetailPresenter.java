package es.ulpgc.eite.alu.diceroller.android.detail.presenter;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_NumerosAStringBridge;
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

public class DetailPresenter extends AndroidScreenPresenter implements I_DetailPresenter, I_ScreenObservable {

    private String _resultadoTiradaStringDetail;
    private Long idData;

    private I_DetailModel getDetailModel(){
        return (I_DetailModel) getScreenModel();
    }

    private I_DetailView getDetailView(){
        return (I_DetailView) getScreenView();
    }

    /**
     * Llama a la factory, DiceFactory
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.DiceFactory
     *
     * @return una instancia de la factory
     */
    private DiceFactory getDiceFactory(){
        return DiceFactory.getFactory();
    }

    @Override
    public void setResultadoTiradaStringDetail(String resultadoTiradaStringDetail) {
        _resultadoTiradaStringDetail = resultadoTiradaStringDetail;
    }

    /**
     * Define la accion a realizar cuando se pulsa el boton Roll
     * <p>
     *     Obtiene los campos del elemento de la base de datos del detalle actual
     *     y se los pasa al modelo como parametros de su metodo rollDetail(). Ademas,
     *     le pasa el resultado de este metodo a un objeto NumerosAStringBridge para
     *     transformarlos en String. Por ultimo le pasa dicho String a la vista para
     *     presentarlo en pantalla mediante su metodo display().
     */
    @Override
    public void rollBtnPressed(){
        int numDados = getDetailModel().getData().getNumDados();
        int sides = getDetailModel().getData().getSides();
        int modif = getDetailModel().getData().getModifier();
        getDetailModel().rollDetail(numDados, sides, modif);
        I_NumerosAStringBridge bridge = getDiceFactory().createBridge();
        bridge.numberToString(getDetailModel().getResultadoTiradaDetail());
        setResultadoTiradaStringDetail(bridge.getResultadoTiradaString());
        getDetailView().display(_resultadoTiradaStringDetail);
    }

    /**
     * Elimina el elemento actual, actualiza la lista de la vista maestro y vuelve a la misma
     */
    @Override
    public void deleteData() {
        debug("deleteData");
        notifyScreenObservers(this, DiceRollerMediatorCode.DELETE, null);
    }

    /**
     * Llama a los metodos necesarios para crear la pantalla detalle
     * <p>
     *     Llama a los metodos de la vista setDetailLayout(), setDetailBtnListenerRemove() y setDetailBtnListenerRoll()
     *     para iniciar la pantalla y los listeners de los botones. Llama al metodo setData() del modelo para presentar
     *     los datos en la pantalla
     */
    @Override
    public void createScreen() {
        debug("createScreen");

        getDetailView().setDetailLayout();
        getDetailView().setDetailBtnListenerRemove();
        getDetailView().setDetailBtnListenerRoll();
        getDetailModel().setData(new DetailData());
    }

    @Override
    public void backScreen() {
        debug("backScreen");

        notifyScreenObservers(this, DiceRollerMediatorCode.BACK, null);
    }

    /**
     * Coteja la ID del ultimo elemento consultado antes de entrar al nuevo elemento
     * <p>
     *     Si la ID es la misma, el numero representado en la pantalla del
     *     dispositivo se conserva. Si no, el campo aparecera en blanco.
     */
    @Override
    public void resumeScreen() {
        debug("resumeScreen");
        getDetailView().setDetailData(getDetailModel().getData());
        getDetailView().setDescriptionData(getDetailModel().getData());
        if(getDetailModel().getData().getId().equals(idData)) {
            getDetailView().display(_resultadoTiradaStringDetail);
        } else {
            setResultadoTiradaStringDetail("");
        }
    }

    /**
     * Guarda la ID del elemento actual de la vista detalle
     */
    @Override
    public void pauseScreen() {
        debug("pauseScreen");
        idData = getDetailModel().getData().getId();
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    /**
     * Almacena el estado de la pantalla de detalle
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     * @param state objeto del estado de la aplicacion
     */
    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null){
            if(view.equals(MasterView.class) && code == DiceRollerMediatorCode.SELECT) {
                DetailState _state = (DetailState) state;
                getDetailModel().setData(_state.getData());
            }
        }
    }

    /**
     * Obtiene los datos del estado de la pantalla detalle
     *
     * @return objeto DetailState con los datos del estado
     */
    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        return new DetailState(getDetailModel().getData());
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        return null;
    }

    /**
     * Finaliza la pantalla detalle si se ha borrado el elemento de la lista maestro
     * <p>
     *     Si el codigo del mediador es el de borrado, finaliza la pantalla actual del detalle
     *
     * @param view clase de la vista
     * @param code codigo del mediador
     * @param state objeto del estado de la aplicacion
     */
    @Override
    public void updateObservableState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObservableState", "view", view.getSimpleName());
        debug("updateObservableState", "code", code);

        if(view.equals(MasterView.class) && code == DiceRollerMediatorCode.DELETE) {
            finishScreen();
        }
    }
}
