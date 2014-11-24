package net.anei.cadpage;

import net.anei.cadpage.donation.DonateActivity;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.Vendor1Event;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.WindowManager;
import android.widget.TextView;

public class CallHistoryActivity extends ListActivity {
  
  private static String EXTRA_NOTIFY = "net.anei.cadpage.CallHistoryActivity.NOTIFY";
  private static String EXTRA_SHUTDOWN = "net.anei.cadpage.CallHistoryActivity.SHUTDOWN";
  private static String EXTRA_POPUP = "net.anei.cadpage.CallHistoryAcivity.POPUP";
  
  private static final int RELEASE_DIALOG = 1;
  
  // keep track of which message text view has opened a context menu
  private HistoryMsgTextView msgTextView = null;
  
  private static CallHistoryActivity mainActivity = null;

  /* (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    if (Log.DEBUG) Log.v("CallHistoryActivity: onCreate()");
    super.onCreate(savedInstanceState);
    
    mainActivity = this;
    
    // If initialization failure in progress, shut down without doing anything
    if (TopExceptionHandler.isInitFailure()) {
      finish();
      return;
    }
    
    // Apparently only an activity can calculate the total screen size.
    // So do it now and save it in preferences so it will be included in
    // generated emails
    DisplayMetrics displaymetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    int height = displaymetrics.heightPixels;
    int width = displaymetrics.widthPixels;
    ManagePreferences.setScreenSize(""+width+"X"+height);
    
    // If preferences have never been initialized, bring up the preference
    // screen to initialize them now.  This is necessary because the new
    // preference retrieval logic throws an exception if any requested preference
    // hasn't been initialized.
    if (! ManagePreferences.initialized()) {
      Intent intent = new Intent(this, SmsPopupConfigActivity.class);
      startActivity(intent);
    }
    
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    
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
    
    // Log intent for debug purposes
    Log.v("CallHistoryActivity.startup()");
    ContentQuery.dumpIntent(intent);
    
    // If this is a shutdown request, that is as far as we need to go
    if (intent.getBooleanExtra(EXTRA_SHUTDOWN, false)) {
      finish();
      return;
    }

    // We do some special processing if the intent was launched by the user
    // instead of through some internal trigger.
    if (Intent.ACTION_MAIN.equals(intent.getAction()) && 
        intent.hasCategory(Intent.CATEGORY_LAUNCHER) &&
        (intent.getFlags() & Intent.FLAG_FROM_BACKGROUND) == 0) {
      
      // First clear any pending notification
      ClearAllReceiver.clearAll(this);
      
      // Second, launch the release info dialog if it hasn't already been displayed
      String release = getString(R.string.release_version);
      if (! ManagePreferences.release().equals(release)) {
        ManagePreferences.setRelease(release);
        showDialog(RELEASE_DIALOG);
      }
      
      // If not, see if we have discovered a direct page vendor sending us text pages
      else {
        Vendor1Event event = Vendor1Event.instance();
        if (event.isEnabled()) DonateActivity.launchActivity(this, event, null);

      }
    }
    
    // Otherwise, if we should automatically display a call, do it now
    else {
      boolean force = intent.getBooleanExtra(EXTRA_POPUP, false);
      SmsMmsMessage msg = SmsMessageQueue.getInstance().getDisplayMessage(force);
      if (msg != null)  {
        
        // Before we open the call display window, see if notifications were requested
        // And if they were, see if we should launch the Scanner channel open.
        // We can't do this in the Broadcast Receiver because this window obscures it
        // completely, so their Activity won't launch.
        
        if (intent.getBooleanExtra(EXTRA_NOTIFY, false)) {
          ManageNotification.show(this, msg);
          SmsReceiver.launchScanner(this);
        }
     
        // OK, go ahead and open the call display window
        // Delay by 100 msecs in attempt to avoid a nasty badtokenException.
        final Activity context = this;
        final int msgId = msg.getMsgId();
        new Handler().postDelayed(new Runnable(){
          @Override
          public void run() {
            // TODO Auto-generated method stub
            
          }}, 100);
        if (!context.isFinishing()) {
          if (Log.DEBUG) Log.v("CallHistoryActivity Auto launch SmsPopup for " + msgId); 
          SmsPopupActivity.launchActivity(context, msgId);
        }
      }
    }
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    
    if (isFinishing()) return null;
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
  
  private boolean activityActive = false;

  @Override
  protected void onStart() {
    if (Log.DEBUG) Log.v("CallHistoryActivity: onStart()");
    super.onStart();
  }

  @Override
  protected void onStop() {
    if (Log.DEBUG) Log.v("CallHistoryActivity: onStop()");
    super.onStop();
  }

  @Override
  protected void onResume() { 
    if (Log.DEBUG) Log.v("CallHistoryActivity: onResume()");
    super.onResume(); 
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    activityActive = true; 
  } 
  
  protected void onPause() {
    if (Log.DEBUG) Log.v("CallHistoryActivity: onPause()");
    super.onPause(); 
    activityActive = false; 
  } 
  
  public boolean onKeyUp(int keyCode, KeyEvent event)  { 
    if (!activityActive) return false;
    return super.onKeyUp(keyCode, event);
  } 
  
  public boolean onKeyDown(int keyCode, KeyEvent event) { 
    if (!activityActive) return false;
    return super.onKeyDown(keyCode, event);
  }
  
  @Override
  protected void onSaveInstanceState(Bundle outState) {

    outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
    super.onSaveInstanceState(outState);

//    int orientation = Safe40Activity.getDisplayOrientation(this);
    
    //Lock the screen orientation to the current display orientation : Landscape or Portrait
//    this.setRequestedOrientation(orientation);
  }
  
  @Override
  protected void onDestroy() {
    mainActivity = null;
    super.onDestroy();
  }

  /**
   * Launch activity
   */
  public static void launchActivity(Context context, boolean notify) {
    Intent intent = getLaunchIntent(context);
    if (notify) intent.putExtra(EXTRA_NOTIFY, true);
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
    
    context.startActivity(intent);
  }
  
  /**
   * Build intent to launch this activity
   * @param context current context
   * @return Intent that will launch Cadpage
   */
  public static Intent getLaunchIntent(Context context) {
    return getLaunchIntent(context, false);
  }
  
  /**
   * Build intent to launch this activity
   * @param context current context
   * @param force force detail popup window
   * @return Intent that will launch Cadpage
   */
  public static Intent getLaunchIntent(Context context, boolean force) {
    Intent intent = new Intent(context, CallHistoryActivity.class);
    int flags =
      Intent.FLAG_ACTIVITY_NEW_TASK |
      Intent.FLAG_ACTIVITY_SINGLE_TOP |
      Intent.FLAG_ACTIVITY_CLEAR_TOP;
    intent.setFlags(flags);
    if (force) intent.putExtra(EXTRA_POPUP, true);
    return intent;
  }

  /**
   * Called by active context to shut down the main application
   * @param context current context
   */
  public static void shutdown(Context context) {
    Intent intent = new Intent(context, CallHistoryActivity.class);
    intent.putExtra(EXTRA_SHUTDOWN, true);
    context.startActivity(intent);
  }
  
  /**
   * @returns main call history activity
   */
  public static CallHistoryActivity getMainActivity() {
    return mainActivity;
  }
}
