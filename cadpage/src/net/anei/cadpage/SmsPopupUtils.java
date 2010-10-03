package net.anei.cadpage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage;
import android.text.TextUtils;

public class SmsPopupUtils {
  //Content URIs for SMS app, these may change in future SDK
  public static final Uri MMS_SMS_CONTENT_URI = Uri.parse("content://mms-sms/");
  public static final Uri THREAD_ID_CONTENT_URI =
    Uri.withAppendedPath(MMS_SMS_CONTENT_URI, "threadID");
  public static final Uri CONVERSATION_CONTENT_URI =
    Uri.withAppendedPath(MMS_SMS_CONTENT_URI, "conversations");
  public static final String SMSTO_URI = "smsto:";
  private static final String UNREAD_CONDITION = "read=0";

  public static final Uri SMS_CONTENT_URI = Uri.parse("content://sms");
  public static final Uri SMS_INBOX_CONTENT_URI = Uri.withAppendedPath(SMS_CONTENT_URI, "inbox");

  public static final Uri MMS_CONTENT_URI = Uri.parse("content://mms");
  public static final Uri MMS_INBOX_CONTENT_URI = Uri.withAppendedPath(MMS_CONTENT_URI, "inbox");

  public static final String SMSMMS_ID = "_id";
  public static final String SMS_MIME_TYPE = "vnd.android-dir/mms-sms";
  public static final int READ_THREAD = 1;
  public static final int MESSAGE_TYPE_SMS = 1;
  public static final int MESSAGE_TYPE_MMS = 2;

  public static final int CONTACT_PHOTO_PLACEHOLDER = android.R.drawable.ic_dialog_info;

  // The size of the contact photo thumbnail on the popup
  public static final int CONTACT_PHOTO_THUMBSIZE = 96;

  // The max size of either the width or height of the contact photo
  public static final int CONTACT_PHOTO_MAXSIZE = 1024;

  private static final String[] AUTHOR_CONTACT_INFO = { "CadPage cadpage@arcolavfd.org" };
  private static final String[] AUTHOR_CONTACT_INFO_DONATE = { "CadPage cadpage@arcolavfd.org" };

  public static final Uri DONATE_PAYPAL_URI =
    Uri.parse("Not Available Yet");
  public static final Uri DONATE_MARKET_URI =
    Uri.parse("Not Available Yet");

  // Platform detection
  public static final int SDK_VERSION_ECLAIR = 5;
  //public static final int SDK_VERSION_DONUT = 4;

  public static boolean PRE_ECLAIR =
    SmsPopupUtils.getSDKVersionNumber() < SmsPopupUtils.SDK_VERSION_ECLAIR ? true : false;

 
 
 
 
  /**
   * Marks a specific message as read
   */
//  public static void setMessageRead(Context context, long messageId, int messageType) {
//
//    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
//    boolean markRead = myPrefs.getBoolean(
//        context.getString(R.string.pref_markread_key),
//        Boolean.valueOf(context.getString(R.string.pref_markread_default)));
//    if (!markRead) return;
//
//    if (messageId > 0) {
//      ContentValues values = new ContentValues(1);
//      values.put("read", READ_THREAD);
//
//      Uri messageUri;
//
//      if (SmsMmsMessage.MESSAGE_TYPE_MMS == messageType) {
//        // Used to use URI of MMS_CONTENT_URI and it wasn't working, not sure why
//        // this is diff to SMS
//        messageUri = Uri.withAppendedPath(MMS_INBOX_CONTENT_URI, String.valueOf(messageId));
//      } else if (SmsMmsMessage.MESSAGE_TYPE_SMS == messageType) {
//        messageUri = Uri.withAppendedPath(SMS_CONTENT_URI, String.valueOf(messageId));
//      } else {
//        return;
//      }
//
//      // Log.v("messageUri for marking message read: " + messageUri.toString());
//
//      ContentResolver cr = context.getContentResolver();
//      int result;
//      try {
//        result = cr.update(messageUri, values, null, null);
//      } catch (Exception e) {
//        result = 0;
//      }
//      if (Log.DEBUG) Log.v(String.format("message id = %s marked as read, result = %s", messageId, result ));
//    }
//  }

