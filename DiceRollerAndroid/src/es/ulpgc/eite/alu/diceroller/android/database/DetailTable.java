package es.ulpgc.eite.alu.diceroller.android.database;

import org.droidpersistence.dao.TableDefinition;

import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;


public class DetailTable extends TableDefinition<DetailData> {

	public DetailTable() {
		super(DetailData.class);
	}

}
