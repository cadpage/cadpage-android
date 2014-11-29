package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
  This is the free version of Cadpage'
  
    This is the free version of Cadpage.  It is functionally equivalent to the
    standard version of Cadpage, except that customer support is minimal and
    updates will run 4-6 months behind the standard version.
     
 */
public class FreeDonateEvent extends DonateScreenEvent {
  
  public FreeDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_free_title, R.string.donate_free_text);
  }
  
  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.FREE);
  }
  
  private static final FreeDonateEvent instance = new FreeDonateEvent();
  
  public static FreeDonateEvent instance() {
    return instance;
  }

}
