package net.anei.cadpage.donation;

import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public abstract class DonateScreenBaseEvent extends DonateEvent {
  
  private int titleId;
  private int textId;
  private int layout;

  protected DonateScreenBaseEvent(AlertStatus alertStatus, int titleId, int textId,
                                   int layout) {
    super(alertStatus, titleId);
    registerScreenEvent(this);
    this.titleId = titleId;
    this.textId = textId;
    this.layout = layout;
  }
  
  protected boolean overrideWindowTitle() {
    return false;
  }

  /**
   * Called to create the associated Donate activity
   * @param activity new activity being created
   * @param msg message associated with this event
   */
  public void create(final Activity activity, SmsMmsMessage msg) {
    
    // Double check that event is still enabled.
    // It isn't that we really worry about showing an inappropriate display
    // as we are making sure that isEnabled has been called for this activity
    // as it sometimes has some required side effects.
    if (!isEnabled(msg)) {
      closeEvents(activity);
      return;
    }

    activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    activity.setContentView(layout);
    
    // Set heading color if appropriate
    // There is one and only one status event that is not really a payment status.
    // Very sloppy, but we will check for that and overwrite the normal title text
    TextView view = (TextView)activity.findViewById(R.id.DonateStatusView);
    if (overrideWindowTitle()) view.setText(activity.getString(titleId));
    setTextColor(view);
    
    // Set up main box text and color
    view = (TextView)activity.findViewById(R.id.DonateTextView);
    view.setText(activity.getString(textId, getTextParms(PARM_TEXT)));
    setTextColor(view);
  }

  @Override
  protected void doEvent(Activity activity, SmsMmsMessage msg) {
    DonateActivity.launchActivity(activity, this, msg);
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
  
  /**
   * Open event screen window popup
   * @param context current context
   */
  public void open(Context context) {
    DonateActivity.launchActivity(context, this, null);
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
    // main donation event, and the two paging events that are not part of the
    // main donation event menu, we can pretty much assure that everything has
    // been instantiated which will set up the class map.
    MainDonateEvent.instance();
    PagingProfileEvent.instance();
    PagingSubRequiredEvent.instance();
    
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
