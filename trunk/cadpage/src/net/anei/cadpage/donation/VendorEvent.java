package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
  Register with %s
    You appear to be getting text pages from %s.  You can register to get direct pages from
    them, which don\'t relay on text messaging, eliminating several problems associated
    with text messages.  

 */
public class VendorEvent extends DonateScreenEvent {

  /*
   * There are two different class instances based on this class that have different enable
   * conditions and have slightly different event lists.
   * instance1 is invoked when Cadpage starts up to determine if it should display the direct page vendor
   * screen event.  It is disabled when the user has asked us to quit bothering them
   * instance2 is invoked by other events in the donation event hierarchy.  It is disabled if the direct 
   * page vendor is not sponsored.  Which means it wouldn't satisfy the Cadpage payment expectation, so we
   * won't display it as though it would
   */
  
  int status;
  
  protected VendorEvent(int status) {
    super(AlertStatus.GREEN, R.string.vendor_title, R.string.vendor_text,
           status == 1 ? new DonateEvent[]{
              VendorRegisterEvent.instance(),
              VendorHelpEvent.instance(),
              VendorIgnoreEvent.instance()
           } : new DonateEvent[]{
              VendorRegisterEvent.instance(),
              VendorHelpEvent.instance(),
           });
    this.status = status;
  }

  @Override
  public boolean isEnabled() {
    return VendorManager.instance().findTextPageVendor(status);
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    return new Object[]{VendorManager.instance().getTextPageVendorName()};
  }
}
