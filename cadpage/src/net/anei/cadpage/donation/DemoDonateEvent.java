package net.anei.cadpage.donation;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.content.Context;

public class DemoDonateEvent extends DonateEvent {

  protected DemoDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_demo_title);
  }

  @Override
  protected Object[] getTextParms(int type) {
    switch (type) {
    
    case PARM_TITLE:
      int days = elapsedDaysSince(ManagePreferences.installDate());
      return new Object[]{days};

    default:
      return null;
    }
  }

  @Override
  protected void doEvent(Context ctx) {
  }
  
  private static final DemoDonateEvent instance = new DemoDonateEvent();
  public static DemoDonateEvent instance() {
    return instance;
  }

}
