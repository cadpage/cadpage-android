package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
 * Generate an email to the developers
 */
public class ConfirmResetDispatchAddressEvent extends DonateEvent {
  
  public ConfirmResetDispatchAddressEvent() {
    super(null, R.string.confirm_reset_dispatch_address_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    VendorManager.instance().resetEmailReq("Cadpage", activity);
    closeEvents(activity);
  }
  
  private static final ConfirmResetDispatchAddressEvent instance = new ConfirmResetDispatchAddressEvent();
  
  public static ConfirmResetDispatchAddressEvent instance() {
    return instance;
  }

}