  /**
   * Marks a specific message thread as read - all messages in the thread will
   * be marked read
   */
//  public static void setThreadRead(Context context, long threadId) {
//    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
//    boolean markRead = myPrefs.getBoolean(
//        context.getString(R.string.pref_markread_key),
//        Boolean.valueOf(context.getString(R.string.pref_markread_default)));
//
//    if (!markRead) return;
//
//    if (threadId > 0) {
//      ContentValues values = new ContentValues(1);
//      values.put("read", READ_THREAD);
//
//      ContentResolver cr = context.getContentResolver();
//      int result = 0;
//      try {
//        result = cr.update(
//            ContentUris.withAppendedId(CONVERSATION_CONTENT_URI, threadId),
//            values, null, null);
//      } catch (Exception e) {
//        if (Log.DEBUG) Log.v("error marking thread read");
//      }
//      if (Log.DEBUG) Log.v("thread id " + threadId + " marked as read, result = " + result);
//    }
//  }
//
//  /**
//   * Tries to locate the message id (from the system database), given the message
//   * thread id, the timestamp of the message and the type of message (sms/mms)
//   */
//  public static long findMessageId(Context context, long threadId, long timestamp,
//      String body, int messageType) {
//
//    long id = 0;
//    String selection = "body = " + DatabaseUtils.sqlEscapeString(body);
//    final String sortOrder = "date DESC";
//    final String[] projection = new String[] { "_id", "date", "thread_id", "body" };
//
//    if (threadId > 0) {
//      if (Log.DEBUG) Log.v("Trying to find message ID");
//      if (SmsMmsMessage.MESSAGE_TYPE_MMS == messageType) {
//        // It seems MMS timestamps are stored in a seconds, whereas SMS timestamps are in millis
//        selection += " and date = " + (timestamp / 1000);
//      }
//
//      // Log.v("Where is: " + where);
//      // Log.v("ThreadId is: " + threadId);
//
//      Cursor cursor = context.getContentResolver().query(
//          ContentUris.withAppendedId(CONVERSATION_CONTENT_URI, threadId),
//          projection,
//          selection,
//          null,
//          sortOrder);
//
//      if (cursor != null) {
//        try {
//          if (cursor.moveToFirst()) {
//            id = cursor.getLong(0);
//            if (Log.DEBUG) Log.v("Message id found = " + id);
//            //Log.v("Timestamp = " + cursor.getLong(1));
//          }
//        } finally {
//          cursor.close();
//        }
//      }
//    }
//    return id;
//  }

  /**
   * Tries to delete a message from the system database, given the thread id,
   * the timestamp of the message and the message type (sms/mms).
   */
//  public static void deleteMessage(Context context, long messageId, long threadId, int messageType) {
//
//    if (messageId > 0) {
//      if (Log.DEBUG) Log.v("id of message to delete is " + messageId);
//
//      // We need to mark this message read first to ensure the entire thread is marked as read
//      setMessageRead(context, messageId, messageType);
//
//      // Construct delete message uri
//      Uri deleteUri;
//
//      if (SmsMmsMessage.MESSAGE_TYPE_MMS == messageType) {
//        deleteUri = Uri.withAppendedPath(MMS_CONTENT_URI, String.valueOf(messageId));
//      } else if (SmsMmsMessage.MESSAGE_TYPE_SMS == messageType) {
//        deleteUri = Uri.withAppendedPath(SMS_CONTENT_URI, String.valueOf(messageId));
//      } else {
//        return;
//      }
//      int count = context.getContentResolver().delete(deleteUri, null, null);
//      if (Log.DEBUG) Log.v("Messages deleted: " + count);
//      if (count == 1) {
//        //TODO: should only set the thread read if there are no more unread messages
//        //setThreadRead(context, threadId);
//      }
//    }
//  }

