package es.ulpgc.eite.alu.diceroller.android.mediator;

import es.ulpgc.eite.framework.android.AndroidMediatorSingleton;

/**
 * Created by David on 12/4/16.
 */
public class  DiceRollerMediatorSingleton extends AndroidMediatorSingleton {
    @Override
    public void createMediator() {
        setCustomConfig(new DiceRollerMediatorConfig(this));
    }
}
