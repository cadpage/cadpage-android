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
  
  private VendorHelpEvent(int status) {
    super(AlertStatus.GREEN, R.string.vendor_help_title, R.string.vendor_help_text,
           VendorRegisterEvent.instance(status),
           VendorIgnoreEvent.instance());
  }
  
  private static final VendorHelpEvent[] instances = new VendorHelpEvent[]{
    new VendorHelpEvent(1),
    new VendorHelpEvent(2)
  };
  
  public static VendorHelpEvent instance(int status) {
    return instances[status-1];
  }

}
