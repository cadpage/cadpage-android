package net.anei.cadpage.donation;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class PaypalDonateEvent extends DonateScreenEvent {
  
  public PaypalDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_paypal_title, R.string.donate_paypal_text);
  }
  
  private static final PaypalDonateEvent instance = new PaypalDonateEvent();
  
  public static PaypalDonateEvent instance() {
    return instance;
  }

}
