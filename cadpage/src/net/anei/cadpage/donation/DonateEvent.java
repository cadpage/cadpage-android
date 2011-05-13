package net.anei.cadpage.donation;

import java.util.Date;

import android.content.Context;
import android.graphics.Color;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
  protected Object[] getTextParms(int type) {
    return null;
  }
  
  /**
   * Called when an event needs to be performed
   * @param ctx current context
   */
  abstract protected void doEvent(Context ctx);
  
  
  private int getAlertColor() {
    return ALERT_COLORS[alertStatus.ordinal()];
  }
  
  /**
   * @return true if event is enabled
   */
  public boolean isEnabled() {
    return true;
  }
  
  /**
   * Set up the root donation status preference for this event, only if it
   * is enabled
   * @param context current context
   * @param pref preference to be set up
   * @return true if this preference was set up for this event
   */
  public boolean setPreference(Context context, Preference pref) {
    
    // If not enabled, return now
    if (!isEnabled()) return false;
    
    // Set up preference to display the regular title and our specific
    // summary in the appropriate color
    int color = getAlertColor();
    String title = pref.getTitle().toString();
    SpannableString span = new SpannableString(title);
    span.setSpan(new ForegroundColorSpan(color), 0, title.length(), 0);
    pref.setTitle(span);
    
    title = context.getString(titleId, getTextParms(PARM_TITLE));
    span = new SpannableString(title);
    span.setSpan(new ForegroundColorSpan(color), 0, title.length(), 0);
    pref.setSummary(span);

    // Set up a preference clicked listener
    final Context ctx = context;
    pref.setOnPreferenceClickListener(new OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {
        doEvent(ctx);
        return true;
      }});
    
    // And we are done
    return true;
  }
  
  /**
   * Add a control button for this event to a view group, only if this event
   * is enabled
   * @param context current context
   * @param parent ViewGroup to which button should be added
   * @return true if button was added to group
   */
  public boolean addButton(Context context, ViewGroup parent) {
    
    // If event is not enabled, bail out here
    if (!isEnabled()) return false;
    
    // Create new button with correct color and title message
    final Context ctx = context;
    Button button = new Button(context);
    button.setTextColor(getAlertColor());
    button.setText(context.getString(titleId, getTextParms(PARM_TITLE)));
    
    // Set up button clicked listenter to call our doEvent method
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        doEvent(ctx);
      }
    });
    
    // Add button to parent view and we are finished
    parent.addView(button);
    return true;
  }
  
  /**
   * Convenience method to calculate number of days elapsed since base date
   * @param date base date
   * @return number of days since the base date
   */
  public static int elapsedDaysSince(Date date) {
    return elapsedDaysSince(date, new Date());
  }
  
  /**
   * Convenience method to calculate number of days elapsed between to dates
   * @param date1 from date
   * @param date2 to date
   * @return number of days between from date and to date, can be negative
   */
  public static int elapsedDaysSince(Date date1, Date date2) {
    // Quick dirty, and wrong, but will do for now
    long days = date2.getTime() - date1.getTime();
    return (int)(days/1000/60/60/24);
  }

}
