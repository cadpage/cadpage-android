package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
Thank you for your support

You have earned free, lifetime access to Cadpage. 
Thank your for you contributions.
 */
public class LifeDonateEvent extends DonateScreenEvent {
  
  public LifeDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_life_title, R.string.donate_life_text,
           PaypalDonateEvent.instance());
  }
  
  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.LIFE);
  }
  
  private static final LifeDonateEvent instance = new LifeDonateEvent();
  
  public static LifeDonateEvent instance() {
    return instance;
  }

}