  /**
   * 
   */
  public static void launchEmailToIntent(Context context, String subject, boolean includeDebug) {
    Intent msg = new Intent(Intent.ACTION_SEND);

    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    boolean donated = myPrefs.getBoolean(context.getString(R.string.pref_donated_key), false);

    StringBuilder body = new StringBuilder();

    if (includeDebug) {
      body.append(String.format("\n\n----------\nSysinfo - %s\nModel: %s\n\n",
          Build.FINGERPRINT, Build.MODEL));

      // Array of preference keys to include in email
      final String[] pref_keys = {
          context.getString(R.string.pref_enabled_key),
          context.getString(R.string.pref_timeout_key),
          context.getString(R.string.pref_privacy_key),
          context.getString(R.string.pref_dimscreen_key),
          context.getString(R.string.pref_onlyShowOnKeyguard_key),
          context.getString(R.string.pref_show_buttons_key),
          context.getString(R.string.pref_button1_key),
          context.getString(R.string.pref_button2_key),
          context.getString(R.string.pref_button3_key),
          // context.getString(R.string.pref_blur_key),
          context.getString(R.string.pref_popup_enabled_key),
          context.getString(R.string.pref_notif_enabled_key),
          context.getString(R.string.pref_notif_sound_key),
          context.getString(R.string.pref_vibrate_key),
          context.getString(R.string.pref_vibrate_pattern_key),
//          context.getString(R.string.pref_vibrate_pattern_custom_key),
          context.getString(R.string.pref_flashled_key),
          context.getString(R.string.pref_flashled_color_key),
          context.getString(R.string.pref_notif_repeat_key),
          context.getString(R.string.pref_notif_repeat_times_key),
          context.getString(R.string.pref_notif_repeat_interval_key),
      };

      Map<String, ?> m = myPrefs.getAll();

      body.append(String.format("%s config -\n", subject));
      for (int i=0; i<pref_keys.length; i++) {
        try {
          body.append(String.format("%s: %s\n", pref_keys[i], m.get(pref_keys[i])));
        } catch (NullPointerException e) {
          // Nothing to do here
        }
      }

      // Fetch number of db rows (=custom contact notifications)
      SmsPopupDbAdapter mDbAdapter = new SmsPopupDbAdapter(context);
      mDbAdapter.open(true);
      Cursor c = mDbAdapter.fetchAllContacts();
      int dbRowCount = 0;
      if (c != null) {
        dbRowCount = c.getCount();
      }
      mDbAdapter.close();
      body.append("Db Rows: " + dbRowCount + "\n");

      // Add locale info
      body.append(String.format("locale: %s\n",
          context.getResources().getConfiguration().locale.getDisplayName()));

      // TODO: fix this up so users can attach system logs to the email
      // this almost works but for some reason the attachment never sends (while it still
      // appears in the draft email that is created) :(
      // Attach the log file if it exists
      //      Uri log = collectLogs(context);
      //      if (log != null) {
      //        msg.putExtra(Intent.EXTRA_STREAM, log);
      //      }
    }

    msg.putExtra(Intent.EXTRA_EMAIL, donated ? AUTHOR_CONTACT_INFO_DONATE : AUTHOR_CONTACT_INFO);
    msg.putExtra(Intent.EXTRA_SUBJECT, subject);
    msg.putExtra(Intent.EXTRA_TEXT, body.toString());

    msg.setType("message/rfc822");
    context.startActivity(Intent.createChooser(
        msg, context.getString(R.string.pref_sendemail_title)));
  }

  /**
   * Fetch output from logcat, dump it in a file and return the URI to the file
   */
  public static Uri collectLogs(Context context) {
    final String logfile = "log.txt";

    try {
      ArrayList<String> commandLine = new ArrayList<String>();
      commandLine.add("logcat");
      commandLine.add("-d");
      commandLine.add("AndroidRuntime:E");
      commandLine.add(Log.LOGTAG + ":V");
      commandLine.add("*:S");

      BufferedInputStream fin = new BufferedInputStream(
          Runtime.getRuntime().exec(commandLine.toArray(new String[0])).getInputStream());
      BufferedOutputStream fout = new BufferedOutputStream(
          context.openFileOutput(logfile, Context.MODE_WORLD_READABLE));

      // Copy output to a log file
      int i;
      do {
        i = fin.read();
        if (i != -1)
          fout.write(i);
      } while (i != -1);
      fin.close();
      fout.close();
    } catch (IOException e) {
      return null;
    } catch (SecurityException e) {
      return null;
    }

    return Uri.fromFile(context.getFileStreamPath(logfile));
  }

  /**
   * Return current unread message count from system db (sms and mms)
   * 
   * @param context
   * @return unread sms+mms message count
   */
  public static int getUnreadMessagesCount(Context context) {
    return getUnreadMessagesCount(context, 0, null);
  }

  /**
   * Return current unread message count from system db (sms and mms)
   * 
   * @param context
   * @param timestamp only messages before this timestamp will be counted
   * @return unread sms+mms message count
   */
  public static int getUnreadMessagesCount(Context context, long timestamp, String messageBody) {
    return getUnreadSmsCount(context, timestamp, messageBody) + getUnreadMmsCount(context);
  }

