package ethered.mcc_project;

/**
 * Created by Mitul Champaneri on 4/6/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suraj on 20-06-2017.
 * This ${class} is used for
 */

public class MyDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "testDatabase.db";
    private final String TABLE_NAME = "testRecords";
    private final String KEY_ID = "id";
    private final String KEY_NAME = "subname";
    private final String KEY_ATTENDED = "attended";
    private final String KEY_BUNKED = "bunked";
    private final String KEY_REQ = "attreq";

    Context context;

    String createTable =
            "create table " + TABLE_NAME + "(" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME +
                    " TEXT," + KEY_ATTENDED + " INTEGER, "+ KEY_BUNKED + " INTEGER, "+ KEY_REQ + " INTEGER)";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        Log.e("45 -->", "" + createTable);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //on upgrade table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public long insertData(String name, String attreq, String attended, String bunked) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, name);
        //here
        contentValues.put(KEY_ATTENDED, attended);
        contentValues.put(KEY_ATTENDED, bunked);
        contentValues.put(KEY_ATTENDED, attreq);
        long ii = database.insert(TABLE_NAME, null, contentValues);

        database.close();

        return ii;  //returns no of row added.
    }

    public void deleteData(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, " id = ? ", new String[]{String.valueOf(id)});
        database.close();
    }


    public void updateTable(int id, String name, String attreq, String attended, String bunked) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, name);
        //here
        contentValues.put(KEY_ATTENDED, attended);
        contentValues.put(KEY_ATTENDED, bunked);
        contentValues.put(KEY_ATTENDED, attreq);
        database.update(TABLE_NAME, contentValues, " id =?",
                new String[]{String.valueOf(id)});

        database.close();


    }

    public List<MyData> getAllDataFromTable() {
        SQLiteDatabase database = this.getReadableDatabase();
        List<MyData> myDatas = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME,
                new String[]{KEY_ID, KEY_NAME, KEY_REQ,KEY_ATTENDED,KEY_BUNKED}
                , null, null, null, null, null, null);

        cursor.moveToFirst();


        // here our logic was gone wrong so that we are getting OutOfMemory Exception
        // as we are in infinite loop

        while (!cursor.isAfterLast()) {
            MyData myData = new MyData();
            myData.setId(cursor.getInt(0));
            myData.setName(cursor.getString(1));
            myData.setattreq(cursor.getString(5));
            myData.setattended(cursor.getString(2));
            myData.setbunked(cursor.getString(3));


            Log.e("114 ", "" + myData.getId() + ", " + myData.getName() + ", " + myData.getattended()+ ", " + myData.getbunked()+ ", " + myData.getattreq());
            myDatas.add(myData);
            cursor.moveToNext();
        }
        cursor.close();
        return myDatas;
    }
}
