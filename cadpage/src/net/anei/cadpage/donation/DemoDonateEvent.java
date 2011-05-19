package net.anei.cadpage.donation;

import net.anei.cadpage.R;

public class DemoDonateEvent extends DonateScreenEvent {

  protected DemoDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_demo_title, R.string.donate_demo_text);
  }

  @Override
  public boolean isEnabled() {
    return DonationManager.daysSinceInstall() <= DonationManager.DEMO_LIMIT_DAYS;
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
