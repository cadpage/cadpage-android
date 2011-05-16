package net.anei.cadpage.donation;

import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class DonateScreenEvent extends DonateEvent {
  
  private int textId;
  private DonateEvent[] events;

  protected DonateScreenEvent(AlertStatus alertStatus, int titleId, int textId,
                               DonateEvent ... events) {
    super(alertStatus, titleId);
    registerScreenEvent(this);
    this.textId = textId;
    this.events = events;
  }

  /**
   * Called to create the associated Donate activity
   * @param activity new activity being created
   */
  public void create(final Activity activity) {

    activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    activity.setContentView(R.layout.popup_donate_screen);
    
    // Set heading color if appropriate
    TextView view = (TextView)activity.findViewById(R.id.DonateStatusView);
    setTextColor(view);
    
    // Set up main box text and color
    view = (TextView)activity.findViewById(R.id.DonateTextView);
    view.setText(activity.getString(textId, getTextParms(PARM_TEXT)));
    setTextColor(view);
    
    // Fill the button list with the appropriate event buttons
    LinearLayout btnList = (LinearLayout)activity.findViewById(R.id.DonateButtonList);
    if (events != null){
      for (DonateEvent event : events) {
        event.addButton(activity, btnList);
      }
    }
    
    // Add a cancel button at bottom of list
    Button btn = new Button(activity);
    btn.setText(R.string.donate_btn_cancel);
    btn.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        activity.finish();
      }
    });
    btnList.addView(btn);
  }

  @Override
  protected void doEvent(Context ctx) {
    DonateActivity.launchActivity(ctx, this);
  }
  
  // Map use to identify Screen events by classname
  private static Map<String, DonateScreenEvent> screenEventMap = 
      new HashMap<String, DonateScreenEvent>();
  
  /**
   * Register a Donate screen event for future retreival
   * @param event Event to be registered
   */
  private static void registerScreenEvent(DonateScreenEvent event) {
    screenEventMap.put(event.getClass().getName(), event);
  }
  
  /**
   * Retrieve a registered Donate screen event
   * @param classname class name of registered event
   * @return registered donate screen event
   */
  public static DonateScreenEvent getScreenEvent(String classname) {
    DonateScreenEvent event = screenEventMap.get(classname);
    if (event == null) throw new RuntimeException("Not Event registered for " + classname);
    return event;
  }

}
