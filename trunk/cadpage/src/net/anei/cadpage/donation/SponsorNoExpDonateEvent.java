package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
  
  Sponsored by %s

  You are using a location sponsored by\n%s\n 
  Support for Cadpage development and maintenance is provided by the
  location sponsor.  No further payment is expected from you as long as you
  are using this location.
  
 */
public class SponsorNoExpDonateEvent extends DonateScreenEvent {
  
  public SponsorNoExpDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_sponsor_noexp_title, R.string.donate_sponsor_noexp_text,
           MagicWordEvent.instance(),
           DonateResetMarketEvent.instance());
  }
  
  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.SPONSOR &&
             DonationManager.instance().expireDate() == null);
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    return new Object[]{
        DonationManager.instance().sponsor()
    };
  }

  private static final SponsorNoExpDonateEvent instance = new SponsorNoExpDonateEvent();
  
  public static SponsorNoExpDonateEvent instance() {
    return instance;
  }

}
