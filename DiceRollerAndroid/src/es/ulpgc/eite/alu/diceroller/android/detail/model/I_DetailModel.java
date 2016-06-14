package es.ulpgc.eite.alu.diceroller.android.detail.model;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

public interface I_DetailModel {

    DetailData getData();
    void setData(DetailData data);

    //void rollDetail(int carasDado, int modificador);

    void rollDetail(int numDados, int carasDado, int modificador);

    int getResultadoTiradaDetail();

    void setResultadoTiradaDetail(int resultadoTirada);
}
