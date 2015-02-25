package dk.aau.cs.psylog.psylog_smslib;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by Praetorian on 25-02-2015.
 */
public class PhoneLogReader {


    public static Cursor readAllCalls(Context context)
    {
        Uri allCalls = Uri.parse("content://call_log/calls");
        ContentResolver contentResolver = context.getContentResolver();

        //This is stupid
        String[] requiredColumns = new String[]{
                CallLog.Calls.COUNTRY_ISO,
                CallLog.Calls.DATE,
                CallLog.Calls.DURATION,
                CallLog.Calls.GEOCODED_LOCATION,
                CallLog.Calls.IS_READ,
                CallLog.Calls.NEW,
                CallLog.Calls.NUMBER,
                CallLog.Calls.NUMBER_PRESENTATION,
                CallLog.Calls.TYPE,
                CallLog.Calls.VOICEMAIL_URI};
        Cursor cursor = contentResolver.query(allCalls, requiredColumns, null, null, null);
        cursor.moveToFirst();
        return cursor;
        //int type = Integer.parseInt(c.getString(c.getColumnIndex(CallLog.Calls.TYPE)));// for call type, Incoming or out going
    }
}
