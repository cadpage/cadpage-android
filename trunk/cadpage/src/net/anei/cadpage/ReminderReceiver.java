package net.anei.cadpage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReminderReceiver extends BroadcastReceiver {

  private static final String ACTION_REMIND = "net.anei.cadpage.ACTION_REMIND";
  
  private static String EXTRAS_MSG_ID = "net.anei.cadpage.EXTRAS_MSG_ID";
  private static String EXTRAS_COUNT = "net.anei.cadpage.EXTRAS_REMINDER_COUNT";
  
  // Flag we keep so we can tell if their is a reminder active
  private static boolean reminderActive = false;

  /*
   * We're not going to do anything in the onReceive() as taking too long here
   * (>10 seconds) will cause a "Application Not Responding: Wait/Close" message
   * to the user. Instead we'll fire up a service that does the work in a
   * different thread.
   */
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
    
    int repeatCount = intent.getIntExtra(EXTRAS_COUNT, 0);
    ManageNotification.show(context, message, false);

    if (repeatCount > 0) repeatCount--;

    reminderActive = repeatCount != 0;
    if (reminderActive) {
      ReminderReceiver.scheduleReminder(context, message, repeatCount);
      ManageWakeLock.acquireFull(context);
    }
  }

  /*
   * This will schedule a reminder notification to play in the future using the
   * system AlarmManager. The time till the reminder and number of reminders is
   * taken from user preferences.
   */
  public static void scheduleReminder(Context context, SmsMmsMessage message) {
    int repeat = ManagePreferences.repeatTimes();
    if (repeat != 0) {
      scheduleReminder(context, message, repeat);
    }
  }

  public static void scheduleReminder(Context context, SmsMmsMessage message, int repeat) {
    boolean reminder_notifications = ManagePreferences.notifyRepeat();
    if (reminder_notifications) {

      int reminderInterval = ManagePreferences.repeatInterval();
      reminderInterval *= 60;
      
      AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

      Intent reminderIntent = new Intent(context, ReminderReceiver.class);
      reminderIntent.setAction(ACTION_REMIND);
      reminderIntent.putExtra(EXTRAS_MSG_ID, message.getMsgId());
      reminderIntent.putExtra(EXTRAS_COUNT, repeat);

      PendingIntent reminderPendingIntent =
        PendingIntent.getBroadcast(context, 0, reminderIntent, PendingIntent.FLAG_CANCEL_CURRENT);

      long triggerTime = System.currentTimeMillis() + (reminderInterval * 1000);
      if (Log.DEBUG) Log.v("ReminderReceiver: scheduled reminder notification in " + reminderInterval
          + " seconds, count is " + 999);
      myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, reminderPendingIntent);
      
      reminderActive = true;
    }
  }

  /*
   * Cancels the reminder notification in the case the user reads the message
   * before it ends up playing.
   */
  public static void cancelReminder(Context context) {

    reminderActive = false;
    Intent reminderIntent = new Intent(context, ReminderReceiver.class);
    reminderIntent.setAction(ACTION_REMIND);
    PendingIntent reminderPendingIntent =
      PendingIntent.getBroadcast(context, 0, reminderIntent, PendingIntent.FLAG_CANCEL_CURRENT);
    reminderPendingIntent.cancel();
    if (Log.DEBUG) Log.v("ReminderReceiver: cancelReminder()");
  }

  /**
   * Determine if we need an acknowledge button to clear an active reminder 
   * @return true if we need an acknowledge button
   */
  public static boolean isAckNeeded() {
    return reminderActive;
  }
}
