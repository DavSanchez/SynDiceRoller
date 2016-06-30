package es.ulpgc.eite.alu.diceroller.android.detail.view;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

public interface I_DetailView {
    /**
     * Establece el Listener y la accion correspondiente a pulsar el boton Remove
     */
    void setDetailBtnListenerRemove();
    /**
     * Establece el Listener y la accion correspondiente a pulsar el boton Roll
     */
    void setDetailBtnListenerRoll();
    /**
     * Carga el layout correspondiente a la vista detalle
     */
    void setDetailLayout();
    /**
     * Rellena el campo de titulo de la vista detalle con el campo titulo del elemento actual
     *
     * @param data el objeto DetailData del que va a sacarse la informacion
     */
    void setDetailData(DetailData data);
    /**
     * Rellena el campo de descripcion de la vista detalle con el campo descripcion descripcion del elemento actual
     *
     * @param data el objeto DetailData del que va a sacarse la informacion
     */
    void setDescriptionData(DetailData data);
    /**
     * Representa en la pantalla del dispositivo la informacion del parametro
     *
     * @param numeroPantalla el numero a representar
     */
    void display(String numeroPantalla);
}
