package net.anei.cadpage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import net.anei.cadpage.donation.DonateActivity;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.VendorEvent;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
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
  private static String EXTRA_POPUP = "net.anei.cadpage.CallHistoryActivity.POPUP";
  private static String EXTRA_MSG_ID = "net.anei.cadpage.CallHistoryActivity.MSG_ID";
  
  private static final int RELEASE_DIALOG = 1;
  private static final int CONFIRM_DELETE_ALL_DIALOG = 2;
  private static final int PLAY_SERVICES_REQUEST_DIALOG = 3;
  
  private PermissionManager permMgr = new PermissionManager(this);

  // keep track of which message text view has opened a context menu
  private HistoryMsgTextView msgTextView = null;
  
  private static CallHistoryActivity mainActivity = null;
  
  private static int lockMsgId = -1;

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
    
    ManagePreferences.setPermissionManager(permMgr);
    ManagePreferences.checkInitialPermissions();
    
    // Apparently only an activity can calculate the total screen size.
    // So do it now and save it in preferences so it will be included in
    // generated emails
    DisplayMetrics displaymetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    int height = displaymetrics.heightPixels;
    int width = displaymetrics.widthPixels;
    ManagePreferences.setScreenSize(""+width+"X"+height);
    
    if (!ManagePreferences.useOldGcm()) {
      int resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
      if (resultCode != ConnectionResult.SUCCESS) {
        if (GoogleApiAvailability.getInstance().isUserResolvableError(resultCode)) {
          Log.w("Google Play Services Recoverable error: " + resultCode);
          GoogleApiAvailability.getInstance().getErrorDialog(this, resultCode, PLAY_SERVICES_REQUEST_DIALOG).show();
        } else {
          Log.w("Google Play Services are not available: " + resultCode);
        }
      }
    }
    
    // If preferences have never been initialized, bring up the preference
    // screen to initialize them now.  This is necessary because the new
    // preference retrieval logic throws an exception if any requested preference
    // hasn't been initialized.  (We get a way with calling useOldGcm() above
    // because it returns a boolean result)
    if (! ManagePreferences.initialized()) {
      SmsPopupConfigActivity.initializePreferences(this);
    }
    
    // If the screen is locked, we  would like both the call history and call detail
    // screens to override the lock screen.  This works fine up until Android 5.0
    // at which point it seems that only one window is allowed to override the
    // lock screen at any time.  So at that level we supress locking the main
    // screen so the detail screen will be visible.
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | 
                           WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
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
    
    // Log intent for debug purposes
    Log.v("CallHistoryActivity.startup()");
    ContentQuery.dumpIntent(intent);
    
    // We have an occasional problem when an old intent is sent with the
    // intent of restoring the Cadpage display.  But has several unfortunate
    // side effects like immediately cancelling the wake lock
    // Solution - when were were started with the intent of displaying a new
    // message, ignore all extraneous intents until we find the one that
    // displays the new page
    int msgId = intent.getIntExtra(EXTRA_MSG_ID, -1);
    if (msgId != lockMsgId) {
      Log.v("Discarding spurious intent");
      return;
    }
    lockMsgId = -1;
    
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
      String oldRelease = ManagePreferences.release();
      String release = CadPageApplication.getVersion();
      if (!release.equals(oldRelease)) { 
        ManagePreferences.setRelease(release);
        if (! trimRelease(release).equals(trimRelease(oldRelease))) {
          showDialog(RELEASE_DIALOG);
        }
      }
      
      // If not, see if we have discovered a direct page vendor sending us text pages
      else {
        VendorEvent event = VendorEvent.instance(1);
        if (event.isEnabled()) DonateActivity.launchActivity(this, event, null);

      }
    }
    
    // Otherwise, if we should automatically display a call, do it now
    else {
      SmsMmsMessage msg = null;
      if (msgId >= 0) {
        msg = SmsMessageQueue.getInstance().getMessage(msgId);
      } else {
        boolean force = intent.getBooleanExtra(EXTRA_POPUP, false);
        msg = SmsMessageQueue.getInstance().getDisplayMessage(force);
      }
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
        msgId = msg.getMsgId();
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

  /**
   * Trim off everything beyond the first 3 components of the release version
   * @param release release version
   * @return trimmed release version
   */
  private String trimRelease(String release) {
    int dotCnt = 0;
    int col = 0;
    while (col < release.length()) {
      char chr = release.charAt(col);
      if (chr == '.') {
        if (++dotCnt >= 3) break;
      }
      else if (chr >= 'A' && chr <= 'Z') break;
      col++;
    }
    return release.substring(0,col);
  }

  @Override
  protected Dialog onCreateDialog(int id, Bundle bundle) {
    
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
        
      case CONFIRM_DELETE_ALL_DIALOG:
        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.confirm_delete_all_title)
        .setMessage(R.string.confirm_delete_all_text)
        .setPositiveButton(R.string.yes, new OnClickListener(){
          @Override
          public void onClick(DialogInterface dialog, int which) {
            SmsMessageQueue.getInstance().clearAll();
          }})
        .setNegativeButton(R.string.no, null)
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
      
    case R.id.markallopened_item:
      msgQueue.markAllRead();
      return true;
      
    case R.id.clearall_item:
      showDialog(CONFIRM_DELETE_ALL_DIALOG);
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
  }
  
  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] granted) {
    ManagePreferences.onRequestPermissionsResult(requestCode, permissions, granted);
  }
  
  @Override
  protected void onDestroy() {
    mainActivity = null;
    ManagePreferences.releasePermissionManager(permMgr);
    super.onDestroy();
  }

  /**
   * Launch activity
   */
  public static void launchActivity(Context context, boolean notify, SmsMmsMessage msg) {
    Intent intent = getLaunchIntent(context);
    if (notify) intent.putExtra(EXTRA_NOTIFY, true);
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
    if (msg != null) {
      lockMsgId = msg.getMsgId();
      intent.putExtra(EXTRA_MSG_ID, lockMsgId);
    }
    
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
