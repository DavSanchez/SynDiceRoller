package es.ulpgc.eite.alu.diceroller.android.detail.model;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.detail.presenter.I_DetailPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

/**
 * Created by David on 7/6/16.
 */
public class DetailModel extends AndroidScreenModel implements I_DetailModel {

    private DetailData _data;

    @Override
    public DetailData getData() {
        return _data;
    }

    @Override
    public void setData(DetailData data) {
        _data = data;
    }

    private I_DetailPresenter getDetailPresenter(){
        return (I_DetailPresenter) getScreenPresenter();
    }
}
