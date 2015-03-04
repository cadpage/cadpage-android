package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
Register for direct paging
This also takes two forms, depending on how it was launched
 */
public class VendorRegisterEvent extends DonateEvent {
  
  int status;
  
  private VendorRegisterEvent(int status) {
    super(AlertStatus.GREEN, R.string.vendor_register_title);
    this.status = status;
  }

  @Override
  protected void doEvent(Activity activity) {
    
    // We could not have gotten here without findTextPageVendor() returning
    // true in the recent past, and presumably it will again.  But there are
    // some side effects that may have been lost if Cadpage has been restarted
    // since then, so we call it again to make sure everything is kosher
    if (VendorManager.instance().findTextPageVendor(status)) {
      VendorManager.instance().registerTextPageVendor(activity);
    }
    closeEvents(activity);
  }
  
  private static VendorRegisterEvent[] instances = new VendorRegisterEvent[]{
    new VendorRegisterEvent(1),
    new VendorRegisterEvent(2)
  };
  
  public static final VendorRegisterEvent instance(int status) {
    return instances[status-1];
  }
}
