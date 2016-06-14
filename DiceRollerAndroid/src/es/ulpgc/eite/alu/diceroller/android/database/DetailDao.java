package es.ulpgc.eite.alu.diceroller.android.database;

import android.database.sqlite.SQLiteDatabase;

import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;


public class DetailDao extends DroidDao<DetailData, Long> {

	public DetailDao(TableDefinition<DetailData> td, SQLiteDatabase db) {

		super(DetailData.class, td, db);
	}

}
