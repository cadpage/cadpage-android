package net.anei.cadpage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.anei.cadpage.donation.DeveloperToolsManager;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.UserAcctManager;
import net.anei.cadpage.vendors.VendorManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Class handles the dialog popup requesting information be sent to developers
 */
public class EmailDeveloperActivity extends Safe40Activity {
  
  public static enum EmailType { GENERAL, MESSAGE, CRASH, INIT_FAILURE, WRONG_USER, MARKET_PROBLEM, SOB_STORY };
  
  private final static String EXTRA_PREFIX="net.anei.cadpage.EmailDeveloperActivity.";
  private final static String EXTRA_TYPE = EXTRA_PREFIX + "EMAIL_TYPE";
  private final static String EXTRA_MSG_ID = EXTRA_PREFIX + "EMAIL_MSG_ID";
  
  // log snapshot filename
  private final static String LOG_SNAPSHOT_FILENAME = "LOG_SNAPSHOT.log";
  
  // Max snapshot filename age in msecs
  private final static long LOG_SNAPSHOT_MAX_AGE = 30L*24*60*60*1000;
  
  
  private TextView textView;
  private EmailType type;
  private int msgId;
  
  private CheckBox includeMsgBox;
  private CheckBox includeConfigBox;
  
  

  /**
   * Create new email dialog activity
   */
  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    if (Log.DEBUG) Log.v("EmailDeveloperActivity: onCreate()");

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.popup_email);
    
    // Find the main textview widget
    textView = (TextView)findViewById(R.id.EmailTextView);
    
    // And the two checkboxes
    includeMsgBox = (CheckBox)findViewById(R.id.EmailMsgBox);
    includeConfigBox = (CheckBox)findViewById(R.id.EmailConfigBox);
    
    // Setup onclick listeners for both buttons
    Button button = (Button) findViewById(R.id.EmailOKBtn);
    button.setOnClickListener(new BtnListener(true));
    button = (Button) findViewById(R.id.EmailCancelBtn);
    button.setOnClickListener(new BtnListener(false));
    
    // Setup everything else
    setup();
  }
  
  @Override
  protected void onNewIntent(Intent intent) {
    setIntent(intent);
    setup();
  }
  
  /**
   * Initialize everything from the current intent
   */
  private void setup() {
    
    // Get current intent and get the important info from it
    Intent intent = getIntent();
    String strType = intent.getStringExtra(EXTRA_TYPE);
    type = EmailType.GENERAL;
    if (strType != null) {
      try {
        type = EmailType.valueOf(strType);
      } catch (Exception ex) {}
    }
    msgId = -1;
    if (type == EmailType.MESSAGE) {
      msgId = intent.getIntExtra(EXTRA_MSG_ID, -1);
    }
    
    // Set the main message dialog text depending on the email request type
    String[] msgTextArry = getResources().getStringArray(R.array.email_devel_text);
    textView.setText(msgTextArry[type.ordinal()]);
  }

  /**
   * Listener class associated with the Send button
   */
  private class BtnListener implements OnClickListener {
    
    private boolean send;
    
    public BtnListener(boolean send) {
      this.send = send;
    }

    @Override
    public void onClick(View v) {
      
      Context context = EmailDeveloperActivity.this;
      
      if (send) {
        sendEmailRequest(context, type, includeMsgBox.isChecked(), msgId, includeConfigBox.isChecked());
      }

      // And finally close the dialog
      if (type == EmailType.INIT_FAILURE) TopExceptionHandler.forceShutdown(context);
      EmailDeveloperActivity.this.finish();
    }
  }
  
  /**
   * Take a snapshot of the current Cadpage log and save it for possible future reporting
   * @param context current context
   * @param title title of snapshot event
   */
  public static void logSnapshot(final Context context, final String title) {
    
    new LogCollector("time", null, "CadPage:V"){
      @Override
      void collectLog(String logBuffer) {
        
        String buffer = 
            "**************************************************************************************\n" +
            "*** " + title +
            "\n**************************************************************************************\n" +
            logBuffer;

        OutputStream os = null; 
        try {
          os = new BufferedOutputStream(context.openFileOutput(LOG_SNAPSHOT_FILENAME, Context.MODE_PRIVATE));
          os.write(buffer.getBytes());
          os.close();
        } catch(IOException ioe) {}
        finally {
          if (os != null) try { os.close(); } catch (IOException ex) {}
        }
      }
    };

  }
  
  public static void sendEmailRequest(final Context context, final EmailType type, 
                                        boolean includeMsg, int msgId,
                                        boolean includeCfg) {
    
    // Build the message text
    StringBuilder body = new StringBuilder();
    
    
    
    // If this is a crash report, include a recorded stack trace
    if (type == EmailType.CRASH || type == EmailType.INIT_FAILURE) {
      TopExceptionHandler.addCrashReport(context, body);
    }
    
    // If message info requested, add that
    String vendorEmail = null;
    if (includeMsg) {
      SmsMmsMessage message;
      if (type == EmailType.MESSAGE) {
        message = SmsMessageQueue.getInstance().getMessage(msgId);
        if (message != null) {
          message.addMessageInfo(context, body);
          vendorEmail = VendorManager.instance().getEmailAddress(message.getVendorCode());
        }
      } else {
        SmsMsgLogBuffer lb = SmsMsgLogBuffer.getInstance();
        if (lb != null) lb.addMessageInfo(context, body);
      }
    }
    
    // If configuration info requested, add that as well
    if (includeCfg) {
      ManagePreferences.addConfigInfo(context, body);
      UserAcctManager acctMgr = UserAcctManager.instance();
      if (acctMgr != null) acctMgr.addAccountInfo(body);
      
      // See if there is any snapshot information to append
      getSnapshotInfo(context, body);
      
    }
    
    final String message = body.toString();
    
    // If config info was requested, include any Cadpage log information
    if (includeCfg) {
      final String vendorEmail2 = vendorEmail;
      new LogCollector("time", null, "CadPage:V"){
        @Override
        void collectLog(String logBuffer) {
          sendEmailRequest(context, type, vendorEmail2,
                           message + 
                           "\n**************************************************************************************\n" +
                           logBuffer);
        }
      };
    } else {
      sendEmailRequest(context, type, vendorEmail, message);
    }
  }
  
  /**
   * Return contents of current log snapshot
   * @param context current context
   * @param body StringBuilder object where snapshot log data will be appended
   */
  private static void getSnapshotInfo(Context context, StringBuilder body) {
    File file = new File(context.getFilesDir().getAbsolutePath() + "/" + LOG_SNAPSHOT_FILENAME);
    if (! file.exists()) return;
    long limit = System.currentTimeMillis() - file.lastModified();
    if (limit > LOG_SNAPSHOT_MAX_AGE) return;
    
    Reader rdr = null;
    try {
      rdr = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
      body.append('\n');
      int chr;
      while ((chr = rdr.read()) != -1) {
        body.append((char)chr);
      }
    } catch (IOException ex) {}
    finally {
      if (rdr != null) try { rdr.close(); } catch (IOException ex) {}
    }
  }

  private static void sendEmailRequest(Context context, EmailType type,
                                         String vendorEmail, String message) {
    
    // If user is a developer, log the message contents.  This helps get
    // the info on emulators where no email clients are available
    // But, we have to surround this with start and end log markers so the log
    // collector won't pick it up and report it a second time
    //
    // Also, since we have started overflowing the maximum single log entry
    // limit and developers are reading the log directly, let's strip out an
    // log information from the message
    if (DeveloperToolsManager.instance().isDeveloper(context)) {
      String msg = message;
      int pt = msg.indexOf("\n********");
      if (pt >= 0) msg = msg.substring(0,pt);
      Log.w(LogCollector.START_MARKER + '\n' + msg + '\n' + LogCollector.END_MARKER);
    }
    
    // Build send email intent and launch it
    Intent intent = new Intent(Intent.ACTION_SEND);
    String[] emailAddr = context.getResources().getStringArray(R.array.email_devel_addr);
    if (vendorEmail != null) {
      List<String> list = new ArrayList<String>();
      list.addAll(Arrays.asList(vendorEmail.split(";")));
      list.addAll(Arrays.asList(emailAddr));
      emailAddr = list.toArray(new String[list.size()]);
    }
    intent.putExtra(Intent.EXTRA_EMAIL, emailAddr);
    String emailSubject = CadPageApplication.getNameVersion() + " " +
        context.getResources().getStringArray(R.array.email_devel_subject)[type.ordinal()];
    intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
    intent.putExtra(Intent.EXTRA_TEXT, message);
    intent.setType("message/rfc822");
    context.startActivity(Intent.createChooser(
        intent, context.getString(R.string.pref_sendemail_title)));
  }
  
  
  /**
   * Launch Email about general request dialog
   * @param context current context
   */
  public static void sendGeneralEmail(Context context) {
    if (DonationManager.instance().isFreeVersion()) {
      sendEmailRequest(context, EmailType.GENERAL, false, 0, false);
    } else {
      sendDeveloperEmail(context, EmailType.GENERAL, 0);
    }
  }
  
  /**
   * Launch Email dialog about specific message request
   * @param context current context
   * @param msgId message ID of specified message
   */
  public static void sendMessageEmail(Context context, int msgId) {
    sendDeveloperEmail(context, EmailType.MESSAGE, msgId);
  }
  
  /**
   * Launch email dialog
   * @param context current context
   * @param type email request type
   * @param msgId message ID associate with MESSAGE type request
   */
  private static void sendDeveloperEmail(Context context, EmailType type, int msgId) {
    Intent intent = buildIntent(context, type, msgId); 
    context.startActivity(intent);
  }
  
  /**
   * Request an Email reporting a CADPage crash
   * @param context current context
   */
  public static void sendCrashEmail(Context context) {
    
    // Launching an intent before throwing a final exception doesn't work
    // Lets schedule an intent launch in 1 second.
    
    AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    Intent intent = buildIntent(context, EmailType.CRASH, 0);
    PendingIntent pendIntent =
      PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);

    long triggerTime = System.currentTimeMillis() + 1000L;
    myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, pendIntent);
  }

  /**
   * Launch Email about initialization failure request dialog
   * @param context current context
   */
  public static void sendInitEmail(Context context) {
    Intent intent = buildIntent(context, EmailType.INIT_FAILURE, 0);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    context.startActivity(intent);
  }
  
  /**
   * Send Email about not having correct user identified as Paypal donator
   * @param context current context
   */
  public static void sendWrongUserEmail(Context context) {
    
    // This one sends a request directly to the email client, without
    // bring up a request screen first.
    sendEmailRequest(context, EmailType.WRONG_USER, false, 0, true);
  }
  
  /**
   * Send Email about user having problems with Market payments
   * @param context current context
   */
  public static void sendMarketProblemEmail(Context context) {
    
    // This one sends a request directly to the email client, without
    // bring up a request screen first.
    sendEmailRequest(context, EmailType.MARKET_PROBLEM, false, 0, true);
  }
  
  /**
   * Send Email about user requesting break on payments
   * @param context current context
   */
  public static void sendSobStoryEmail(Context context) {
    
    // This one sends a request directly to the email client, without
    // bring up a request screen first.
    sendEmailRequest(context, EmailType.SOB_STORY, false, 0, true);
  }

  /**
   * Construct an Intent to launch a Email dialog
   * @param context current context
   * @param type requested message type
   * @param msgId If message request, contains the message ID of requested message
   * @return The new intent
   */
  private static Intent buildIntent(Context context, EmailType type, int msgId) {
    Intent intent = new Intent(context, EmailDeveloperActivity.class);
    intent.putExtra(EXTRA_TYPE, type.toString());
    if (type == EmailType.MESSAGE) intent.putExtra(EXTRA_MSG_ID, msgId);
    return intent;
  }
}
