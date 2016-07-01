package es.ulpgc.eite.alu.diceroller.android.main_screen.presenter;

public interface I_DiceRollerPresenter {
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
    void dicePressed(int carasDado);
    /**
     * Define la accion a realizar al pulsar el boton Lista de la pantalla principal
     * <p>
     *     Llama al metodo startNextScreenWithFinish para pasar a la siguiente pantalla
     */
    void botonListaPressed();
    String getDisplay();
    void setDisplay(String display);
}
