package es.ulpgc.eite.alu.diceroller.android.master.view;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

import java.util.List;

/**
 * Created by David on 2/6/16.
 */
public interface I_MasterView {

    void setMasterCollection(List<DetailData> collection);
    void setListPosition(int position);

    void setMasterScreen();

}
