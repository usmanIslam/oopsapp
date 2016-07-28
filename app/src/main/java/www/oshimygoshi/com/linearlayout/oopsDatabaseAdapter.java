package www.oshimygoshi.com.linearlayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class oopsDatabaseAdapter
{
    oopsDatabase obg;

    oopsDatabaseAdapter(Context context)
    {
        obg=new oopsDatabase(context);
    }
    public long insertData(String name,String password)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(oopsDatabase.UNANME,name);
        contentValues.put(oopsDatabase.UPASS, password);
        SQLiteDatabase sqLiteDatabase=obg.getWritableDatabase();
        long id=sqLiteDatabase.insert(oopsDatabase.TABLE_NAME,null,contentValues);
        return id;

    }
    public String loginChecker(String Password)
    {
        SQLiteDatabase db=obg.getWritableDatabase();
        String[] columns={oopsDatabase.UPASS};
        Cursor cursor=db.query(oopsDatabase.TABLE_NAME, columns, oopsDatabase.UPASS+" = '"+Password+"'", null, null, null, null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext())
        {
            int index1=cursor.getColumnIndex(oopsDatabase.UPASS);
            String pass=cursor.getString(index1);
            buffer.append(pass+"\n");
        }
           return buffer.toString();
    }

    public String getAllData()
        {
            SQLiteDatabase db=obg.getWritableDatabase();
            String[] columns={oopsDatabase.UID,oopsDatabase.UNANME,oopsDatabase.UPASS};
            Cursor cursor=db.query(oopsDatabase.TABLE_NAME, columns, null, null, null, null, null);
            StringBuffer buffer=new StringBuffer();
            while (cursor.moveToNext())
            {
                int cid=cursor.getInt(0);
                String name=cursor.getString(1);
                String pass=cursor.getString(2);
                buffer.append(cid+" "+name+" "+pass+"\n");
            }
            return buffer.toString();

        }
    static class oopsDatabase extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "oopsdatabase";
        public static final String TABLE_NAME = "LOGIN";
        public static final int DATABASE_VERSION = 11;
        public static final String UID = "_id";
        public static final String UNANME = "Name";
        public static final String UPASS = "pass";

        String create_table = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UNANME + " VARCHAR(255), " + UPASS + " VARCHAR(255));";
        private Context context;
        public static final String drop_table = "DROP TABLE IF EXISTS " + TABLE_NAME;


        oopsDatabase(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(create_table);
                Massage.massage(context, "create called");
            } catch (SQLException e) {
                e.printStackTrace();
                Massage.massage(context, "" + e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(drop_table);
                onCreate(db);
                Massage.massage(context, "upgrade called");
            } catch (SQLException e) {
                e.printStackTrace();
                Massage.massage(context, "" + e);
            }
        }
    }
}
