package es.ulpgc.eite.alu.diceroller.android.main_screen.model;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_TiraDados;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerModel extends AndroidScreenModel implements I_DiceRollerModel {
    private int _resultadoTirada;

    private DiceFactory getDiceFactory(){
        return DiceFactory.getFactory();
    }

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
