package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/*
I am registered with %s

You have not received an alert from %s for more than 60 days, leading us to believe
that your account with them is no longer active.  If we are wrong about this, use the
"Send Email" button to contact us and we will get this fixed.
 
 */
public class InactiveSponsorDonateEvent extends DonateScreenEvent {

  protected InactiveSponsorDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_inactive_sponsor_title, R.string.donate_inactive_sponsor_text,
           EmailInactiveSponsorEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return VendorManager.instance().getInactiveSponsor() != null;
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    return new Object[]{VendorManager.instance().getInactiveSponsor()};
  }

  private static final InactiveSponsorDonateEvent instance = new InactiveSponsorDonateEvent();
  public static InactiveSponsorDonateEvent instance() {
    return instance;
  }

}