  /**
   * Return current unread message count from system db (sms only)
   * 
   * @param context
   * @return unread sms message count
   */
  public static int getUnreadSmsCount(Context context) {
    return getUnreadSmsCount(context, 0, null);
  }

  /**
   * Return current unread message count from system db (sms only)
   * 
   * @param context
   * @param timestamp only messages before this timestamp will be counted
   * @return unread sms message count
   */
  public static int getUnreadSmsCount(Context context, long timestamp, String messageBody) {

    if (Log.DEBUG) Log.v("getUnreadSmsCount()");

    final String[] projection = new String[] { SMSMMS_ID, "body" };
    final String selection = UNREAD_CONDITION;
    final String[] selectionArgs = null;
    final String sortOrder = "date DESC";

    int count = 0;

    Cursor cursor = context.getContentResolver().query(
        SMS_INBOX_CONTENT_URI,
        projection,
        selection,
        selectionArgs,
        sortOrder);

    if (cursor != null) {
      try {
        count = cursor.getCount();

        /*
         * We need to check if the message received matches the most recent one in the db
         * or not (to find out if our code ran before the system code or vice-versa)
         */
        if (messageBody != null && count > 0) {
          if (cursor.moveToFirst()) {
            /*
             * Check the most recent message, if the body does not match then it hasn't yet
             * been inserted into the system database, therefore we need to add one to our
             * total count
             */
            if (!messageBody.equals(cursor.getString(1))) {
              if (Log.DEBUG) Log.v("getUnreadSmsCount(): most recent message did not match body, adding 1 to count");
              count++;
            }
          }
        }
      } finally {
        cursor.close();
      }
    }

    /*
     * If count is still 0 and timestamp is set then its likely the system db had not updated
     * when this code ran, therefore let's add 1 so the notify will run correctly.
     */
    if (count == 0 && timestamp > 0) {
      count = 1;
    }

    if (Log.DEBUG) Log.v("getUnreadSmsCount(): unread count = " + count);
    return count;
  }

  /**
   * Return current unread message count from system db (mms only)
   * 
   * @param context
   * @return unread mms message count
   */
  public static int getUnreadMmsCount(Context context) {

    final String selection = UNREAD_CONDITION;
    final String[] projection = new String[] { SMSMMS_ID };

    int count = 0;

    Cursor cursor = context.getContentResolver().query(
        MMS_INBOX_CONTENT_URI,
        projection,
        selection, null, null);

    if (cursor != null) {
      try {
        count = cursor.getCount();
      } finally {
        cursor.close();
      }
    }
    if (Log.DEBUG) Log.v("mms unread count = " + count);
    return count;
  }

  /*
   * 
   */
  public static SmsMmsMessage getSmsDetails(Context context,
      long ignoreThreadId, boolean unreadOnly) {

    final String[] projection =
      new String[] { "_id", "thread_id", "address", "date", "body" };
    String selection = unreadOnly ? UNREAD_CONDITION : null;
    String[] selectionArgs = null;
    final String sortOrder = "date DESC";

    int count = 0;

    if (ignoreThreadId > 0) {
      selection = (selection == null) ? "" : selection + " and ";
      selection += "thread_id != ?";
      selectionArgs = new String[] { String.valueOf(ignoreThreadId) };
    }

    Cursor cursor = context.getContentResolver().query(
        SMS_INBOX_CONTENT_URI,
        projection,
        selection,
        selectionArgs,
        sortOrder);

    if (cursor != null) {
      try {
        count = cursor.getCount();
        if (count > 0) {
          cursor.moveToFirst();

          //					String[] columns = cursor.getColumnNames();
          //					for (int i=0; i<columns.length; i++) {
          //						Log.v("columns " + i + ": " + columns[i] + ": "
          //								+ cursor.getString(i));
          //					}

          long messageId = cursor.getLong(0);
          long threadId = cursor.getLong(1);
          String address = cursor.getString(2);
          long timestamp = cursor.getLong(3);
          String body = cursor.getString(4);

          if (!unreadOnly) {
            count = 0;
          }

          SmsMmsMessage smsMessage = new SmsMmsMessage(
              context, address, body, timestamp, SmsMmsMessage.MESSAGE_TYPE_SMS);

          return smsMessage;

        }
      } finally {
        cursor.close();
      }
    }
    return null;
  }

  public static SmsMmsMessage getSmsDetails(Context context) {
    return getSmsDetails(context, 0);
  }

