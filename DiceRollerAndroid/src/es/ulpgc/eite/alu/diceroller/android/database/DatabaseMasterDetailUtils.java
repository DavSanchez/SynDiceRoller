package es.ulpgc.eite.alu.diceroller.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseMasterDetailUtils extends SQLiteOpenHelper {


    public DatabaseMasterDetailUtils(
            Context ctx, String name, CursorFactory factory, int ver) {

        super(ctx, name, factory, ver);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            DetailTable detailTable = new DetailTable();
            detailTable.onCreate(db);

            MasterTable masterTable = new MasterTable();
            masterTable.onCreate(db);

        } catch (Exception e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        try {

            DetailTable detailTable = new DetailTable();
            detailTable.onUpgrade(db, oldVer, newVer);

            MasterTable masterTable = new MasterTable();
            masterTable.onUpgrade(db, oldVer, newVer);

        } catch (Exception e) {
        }

    }

}
