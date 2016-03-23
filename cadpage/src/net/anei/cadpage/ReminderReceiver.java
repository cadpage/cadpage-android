package net.anei.cadpage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReminderReceiver extends BroadcastReceiver {

  private static final String ACTION_REMIND = "net.anei.cadpage.ACTION_REMIND";
  
  private static String EXTRA_MSG_ID = "net.anei.cadpage.ReminderReceiver.EXTRA_MSG_ID";
  private static String EXTRA_START = "net.anei.cadpage.ReminderReceiver.EXTRA_START";

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("ReminderReceivere: onReceive()");

    String action = intent.getAction();

    if (ACTION_REMIND.equals(action)) {
      if (Log.DEBUG) Log.v("ReminderReceiver: processReminder()");
      processReminder(context, intent);
    } else if (Intent.ACTION_DELETE.equals(action)) {

      if (Log.DEBUG) Log.v("ReminderReceiver: cancelReminder()");
      ManageNotification.clear(context);
    }
  }

  private void processReminder(Context context, Intent intent) {
    
    int msgId = intent.getIntExtra(EXTRA_MSG_ID, 0);
    SmsMmsMessage message = SmsMessageQueue.getInstance().getMessage(msgId);
    if (message == null) return;

    boolean start = intent.getBooleanExtra(EXTRA_START, true);
    ManageNotification.show(context, message, start);
  }
  
  public static void scheduleNotification(Context context, SmsMmsMessage message) {
    long delay = ManagePreferences.notifyDelay();
    if (delay == 0L) {
      ManageNotification.show(context, message, true);
    } else {
      scheduleReminder(context, message, true, delay);
    }
  }

  /*
   * This will schedule a reminder notification to play in the future using the
   * system AlarmManager. The time till the reminder and number of reminders is
   * taken from user preferences.
   */
  public static void scheduleReminder(Context context, SmsMmsMessage message) {
    int reminderInterval = ManagePreferences.notifyRepeatInterval();
    if (reminderInterval == 0) return;
    scheduleReminder(context, message, false, reminderInterval*1000L);
  }
  
  private static void scheduleReminder(Context context, SmsMmsMessage message, boolean start, long interval) {
    
    AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    Intent reminderIntent = new Intent(context, ReminderReceiver.class);
    reminderIntent.setAction(ACTION_REMIND);
    reminderIntent.putExtra(EXTRA_MSG_ID, message.getMsgId());
    reminderIntent.putExtra(EXTRA_START, start);

    PendingIntent reminderPendingIntent =
      PendingIntent.getBroadcast(context, 0, reminderIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    long triggerTime = System.currentTimeMillis() + interval;
    if (Log.DEBUG) Log.v("ReminderReceiver: scheduled reminder notification in " + interval
        + " seconds");
    myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, reminderPendingIntent);
  }

  /*
   * Cancels the reminder notification in the case the user reads the message
   * before it ends up playing.
   */
  public static void cancelReminder(Context context) {

    Intent reminderIntent = new Intent(context, ReminderReceiver.class);
    reminderIntent.setAction(ACTION_REMIND);
    PendingIntent reminderPendingIntent =
      PendingIntent.getBroadcast(context, 0, reminderIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    reminderPendingIntent.cancel();
    if (Log.DEBUG) Log.v("ReminderReceiver: cancelReminder()");
  }
}
