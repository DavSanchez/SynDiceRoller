package es.ulpgc.eite.alu.diceroller.android.common;

public class NumerosAStringBridge implements I_NumerosAStringBridge {

    private String _resultadoTiradaString;

    @Override
    public void numberToString(Integer numero){
        String numeroString = numero.toString();
        setResultadoTiradaString(numeroString);
    }

    @Override
    public String getResultadoTiradaString() {
        return _resultadoTiradaString;
    }

    private void setResultadoTiradaString(String resultadoTiradaString) {
        _resultadoTiradaString = resultadoTiradaString;
    }
}
