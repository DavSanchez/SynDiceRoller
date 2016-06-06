package es.ulpgc.eite.alu.diceroller.android.database;

import es.ulpgc.eite.masterdetail.android.master.data.MasterData;

import java.util.List;

public interface I_MasterDatabase {


    MasterData getMasterData(Long dataId);
    MasterData getMasterDataBy(DatabaseClauseArg[] args);
    List<MasterData> getMasterDataListBy(DatabaseClauseArg[] args);
    List<MasterData> getMasterDataList();
    boolean deleteMasterData(Long dataId);
    boolean deleteMasterDataList();
    Long saveMasterData(MasterData data);
    boolean updateMasterData(MasterData data);
}
