package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
Leave things the way they are
 */
public class VendorIgnoreEvent extends DonateEvent {
  
  public VendorIgnoreEvent() {
    super(AlertStatus.GREEN, R.string.vendor_ignore_title);
  }
  
   @Override
  public boolean isEnabled() {
    return super.isEnabled();
  }

  @Override
  protected void doEvent(Activity activity) {
    VendorManager.instance().ignoreTextPageVendor();
    closeEvents(activity);
  }
  
  private static final VendorIgnoreEvent instance = new VendorIgnoreEvent();
  
  public static VendorIgnoreEvent instance() {
    return instance;
  }

}
