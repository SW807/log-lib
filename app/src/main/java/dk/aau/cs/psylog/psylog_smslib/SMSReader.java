package dk.aau.cs.psylog.psylog_smslib;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Mathias on 25-02-2015.
 */
public class SMSReader {

    private Uri sentURI = Uri.parse("content://sms/sent");
    private Uri draftURI = Uri.parse("content://sms/draft");
    private Uri inboxURI = Uri.parse("content://sms/inbox");
    private Context context;

    public SMSReader(Context context){
        this.context = context;
    }

    public Cursor readInbox(){
        return readURI(inboxURI);
    }

    public Cursor readDraft(){
        return readURI(draftURI);
    }

    public Cursor readSent(){
        return readURI(sentURI);
    }

    private Cursor readURI(Uri uri){
        String[] requiredColumns = new String[] {"_id","thread_id","address","person","date","protocol","read","status","type","reply_path_present","subject","body","service_center","locked"};
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(uri, requiredColumns,null,null,null);
        cursor.moveToFirst();
        return cursor;
    }
}
