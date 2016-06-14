package es.ulpgc.eite.alu.diceroller.android.common;

import android.util.JsonReader;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.framework.android.I_AndroidMediatorSingleton;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 14/6/16.
 */
public class JSONParser {

    private static JSONParser parser;

    public JSONParser() {
    }

    public static synchronized JSONParser getJsonParser()
    {
        if (parser == null)
            parser = new JSONParser();
        return parser;
    }

//    private I_AndroidMediatorSingleton getCurrentMediator(){
//        return (I_AndroidMediatorSingleton) getMediator();
//    }

    public List<DetailData> readJsonStream (InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return leerArrayDatos(reader);
        } finally {
            reader.close();
        }
    }

    public List leerArrayDatos(JsonReader reader) throws IOException {
        ArrayList datos = new ArrayList();
        reader.beginArray();
        while(reader.hasNext()){
            datos.add(leerDato(reader));
        }
        reader.endArray();
        return datos;
    }

    public DetailData leerDato(JsonReader reader) throws IOException {
        String etiqueta = null;
        String descrip = null;
        String tipoTirada = null;
        int numDados = 0;
        int carasDado = 0;
        int modificador = 0;

        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            switch (name){
                case "label":
                    etiqueta = reader.nextString();
                    break;
                case "descripcion":
                    descrip = reader.nextString();
                    break;
                case "tipo_tirada":
                    tipoTirada = reader.nextString();
                    break;
                case "numero_dados":
                    numDados = reader.nextInt();
                    break;
                case "dado":
                    carasDado = reader.nextInt();
                    break;
                case "modificador":
                    modificador = reader.nextInt();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new DetailData(etiqueta, descrip, tipoTirada, numDados, carasDado, modificador);
    }
//
//    public InputStream loadJSONFromAsset(String filename) {
//        String json = null;
//        try {
//            InputStream in = getCurrentMediator().getContext().getAssets().open(filename + ".json");
//            // InputStream in = getAssets().open(filename);
//            int size = in.available();
//            byte[] buffer = new byte[size];
//            in.read(buffer);
//            in.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) { }
//        return buffer;
//    }
}
