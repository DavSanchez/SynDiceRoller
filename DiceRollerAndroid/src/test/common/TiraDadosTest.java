package test.common;

import es.ulpgc.eite.alu.diceroller.android.common.I_TiraDados;
import es.ulpgc.eite.alu.diceroller.android.common.TiraDados;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 16/6/16.
 */
public class TiraDadosTest {
    private I_TiraDados _dado;

    @Before
    public void setUp() throws Exception {
        _dado = new TiraDados();
    }

    @Test
    public void roll() throws Exception {
        for (int carasDado = 1; carasDado < 1000; carasDado++)
            for (int contador = 1; contador < 1000; contador++) {
                _dado.roll(carasDado);
                int tirada = _dado.getResultadoTirada();
                assertTrue(tirada <= carasDado && tirada > 0);
            }
    }

    @Test
    public void complexRollPositivo() throws Exception {
        _dado.complexRoll(3, 20, 5);
        int tirada =  _dado.getResultadoTirada();
        assertTrue(tirada <= 65 && tirada >= 8);
    }

    @Test
    public void complexRollNegativo() throws Exception {
        _dado.complexRoll(2, 24, -4);
        int tirada = _dado.getResultadoTirada();
        assertTrue(tirada <= 44 && tirada >= 0);
    }

}