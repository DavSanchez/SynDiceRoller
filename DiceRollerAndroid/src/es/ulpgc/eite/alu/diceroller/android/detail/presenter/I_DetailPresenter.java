package es.ulpgc.eite.alu.diceroller.android.detail.presenter;

public interface I_DetailPresenter {
    void setResultadoTiradaStringDetail(String resultadoTiradaStringDetail);
    /**
     * Define la accion a realizar cuando se pulsa el boton Roll
     * <p>
     *     Obtiene los campos del elemento de la base de datos del detalle actual
     *     y se los pasa al modelo como parametros de su metodo rollDetail(). Ademas,
     *     le pasa el resultado de este metodo a un objeto NumerosAStringBridge para
     *     transformarlos en String. Por ultimo le pasa dicho String a la vista para
     *     presentarlo en pantalla mediante su metodo display().
     */
    void rollBtnPressed();
    /**
     * Elimina el elemento actual, actualiza la lista de la vista maestro y vuelve a la misma
     */
    void deleteData();
}
