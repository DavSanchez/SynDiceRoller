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

//    @Override
//    public void setDiceRollerButtons() {
//
//        registerListener(R.id.btn_remove);
//        registerListener(R.id.btn_roll);
//    }
//
//    private void registerListener(int btnId) {
//
//        View btn = findViewById(btnId);
//
//        if (btn != null) {
//            btn.setOnClickListener((View.OnClickListener) this);
//        } else {
//            debug("registerListener", "error", "resource not available");
//        }
//    }

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

    @Override
    public void setDetailLayout(){
        debug("setDetailLayout");

        setContentView(getDataLayout());
    }

    private int getDataLayout(){
        return R.layout.detail_view;
    }

    @Override
    public void setDetailData(DetailData data){
        TextView dataView = (TextView) findViewById(R.id.lbl_data);
        dataView.setText(data.getLabel());
    }

    @Override
    public void display(String numeroPantalla) {
        debug ("display", "numeroPantalla", numeroPantalla);
        TextView display = (TextView) findViewById(R.id.detailNumberRolled);
        display.setText(numeroPantalla);
    }
}
