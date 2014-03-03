package net.anei.cadpage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReminderReceiver extends BroadcastReceiver {

  private static final String ACTION_REMIND = "net.anei.cadpage.ACTION_REMIND";
  
  private static String EXTRAS_MSG_ID = "net.anei.cadpage.EXTRAS_MSG_ID";

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("ReminderReceivere: onReceive()");

    String action = intent.getAction();

    if (ACTION_REMIND.equals(action)) {
      if (Log.DEBUG) Log.v("ReminderReceiver: processReminder()");
      processReminder(context, intent);
    } else if (Intent.ACTION_DELETE.equals(action)) {

      if (Log.DEBUG) Log.v("ReminderReceiver: cancelReminder()");
      ReminderReceiver.cancelReminder(context);
    }
  }

  private void processReminder(Context context, Intent intent) {
    
    int msgId = intent.getIntExtra(EXTRAS_MSG_ID, 0);
    SmsMmsMessage message = SmsMessageQueue.getInstance().getMessage(msgId);
    if (message == null) return;

    ReminderReceiver.scheduleReminder(context, message);
  }

  /*
   * This will schedule a reminder notification to play in the future using the
   * system AlarmManager. The time till the reminder and number of reminders is
   * taken from user preferences.
   */
  public static void scheduleReminder(Context context, SmsMmsMessage message) {
    boolean reminder_notifications = ManagePreferences.notifyRepeat();
    if (reminder_notifications) {

      int reminderInterval = ManagePreferences.repeatInterval();
      reminderInterval *= 60;
      
      AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

      Intent reminderIntent = new Intent(context, ReminderReceiver.class);
      reminderIntent.setAction(ACTION_REMIND);
      reminderIntent.putExtra(EXTRAS_MSG_ID, message.getMsgId());

      PendingIntent reminderPendingIntent =
        PendingIntent.getBroadcast(context, 0, reminderIntent, PendingIntent.FLAG_CANCEL_CURRENT);

      long triggerTime = System.currentTimeMillis() + (reminderInterval * 1000);
      if (Log.DEBUG) Log.v("ReminderReceiver: scheduled reminder notification in " + reminderInterval
          + " seconds, count is " + 999);
      myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, reminderPendingIntent);
    }
  }

  /*
   * Cancels the reminder notification in the case the user reads the message
   * before it ends up playing.
   */
  public static void cancelReminder(Context context) {

    Intent reminderIntent = new Intent(context, ReminderReceiver.class);
    reminderIntent.setAction(ACTION_REMIND);
    PendingIntent reminderPendingIntent =
      PendingIntent.getBroadcast(context, 0, reminderIntent, PendingIntent.FLAG_CANCEL_CURRENT);
    reminderPendingIntent.cancel();
    if (Log.DEBUG) Log.v("ReminderReceiver: cancelReminder()");
  }
}
