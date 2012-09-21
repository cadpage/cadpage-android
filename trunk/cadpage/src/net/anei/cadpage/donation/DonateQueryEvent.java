package net.anei.cadpage.donation;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import net.anei.cadpage.R;


public abstract class DonateQueryEvent extends DonateScreenBaseEvent {

  protected DonateQueryEvent(AlertStatus alertStatus, int titleId, int textId) {
    super(alertStatus, titleId, textId, R.layout.popup_donate_query_screen);
  }

  /**
   * Called to create the associated Donate activity
   * @param activity new activity being created
   */
  public void create(final Activity activity) {
    super.create(activity);
    
    final TextView editView = (TextView)activity.findViewById(R.id.editText);
    
    Button btn = (Button)activity.findViewById(R.id.btnCancel);
    btn.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        activity.finish();
      }});
   
    btn = (Button)activity.findViewById(R.id.btnDone);
    btn.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        String entry = editView.getText().toString();
        if (process(activity, entry)) closeEvents(activity);
      }});
  }
  
  /**
   * Method called to validate and process the entered string
   * @param activity current activity
   * @param input entered input string
   * @return true if input was accepted, false otherwise
   */
  protected abstract boolean process(Activity activity, String input);

}
