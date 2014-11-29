package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
Register for direct paging
 */
public class VendorRegisterEvent extends DonateEvent {
  
  public VendorRegisterEvent() {
    super(AlertStatus.GREEN, R.string.vendor_register_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    VendorManager.instance().registerTextPageVendor(activity);
    closeEvents(activity);
  }
  
  private static final VendorRegisterEvent instance = new VendorRegisterEvent();
  
  public static VendorRegisterEvent instance() {
    return instance;
  }

}
