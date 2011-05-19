package net.anei.cadpage.donation;

import net.anei.cadpage.R;

public class DemoExpireDonateEvent extends DonateScreenEvent {

  protected DemoExpireDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_demo_expire_title, R.string.donate_demo_expire_text,
           PaypalDonateEvent.instance(),
           NoUserDonateEvent.instance(), WrongUserDonateEvent.instance());
  }

  @Override
  protected Object[] getTextParms(int type) {
    int days = DonationManager.daysSinceInstall();
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
