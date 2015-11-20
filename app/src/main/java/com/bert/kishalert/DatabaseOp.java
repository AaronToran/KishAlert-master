package com.bert.kishalert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Aaron on 11/4/2015.
 * This does all the database related operations
 * requried for the app
 */
 

public class DatabaseOp extends SQLiteOpenHelper {
//// TODO: 11/11/2015 need to create a DatabaseOp constucter method that will get the context and set the private database var and then create a getter method for the database
    public static final int database_version = 1;
    private Context context;
    //  Building the database cols
    public static final String CLASS = "class";
    public static final String DUE_DATE = "due_date";
    public static final String REMIND = "remind";
    public static final String HW_NAME = "hw_name";

    //  Naming the database and table
    public static final String DATABASE_NAME = "kish_alert_database2";
    public static final String TABLE_NAME = "user_info";
    // Query's
    //  Query that is used to create the main table for the database
    public String CREATE_QUERY="CREATE TABLE "+TABLE_NAME+"("+CLASS+" TEXT, "+DUE_DATE+" DATE, "+REMIND+" VARCHAR, "+HW_NAME+" TEXT);";


    //  opening or creating the database depending on whether its the user's first time running the application
    public DatabaseOp(Context thisContext) {
        super(thisContext, DATABASE_NAME, null, database_version);
        setContext(thisContext);
        Log.v("Databaseops", "Database Created or opened");
    }
    //setters and getters
    protected void setContext(Context c){
        context = c;
    }
    public Context getContext(){
        return context;
    }
    public DatabaseOp getDatabase(){
        DatabaseOp db = new DatabaseOp(getContext());
        return db;
    }
    //
    @Override
    //runs when ever new table is created
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.v("Databaseops", "table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //adding the data into the database
    public void addDbRec(String classname, String hw_name, String due,String remind  ){
        DatabaseOp dop = getDatabase();
        SQLiteDatabase db = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CLASS, classname);
        cv.put(HW_NAME, hw_name);
        cv.put(DUE_DATE, due);
        cv.put(REMIND, remind);
        db.insert(TABLE_NAME, null, cv);
    }
    //prints out the entire database to the log must use the getclass function to get the array
    public void debugQuery(String[][] classes){
        for(String[] arr : classes) System.out.println(Arrays.toString(arr));
    }

    // TODO: 11/9/2015 needs a better way to pull data from the database to create the alerts 
    public String[] alert(Date date){
        DatabaseOp dop = getDatabase();
        SQLiteDatabase db = dop.getWritableDatabase();
        Cursor c =db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE date('"+DUE_DATE+"') = date('"+date+"')",null);
        String[] theClassInfo = new String[4];
        if(c.moveToFirst()){
            do {
                theClassInfo[0] = c.getString(0);
                theClassInfo[1] = c.getString(1);
                theClassInfo[2] = c.getString(2);
                theClassInfo[3] = c.getString(2);
            }while(c.moveToNext());
        }
        return  theClassInfo;
    }
    public void DeleteTable(){
        DatabaseOp dop = getDatabase();
        SQLiteDatabase db = dop.getWritableDatabase();
        db.execSQL("DROP TABLE [ IF EXISTS ] "+TABLE_NAME);
    }
    //Finds all Records that are out of date and deletes them
    public void cleanDatabase(){
        DatabaseOp dop = getDatabase();
        Calendar CURRENT_DATE = Calendar.getInstance();
        //TODO change current date from date to text and pull the date
        String findOldRecordsQuery ="DELETE * FROM "+TABLE_NAME+" WHERE "+DUE_DATE+" > "+CURRENT_DATE+";";
        SQLiteDatabase db = dop.getWritableDatabase();
        db.execSQL(findOldRecordsQuery);
    }
    //gets a count of all the rows in the database
    public int getDbRows(){
        DatabaseOp dop = getDatabase();
        SQLiteDatabase db = dop.getWritableDatabase();
        String[] cols = {CLASS,DUE_DATE,REMIND,HW_NAME};
        Cursor mCursor = db.query(TABLE_NAME, cols, null, null, null, null, null);
        int i = 0;
        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()){
            i++;
        }
        return i;

    }
    //Returns a muti-dimensional array of all the classes in the database can only store 200 pieces
    public String[][] getClasses(){
        DatabaseOp dop = getDatabase();
        SQLiteDatabase db = dop.getWritableDatabase();
        String[][] classes = new String[getDbRows()][4];
        String[] cols = {CLASS,DUE_DATE,REMIND,HW_NAME};
        Cursor mCursor =db.query(TABLE_NAME, cols,null,null,null,null,null);

        int i = 0;
        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()){
            classes[i][0]=mCursor.getString(mCursor.getColumnIndex(CLASS));
            classes[i][1]=mCursor.getString(mCursor.getColumnIndex(DUE_DATE));
            classes[i][2]=mCursor.getString(mCursor.getColumnIndex(REMIND));
            classes[i][3]=mCursor.getString(mCursor.getColumnIndex(HW_NAME));
            i++;
        }
        return classes;
    }
}
