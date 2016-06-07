package es.ulpgc.eite.alu.diceroller.android.master.model;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

import java.util.List;

/**
 * Created by David on 2/6/16.
 */
public interface I_MasterModel {
    int getPosition();

    void setPosition(int pos);

    List<DetailData> getCollection();

    DetailData getData();
}
