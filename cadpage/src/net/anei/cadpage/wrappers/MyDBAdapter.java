package net.anei.cadpage.wrappers;

import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class MyDBAdapter {
private static final String DATABASE_NAME = "cadpage.db";
private static final String DATABASE_TABLE = "mainTable";
private static final String DATABASE_RAW_TABLE = "rawTable";
private static final int DATABASE_VERSION = 1;

// The index (key) column name for use in where clauses.
public static final String KEY_ID="_id";
public static final String KEY_R_ID="_id";

// The name and column index of each column in your database. 
public static final String KEY_Date="date";
public static final String KEY_Time="time";
public static final String KEY_Call="call";
public static final String KEY_Address="address";
public static final String KEY_Apt="apt";
public static final String KEY_Cross="cross";
public static final String KEY_Box="box";
public static final String KEY_ADC="adc";
public static final String KEY_UNITS="units";
public static final String KEY_NOTES="notes";
public static final String KEY_Archive="archive";
public static final String KEY_RAW="raw";


// SQL Statement to create a new database.
private static final String DATABASE_CREATE = "create table " + 
 DATABASE_TABLE + " (" + KEY_ID + 
 " integer primary key autoincrement, " +
 KEY_Date + " text default CURRENT_DATE" +
 KEY_Time + " text default CURRENT_TIME" +
 KEY_Call + " text null" +
 KEY_Address + " text null" +
 KEY_Apt + " text null" +
 KEY_Cross + " text null" +
 KEY_Box + " text null" +
 KEY_ADC + " text null" +
 KEY_UNITS + " text null" +
 KEY_NOTES + " text null" +
 KEY_Archive + "integer default 0" +
 		");" ;

private static final String DATABASE_RAW_CREATE = "create table " + 
DATABASE_RAW_TABLE + " (" + KEY_R_ID + " integer primary key autoincrement, " +
KEY_Date + " text default CURRENT_DATE, " +
KEY_Time + " text default CURRENT_TIME, " +
KEY_RAW + 	" text );" ;

// Variable to hold the database instance
private SQLiteDatabase db;
// Context of the application using the database.
private final Context context;
// Database open/upgrade helper
private myDbHelper dbHelper;

public long insertCall(String strCall) {
	
	
	
	return 0;
}

public long insertRaw(String strMessage) {
	ContentValues newValues = new ContentValues();
	newValues.put(KEY_RAW, strMessage);
	return db.insert(DATABASE_RAW_TABLE, null, newValues);
	
}

public Cursor getRawEntries(String MaxRows) {
	
	return db.query(DATABASE_RAW_TABLE, new String[] {KEY_R_ID, KEY_RAW}, null, null, null, null, KEY_R_ID,MaxRows);
	
}
public MyDBAdapter(Context _context) {
 context = _context;
 dbHelper = new myDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
}

public MyDBAdapter open() throws SQLException {
 db = dbHelper.getWritableDatabase();
 return this;
}

public void close() {
   db.close();
}


private static class myDbHelper extends SQLiteOpenHelper {

 public myDbHelper(Context context, String name, 
                   CursorFactory factory, int version) {
   super(context, name, factory, version);
 }

 // Called when no database exists in disk and the helper class needs
 // to create a new one. 
 @Override
 public void onCreate(SQLiteDatabase _db) {
  // _db.execSQL(DATABASE_CREATE);
   _db.execSQL(DATABASE_RAW_CREATE);
 }

 // Called when there is a database version mismatch meaning that the version
 // of the database on disk needs to be upgraded to the current version.
 @Override
 public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
   // Log the version upgrade.
   Log.w("TaskDBAdapter", "Upgrading from version " + 
                          _oldVersion + " to " +
                          _newVersion + ", which will destroy all old data");
     
   // Upgrade the existing database to conform to the new version. Multiple 
   // previous versions can be handled by comparing _oldVersion and _newVersion
   // values.

   // The simplest case is to drop the old table and create a new one.
   _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
   _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_RAW_TABLE);
   // Create a new one.
   onCreate(_db);
 }
}
}

