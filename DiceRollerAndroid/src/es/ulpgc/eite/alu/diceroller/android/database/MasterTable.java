package es.ulpgc.eite.alu.diceroller.android.database;

import es.ulpgc.eite.masterdetail.android.master.data.MasterData;
import org.droidpersistence.dao.TableDefinition;


public class MasterTable extends TableDefinition<MasterData> {

	public MasterTable() {
		super(MasterData.class);
	}

}
