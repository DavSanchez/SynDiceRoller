package es.ulpgc.eite.alu.diceroller.android.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import es.ulpgc.eite.framework.android.AndroidScreenDatabase;
import es.ulpgc.eite.framework.android.I_AndroidMediatorSingleton;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.detail.data.DetailData;
import es.ulpgc.eite.alu.diceroller.android.master.data.MasterData;

import java.util.List;


public class DatabaseMasterDetail extends AndroidScreenDatabase
        implements  I_MasterDatabase,  I_DetailDatabase {


    private final static int DB_VERSION = 11;
    public static final int DB_NAME = R.string.app_name;

    private DatabaseMasterDetailUtils dbUtils;
	private SQLiteDatabase database;
	private DetailDao detailDao;
    private MasterDao masterDao;


    @Override
    public void configDatabase() {

        String dbname=getPlatformMediator().getNormalizedResource(DB_NAME);

        dbUtils = new DatabaseMasterDetailUtils(
                getPlatformMediator().getContext(), dbname, null, DB_VERSION);
        setDatabase(dbUtils.getWritableDatabase());

        detailDao = new DetailDao(new DetailTable(), database);
        masterDao = new MasterDao(new MasterTable(), database);
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

    private MasterDao getMasterDao() {
   		return masterDao;
   	}

   	private void setMasterDao(MasterDao dao) {
   		masterDao = dao;
   	}

   	private DetailDao getDetailDao() {
   		return detailDao;
   	}

   	private void setDetailDao(DetailDao dao) {
   		detailDao = dao;
   	}

    @Override
	public MasterData getMasterData(Long dataId){
		return getMasterDao().get(dataId);
	}

    @Override
	public DetailData getDetailData(Long dataId){
		return getDetailDao().get(dataId);
	}

    @Override
    public MasterData getMasterDataBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val +"'";

        return getMasterDao().getByClause(clause, null);
   	}

    @Override
    public DetailData getDetailDataBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val +"'";

        return getDetailDao().getByClause(clause, null);
   	}


    @Override
    public List<MasterData> getMasterDataListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getMasterDao().getAllbyClause(clause, null, null, null, "id");
   	}

    @Override
    public List<DetailData> getDetailDataListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getDetailDao().getAllbyClause(clause, null, null, null, "id");
   	}

    @Override
	public List<MasterData> getMasterDataList(){

        return getMasterDao().getAllbyClause(null, null, null, null, "id");
	}

    @Override
	public List<DetailData> getDetailDataList(){

        return getDetailDao().getAllbyClause(null, null, null, null, "id");
	}

    @Override
    public boolean deleteMasterDataList(){
        int size = getMasterDataList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getMasterDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}

    @Override
    public boolean deleteDetailDataList(){
        int size = getDetailDataList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getDetailDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}

    @Override
	public boolean deleteMasterData(Long dataId){
		getDatabase().beginTransaction();
        boolean result = getMasterDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}

    @Override
	public boolean deleteDetailData(Long dataId){
		getDatabase().beginTransaction();
        boolean result = getDetailDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}


    @Override
	public Long saveMasterData(MasterData data){

		long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getMasterDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveMasterData", "error", ex.toString());
		}
		getDatabase().endTransaction();


		return result;
	}

    @Override
	public Long saveDetailData(DetailData data){

		long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getDetailDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveDetailData", "error", ex.toString());
		}
		getDatabase().endTransaction();


		return result;
	}


    @Override
    public boolean updateMasterData(MasterData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getMasterDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {

        }
        getDatabase().endTransaction();
        return result;
    }


    @Override
    public boolean updateDetailData(DetailData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getDetailDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {

        }
        getDatabase().endTransaction();
        return result;
    }



}
