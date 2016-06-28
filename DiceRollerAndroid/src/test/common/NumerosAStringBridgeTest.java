package test.common;

import es.ulpgc.eite.alu.diceroller.android.common.I_NumerosAStringBridge;
import es.ulpgc.eite.alu.diceroller.android.common.NumerosAStringBridge;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumerosAStringBridgeTest {

    private I_NumerosAStringBridge _bridge;

    @Before
    public void setUp() throws Exception {
        _bridge = new NumerosAStringBridge();
    }

    @Test
    public void numberToStringPositivo() throws Exception {
        _bridge.numberToString(1234);
        String salida = _bridge.getResultadoTiradaString();
        assertEquals("1234", salida);
    }

    @Test
    public void numberToStringNegativo() throws Exception {
        _bridge.numberToString(-5678);
        String salida = _bridge.getResultadoTiradaString();
        assertEquals("-5678", salida);
    }

}