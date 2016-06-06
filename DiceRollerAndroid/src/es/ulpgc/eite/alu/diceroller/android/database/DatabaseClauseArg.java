package es.ulpgc.eite.alu.diceroller.android.database;

public class DatabaseClauseArg {

    public String key;
    public String val;
    public String cond;

    public DatabaseClauseArg(String k, String c, String v) {
        key = k;
        val = v;
        cond = c;
    }

}