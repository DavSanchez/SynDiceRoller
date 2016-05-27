package es.ulpgc.eite.alu.diceroller.android.screen.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.screen.data.DiceRollerData;
import es.ulpgc.eite.alu.diceroller.android.screen.presenter.I_DiceRollerPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerView extends AndroidScreenView implements I_DiceRollerView {

    private I_DiceRollerPresenter getDiceRollerPresenter(){
        return (I_DiceRollerPresenter) getScreenPresenter();
    }

    @Override
    public void setLayout() {
        debug("setLayout");
        setContentView(R.layout.diceroller_main_view);
    }

    @Override
    public void roll(){

    }

    @Override
    public void setData(DiceRollerData data){
        debug("setData");
        TextView scrMsg = (TextView) findViewById(R.id.numberRolled);
        scrMsg.setText(data.getTxtMsg());
    }

    @Override
    public void setListener(){
        debug("setListener");
        Button dice = (Button) findViewById(R.id.buttond2); // ATENCION INCOMPLETO!!!!!!!
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               getDiceRollerPresenter().buttonClicked();
            }
        });
    }
}
