package net.anei.cadpage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class ContentQuery {
  
  private static String[] MMS_COL_LIST = new String[]{"_ID", "sub"};
  private static String[] PART_COL_LIST = new String[]{"text", "_data"};
  
  public static void query(Context context) {
    
    ContentResolver res = context.getContentResolver();
    String msg_id = "0BCAE1D8A60800007D40000101";
    
    Uri uri  = Uri.parse("content://mms");
    Cursor cur = res.query(uri, MMS_COL_LIST, "tr_id=?", new String[]{msg_id}, null);
    if (cur == null) return;
    if (!cur.moveToFirst()) return;
    int id = cur.getInt(0);
    String sub = cur.getString(1);
    Log.w("_ID=" + id + "   sub=" + sub);
    
    uri = Uri.parse("content://mms/"+id+"/part");
    cur = res.query(uri, PART_COL_LIST, null, null, null);
    dumpCursor("MMS part", cur);
    
    if (cur == null || !cur.moveToFirst()) return;
    String text = cur.getString(0);
    if (text == null) {
      byte[] ba = cur.getBlob(1);
      if (ba == null) return;
      text = new String(ba);
    }
    Log.w("Contents=" + text);
//    
//    InputStream is = null;
//    ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
//    try { 
//      is = res.openInputStream(uri); 
//  
//      byte[] buffer = new byte[256]; 
//      int len = is.read(buffer); 
//      while (len >= 0) { 
//      baos.write(buffer, 0, len); 
//      len = is.read(buffer); 
//      } 
//    } catch (IOException ex) {
//      throw new RuntimeException(ex.getMessage(), ex);
//    } finally {
//      if (is != null) try {is.close();} catch (IOException ex) {}
//    }
//    
//    Log.w("Msg contents: " + baos.toString());
  }
  
  
  public static void dumpCursor(String title, Cursor cursor) {
    
    if (cursor == null) {
      Log.w(title + ": No Results returned");
      return;
    }
    
    Log.w(title + ": " + cursor.getCount() + " row returned");
    if (cursor.moveToFirst()) {
      do {
        Log.w("\n");
        for (int ndx = 0; ndx < cursor.getColumnCount(); ndx++) {
          Log.w("    " + cursor.getColumnName(ndx) + " = " + cursor.getString(ndx));
        }
      } while (cursor.moveToNext()); 
    }
    
    
  }

}
