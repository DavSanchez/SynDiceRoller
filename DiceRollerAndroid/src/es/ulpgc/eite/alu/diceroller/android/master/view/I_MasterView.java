package es.ulpgc.eite.alu.diceroller.android.master.view;

import es.ulpgc.eite.alu.diceroller.android.data.DetailData;

import java.util.List;

/**
 * Created by David on 2/6/16.
 */
public interface I_MasterView {
    int getListPosition();

    void setMasterLayout();

    void setMasterCollection(List<DetailData> collection);

    //void setListPosition();

    void setListPosition(int position);

    void setMasterList();

    void setMasterAdapter();

    void setMasterListAdapter();

    void setMasterListListener();
}
