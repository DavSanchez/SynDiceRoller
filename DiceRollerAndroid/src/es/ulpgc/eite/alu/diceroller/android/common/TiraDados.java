package es.ulpgc.eite.alu.diceroller.android.common;

import java.util.Random;

/**
 * Created by David on 10/6/16.
 */
public class TiraDados implements I_Tiradados {

    private int _resultadoTirada;

    @Override
    public void roll(int carasDado) {
        Random tirada = new Random();
        int resultado = tirada.nextInt(carasDado)+1;
        setResultadoTirada(resultado);
    }

    @Override
    public void rollConMods(int carasDado, int modificador) {
        Random roll = new Random();
        int tirada = roll.nextInt(carasDado)+1;
        int resultado = tirada + modificador;
        setResultadoTirada(resultado);
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
