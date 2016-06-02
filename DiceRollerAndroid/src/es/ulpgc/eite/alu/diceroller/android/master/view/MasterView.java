package es.ulpgc.eite.alu.diceroller.android.master.view;

import es.ulpgc.eite.alu.diceroller.android.master.presenter.I_MasterPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;

/**
 * Created by David on 2/6/16.
 */
public class MasterView extends AndroidScreenView implements I_MasterView {

    private I_MasterPresenter getMasterPresenter(){
        return (I_MasterPresenter) getScreenPresenter();
    }
}
