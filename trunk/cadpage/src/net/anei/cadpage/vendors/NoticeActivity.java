package net.anei.cadpage.vendors;

import net.anei.cadpage.R;
import net.anei.cadpage.Safe40Activity;
import 
android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

/**
 * Dummy activity that does nothing more than present a stand alone dialog
 */
public class NoticeActivity extends Safe40Activity {
  
  private static final String EXTRAS_MSG = "net.anei.cadpage.NoticeActivity.MESSAGE";
  
  private static final int NOTICE_DLG = 1;
  
  private String message;

  @Override
  protected void onStart() {
    super.onStart();
    Intent intent = getIntent();
    message = intent.getStringExtra(EXTRAS_MSG);
    if (message == null) {
      finish();
      return;
    }
    
    showDialog(NOTICE_DLG);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    
    if (isFinishing()) return null;
    switch (id) {

      case NOTICE_DLG:
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
    }
    return super.onCreateDialog(id);
  }

  /**
   * Launch call display popup activity
   * @param context context
   * @param message Message to be displayed to user
   */
  public static void showNotice(Context context, String message) {
    Intent intent = new Intent(context, NoticeActivity.class);
    if (!(context instanceof Activity)) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra(EXTRAS_MSG, message);
    context.startActivity(intent);
  }

}
