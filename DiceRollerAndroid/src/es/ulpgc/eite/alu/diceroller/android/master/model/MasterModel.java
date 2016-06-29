package es.ulpgc.eite.alu.diceroller.android.master.model;

import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.database.I_MasterDetailDatabase;
import es.ulpgc.eite.framework.android.I_AndroidMediatorSingleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MasterModel extends AndroidScreenModel implements I_MasterModel{

    private int position;

    private I_MasterDetailDatabase getMasterDetailDatabase(){
        return (I_MasterDetailDatabase) getScreenDatabase();
    }

    private I_AndroidMediatorSingleton getCurrentMediator(){
        return (I_AndroidMediatorSingleton) getMediator();
    }

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

    /**
     * Lee elementos de la base de datos y los convierte en objetos DetailData.
     *
     * @see {@link #loadJSONFromAsset(String filename)}
     *
     * Ver http://stackoverflow.com/questions/9605913/how-to-parse-json-in-android/9606629#9606629 para más info
     *
     */
    private void fillCollection() {
        debug("fillCollection");

        JSONObject tiradasDB;
        JSONArray tiradasArray;
        try {
            String jsonFile = "tiradasDB.json";
            tiradasDB = new JSONObject(loadJSONFromAsset(jsonFile));
            tiradasArray = tiradasDB.getJSONArray("tiradas");
            for (int i = 0; i < tiradasArray.length(); i++) {
                JSONObject tirada = tiradasArray.getJSONObject(i);
                String label = tirada.getString("label");
                String descrip = tirada.getString("descripcion");
                String tipoTirada = tirada.getString("tipo_tirada");
                int numeroDados = tirada.getInt("numero_dados");
                int dado = tirada.getInt("dado");
                int modif = tirada.getInt("modificador");
                DetailData data = new DetailData(label, descrip, tipoTirada, numeroDados, dado, modif);
                getMasterDetailDatabase().saveData(data);
            }
        } catch (JSONException e) { }
    }

    /**
     *
     * @param filename
     * @return
     */
    private String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream in = getCurrentMediator().getContext().getAssets().open(filename);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) { }
        return json;
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
