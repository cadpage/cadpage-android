package net.anei.cadpage;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/*
 * This class handles the Notifications (sounds/vibrate/LED)
 */
public class ManageNotification {
  
  private static final int MAX_PLAYER_RETRIES = 4;

  private static final int NOTIFICATION_ALERT = 1337;
  
  private static MediaPlayer mMediaPlayer = null;
  
  @SuppressWarnings("serial")
  private static class MediaFailureException extends RuntimeException {
    MediaFailureException(String desc) {
      super(desc);
    }
    MediaFailureException(String desc, Throwable cause) {
      super(desc, cause);
    }
  }
  
  /**
   * @return true if some kind of notification should be launched when page is received
   */
  public static boolean isNotificationEnabled() {
    return ManagePreferences.notifyEnabled() || ManagePreferences.notifyOverride();
  }

  /*
   * The main notify method
   */
  public static boolean show(Context context, SmsMmsMessage message) {
    boolean result = show(context, message, true);
    if (result) {
      ClearAllReceiver.setCancel(context, ManagePreferences.notifyTimeout(), 
                                 ClearAllReceiver.ClearType.NOTIFY);
    }
    return result;
  }
  
  
  public static boolean show(Context context, SmsMmsMessage message, boolean reminder) {
    
    // Check if notifications are enabled - if not, we're done :)
    if (!ManagePreferences.notifyEnabled() && !ManagePreferences.notifyOverride()) return false;

    Notification n = buildNotification(context, message);

    // Launch the notification
    NotificationManager myNM =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

      // Seems this is needed for the number value to take effect on the Notification
      myNM.cancel(NOTIFICATION_ALERT);
      myNM.notify(NOTIFICATION_ALERT, n);

    // Schedule a reminder notification
    if (reminder && !ManagePreferences.notifyOverride()) ReminderReceiver.scheduleReminder(context, message);
    return true;
  }

  /*
   * Build the notification from user preferences
   */
  private static Notification buildNotification(Context context, SmsMmsMessage message) {

    /*
     * Ok, let's create our Notification object and set up all its parameters.
     */
    NotificationCompat.Builder nbuild = new NotificationCompat.Builder(context);

    // Set auto-cancel flag
    nbuild.setAutoCancel(true);
    
    // Maximum priority
    nbuild.setPriority(NotificationCompat.PRIORITY_MAX);
    
    // Set display icon
    nbuild.setSmallIcon(R.drawable.ic_stat_notify);

    // Set up LED pattern and color
    if (ManagePreferences.flashLED()) {
      /*
       * Set up LED blinking pattern
       */
      int[] led_pattern = null;

      String flashLedPattern = ManagePreferences.flashLEDPattern();
      if (context.getString(R.string.pref_custom_val).equals(flashLedPattern)) {
        led_pattern = parseLEDPattern(ManagePreferences.flashLEDPatternCustom());
      } else {
        led_pattern = parseLEDPattern(flashLedPattern);
      }


      // Set to default if there was a problem
      if (led_pattern == null) {
        led_pattern = parseLEDPattern(context.getString(R.string.pref_flashled_pattern_default));
      }
      
      /*
       * Set up LED color
       */
      // Check if a custom color is set
      String flashLedCol = ManagePreferences.flashLEDColor();
      if (context.getString(R.string.pref_custom_val).equals(flashLedCol)) {
        flashLedCol = ManagePreferences.flashLEDColorCustom();
      }

      // Default in case the parse fails
      int col = Color.parseColor(context.getString(R.string.pref_flashled_color_default));

      // Try and parse the color
      if (flashLedCol != null) {
        try {
          col = Color.parseColor(flashLedCol);
        } catch (IllegalArgumentException e) {
          // No need to do anything here
        }
      }

      nbuild.setLights(col, led_pattern[0], led_pattern[1]);
    }

    /*
     * Set up vibrate pattern
     */
    // If vibrate is ON, or if phone is set to vibrate
    AudioManager AM = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    if ((ManagePreferences.vibrate() || AudioManager.RINGER_MODE_VIBRATE == AM.getRingerMode())) {
      String vibrate_pattern_raw = ManagePreferences.vibratePattern();
      if (context.getString(R.string.pref_custom_val).equals(vibrate_pattern_raw)) {
        vibrate_pattern_raw = ManagePreferences.vibratePatternCustom();
      }
      long[] vibrate_pattern = parseVibratePattern(vibrate_pattern_raw);

     if (vibrate_pattern != null) {
       nbuild.setVibrate(vibrate_pattern);
      } else {
        nbuild.setDefaults(Notification.DEFAULT_VIBRATE);
      }
    }

    if ( ManagePreferences.notifyOverride() || ManagePreferences.notifyEnabled()) { 
      if (ManagePreferences.notifyOverride()) {
        startMediaPlayer(context, 0);
      } else {	 
        Uri alarmSoundURI = Uri.parse(ManagePreferences.notifySound());
        nbuild.setSound(alarmSoundURI);
      }
    }

    String call = message.getInfo().getTitle();
    nbuild.setContentTitle(context.getString(R.string.cadpage_alert));
    nbuild.setContentText(call);
    nbuild.setStyle(new NotificationCompat.InboxStyle().addLine(call).addLine(message.getInfo().getAddress()));
    nbuild.setWhen(message.getIncidentDate().getTime());

    // The default intent when the notification is clicked (Inbox)
    Intent smsIntent = CallHistoryActivity.getLaunchIntent(context, true);
    PendingIntent notifIntent = PendingIntent.getActivity(context, 0, smsIntent, 0);
    nbuild.setContentIntent(notifIntent);
    
    // Set intent to execute if the "clear all" notifications button is pressed -
    // basically stop any future reminders.
    Intent deleteIntent = new Intent(new Intent(context, ReminderReceiver.class));
    deleteIntent.setAction(Intent.ACTION_DELETE);
    PendingIntent pendingDeleteIntent = PendingIntent.getBroadcast(context, 0, deleteIntent, 0);
    nbuild.setDeleteIntent(pendingDeleteIntent);

    return nbuild.build();
  }


