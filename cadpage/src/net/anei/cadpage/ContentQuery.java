package net.anei.cadpage;

import java.util.List;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class ContentQuery {
  
  private static String[] MMS_COL_LIST = new String[]{"_ID", "sub"};
  private static String[] PART_COL_LIST = new String[]{"text", "_data"};
  
  public static void query(Context context) {
    retrieveMsg(context);
  }
  
  public static void dumpEverything(Context context) {
    
    ContentResolver res = context.getContentResolver();
    Uri uri  = Uri.parse("content://mms");
    Cursor cur = res.query(uri, null, null, null, null);
    dumpCursor("Full MMS", cur);
  }
  
  public static void retrieveMsg(Context context) {
    
    ContentResolver res = context.getContentResolver();
    int id = -1;
    String msg_id = "0ECCC4DDA63A0000D940000101";
    
    if (id < 0) {
      Uri uri  = Uri.parse("content://mms");
      Cursor cur = res.query(uri, MMS_COL_LIST, "tr_id=?", new String[]{msg_id}, null);
      if (cur == null) return;
      Log.w("rec count:" + cur.getCount());
      if (!cur.moveToFirst()) return;
      id = cur.getInt(0);
      String sub = cur.getString(1);
      Log.w("_ID=" + id + "   sub=" + sub);
    }
    
    Uri uri = Uri.parse("content://mms/"+id+"/part");
    Cursor cur = res.query(uri, PART_COL_LIST, null, null, null);
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
  
  public static void dumpRecentTasks(Context context) {
    ActivityManager mgr = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
    List<ActivityManager.RecentTaskInfo> taskList = mgr.getRecentTasks(100,ActivityManager.RECENT_WITH_EXCLUDED);
    Log.w("Recent task information");
    for (ActivityManager.RecentTaskInfo task : taskList) {
      Intent intent = task.baseIntent;
      dumpIntent(intent);
      Log.w("");
    }
  }

  public static void dumpIntent(Intent intent) {
    Log.w("Action:" + intent.getAction());
    Log.w("Categories:");
    if (intent.getCategories() != null) {
      for (String str : intent.getCategories()) Log.v("  " + str);
    }
    Log.w("Type:" + intent.getType());
    Log.w("Comp:" + intent.getComponent().getClassName());
    Bundle extra = intent.getExtras();
    if (extra != null) {
      for (String key : extra.keySet()) {
        Log.w("  " + key + ":" + extra.get(key));
      }
    }
  }

}
