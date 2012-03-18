package net.anei.cadpage;

import net.anei.cadpage.billing.BillingManager;
import net.anei.cadpage.donation.DonationManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class CallHistoryActivity extends ListActivity {
  
  private static final String EXTRA_MSG_ID = "net.anei.cadpage.CallHistoryActivity.MSG_ID";
  
  private static final int RELEASE_DIALOG = 1;
  
  // keep track of which message text view has opened a context menu
  private HistoryMsgTextView msgTextView = null;

  /* (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.v("CallaHistoryActivity.onCreate()");
    
    Log.w("CallHistoryActivity.onCreate()");
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) {
      finish();
      return;
    }
    
    // Initialize billing manager
    BillingManager.instance().initialize(this);
    
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

  @Override
  protected void onDestroy() {
    BillingManager.instance().destroy();
    super.onDestroy();
  }


  /* (non-Javadoc)
   * @see android.app.Activity#onNewIntent(android.content.Intent)
   */
  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    Log.v("CallHistoryActivity.onNewIntent()");
    
    Log.w("CallHistoryActivity.onNewIntent()");
    
    startup();
  }
  
  /**
   * Perform initial intent processing logic
   * whether called from onCreate or onNewIntent
   */
  private void startup() {
    Intent intent = getIntent();
    
    // Log intent for debug purposes
    ContentQuery.dumpIntent(intent);

    // We do some special processing if the intent was launched by the user
    // instead of through some internal trigger.
    if (Intent.ACTION_MAIN.equals(intent.getAction()) && 
        intent.hasCategory(Intent.CATEGORY_LAUNCHER)) {
      
      // First clear any pending notification
      ManageNotification.clear(this);
      
      // Second, launch the release info dialog if it hasn't already been displayed
      String release = getString(R.string.release_version);
      if (! ManagePreferences.release().equals(release)) {
        ManagePreferences.setRelease(release);
        showDialog(RELEASE_DIALOG);
      }
    }
    
    // If popup is enabled, and there is a message ID passed from SmsReceiver
    // launch a message popup to display it
    else {
      int msgId = intent.getIntExtra(EXTRA_MSG_ID, 0);
      if (msgId > 0)  SmsPopupActivity.launchActivity(this, msgId);
    }
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    switch (id) {

      case RELEASE_DIALOG:
        int releaseId = (DonationManager.instance().isFreeVersion() ? R.string.free_release_text : R.string.release_text);
        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.release_title)
        .setMessage(releaseId)
        .setPositiveButton(android.R.string.ok, null)
        .create();
    }
    return super.onCreateDialog(id);
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

  /* (non-Javadoc)
   * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu.ContextMenuInfo)
   */
  @Override
  public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, view, menuInfo);

    msgTextView = (HistoryMsgTextView)view;
    MsgOptionManager optMgr = new MsgOptionManager(this, msgTextView.getMessage());
    optMgr.createMenu(menu, false);
    optMgr.prepareMenu(menu);
  }


  /* (non-Javadoc)
   * @see android.app.Activity#onContextItemSelected(android.view.MenuItem)
   */
  @Override
  public boolean onContextItemSelected(MenuItem item) {
    
    if (msgTextView != null) {
      SmsMmsMessage msg = msgTextView.getMessage();
      if (msg != null) {
        if (new MsgOptionManager(this, msg).menuItemSelected(item.getItemId(), false)) return true;
      }
    }
    return super.onContextItemSelected(item);
  }

  /**
   * Launch activity
   */
  public static void launchActivity(Context context, SmsMmsMessage message) {
    Intent intent = getLaunchIntent(context, message);
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
    
    Log.v("CallHistoryActivity Launching....");
    ContentQuery.dumpIntent(intent);
    
    context.startActivity(intent);
  }

  /**
   * Build intent to launch this activity
   * @param context
   * @return
   */
  public static Intent getLaunchIntent(Context context) {
    return getLaunchIntent(context, null);
  }
  
  /**
   * Build intent to launch this activity
   * @param context
   * @param message
   * @return
   */
  public static Intent getLaunchIntent(Context context, SmsMmsMessage message) {
    Intent intent = new Intent(context, CallHistoryActivity.class);
    int flags =
      Intent.FLAG_ACTIVITY_NEW_TASK |
      Intent.FLAG_ACTIVITY_SINGLE_TOP |
      Intent.FLAG_ACTIVITY_CLEAR_TOP;
    intent.setFlags(flags);
    if (message != null) {
      intent.putExtra(EXTRA_MSG_ID, message.getMsgId());
    }
    return intent;
  }
}
