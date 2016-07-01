package es.ulpgc.eite.alu.diceroller.android.mediator;

import es.ulpgc.eite.framework.android.AndroidMediatorSingleton;

/**
 * Singleton del mediador de la aplicacion, la actividad principal de la misma, especificada en el AndroidManifest.xml
 */
public class  DiceRollerMediatorSingleton extends AndroidMediatorSingleton {
    @Override
    public void createMediator() {
        setCustomConfig(new DiceRollerMediatorConfig(this));
    }
}
