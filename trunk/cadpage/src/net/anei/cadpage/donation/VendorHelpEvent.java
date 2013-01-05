package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
  What is direct paging?

    Direct paging allows message servicing agencies to push pages to Cadpage directly through 
    the data networks, without relying on text paging.  Which eliminates both the text message fees
    and the length limits carriers impose on text messages.  And most agencies pay Cadpage out of
    the money they get from departments and dispatch centers, so we don\'t bug direct paging users
    about purchasing a Cadpage subscription.

 */
public class VendorHelpEvent extends DonateScreenEvent {
  
  public VendorHelpEvent() {
    super(AlertStatus.GREEN, R.string.vendor_help_title, R.string.vendor_help_text,
           VendorRegisterEvent.instance());
  }
  
  private static final VendorHelpEvent instance = new VendorHelpEvent();
  
  public static VendorHelpEvent instance() {
    return instance;
  }

}
