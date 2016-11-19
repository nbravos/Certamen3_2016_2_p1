package cl.telematica.android.certamen3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cl.telematica.android.certamen3.Model.feed_contract;

/**
 *
 *

*/
public class SQLiteOp extends SQLiteOpenHelper {

    public SQLiteOp(Context context){
        super(context, "News", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + feed_contract.FeedEntry.TABLE_NAME + " ("
                + feed_contract.FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + feed_contract.FeedEntry.TITLE + " TEXT NOT NULL,"
                + feed_contract.FeedEntry.LINK + " TEXT NOT NULL,"
                + feed_contract.FeedEntry.AUTHOR + " TEXT NOT NULL,"
                + feed_contract.FeedEntry.PUBLISHEDDATE + " INTEGER,"
                + feed_contract.FeedEntry.CONTENT + " TEXT NOT NULL,"
                + feed_contract.FeedEntry.IMAGE + " TEXT,"
                + feed_contract.FeedEntry.ISFAVORITE + " TEXT,"
                + "UNIQUE (" + feed_contract.FeedEntry._ID + "))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist Feed");

    }


}


