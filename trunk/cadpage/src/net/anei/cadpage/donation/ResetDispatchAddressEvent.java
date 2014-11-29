package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
 * Generate an email to the developers
 */
public class ResetDispatchAddressEvent extends DonateScreenEvent {
  
  public ResetDispatchAddressEvent() {
    super(null, R.string.reset_dispatch_address_title, R.string.reset_dispatch_address_text,
          ConfirmResetDispatchAddressEvent.instance());
  }
  
  private static final ResetDispatchAddressEvent instance = new ResetDispatchAddressEvent();
  
  public static ResetDispatchAddressEvent instance() {
    return instance;
  }

}