  public static SmsMmsMessage getSmsDetails(Context context, boolean unreadOnly) {
    return getSmsDetails(context, 0, unreadOnly);
  }

  public static SmsMmsMessage getSmsDetails(Context context, long ignoreThreadId) {
    return getSmsDetails(context, ignoreThreadId, true);
  }

  /*
   * 
   */
//  public static SmsMmsMessage getMmsDetails(Context context, long ignoreThreadId) {
//
//    final String[] projection = new String[] { "_id", "thread_id", "date", "sub", "sub_cs" };
//    String selection = UNREAD_CONDITION;
//    String[] selectionArgs = null;
//    final String sortOrder = "date DESC";
//    int count = 0;
//
//    if (ignoreThreadId > 0) {
//      selection += " and thread_id != ?";
//      selectionArgs = new String[] { String.valueOf(ignoreThreadId) };
//    }
//
//    Cursor cursor = context.getContentResolver().query(
//        MMS_INBOX_CONTENT_URI,
//        projection,
//        selection,
//        selectionArgs,
//        sortOrder);
//
//    if (cursor != null) {
//      try {
//        count = cursor.getCount();
//        if (count > 0) {
//          cursor.moveToFirst();
//          //          String[] columns = cursor.getColumnNames();
//          //          for (int i=0; i<columns.length; i++) {
//          //            Log.v("columns " + i + ": " + columns[i] + ": "
//          //                + cursor.getString(i));
//          //          }
//          long messageId = cursor.getLong(0);
//          long threadId = cursor.getLong(1);
//          long timestamp = cursor.getLong(2) * 1000;
//          String subject = cursor.getString(3);
//
//          return new SmsMmsMessage(context, messageId, threadId, timestamp,
//              subject, count, SmsMmsMessage.MESSAGE_TYPE_MMS);
//        }
//
//      } finally {
//        cursor.close();
//      }
//    }
//    return null;
//  }

//  public static SmsMmsMessage getMmsDetails(Context context) {
//    return getMmsDetails(context, 0);
//  }

  public static String getMmsAddress(Context context, long messageId) {
    final String[] projection =  new String[] { "address", "contact_id", "charset", "type" };
    final String selection = "type=137"; // "type="+ PduHeaders.FROM,

    Uri.Builder builder = MMS_CONTENT_URI.buildUpon();
    builder.appendPath(String.valueOf(messageId)).appendPath("addr");

    Cursor cursor = context.getContentResolver().query(
        builder.build(),
        projection,
        selection,
        null, null);

    if (cursor != null) {
      try {
        if (cursor.moveToFirst()) {
          // Apparently contact_id is always empty in this table so we can't get it from here

          // Just return the address
          return cursor.getString(0);
        }
      } finally {
        cursor.close();
      }
    }

    return context.getString(android.R.string.unknownName);
  }

  public static final Pattern NAME_ADDR_EMAIL_PATTERN =
    Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");

  public static final Pattern QUOTED_STRING_PATTERN =
    Pattern.compile("\\s*\"([^\"]*)\"\\s*");

  private static String extractAddrSpec(String address) {
    Matcher match = NAME_ADDR_EMAIL_PATTERN.matcher(address);

    if (match.matches()) {
      return match.group(2);
    }
    return address;
  }

  private static String getEmailDisplayName(String displayString) {
    Matcher match = QUOTED_STRING_PATTERN.matcher(displayString);
    if (match.matches()) {
      return match.group(1);
    }
    return displayString;
  }

  /**
   * Read the PDUs out of an {@link #SMS_RECEIVED_ACTION} or a
   * {@link #DATA_SMS_RECEIVED_ACTION} intent.
   * 
   * @param intent
   *           the intent to read from
   * @return an array of SmsMessages for the PDUs
   */
  public static final SmsMessage[] getMessagesFromIntent(Intent intent) {
    Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
    if (messages == null) {
      return null;
    }
    if (messages.length == 0) {
      return null;
    }

    byte[][] pduObjs = new byte[messages.length][];

    for (int i = 0; i < messages.length; i++) {
      pduObjs[i] = (byte[]) messages[i];
    }
    byte[][] pdus = new byte[pduObjs.length][];
    int pduCount = pdus.length;
    SmsMessage[] msgs = new SmsMessage[pduCount];
    for (int i = 0; i < pduCount; i++) {
      pdus[i] = pduObjs[i];
      msgs[i] = SmsMessage.createFromPdu(pdus[i]);
    }
    return msgs;
  }

