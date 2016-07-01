package es.ulpgc.eite.alu.diceroller.android.common;

import java.util.Random;

public class TiraDados implements I_TiraDados {

    private int _resultadoTirada;

    /**
     * Simula una tirada de dados
     * <p>
     *     Genera un numero aleatorio entre 1 y el numero de caras del dado especificado mediante el parametro.
     *
     * @see java.util.Random
     *
     * @param carasDado numero de caras del dado a tirar
     */
    @Override
    public void roll(int carasDado) {
        Random tirada = new Random();
        int resultado = tirada.nextInt(carasDado)+1;
        setResultadoTirada(resultado);
    }

    /**
     * Simula una tirada de dados mas compleja.
     * <p>
     *     Utilizando el metodo roll() de esta misma clase, genera un numero aleatorio que es la suma de tantas tiradas
     *     de dado como indique el parametro numDados. Los dados tendran tantas caras como indique el parametro
     *     carasDado. A la suma de estos dados se le suma un modificador entero indicado por el parametro modificador.
     *     Si el resultado de esta suma es negativo el resultado final sera cero.
     *
     * @param numDados numero de dados a tirar
     * @param carasDado caras de los dados a tirar
     * @param modificador numero entero que se suma a la tirada. Puede ser negativo
     */
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

    private void setResultadoTirada(int resultadoTirada) {
        _resultadoTirada = resultadoTirada;
    }
}
