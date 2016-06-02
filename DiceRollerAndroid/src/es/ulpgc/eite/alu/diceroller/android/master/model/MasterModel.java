package es.ulpgc.eite.alu.diceroller.android.master.model;

import es.ulpgc.eite.alu.diceroller.android.master.presenter.I_MasterPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

/**
 * Created by David on 2/6/16.
 */
public class MasterModel extends AndroidScreenModel implements I_MasterModel {

    private I_MasterPresenter getMasterPresenter(){
        return (I_MasterPresenter) getScreenPresenter();
    }
}
