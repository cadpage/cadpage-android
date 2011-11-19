/*
 * Copyright (C) 2007-2008 Esmertec AG.
 * Copyright (C) 2007-2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.anei.cadpage;



import net.anei.cadpage.parsers.SmsMsgParser;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Receives M2DM related intents 
 */
public class C2DMReceiver extends BroadcastReceiver {
  
  private static final String ACTION_C2DM_REGISTER = "com.google.android.c2dm.intent.REGISTER";
  private static final String ACTION_C2DM_UNREGISTER = "com.google.android.c2dm.intent.UNREGISTER";
  private static final String ACTION_C2DM_REGISTERED = "com.google.android.c2dm.intent.REGISTRATION";
  private static final String ACTION_C2DM_RECEIVE = "com.google.android.c2dm.intent.RECEIVE";
  private static final String C2DM_SENDER_EMAIL = "alerts@cadpage.org";
  
  private static Activity curActivity = null;

  @Override
  public void onReceive(Context context, Intent intent) {
    if (Log.DEBUG) Log.v("C2DMReceiver: onReceive()");
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) return;
    
    if (ACTION_C2DM_REGISTERED.equals(intent.getAction())) {
      handleRegistration(context, intent);
    }
    
    else if (ACTION_C2DM_RECEIVE.equals(intent.getAction())) {
      handleMessage(context, intent);
    }
  }
  
  private void handleRegistration(Context context, Intent intent) {
    String error = intent.getStringExtra("error");
    if (error != null) {
      Log.w("C2DM registration failed: " + error);
      if (curActivity != null) {
        new AlertDialog.Builder(curActivity)
              .setIcon(R.drawable.ic_launcher).setTitle("C2DM Registration Error")
              .setPositiveButton(R.string.donate_btn_OK, null)
              .setMessage(error)
              .create().show();
      }
      return;
    }
    
    String regId = intent.getStringExtra("unregistered");
    if (regId != null) {
      ManagePreferences.setRegistrationId(null);
      Log.w("C2DM registration cancelled: " + regId);
      if (curActivity != null) {
        new AlertDialog.Builder(curActivity)
              .setIcon(R.drawable.ic_launcher).setTitle("C2DM Registration Cancelled")
              .setPositiveButton(R.string.donate_btn_OK, null)
              .setMessage(regId)
              .create().show();
      }
      return;
    }
    
    regId = intent.getStringExtra("registration_id");
    if (regId != null) {
      ManagePreferences.setRegistrationId(regId);
      Log.w("C2DM registration succeeded: " + regId);
      if (curActivity != null) {
        new AlertDialog.Builder(curActivity)
              .setIcon(R.drawable.ic_launcher).setTitle("C2DM Registration Succeeded")
              .setPositiveButton(R.string.donate_btn_OK, null)
              .setMessage(regId)
              .create().show();
      }
      return;
    }
    
  }

  private void handleMessage(Context context, Intent intent) {
    
    // If registration has been canceled, all C2DM messages should be ignored
    if (ManagePreferences.getRegistrationId() == null) return;
    
    // Reconstruct message from data
    String from = intent.getStringExtra("from");
    if (from == null) from = "C2DM";
    String subject = intent.getStringExtra("subject");
    if (subject == null) subject = "";
    String content = intent.getStringExtra("content");
    if (content == null) {
      Log.w("C2DM message has no content");
      return;
    }
    
    SmsMmsMessage message = 
      new SmsMmsMessage(from, subject, content, System.currentTimeMillis(), 
                        SmsMmsMessage.MESSAGE_TYPE_C2DM);
    
    String location = intent.getStringExtra("location");
    location = ManagePreferences.convertOldLocationCode(context, location);
    message.setReqLocation(location);
    message.setSponsor(intent.getStringExtra("sponsor"));
    
    // Add to log buffer
    if (!SmsMsgLogBuffer.getInstance().add(message)) return;
    
    // See if the current parser will accept this as a CAD page
    SmsMsgParser parser = ManageParsers.getInstance().getParser(null);
    boolean isPage = parser.isPageMsg(message, true, false);
    
    // If it didn't, accept it as a general page.  We have to do something with
    // it or it will just disappear
    if (! isPage) {
      SmsMsgParser genAlertParser = ManageParsers.getInstance().getAlertParser();
      isPage = genAlertParser.isPageMsg(message, true, true);
    }
    
    // This should never happen, but if the general alert parser can't handle
    // it bail out
    if (!isPage) return;
    SmsReceiver.processCadPage(context, message);
  }
  
  /**
   * Register activity to be used to generate any alert dialogs
   * @param activity
   */
  public static void registerActivity(Activity activity) {
    curActivity = activity;
  }
  
  /**
   * Unregister activity previously registered for any generated alert dialogs
   * @param activity
   */
  public static void unregisterActivity(Activity activity) {
    if (curActivity == activity) curActivity = null;
  }

  public static void register(Context context) {
    Intent intent = new Intent(ACTION_C2DM_REGISTER);
    intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    intent.putExtra("sender", C2DM_SENDER_EMAIL);
    context.startService(intent);
  }
  
  public static void unregister(Context context) {
    Intent intent = new Intent(ACTION_C2DM_UNREGISTER);
    intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    context.startService(intent);
  }

  public static void emailRegistrationId(Context context) {
    
    // Build send email intent and launch it
    Intent intent = new Intent(Intent.ACTION_SEND);
    String emailSubject = CadPageApplication.getNameVersion() + " C2DM registrion ID";
    intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
    intent.putExtra(Intent.EXTRA_TEXT, "My C2DM registration ID is " + ManagePreferences.getRegistrationId());
    intent.setType("message/rfc822");
    context.startActivity(Intent.createChooser(
        intent, context.getString(R.string.pref_sendemail_title)));
  }
}

