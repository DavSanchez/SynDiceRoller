package es.ulpgc.eite.alu.diceroller.android.main_screen.view;

public interface I_DiceRollerView {
    /**
     * Obtiene el identificador del layout de la pantalla principal
     *
     * @return el identificador del layout de la pantalla principal
     */
    int getDiceRollerLayout();
    /**
     * Inicia la pantalla principal cargando el layout y los listeners de los botones
     */
    void initDiceRoller();
    /**
     * Muestra en la pantalla del dispositivo el numero indicado
     *
     * @param numeroPantalla el numero entero en una variable String
     */
    void display(String numeroPantalla);
}
