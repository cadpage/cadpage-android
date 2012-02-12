package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
  
  Sponsored by Cadpage

  You are using a location sponsored by Cadpage.\n 
  Cadpage sponsors the general locations because their performance is 
  unreliable and we do not want to charge users who are waiting until a
  better location can be implemented.
  
 */
public class CadpageUKDonateEvent extends DonateScreenEvent {
  
  public CadpageUKDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_cadpage_uk_title, R.string.donate_cadpage_uk_text,
           AndroidDonateEvent.instance(),
           PaypalDonateEvent.instance());
  }
  
  @Override
  public boolean isEnabled() {
    return ("UK".equals(DonationManager.instance().sponsor()));
  }

  private static final CadpageUKDonateEvent instance = new CadpageUKDonateEvent();
  
  public static CadpageUKDonateEvent instance() {
    return instance;
  }

}
