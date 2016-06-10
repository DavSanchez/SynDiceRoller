package test.main_screen.model;

import es.ulpgc.eite.alu.diceroller.android.main_screen.model.DiceRollerModel;
import es.ulpgc.eite.alu.diceroller.android.main_screen.model.I_DiceRollerModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 28/5/16.
 */
public class DiceRollerModelTest {
    private I_DiceRollerModel _lanzaDados;

    // MÁS TEST. TODO

    @Before
    public void setUp() throws Exception {
        _lanzaDados = new DiceRollerModel();
    }

    @Test
    public void roll() throws Exception {
        for (int carasDado = 1; carasDado < 1000; carasDado++)
            for (int contador = 1; contador < 1000; contador++) {
                _lanzaDados.roll(carasDado);
                int tirada = _lanzaDados.getResultadoTirada();
                assertTrue(tirada <= carasDado && tirada > 0);
            }
    }



}