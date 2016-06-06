package es.ulpgc.eite.alu.diceroller.android.database;

import android.database.sqlite.SQLiteDatabase;
import es.ulpgc.eite.masterdetail.android.master.data.MasterData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;


public class MasterDao extends DroidDao<MasterData, Long> {

	public MasterDao(TableDefinition<MasterData> td, SQLiteDatabase db) {

		super(MasterData.class, td, db);
	}

}
