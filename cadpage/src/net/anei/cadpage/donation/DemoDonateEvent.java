package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
You have been using Cadpage for %d days

You have been using Cadpage for %1$d days, you have %2$d days left before the
demo expires.  The current version of Cadpage will not bother you if you go over that 
limit.  But the next version might.
 */
public class DemoDonateEvent extends DonateScreenEvent {

  protected DemoDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_demo_title, R.string.donate_demo_text,
           ReqMoneyGroup.instance(), MagicWordEvent.instance(),
           Android16DonateEvent.instance(),
           NoUserDonateEvent.instance(), WrongUserDonateEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return (DonationManager.status() == DonationManager.DonationStatus.DEMO);
  }

  @Override
  protected Object[] getTextParms(int type) {
    int days = DonationManager.daysSinceInstall();
    
    switch (type) {
    
    case PARM_TITLE:
      return new Object[]{days};
      
    case PARM_TEXT:
      return new Object[]{days, DonationManager.DEMO_LIMIT_DAYS-days};

    default:
      return null;
    }
  }
  
  private static final DemoDonateEvent instance = new DemoDonateEvent();
  public static DemoDonateEvent instance() {
    return instance;
  }

}
