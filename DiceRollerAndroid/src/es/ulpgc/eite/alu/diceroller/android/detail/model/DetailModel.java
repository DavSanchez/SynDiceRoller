package es.ulpgc.eite.alu.diceroller.android.detail.model;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_TiraDados;
import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

public class DetailModel extends AndroidScreenModel implements I_DetailModel{

    private DetailData _data;
    private int _resultadoTiradaDetail;

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

    @Override
    public DetailData getData() {
        return _data;
    }

    @Override
    public void setData(DetailData data) {
        _data = data;
    }

    /**
     * Llama al metodo complexRoll de la clase TiraDados y almacena el resultado
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @param numDados numero de dados a tirar
     * @param carasDado caras de los dados a tirar
     * @param modificador numero entero que se suma a la tirada. Puede ser negativo
     */
    @Override
    public void rollDetail(int numDados, int carasDado, int modificador) {
        I_TiraDados dado = getDiceFactory().createDice();
        dado.complexRoll(numDados, carasDado, modificador);
        setResultadoTiradaDetail(dado.getResultadoTirada());
    }

    @Override
    public int getResultadoTiradaDetail() {
        return _resultadoTiradaDetail;
    }

    @Override
    public void setResultadoTiradaDetail(int resultadoTirada) {
        _resultadoTiradaDetail = resultadoTirada;
    }

}
