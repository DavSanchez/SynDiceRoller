package es.ulpgc.eite.alu.diceroller.android.detail.view;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

public interface I_DetailView {

    void setDetailBtnListenerRemove();

    void setDetailBtnListenerRoll();

    //void setDetailBtnListener();
    void setDetailLayout();
    void setDetailData(DetailData data);

    void display(String numeroPantalla);


}
