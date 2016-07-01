package es.ulpgc.eite.alu.diceroller.android.main_screen.model;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_TiraDados;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

public class DiceRollerModel extends AndroidScreenModel implements I_DiceRollerModel {
    private int _resultadoTirada;

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

    /**
     * Llama al metodo roll() de la clase TiraDados y almacena el resultado
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @param carasDado numero de caras del dado a tirar
     */
    @Override
    public void roll(int carasDado) {
        I_TiraDados dado = getDiceFactory().createDice();
        dado.roll(carasDado);
        setResultadoTirada(dado.getResultadoTirada());
    }

    @Override
    public int getResultadoTirada() {
        return _resultadoTirada;
    }

    @Override
    public void setResultadoTirada(int resultadoTirada) {
        _resultadoTirada = resultadoTirada;
    }

}
