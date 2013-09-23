package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.donation.DonationManager.DonationStatus;

/**
  
  Sponsored by Cadpage

  You are using a location sponsored by Cadpage.\n 
  Cadpage sponsors the general locations because their performance is 
  unreliable and we do not want to charge users who are waiting until a
  better location can be implemented.
  
 */
public class CadpageAUDonateEvent extends DonateScreenEvent {
  
  public CadpageAUDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_cadpage_au_title, R.string.donate_cadpage_au_text,
           Vendor2Event.instance(),
           AndroidDonateEvent.instance(),
           PaypalDonateEvent.instance(),
           MagicWordEvent.instance());
  }
  
  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationStatus.SPONSOR &&
            "AU".equals(DonationManager.instance().sponsor()));
  }

  private static final CadpageAUDonateEvent instance = new CadpageAUDonateEvent();
  
  public static CadpageAUDonateEvent instance() {
    return instance;
  }

}
