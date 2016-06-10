package es.ulpgc.eite.alu.diceroller.android.detail.presenter;

public interface I_DetailPresenter {

    void numberToStringDetail(Integer numero);

    String getResultadoTiradaStringDetail();

    void setResultadoTiradaStringDetail(String resultadoTiradaStringDetail);

    // CAMBIAR ESTO QUE VIENE DE LA PRINCIPAL
    void rollBtnPressed();

    void deleteData();
}
