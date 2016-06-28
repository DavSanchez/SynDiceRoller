package test.common;

import es.ulpgc.eite.alu.diceroller.android.common.I_TiraDados;
import es.ulpgc.eite.alu.diceroller.android.common.TiraDados;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
        int numeroDados = 3;
        int numeroCaras = 20;
        int modificador = 5;
        _dado.complexRoll(numeroDados, numeroCaras, modificador);
        int tirada =  _dado.getResultadoTirada();
        assertTrue(tirada <= 65 && tirada >= 8);
    }

    @Test
    public void complexRollNegativo() throws Exception {
        int numeroDados = 2;
        int numeroCaras = 24;
        int modificador = -4;
        _dado.complexRoll(numeroDados, numeroCaras, modificador);
        int tirada = _dado.getResultadoTirada();
        assertTrue(tirada <= 44 && tirada >= 0);
    }
}