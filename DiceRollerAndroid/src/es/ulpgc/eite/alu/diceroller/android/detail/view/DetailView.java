package es.ulpgc.eite.alu.diceroller.android.detail.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.detail.presenter.I_DetailPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;

/**
 * Created by David on 7/6/16.
 */
public class DetailView extends AndroidScreenView implements I_DetailView {
    private I_DetailPresenter getDetailPresenter(){
        return (I_DetailPresenter) getScreenPresenter();
    }

    @Override
    public void setDetailBtnListener(){
        Button deleteView = (Button) findViewById(R.id.btn_data);
        deleteView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
getDetailPresenter().deleteData();
            }
        });
    }

    @Override
    public void setDetailLayout(){
        debug("setDetailLayout ");

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

}
