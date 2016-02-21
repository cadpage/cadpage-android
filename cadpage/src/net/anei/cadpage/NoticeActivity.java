package net.anei.cadpage;

import net.anei.cadpage.R;
import 
android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Dummy activity that does nothing more than present a stand alone dialog
 * for non-activity processes that want to display a dialog box
 */
public class NoticeActivity extends Safe40Activity {
  
  private static final String EXTRAS_TYPE = "net.anei.cadpage.NoticeActivity.TYPE";
  private static final String EXTRAS_PARMS = "net.anei.cadpage.NoticeActivity.PARMS";
  
  private static final int VENDOR_NOTICE_DLG = 1;
  private static final int MISSING_READER_DLG = 2;
  private static final int NEED_PERMISSION_DLG = 3;
  
  String[] parms;

  @Override
  protected void onStart() {
    super.onStart();
    Intent intent = getIntent();
    int type = intent.getIntExtra(EXTRAS_TYPE, -1);
    if (type < 0) return;
    
    Bundle extras = intent.getExtras();
    if (extras == null) return;
    parms = intent.getStringArrayExtra(EXTRAS_PARMS);
    
    showDialog(type);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    
    if (isFinishing()) return null;
    
    switch (id) {

      case VENDOR_NOTICE_DLG:
        if (parms == null || parms.length < 1) return null;
        String message = parms[0];
        
        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.vendor_notice_title)
        .setMessage(message)
        .setPositiveButton(android.R.string.ok, new OnClickListener(){
          @Override
          public void onClick(DialogInterface dialog, int which) {
            NoticeActivity.this.finish();
          }})
        .setOnCancelListener(new OnCancelListener(){
          @Override
          public void onCancel(DialogInterface dialog) {
            NoticeActivity.this.finish();
          }})
        .create();

      case MISSING_READER_DLG:
        if (parms == null || parms.length < 2) return null;
        String readerName = parms[0];
        final String packageName = parms[1];
        message = NoticeActivity.this.getString(R.string.missing_map_page_reader_text);
        message = message.replace("%%", "%");
        message = String.format(message, readerName);
        
        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.missing_map_page_reader_title)
        .setMessage(message)
        .setPositiveButton(R.string.yes, new OnClickListener(){
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
              NoticeActivity.this.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
              Log.w("Failed to launch Google Play Store");
              ContentQuery.dumpIntent(intent);
            }
            NoticeActivity.this.finish();
          }})
        .setNegativeButton(R.string.no, new OnClickListener(){
          @Override
          public void onClick(DialogInterface dialog, int which) {
            NoticeActivity.this.finish();
          }})
        .setOnCancelListener(new OnCancelListener(){
          @Override
          public void onCancel(DialogInterface dialog) {
            NoticeActivity.this.finish();
          }})
        .create();
        
      case NEED_PERMISSION_DLG:
        if (parms == null || parms.length < 1) return null;
        message = parms[0];
        return new AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_launcher)
            .setTitle(R.string.need_permission_title)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, new OnClickListener(){
              @Override
              public void onClick(DialogInterface dialog, int which) {
                NoticeActivity.this.finish();
              }})
            .create();

    }
    
    return super.onCreateDialog(id);
  }

  /**
   * Launch call display popup activity
   * @param context context
   * @param message Message to be displayed to user
   */
  public static void showVendorNotice(Context context, String message) {
    showNotice(context, VENDOR_NOTICE_DLG, message);
  }
  
  public static void showMissingReaderNotice(Context context, int readerNameId, String readerPkg) {
    showNotice(context, MISSING_READER_DLG, context.getString(readerNameId), readerPkg);
  }
  
  public static void showNeedPermissionNotice(Context context, String text) {
    showNotice(context, NEED_PERMISSION_DLG, text);
  }

  private static void showNotice(Context context, int type, String ... parms) {
    Intent intent = new Intent(context, NoticeActivity.class);
    if (!(context instanceof Activity) || type == NEED_PERMISSION_DLG) {
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
    intent.putExtra(EXTRAS_TYPE, type);
    intent.putExtra(EXTRAS_PARMS, parms);
    context.startActivity(intent);
  }

}
