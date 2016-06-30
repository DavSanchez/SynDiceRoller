package es.ulpgc.eite.alu.diceroller.android.detail.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import es.ulpgc.eite.framework.android.AndroidScreenView;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.detail.presenter.I_DetailPresenter;

public class DetailView extends AndroidScreenView implements I_DetailView {

    private I_DetailPresenter getDetailPresenter(){
        return (I_DetailPresenter) getScreenPresenter();
    }

    /**
     * Establece el Listener y la accion correspondiente a pulsar el boton Remove
     */
    @Override
    public void setDetailBtnListenerRemove(){
        Button deleteView = (Button) findViewById(R.id.btn_remove);
        deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDetailPresenter().deleteData();
            }
        });
    }

    /**
     * Establece el Listener y la accion correspondiente a pulsar el boton Roll
     */
    @Override
    public void setDetailBtnListenerRoll(){
        Button deleteView = (Button) findViewById(R.id.btn_roll);
        deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDetailPresenter().rollBtnPressed();
            }
        });
    }

    /**
     * Carga el layout correspondiente a la vista detalle
     */
    @Override
    public void setDetailLayout(){
        debug("setDetailLayout");

        setContentView(getDataLayout());
    }

    private int getDataLayout(){
        return R.layout.detail_view;
    }

    /**
     * Rellena el campo de titulo de la vista detalle con el campo titulo del elemento actual
     *
     * @param data el objeto DetailData del que va a sacarse la informacion
     */
    @Override
    public void setDetailData(DetailData data){
        TextView dataView = (TextView) findViewById(R.id.lbl_data);
        dataView.setText(data.getLabel());
    }

    /**
     * Rellena el campo de descripcion de la vista detalle con el campo descripcion descripcion del elemento actual
     *
     * @param data el objeto DetailData del que va a sacarse la informacion
     */
    @Override
    public void setDescriptionData(DetailData data){
        TextView dataView = (TextView) findViewById(R.id.descr_data);
        dataView.setText(data.getDescrip());
    }

    /**
     * Representa en la pantalla del dispositivo la informacion del parametro
     *
     * @param numeroPantalla el numero a representar
     */
    @Override
    public void display(String numeroPantalla) {
        debug ("display", "numeroPantalla", numeroPantalla);
        TextView display = (TextView) findViewById(R.id.detailNumberRolled);
        display.setText(numeroPantalla);
    }
}
