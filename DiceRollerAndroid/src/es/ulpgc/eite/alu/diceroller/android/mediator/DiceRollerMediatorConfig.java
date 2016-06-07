package es.ulpgc.eite.alu.diceroller.android.mediator;

import es.ulpgc.eite.alu.diceroller.android.database.DatabaseMasterDetail;
import es.ulpgc.eite.alu.diceroller.android.detail.model.DetailModel;
import es.ulpgc.eite.alu.diceroller.android.detail.presenter.DetailPresenter;
import es.ulpgc.eite.alu.diceroller.android.detail.view.DetailView;
import es.ulpgc.eite.alu.diceroller.android.main_screen.model.DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.main_screen.presenter.DiceRollerPresenter;
import es.ulpgc.eite.alu.diceroller.android.main_screen.view.DiceRollerView;
import es.ulpgc.eite.alu.diceroller.android.master.model.MasterModel;
import es.ulpgc.eite.alu.diceroller.android.master.presenter.MasterPresenter;
import es.ulpgc.eite.alu.diceroller.android.master.view.MasterView;
import es.ulpgc.eite.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.framework.core.mediator.MediatorTransition;

/**
 * Created by David on 12/4/16.
 */
public class DiceRollerMediatorConfig extends MediatorConfig {
    public DiceRollerMediatorConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setDiceRollerConfig();
    }

    private void setDiceRollerConfig() {
        setDiceRollerScreenCollection();
        setDiceRollerTransitionCollection();

    }

    private void setDiceRollerTransitionCollection() {
        getTransitions().add(new MediatorTransition(DiceRollerView.class, null, DiceRollerMediatorCode.CLICK));

        // MASTER-DETAIL. CHECK DiceRollerMediatorCode.CLICK...
        getTransitions().add(new MediatorTransition(MasterView.class,
                DetailView.class, DiceRollerMediatorCode.CLICK_MASTERDETAIL));
    }

    private void setDiceRollerScreenCollection() {
        getScreens().add(new MediatorScreen(DiceRollerView.class, DiceRollerPresenter.class, DiceRollerModel.class));

        // MASTER-DETAIL. CHECK DatabaseMasterDetail.class...
        getScreens().add(new MediatorScreen(MasterView.class,
                MasterPresenter.class, MasterModel.class, DatabaseMasterDetail.class));

        getScreens().add(new MediatorScreen(DetailView.class,
                DetailPresenter.class, DetailModel.class, DatabaseMasterDetail.class));
        
    }
}
