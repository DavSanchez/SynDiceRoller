package es.ulpgc.eite.alu.diceroller.android.detail.model;

import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.detail.presenter.I_DetailPresenter;

import java.util.Random;

public class DetailModel extends AndroidScreenModel implements I_DetailModel{

    private DetailData _data;
    private int _resultadoTiradaDetail;

    private I_DetailPresenter getDetailPresenter(){
        return (I_DetailPresenter) getScreenPresenter();
    }

    @Override
    public DetailData getData() {
        return _data;
    }

    @Override
    public void setData(DetailData data) {
        _data = data;
    }

    @Override
    public void rollDetail(int carasDado, int modificador) {
        Random roll = new Random();
        int tirada = roll.nextInt(carasDado)+1;
        int resultado = tirada + modificador;
        setResultadoTiradaDetail(resultado);
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
