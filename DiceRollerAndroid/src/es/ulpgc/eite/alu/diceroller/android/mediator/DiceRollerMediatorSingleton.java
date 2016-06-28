package es.ulpgc.eite.alu.diceroller.android.mediator;

import es.ulpgc.eite.framework.android.AndroidMediatorSingleton;

public class  DiceRollerMediatorSingleton extends AndroidMediatorSingleton {
    @Override
    public void createMediator() {
        setCustomConfig(new DiceRollerMediatorConfig(this));
    }
}
