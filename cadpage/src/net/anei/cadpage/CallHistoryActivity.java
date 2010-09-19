package net.anei.cadpage;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class CallHistoryActivity extends ListActivity {
  
  private static final String EXTRA_INCOMING_MSG = "CallHistoryActivity.MESSAGE";
  
  private SmsMessageQueue msgQueue;

  /* (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    // Reload existing message queue
    msgQueue = new SmsMessageQueue(this);
    
    // Set up list heading
    TextView tv = new TextView(this);
    tv.setText(R.string.call_history);
    getListView().addHeaderView(tv);
    
    // Set up message queue list adapter
    setListAdapter(msgQueue.listAdapter(this));
    
    startup();
  }
  

  /* (non-Javadoc)
   * @see android.app.Activity#onNewIntent(android.content.Intent)
   */
  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    
    startup();
  }
  
  /**
   * Perform initial intent processing logic
   * whether called from onCreate or onNewIntent
   */
  private void startup() {
    Intent intent = getIntent();
    
    
    // If there is an incoming message in this intent, retrieve it, add it
    // to our message queue, and determine if if should popup the display
    boolean process = true;
    if (intent.getBooleanExtra(EXTRA_INCOMING_MSG, false)) {
      SmsMmsMessage msg = new SmsMmsMessage(this, intent);
      if (msg != null) {
        msgQueue.addNewMsg(msg);
        ManageNotification.show(this, msg);
        
        process = isPopup();
      }
    }
    
    // If there isn't an incoming message, this was presumably launched
    // through some kind of user interaction, which means it is time to clear
    // the notification
    else {
      ManageNotification.clear(this);
    }
    
    // we aren't supposed to display anything for this intent, shut us down now
    if (!process) {
      finish();
      return;
    }
    
    // If there is one and only one unread message in the queue, launch a 
    // message popup to display it
    SmsMmsMessage msg = msgQueue.getDisplayMsg();
    if (msg != null) {
      
      // Flag message read
      msg.setRead(true);
      SmsMessageQueue.dataChange();
      SmsPopupActivity.launchActivity(this, msg);
    }
  }


  private boolean isPopup() {

    // Whether or not the popup should only show when keyguard is on
    boolean onlyShowOnKeyguard = ManagePreferences.onlyShowOnKeyguard();

    // Fetch call state, if the user is in a call or the phone is ringing we don't want to show the popup
    TelephonyManager mTM = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    boolean callStateIdle = mTM.getCallState() == TelephonyManager.CALL_STATE_IDLE;

    // Initialize keyguard manager
    ManageKeyguard.initialize(this);

    /*
     * If popup is enabled for this user -AND- the user is not in a call -AND-
     * -AND- phone is not docked -AND-
     * (screen is locked -OR- (setting is OFF to only show on keyguard -AND- user is not in messaging app:
     * then show the popup activity, otherwise check if notifications are on and just use the standard
     * notification))
     * DB -removed Docked check. We want alert on docked
     */
    return (callStateIdle && 
             (ManageKeyguard.inKeyguardRestrictedInputMode() || !onlyShowOnKeyguard));
  }


  /* (non-Javadoc)
   * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.history_menu, menu);
    
    return true;
  }

  /* (non-Javadoc)
   * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
   */
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
    case R.id.settings_item:
      Intent intent = new Intent(this, SmsPopupConfigActivity.class);
      startActivity(intent);
      return true;
    case R.id.exit_item:
    	this.finish();
    	return true;
    	
    default:
        return super.onOptionsItemSelected(item);
    }
  }

  /**
   * Launch activity with new message
   */
  public static void launchActivity(Context context, SmsMmsMessage message) {
    Intent intent = getLaunchIntent(context);
    message.addToIntent(intent);
    intent.putExtra(EXTRA_INCOMING_MSG, true);
    context.startActivity(intent);
  }

  /**
   * Build intent to launch this activity
   * @param context
   * @return
   */
  public static Intent getLaunchIntent(Context context) {
    Intent intent = new Intent(context, CallHistoryActivity.class);
    int flags =
      Intent.FLAG_ACTIVITY_NEW_TASK |
      Intent.FLAG_ACTIVITY_SINGLE_TOP |
      Intent.FLAG_ACTIVITY_CLEAR_TOP;
    intent.setFlags(flags);
    return intent;
  }
}
