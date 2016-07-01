package es.ulpgc.eite.alu.diceroller.android.main_screen.model;

public interface I_DiceRollerModel {
    /**
     * Llama al metodo roll() de la clase TiraDados y almacena el resultado
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @param carasDado numero de caras del dado a tirar
     */
    void roll(int carasDado);
    int getResultadoTirada();
    void setResultadoTirada(int resultadoTirada);
}
