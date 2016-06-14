package es.ulpgc.eite.alu.diceroller.android.common;

import java.util.Random;

/**
 * Created by David on 10/6/16.
 */
public class TiraDados implements I_TiraDados {

    private int _resultadoTirada;

    @Override
    public void roll(int carasDado) {
        Random tirada = new Random();
        int resultado = tirada.nextInt(carasDado)+1;
        setResultadoTirada(resultado);
    }

    @Override
    public void rollConMods(int carasDado, int modificador) {
        roll(carasDado);
        setResultadoTirada(getResultadoTirada() + modificador);
    }

    /*
    @Override
    public void complexRoll(int numDados, int carasDado, int modificador) {
        int res = 0;
        for (int veces = 0; veces < numDados; numDados++){
            roll(carasDado);
            res = res + getResultadoTirada();
        }
        setResultadoTirada(getResultadoTirada() + modificador;);
    }*/

    @Override
    public int getResultadoTirada() {
        return _resultadoTirada;
    }

    @Override
    public void setResultadoTirada(int resultadoTirada) {
        _resultadoTirada = resultadoTirada;
    }
}
