package net.anei.cadpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Class handles the dialog popup requesting information be sent to developers
 */
public class TrackingPromptActivity extends Safe40Activity {
  
  private final static String EXTRA_PREFIX="net.anei.cadpage.EmailDeveloperActivity.";
  private final static String EXTRA_URL = EXTRA_PREFIX + "URL";
  private final static String EXTRA_DURATION = EXTRA_PREFIX + "DURATION";
  private final static String EXTRA_MIN_DIST = EXTRA_PREFIX + "MIN_DIST";
  private final static String EXTRA_MIN_TIME = EXTRA_PREFIX + "MIN_TIME";

  /**
   * Create new email dialog activity
   */
  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    if (Log.DEBUG) Log.v("TrackingPromptActivity: onCreate()");

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.tracking_prompt);
    
    Intent intent = getIntent();
    final String url = intent.getStringExtra(EXTRA_URL);
    if (url == null) {
      finish();
      return;
    }
    final int duration = intent.getIntExtra(EXTRA_DURATION, 10);
    final int minDist = intent.getIntExtra(EXTRA_MIN_DIST, 10);
    final int minTime = intent.getIntExtra(EXTRA_MIN_TIME, 10);
    
    final CheckBox rememberBox = (CheckBox)findViewById(R.id.TrackingRememberBox);
    
    // Setup onclick listeners for both buttons
    Button button = (Button) findViewById(R.id.TrackingYesBtn);
    button.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View view) {
        if (rememberBox.isChecked()) ManagePreferences.setReportPosition("Y");
        TrackingService.addLocationRequest(TrackingPromptActivity.this, url, duration, minDist, minTime);
        finish();
      }
    });
    
    button = (Button) findViewById(R.id.TrackingNoBtn);
    button.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View view) {
        if (rememberBox.isChecked()) ManagePreferences.setReportPosition("N");
        finish();
      }
    });
  }
  
  /**
   * Handle server request to start position tracking.  Method check to see what user has permitted, possibly prompting user for
   * permission, before passing request on to TrackignService
   * @param context current context
   * @param url position reporting URL
   * @param duration reporting duration in minutes
   * @param minDist minimum reporting distance interval in meters
   * @param minTime minimum reporting time interval in seconds
   */
  static public void addLocationRequest(Context context, String url, int duration, int minDist, int minTime) {
    String opt = ManagePreferences.reportPosition();
    if (opt.equals("Y")) {
      TrackingService.addLocationRequest(context, url, duration, minDist, minTime);
    } else if (!opt.equals("N")) {
      Intent intent = new Intent(context, TrackingPromptActivity.class);
      intent.putExtra(EXTRA_URL, url);
      intent.putExtra(EXTRA_DURATION, duration);
      intent.putExtra(EXTRA_MIN_DIST, minDist);
      intent.putExtra(EXTRA_MIN_TIME, minTime);
      context.startActivity(intent);
    }
  }
}
