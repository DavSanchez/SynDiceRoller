package es.ulpgc.eite.alu.diceroller.android.detail.model;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

public interface I_DetailModel {
    DetailData getData();
    void setData(DetailData data);
    /**
     * Llama al metodo complexRoll de la clase TiraDados
     *
     * @see es.ulpgc.eite.alu.diceroller.android.common.TiraDados
     *
     * @param numDados numero de dados a tirar
     * @param carasDado caras de los dados a tirar
     * @param modificador numero entero que se suma a la tirada. Puede ser negativo
     */
    void rollDetail(int numDados, int carasDado, int modificador);
    int getResultadoTiradaDetail();
    void setResultadoTiradaDetail(int resultadoTirada);
}
