package net.anei.cadpage.donation;

import android.app.Activity;
import android.graphics.Color;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class handles a donation event triggered by an outside event.  Typically
 * this will be a button press in another donation dialog menu, but it could
 * also be a preference selection, or a triggered donation status check
 */

public abstract class DonateEvent {
  
  // Different alert status codes
  public enum  AlertStatus {GREEN, YELLOW, RED};
  
  private AlertStatus alertStatus;
  private int titleId;
  
  // Array of colors corresponding to alert codes
  private static final int[] ALERT_COLORS = new int[]{
    Color.GREEN, Color.YELLOW, Color.RED
  };
  
  /**
   * Constructor
   * @param alertStatus  alert status
   * @param titleId resource Id of main title
   */
  protected DonateEvent(AlertStatus alertStatus, int titleId) {
    this.alertStatus = alertStatus;
    this.titleId = titleId;
  }
  
  /**
   * Get any parameters associated with any display strings
   */
  protected final static int PARM_TITLE = 0;
  protected final static int PARM_TEXT = 1;
  protected Object[] getTextParms(int type) {
    return null;
  }
  
  /**
   * Called when an event needs to be performed
   * @param activity current context
   */
  abstract protected void doEvent(Activity activity);
  
  /**
   * @return true if event is enabled
   */
  public boolean isEnabled() {
    return true;
  }
  
  /**
   * Set up the root donation status preference for this event, only if it
   * is enabled
   * @param activity current context
   * @param pref preference to be set up
   * @return true if this preference was set up for this event
   */
  public boolean setPreference(Activity activity, Preference pref) {
    
    // If not enabled, return now
    if (!isEnabled()) return false;
    
    // Set up preference to display the regular title and our specific
    // summary in the appropriate color
    String title = pref.getTitle().toString();
    pref.setTitle(setAlertColor(title));
    
    title = activity.getString(titleId, getTextParms(PARM_TITLE));
    pref.setSummary(setAlertColor(title));

    // Set up a preference clicked listener
    final Activity act = activity;
    pref.setOnPreferenceClickListener(new OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {
        doEvent(act);
        return true;
      }});
    
    // And we are done
    return true;
  }
  
  /**
   * Construct spannable text setting up alert status foreground color
   * @param input test string to be colored
   * @return spannable text of input string with appropriate alert foreground color
   */
  private CharSequence setAlertColor(CharSequence input) {
    if (alertStatus == null) return input;
    int color = ALERT_COLORS[alertStatus.ordinal()];
    SpannableString span = new SpannableString(input);
    span.setSpan(new ForegroundColorSpan(color), 0, input.length(), 0);
    return span;
  }
  
  /**
   * Add a control button for this event to a view group, only if this event
   * is enabled
   * @param activity current context
   * @param parent ViewGroup to which button should be added
   * @return true if button was added to group
   */
  public boolean addButton(Activity activity, ViewGroup parent) {
    
    // If event is not enabled, bail out here
    if (!isEnabled()) return false;
    
    // Create new button with correct color and title message
    final Activity act = activity;
    Button button = new Button(activity);
    button.setText(activity.getString(titleId, getTextParms(PARM_TITLE)));
    
    // Set up button clicked listener to call our doEvent method
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        doEvent(act);
      }
    });
    
    // Add button to parent view and we are finished
    parent.addView(button);
    return true;
  }
  
  /**
   * Set a text view foreground color to indicated status color
   * @param view view to be set
   */
  protected void setTextColor(TextView view) {
    if (alertStatus != null) view.setTextColor(ALERT_COLORS[alertStatus.ordinal()]);
  }

  /**
   * Set up an already existing button with the current donation status
   * @param activity current activity
   * @param button button to be set up
   * @return true if button was set up, false otherwise
   */
  public boolean setButton(final Activity activity, Button button) {
    if (!isEnabled()) return false;
    String title = activity.getString(titleId, getTextParms(PARM_TITLE));
    button.setText(setAlertColor(title));
    
    // Set up button clicked listener to call our doEvent method
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        doEvent(activity);
      }
    });
    
    // Green status buttons can disappear, everything else should be visible
    button.setVisibility(alertStatus == null || alertStatus == AlertStatus.GREEN ? View.GONE : View.VISIBLE);
    return true;
  }
  
  /**
   * Close all donation events and recalculate the donation status
   * @param activity activity that launched this event
   */
  protected void closeEvents(Activity activity) {
    MainDonateEvent.instance().refreshStatus();
    activity.setResult(Activity.RESULT_OK);
    activity.finish();
    
  }
}
