package es.ulpgc.eite.alu.diceroller.android.master.view;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

import java.util.List;

public interface I_MasterView {
    void setMasterCollection(List<DetailData> collection);
    void setListPosition(int position);
    void setMasterScreen();
}
