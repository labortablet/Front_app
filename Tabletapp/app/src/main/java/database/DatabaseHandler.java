package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Grit on 19.06.2014.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables


    private static String Path = new String();

    // Database Name
    private static final String DB_NAME = "Lablet.db";
    // table names
    private static final String DB_Entry = "_entry";
    private static final String DB_Project = "_project";
    private static final String DB_User = "_user";
    private static final String DB_TableWizard = "_tableWizard";
    private static final String DB_Rows = "_rows";

    // Database Version
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    Cursor cursor;

    // Create SQL Tables


    private static final String Create_Table_Entry =
            "CREATE TABLE IF NOT EXISTS `_entry` (" +
                    "  `Entry_ID` int(11) NOT NULL AUTO_INCREMENT," +
                    "  `Entry_Typ` int(11) NOT NULL," +
                    "  `Entry_Titel` varchar(100) NOT NULL," +
                    "  `Entry_Content` MEDIUMBLOB NOT NULL," +
                    "  `Entry_Date` TIMESTAMP NOT NULL," +
                    "  `Entry_Sync` tinyint(1) NOT NULL," +
                    "  `Entry_ProjectID` int(11) NOT NULL," +
                    "  `Entry_UserID` int(11) NOT NULL," +
                    "   PRIMARY KEY (`Entry_ID`)," +
                    "   FOREIGN KEY (Entry_UserID) " +
                    "   REFERENCES _user(User_ID)," +
                    "   FOREIGN KEY (Entry_ProjectID) " +
                    "   REFERENCES _project(Project_ID)" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";

    private static final String Create_Table_Project =
            "CREATE TABLE IF NOT EXISTS `_project` (" +
                    "  `Project_ID` int(11) NOT NULL AUTO_INCREMENT," +
                    "  `Project_Name` varchar(100) NOT NULL," +
                    "  `Project_Description` text NOT NULL," +
                    "  `Project_Sync` tinyint(1) NOT NULL," +
                    "  `Project_UserID` int(11) NOT NULL," +
                    "   PRIMARY KEY (`Project_ID`)," +
                    "   FOREIGN KEY (Project_UserID) " +
                    "   REFERENCES _user(User_ID)" +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";

    private static final String Create_Table_User =
            "CREATE TABLE IF NOT EXISTS "+DB_User+" (" +
                    "   `User_ID` int(11) NOT NULL AUTO_INCREMENT," +
                    "   `User_EMail` varchar(100) NOT NULL," +
                    "   `User_Password` varchar(100) NOT NULL," +
                    "    PRIMARY KEY (`User_ID`)" +
                    "  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";

    private static final String Create_Table_TableWizard =
            "CREATE TABLE IF NOT EXISTS `_table` (" +
                    "  `Table_ID` int(11) NOT NULL AUTO_INCREMENT," +
                    "  `Table_Name` varchar(100) NOT NULL," +
                    "  `Table_Sync` tinyint(1) NOT NULL," +
                    "  `Table_UserID` int(11) NOT NULL," +
                    "   PRIMARY KEY (`Table_ID`)," +
                    "   FOREIGN KEY (Table_UserID) " +
                    "   REFERENCES _user(User_ID)  " +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";

    private static final String Create_Table_Rows =
            "CREATE TABLE IF NOT EXISTS `_rows` (" +
                    "  `Row_ID` int(11) NOT NULL AUTO_INCREMENT," +
                    "  `Row_Content` MEDIUMBLOB NOT NULL," +
                    "  `Row_Sync` int(11) NOT NULL," +
                    "  `Row_UserID` int(11) NOT NULL," +
                    "  `Row_TableID` int(11) NOT NULL," +
                    "   PRIMARY KEY (`Row_ID`)," +
                    "   FOREIGN KEY (Row_UserID) " +
                    "   REFERENCES _user(User_ID),  " +
                    "   FOREIGN KEY (Row_TableID)" +
                    "   REFERENCES _table(Table_ID)  " +
                    " ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";

    public DatabaseHandler(Context ctx) {
        super(ctx, DB_NAME, null, DATABASE_VERSION);
    //    Path = Environment.getDataDirectory().getAbsolutePath() + "/" + "data/" + ctx.getResources().getString(R.string.app_name);
       // this.myContext = ctx;


    }
    // super(ctx, Includes.get_Db_Name(), null, Includes.get_Database_Version());
    //   Path = Environment.getDataDirectory().getAbsolutePath() + "/" + "data/" + ctx.getResources().getString(R.string.app_name);


    public void close() {
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



              sqLiteDatabase.execSQL(Create_Table_User);
           // db = openOrCreateDatabase(DB_NAME, null);
           // db.execSQL(Create_Table_User);
              sqLiteDatabase.execSQL(Create_Table_Project);
              sqLiteDatabase.execSQL(Create_Table_Entry);
              sqLiteDatabase.execSQL(Create_Table_TableWizard);
              sqLiteDatabase.execSQL(Create_Table_Rows);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }


    public String get_UserID(String email) {
        String test = "test";
        try {
            db = getWritableDatabase();
            String User_ID_query = "SELECT User_ID FROM _user WHERE User_E_Mail LIKE " + email + ";";
            db.execSQL("INSERT INTO `_user`(`User_EMail`, `User_Password`) VALUES (" + test + "," + test + ") ;");
            //cursor = db.query(DB_User,new String[]{"User_ID"},"User_EMAIL LIKE " + email,null,null,null,null);
            //    cursor.moveToFirst();
            //       return cursor.getString(0);
            return null;
        } catch (NullPointerException e)

        {
            return "Exception";
        }

    }


    private void delete_DB(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
    }
}

/*
    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db = SQLiteDatabase.openDatabase(Path, null,0);
            Log.d("opendb", "EXIST");
            db.close();
        }
        catch(SQLiteException e){
            Log.d("opendb","NOT EXIST");

            db = openOrCreateDatabase(Path, null, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS LIST(wlist varchar);");

            db.execSQL("INSERT INTO LIST VALUES('খবর');");
            db.execSQL("INSERT INTO LIST VALUES('কবর');"); //whatever you want
            db.close();
        }
    }*/
/*
private boolean db_exist(){
    SQLiteDatabase checkDB = null;
    try {
        checkDB = SQLiteDatabase.openDatabase(Path, null, // true if exists false if not
                SQLiteDatabase.OPEN_READONLY);
        checkDB.close();
    } catch (SQLiteException e) {
        // database doesn't exist yet.
    }
    return checkDB != null ? true : false;
}*/

/*
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {

    }
}

*/