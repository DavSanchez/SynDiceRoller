package test.model;

import es.ulpgc.eite.alu.diceroller.android.screen.model.DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.screen.model.I_DiceRollerModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 28/5/16.
 */
public class DiceRollerModelTest {
    private I_DiceRollerModel _lanzaDados;

    @Before
    public void setUp() throws Exception {
        _lanzaDados = new DiceRollerModel();
    }

    @Test
    public void roll() throws Exception {
        for (int carasDado = 2; carasDado < 1000; carasDado++) {
            int tirada = _lanzaDados.roll(carasDado);
            assertTrue(tirada <= carasDado && tirada > 0);
        }
    }

}