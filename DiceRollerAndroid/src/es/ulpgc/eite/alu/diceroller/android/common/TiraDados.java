package es.ulpgc.eite.alu.diceroller.android.common;

import java.util.Random;

public class TiraDados implements I_TiraDados {

    private int _resultadoTirada;

    @Override
    public void roll(int carasDado) {
        Random tirada = new Random();
        int resultado = tirada.nextInt(carasDado)+1;
        setResultadoTirada(resultado);
    }

    @Override
    public void complexRoll(int numDados, int carasDado, int modificador) {
        int res = 0;
        int comp;
        for (int veces = 0; veces < numDados; veces++){
            roll(carasDado);
            res += getResultadoTirada();
        }
        comp = res + modificador;
        if (comp < 0 ){
            setResultadoTirada(0);
        } else {
            setResultadoTirada(comp);
        }
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
