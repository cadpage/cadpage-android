package net.anei.cadpage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/*
 * This class provides an easy way to clear held WakeLocks and re-enable the
 * Keyguard (either immediately or scheduled in the future).
 */

public class ClearAllReceiver extends BroadcastReceiver {
  
  public enum ClearType { SCREEN,  NOTIFY };

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("ClearAllReceiver: onReceive()");
    String action = intent.getAction();
    if (action == null) return;
    int pt = action.lastIndexOf('.');
    if (pt < 0) return;
    action = action.substring(pt+1);
    try {
      ClearType type = ClearType.valueOf(action);
      doCancel(context, type);
    } catch (IllegalArgumentException ex) {}
  }

  /*
   * Release WakeLocks and re-enable Keyguard (if reenableKeyguard is true). The
   * only time we don't want to re-enable the Keyguard is if the user is trying
   * to exit the Keyguard securely (exitKeyguardSecurely()) to perform an action
   * like "Reply" or "Inbox".
   */
  public static synchronized void clearAll(Context context) {
    if (Log.DEBUG) Log.v("ClearAllReceiver: clearAll()");
    for (ClearType type : ClearType.values()) {
      removeCancel(context, type);
      doCancel(context, type);
    }
  }

  /*
   * Schedules a Broadcast to this receiver for some time in the future to 
   * cancel something
   */
  public static synchronized void setCancel(Context context, int timeout, ClearType type) {
    if (Log.DEBUG) Log.v("ClearAllReceiver: setCancel() " + type + " for " + timeout + " seconds");
    AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    myAM.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (timeout * 1000),
        getPendingIntent(context, type));
  }

  /*
   * Cancels the scheduled Broadcast to this receiver (the user took some action
   * so the Activity can now react to whatever they are doing).
   */
  private static synchronized void removeCancel(Context context, ClearType type) {
    if (Log.DEBUG) Log.v("ClearAllReceiver: removeCancel() - " + type);
    AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    myAM.cancel(getPendingIntent(context, type));
  }
  
  private static void doCancel(Context context, ClearType type) {
    if (Log.DEBUG)Log.v("ClearAllReceiver: doClear() - " + type);
    
    switch (type) {
    case SCREEN:
      ManageWakeLock.releaseFull();
      break;
    
    case NOTIFY:
      ManageNotification.clear(context);
      break;
    }
  }

  /*
   * Gets the PendingIntent for a Broadcast to this class
   */
  private static PendingIntent getPendingIntent(Context context, ClearType type) {
    Intent intent = new Intent(context, ClearAllReceiver.class);
    intent.setAction("net.anei.cadpage.ClearAllReceiver." + type);
    return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
  }
}
