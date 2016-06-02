package es.ulpgc.eite.alu.diceroller.android.main_screen.model;

import es.ulpgc.eite.framework.android.AndroidScreenModel;

import java.util.Random;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerModel extends AndroidScreenModel implements I_DiceRollerModel {
    private int _resultadoTirada;
    private String _resultadoTiradaString;

    @Override
    public void roll(int carasDado) {
        Random tirada = new Random();
        int resultado = tirada.nextInt(carasDado)+1;
        setResultadoTirada(resultado);
    }

    @Override
    public void numberToString(Integer numero){
        String numeroString = numero.toString();
        setResultadoTiradaString(numeroString);
    }

    @Override
    public int getResultadoTirada() {
        return _resultadoTirada;
    }

    @Override
    public void setResultadoTirada(int resultadoTirada) {
        _resultadoTirada = resultadoTirada;
    }

    @Override
    public String getResultadoTiradaString() {
        return _resultadoTiradaString;
    }

    @Override
    public void setResultadoTiradaString(String resultadoTiradaString) {
        _resultadoTiradaString = resultadoTiradaString;
    }

}
