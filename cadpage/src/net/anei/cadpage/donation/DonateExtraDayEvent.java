package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;

/**
Give me another day (n left)
 */
public class DonateExtraDayEvent extends DonateEvent {
  
  public DonateExtraDayEvent() {
    super(AlertStatus.YELLOW, R.string.donate_extra_day_title);
  }

  @Override
  public boolean isEnabled() {
    if (DonationManager.instance().isEnabled()) return false;
    return (DonationManager.instance().extraAuthLeft() > 0);
  }

  @Override
  protected Object[] getTextParms(int type) {
    if (type == PARM_TITLE) return new Object[]{DonationManager.instance().extraAuthLeft()};
    return null;
  }

  @Override
  protected void doEvent(Activity activity) {
    ManagePreferences.authExtraDay();
    DonationManager.instance().reset();
    MainDonateEvent.instance().refreshStatus();
    closeEvents(activity);
  }
  
  private static final DonateExtraDayEvent instance = new DonateExtraDayEvent();
  
  public static DonateExtraDayEvent instance() {
    return instance;
  }

}
