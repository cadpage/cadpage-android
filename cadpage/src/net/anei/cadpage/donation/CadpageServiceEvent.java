package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
Reinstall Cadpage
 */
public class CadpageServiceEvent extends DonateEvent {
  
  public CadpageServiceEvent() {
    super(AlertStatus.YELLOW, R.string.paging_drop_service);
  }

  @Override
  protected void doEvent(Activity activity) {
    VendorManager.instance().CadpageServicePopup(activity);
    closeEvents(activity);
  }
  
  private static final CadpageServiceEvent instance = new CadpageServiceEvent();
  
  public static CadpageServiceEvent instance() {
    return instance;
  }

}
