package es.ulpgc.eite.alu.diceroller.android.master.model;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

import java.util.List;

public interface I_MasterModel {

    int getPosition();
    void setPosition(int pos);
    List<DetailData> getCollection();
    DetailData getData();
    void removeData();
}
