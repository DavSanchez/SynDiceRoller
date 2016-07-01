package es.ulpgc.eite.alu.diceroller.android.master.model;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

import java.util.List;

public interface I_MasterModel {
    int getPosition();
    void setPosition(int pos);
    /**
     * Pide la lista de entradas de la vista maestro
     * <p>
     *     Si la lista de la vista maestro esta vacia se ejecuta el metodo fillCollection() para llenarla
     *
     * @return lista de objetos DetailData que son los elementos de la base de datos
     */
    List<DetailData> getCollection();
    DetailData getData();
    /**
     * Elimina una entrada de la base de datos java y de la lista de la vista maestro
     */
    void removeData();
}