  /**
   * Start up Media player to playoverride alert sound
   * @param context current context
   */
  private synchronized static void startMediaPlayer(Context context, int startCnt) {
    if (mMediaPlayer == null) {
      try {
        mMediaPlayer = new MediaPlayer();
        MediaErrorListener listener = new MediaErrorListener(context, startCnt);
        mMediaPlayer.setOnErrorListener(listener);
        AssetFileDescriptor fd = context.getResources().openRawResourceFd(R.raw.generalquarter);
        mMediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
        mMediaPlayer.prepare();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.setVolume(1.0f, 1.0f);
        listener.arm();
        mMediaPlayer.start();
      } catch (IOException ex) {
        throw new MediaFailureException(ex.getMessage(), ex);
      }
    }
  }


  /**
   * Stop media player
   */
  private synchronized static void stopMediaPlayer() {
    // Stop media player if running
    if (mMediaPlayer != null) {
      mMediaPlayer.stop();
      mMediaPlayer.release();
      mMediaPlayer = null;
    }
  }
  
  // Media error listener
  // Our job is to shut down and restart the media play if it dies for some
  // unknown reason.  
  private static class MediaErrorListener implements OnErrorListener {
    
    private Context context;
    private int startCnt;
    private boolean armed = false;
    
    public MediaErrorListener(Context context, int startCnt) {
      this.context = context;
      this.startCnt = startCnt;
    }
    
    public void arm() {
      armed = true;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
      if (armed && what == MediaPlayer.MEDIA_ERROR_SERVER_DIED && startCnt < MAX_PLAYER_RETRIES) {
        Log.e("Restarting Media Player");
        stopMediaPlayer();
        startMediaPlayer(context, startCnt+1);
        return true;
      }

      throw new MediaFailureException("Media Player failure - what:" + what + " extra:" + extra + " cnt:" + startCnt);
    }
    
  }

  // Clear a single notification
  public static void clear(Context context) {

    // Clear any pending reminders
    ReminderReceiver.cancelReminder(context);

    NotificationManager myNM =
      (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    myNM.cancel(NOTIFICATION_ALERT);
    
    stopMediaPlayer();
  }

  /**
   * Parse the user provided custom vibrate pattern into a long[]
   * 
   */
  // TODO: tidy this up
  public static long[] parseVibratePattern(String stringPattern) {
    ArrayList<Long> arrayListPattern = new ArrayList<Long>();
    Long l;

    if (stringPattern == null) return null;

    String[] splitPattern = stringPattern.split(",");
    int VIBRATE_PATTERN_MAX_SECONDS = 60000;
    int VIBRATE_PATTERN_MAX_PATTERN = 100;

    for (int i = 0; i < splitPattern.length; i++) {
      try {
        l = Long.parseLong(splitPattern[i].trim());
      } catch (NumberFormatException e) {
        return null;
      }
      if (l > VIBRATE_PATTERN_MAX_SECONDS) {
        return null;
      }
      arrayListPattern.add(l);
    }

    // TODO: can i just cast the whole ArrayList into long[]?
    int size = arrayListPattern.size();
    if (size > 0 && size < VIBRATE_PATTERN_MAX_PATTERN) {
      long[] pattern = new long[size];
      for (int i = 0; i < pattern.length; i++) {
        pattern[i] = arrayListPattern.get(i);
      }
      return pattern;
    }

    return null;
  }

  /**
   * Parse LED pattern string into int[]
   * 
   * @param stringPattern
   * @return
   */
  public static int[] parseLEDPattern(String stringPattern) {
    int[] arrayPattern = new int[2];
    int on, off;

    if (stringPattern == null) return null;

    String[] splitPattern = stringPattern.split(",");

    if (splitPattern.length != 2) return null;

    int LED_PATTERN_MIN_SECONDS = 0;
    int LED_PATTERN_MAX_SECONDS = 60000;

    try {
      on = Integer.parseInt(splitPattern[0]);
    } catch (NumberFormatException e) {
      return null;
    }

    try {
      off = Integer.parseInt(splitPattern[1]);
    } catch (NumberFormatException e) {
      return null;
    }

    if (on >= LED_PATTERN_MIN_SECONDS && on <= LED_PATTERN_MAX_SECONDS
        && off >= LED_PATTERN_MIN_SECONDS && off <= LED_PATTERN_MAX_SECONDS) {
      arrayPattern[0] = on;
      arrayPattern[1] = off;
      return arrayPattern;
    }

    return null;
  }


  /**
   * Called to determine if an acknowledge function is needed to clear a
   * pending alert
   * @return true if there is a reminder or alert to be cleared
   */
  public static boolean isAckNeeded() {
    
    // If the media player is active, we *REALLY* need an acknowledge function
    if (mMediaPlayer != null) return true;
    
    // Otherwise, we need a acknowledge function if reminders are active
    return ManagePreferences.notifyRepeat();
  }
}
