package net.anei.cadpage;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class CallHistoryActivity extends ListActivity {
  
  private static final String EXTRA_AUTOLAUNCH = "CallHistoryActivity.AUTO_LAUNCH";

  /* (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    // If preferences have never been initialized, bring up the preference
    // screen to initialize them now.  This is necessary because the new
    // preference retrieval logic throws an exception if any requested preference
    // hasn't been initialized.
    if (! ManagePreferences.initialized()) {
      Intent intent = new Intent(this, SmsPopupConfigActivity.class);
      startActivity(intent);
    }
    
    // Set up list heading
    TextView tv = new TextView(this);
    tv.setText(R.string.call_history);
    getListView().addHeaderView(tv);
    
    // Set up message queue list adapter
    setListAdapter(SmsMessageQueue.getInstance().listAdapter(this));
    
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
    
    SmsMessageQueue msgQueue = SmsMessageQueue.getInstance();

    // If this intent was not flagged as being generated internally, then it 
    // presumably was launched through some kind of user interaction, 
    // which means it is time to clear any pending notification
    if (intent.getBooleanExtra(EXTRA_AUTOLAUNCH, false)) {
      ManageNotification.clear(this);
    }
    
    // If popup is enabled, and there is one and only one unread message in the
    // queue, launch a message popup to display it
    SmsMmsMessage msg = msgQueue.getDisplayMsg();
    if (msg != null) SmsPopupActivity.launchActivity(this, msg);
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
	  SmsMessageQueue msgQueue = SmsMessageQueue.getInstance();
    switch (item.getItemId()) {
    case R.id.settings_item:
      Intent intent = new Intent(this, SmsPopupConfigActivity.class);
      startActivity(intent);
      return true;
    case R.id.clearall_item:
    	msgQueue.clearAll();
    	return true;
    case R.id.exit_item:
    	this.finish();
    	return true;
    	
    default:
        return super.onOptionsItemSelected(item);
    }
  }

  /**
   * Launch activity
   */
  public static void launchActivity(Context context, SmsMmsMessage message) {
    Intent intent = getLaunchIntent(context);
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
