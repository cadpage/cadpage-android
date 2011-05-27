package net.anei.cadpage.donation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class PaypalDonateEvent extends DonateEvent {
  
  private static final String TARGET_URL = "http://www.cadpage.org/financial-support/paypal-donations";
  
  public PaypalDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_paypal_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(TARGET_URL)); 
    activity.startActivity(intent); 
    activity.setResult(Activity.RESULT_OK);
    activity.finish();
  }
  
  private static final PaypalDonateEvent instance = new PaypalDonateEvent();
  
  public static PaypalDonateEvent instance() {
    return instance;
  }

}
