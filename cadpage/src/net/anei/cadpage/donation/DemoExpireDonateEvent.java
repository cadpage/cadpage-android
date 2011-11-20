package net.anei.cadpage.donation;

import net.anei.cadpage.R;
/*
Your Cadpage demmo has expired

You have been using Cadpage for %1$d days.  Your cadpage demo expired %2$d days ago.  
The current version of Cadpage will not bother you about this, but the next version
just might.
 */
public class DemoExpireDonateEvent extends DonateScreenEvent {

  protected DemoExpireDonateEvent() {
    super(AlertStatus.RED, R.string.donate_demo_expire_title, R.string.donate_demo_expire_text,
           ReqMoneyGroup.instance(), MagicWordEvent.instance(),
           Android16DonateEvent.instance(),
           NoUserDonateEvent.instance(), 
           WrongUserDonateEvent.instance());
           // DonateExtraDayEvent.instance(),
           // ClearDataConfirmEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.DEMO_EXPIRE);
  }

  @Override
  protected Object[] getTextParms(int type) {
    int days = DonationManager.instance().daysSinceInstall();
    switch (type) {
    
    case PARM_TITLE:
      return new Object[]{days};
      
    case PARM_TEXT:
      return new Object[]{days, days-DonationManager.DEMO_LIMIT_DAYS};

    default:
      return null;
    }
  }
  
  private static final DemoExpireDonateEvent instance = new DemoExpireDonateEvent();
  public static DemoExpireDonateEvent instance() {
    return instance;
  }

}
