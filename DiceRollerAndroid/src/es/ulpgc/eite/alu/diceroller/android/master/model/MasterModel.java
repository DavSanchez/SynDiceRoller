package es.ulpgc.eite.alu.diceroller.android.master.model;

import es.ulpgc.eite.alu.diceroller.android.common.JSONParser;
import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.database.I_MasterDetailDatabase;
import es.ulpgc.eite.alu.diceroller.android.master.presenter.I_MasterPresenter;
import es.ulpgc.eite.framework.android.I_AndroidMediatorSingleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MasterModel extends AndroidScreenModel implements I_MasterModel{

    private int position;
    String jsonFile = "";

    private I_MasterPresenter getMasterPresenter() {
        return (I_MasterPresenter) getScreenPresenter();
    }

    private I_MasterDetailDatabase getMasterDetailDatabase(){
        return (I_MasterDetailDatabase) getScreenDatabase();
    }

    private I_AndroidMediatorSingleton getCurrentMediator(){
        return (I_AndroidMediatorSingleton) getMediator();
    }

//    private JSONParser parser;
//
//    private JSONParser getParser(){
//        parser = JSONParser.getJsonParser();
//        return parser;
//    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int pos) {
        position = pos;
    }

    @Override
    public List<DetailData> getCollection(){
        if(getMasterDetailDatabase().getDataList().size() == 0){
            fillCollection();
        }
        return getMasterDetailDatabase().getDataList();
    }

    private void fillCollection() {
        debug("fillCollection");
        //getCurrentMediator().getContext().getAssets();

        for(int pos=0; pos < 5; pos++){
            DetailData data = new DetailData("Ataque " + pos, "Descripcion", "Ataque", 1, 20, pos);
            getMasterDetailDatabase().saveData(data);
        }

    }

    @Override
    public DetailData getData() {
        return getMasterDetailDatabase().getDataList().get(getPosition());
    }

    @Override
    public void removeData(){
        getMasterDetailDatabase().deleteData(getData().getId());
        debug("removeData", "collection", getCollection());
    }

}
