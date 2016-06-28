package es.ulpgc.eite.alu.diceroller.android.detail.model;

import es.ulpgc.eite.alu.diceroller.android.common.DiceFactory;
import es.ulpgc.eite.alu.diceroller.android.common.I_TiraDados;
import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.detail.presenter.I_DetailPresenter;

public class DetailModel extends AndroidScreenModel implements I_DetailModel{

    private DetailData _data;
    private int _resultadoTiradaDetail;

    private I_DetailPresenter getDetailPresenter(){
        return (I_DetailPresenter) getScreenPresenter();
    }

    private DiceFactory factory;

    private DiceFactory getDiceFactory(){
        factory = DiceFactory.getFactory();
        return factory;
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
