package net.anei.cadpage.donation;

import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;

public abstract class DonateScreenBaseEvent extends DonateEvent {
  
  private int textId;
  private int layout;

  protected DonateScreenBaseEvent(AlertStatus alertStatus, int titleId, int textId,
                                   int layout) {
    super(alertStatus, titleId);
    registerScreenEvent(this);
    this.textId = textId;
    this.layout = layout;
  }

  /**
   * Called to create the associated Donate activity
   * @param activity new activity being created
   */
  public void create(final Activity activity) {

    activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    activity.setContentView(layout);
    
    // Set heading color if appropriate
    TextView view = (TextView)activity.findViewById(R.id.DonateStatusView);
    setTextColor(view);
    
    // Set up main box text and color
    view = (TextView)activity.findViewById(R.id.DonateTextView);
    view.setText(activity.getString(textId, getTextParms(PARM_TEXT)));
    setTextColor(view);
  }

  @Override
  protected void doEvent(Activity activity) {
    DonateActivity.launchActivity(activity, this);
  }

  /**
   * Create dialog in response to showDialog call
   * @param id ID code passed to showDialog
   * @return created dialog
   */
  public Dialog createDialog(Activity activity, int id) {
    return new AlertDialog.Builder(activity)
        .setIcon(R.drawable.ic_launcher)
        .setTitle(R.string.pref_payment_status_title)
        .setMessage(id)
        .setPositiveButton(R.string.donate_btn_done, null)
        .show();
  }
  
  // Map use to identify Screen events by classname
  private static Map<String, DonateScreenBaseEvent> screenEventMap = 
      new HashMap<String, DonateScreenBaseEvent>();
  
  /**
   * Register a Donate screen event for future retrieval
   * @param event Event to be registered
   */
  private static void registerScreenEvent(DonateScreenBaseEvent event) {
    screenEventMap.put(event.getClass().getName(), event);
  }
  
  /**
   * Retrieve a registered Donate screen event
   * @param classname class name of registered event
   * @return registered donate screen event
   */
  public static DonateScreenBaseEvent getScreenEvent(String classname) {
    
    // Very rarely, we will called before the registration map has been initialized
    // How this can happen is not entirely clear, but by coding a reference to the
    // main donation event, we can pretty much assure that everything has been
    // instantiated which will set up the class map.
    MainDonateEvent.instance();
    
    // Except for Vendor1Event which isn't in the main menu.   So we will invoke it
    // as well
    Vendor1Event.instance();
    
    DonateScreenBaseEvent event = screenEventMap.get(classname);
    if (event == null) {
      StringBuilder sb = new StringBuilder("No Event registered for " + classname);
      sb.append("Registered Classes:\n");
      for (String key : screenEventMap.keySet()) {
        sb.append("\n" + key);
      }
      throw new RuntimeException(sb.toString());
    }
    return event;
  }

}
