package es.ulpgc.eite.alu.diceroller.android.database;


import java.util.List;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;


public interface I_MasterDetailDatabase {

    DetailData getData(Long dataId);
    DetailData getDataBy(DatabaseClauseArg[] args);
    List<DetailData> getDataListBy(DatabaseClauseArg[] args);
    List<DetailData> getDataList();
    boolean deleteData(Long dataId);
    boolean deleteDataList();
    Long saveData(DetailData data);
    boolean updateData(DetailData data);

}