  /**
   * This function will see if the most recent activity was the system messaging app so we can suppress
   * the popup as the user is likely already viewing messages or composing a new message
   */
//  public static final boolean inMessagingApp(Context context) {
//    // TODO: move these to static strings somewhere
//    final String PACKAGE_NAME = "com.android.mms";
//    //final String COMPOSE_CLASS_NAME = "com.android.mms.ui.ComposeMessageActivity";
//    final String CONVO_CLASS_NAME = "com.android.mms.ui.ConversationList";
//
//    ActivityManager mAM = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//
//    List<RunningTaskInfo> mRunningTaskList = mAM.getRunningTasks(1);
//    Iterator<RunningTaskInfo> mIterator = mRunningTaskList.iterator();
//    if (mIterator.hasNext()) {
//      RunningTaskInfo mRunningTask = mIterator.next();
//      if (mRunningTask != null) {
//        ComponentName runningTaskComponent = mRunningTask.baseActivity;
//
//        //				Log.v("baseActivity = " + mRunningTask.baseActivity.toString());
//        //				Log.v("topActivity = " + mRunningTask.topActivity.toString());
//
//        if (PACKAGE_NAME.equals(runningTaskComponent.getPackageName()) &&
//            CONVO_CLASS_NAME.equals(runningTaskComponent.getClassName())) {
//          if (Log.DEBUG) Log.v("User in messaging app - from running task");
//          return true;
//        }
//      }
//    }
//
//    /*
//		List<RecentTaskInfo> mActivityList = mAM.getRecentTasks(1, 0);
//		Iterator<RecentTaskInfo> mIterator = mActivityList.iterator();
//
//		if (mIterator.hasNext()) {
//			RecentTaskInfo mRecentTask = (RecentTaskInfo) mIterator.next();
//			Intent recentTaskIntent = mRecentTask.baseIntent;
//
//			if (recentTaskIntent != null) {
//				ComponentName recentTaskComponentName = recentTaskIntent.getComponent();
//				if (recentTaskComponentName != null) {
//					String recentTaskClassName = recentTaskComponentName.getClassName();
//					if (PACKAGE_NAME.equals(recentTaskComponentName.getPackageName()) &&
//							(COMPOSE_CLASS_NAME.equals(recentTaskClassName) ||
//							 CONVO_CLASS_NAME.equals(recentTaskClassName))) {
//						if (Log.DEBUG) Log.v("User in messaging app");
//						return true;
//					}
//				}
//			}
//		}
//     */
//
//    /*
//		These appear to be the 2 main intents that mean the user is using the messaging app
//
//		action "android.intent.action.MAIN"
//		data null
//		class "com.android.mms.ui.ConversationList"
//		package "com.android.mms"
//
//		action "android.intent.action.VIEW"
//		data "content://mms-sms/threadID/3"
//		class "com.android.mms.ui.ComposeMessageActivity"
//		package "com.android.mms"
//     */
//
//    return false;
//  }

  /**
   * Enables or disables the main SMS receiver
   */
  public static void enableSMSPopup(Context context, boolean enable) {
    PackageManager pm = context.getPackageManager();
    ComponentName cn = new ComponentName(context, SmsReceiver.class);

    // Update preference so it reflects in the preference activity
    SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    SharedPreferences.Editor settings = myPrefs.edit();
    settings.putBoolean(context.getString(R.string.pref_enabled_key), enable);
    settings.commit();

    if (enable) {
      if (Log.DEBUG) Log.v("SMSPopup receiver is enabled");
      pm.setComponentEnabledSetting(cn,
          PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
          PackageManager.DONT_KILL_APP);

    } else {
      if (Log.DEBUG) Log.v("SMSPopup receiver is disabled");
      pm.setComponentEnabledSetting(cn,
          PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
          PackageManager.DONT_KILL_APP);
    }
  }

  /**
   * Fetch the current device Android OS platform number.
   * 
   * TODO: once Cupcake support is no longer needed the system var
   * android.os.Build.VERSION.SDK_INT can be used instead.
   * 
   * @return SDK version number
   */
  public static int getSDKVersionNumber() {
    int version_sdk;
    try {
      version_sdk = Integer.valueOf(android.os.Build.VERSION.SDK);
    } catch (NumberFormatException e){
      version_sdk = 0;
    }
    return version_sdk;
  }
}