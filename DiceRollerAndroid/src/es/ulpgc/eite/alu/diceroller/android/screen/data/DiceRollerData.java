package es.ulpgc.eite.alu.diceroller.android.screen.data;

/**
 * Created by David on 27/5/16.
 */
public class DiceRollerData {
    private String _txtMsg;

    public DiceRollerData(String txtMsg) {
        setTxtMsg(txtMsg);
    }

    public DiceRollerData() {
        setTxtMsg("");
    }

    private String _txtBtn;

    public String getTxtMsg() {
        return _txtMsg;
    }

    public void setTxtMsg(String txtMsg) {
        _txtMsg = txtMsg;
    }
}
