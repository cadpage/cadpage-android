package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.util.Date;

import net.anei.cadpage.R;

/**
  
  Sponsored by %s

  You are using a service sponsored by\n%1$s until %2$s\n 
  Support for Cadpage development and maintenance is provided by this
  sponsor.  No further payment is expected from you as long as you
  are using services provided by this sponsor.
  
 */
public class SponsorDonateEvent extends DonateScreenEvent {
  
  public SponsorDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_sponsor_title, R.string.donate_sponsor_text,
           AndroidDonateEvent.instance(),
           PaypalDonateEvent.instance(),
           MagicWordEvent.instance(),
           DonateResetMarketEvent.instance());
  }
  
  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.SPONSOR &&
             DonationManager.instance().expireDate() != null);
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    Date expireDate = DonationManager.instance().expireDate();
    String sDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(expireDate);
    return new Object[]{
        DonationManager.instance().sponsor(),
        sDate
    };
  }

  private static final SponsorDonateEvent instance = new SponsorDonateEvent();
  
  public static SponsorDonateEvent instance() {
    return instance;
  }

}
