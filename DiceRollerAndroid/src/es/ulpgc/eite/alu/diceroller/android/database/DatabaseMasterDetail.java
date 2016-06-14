package es.ulpgc.eite.alu.diceroller.android.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import es.ulpgc.eite.framework.android.AndroidScreenDatabase;
import es.ulpgc.eite.framework.android.I_AndroidMediatorSingleton;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;

import java.util.List;


public class DatabaseMasterDetail 
        extends AndroidScreenDatabase implements I_MasterDetailDatabase {


    private final static int DB_VERSION = 10;
    public static final int DB_NAME = R.string.app_name;

    private DatabaseMasterDetailUtils dbUtils;
	private SQLiteDatabase database;
	private DetailDao detailDao;



    @Override
    public void configDatabase() {

        String dbname=getPlatformMediator().getNormalizedResource(DB_NAME);

        dbUtils = new DatabaseMasterDetailUtils(
                getPlatformMediator().getContext(), dbname, null, DB_VERSION);
        setDatabase(dbUtils.getWritableDatabase());

        detailDao = new DetailDao(new DetailTable(), database);
    }


    private I_AndroidMediatorSingleton getPlatformMediator() {
        return (I_AndroidMediatorSingleton) getMediator();
    }

	private void openDatabase(){
		if(! getDatabase().isOpen()){

            setDatabase(dbUtils.getWritableDatabase());
		}
	}
	
	private void closeDatabase() {
		if (getDatabase().isOpen()) {
			getDatabase().close();
	    }
	}

	private void resetDatabase() {
		closeDatabase();
	    SystemClock.sleep(500);
	    openDatabase();
	}



    private SQLiteDatabase getDatabase() {
   		return database;
   	}

   	private void setDatabase(SQLiteDatabase db) {
   		database = db;
   	}



   	private DetailDao getDataDao() {
   		return detailDao;
   	}

   	private void setDataDao(DetailDao dao) {
   		detailDao = dao;
   	}



    @Override
	public DetailData getData(Long dataId){
		return getDataDao().get(dataId);
	}



    @Override
    public DetailData getDataBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val +"'";

        return getDataDao().getByClause(clause, null);
   	}


    @Override
    public List<DetailData> getDataListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getDataDao().getAllbyClause(clause,
                null, null, null, "id");
   	}

    @Override
	public List<DetailData> getDataList(){

        return getDataDao().getAllbyClause(null, null, null, null, "id");
	}	


    
    @Override
    public boolean deleteDataList(){
        int size = getDataList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getDataDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}

    @Override
	public boolean deleteData(Long dataId){
		getDatabase().beginTransaction();
        boolean result = getDataDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}


    @Override
	public Long saveData(DetailData data){

        debug("saveData");

		long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getDataDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveData", "error", ex.toString());
		}
		getDatabase().endTransaction();


		return result;
	}


    @Override
    public boolean updateData(DetailData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getDataDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {

        }
        getDatabase().endTransaction();
        return result;
    }



}
