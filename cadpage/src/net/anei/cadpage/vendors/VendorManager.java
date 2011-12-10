package net.anei.cadpage.vendors;

import net.anei.cadpage.C2DMReceiver;
import android.content.Context;
import android.preference.PreferenceScreen;

/**
 * This class manages all of the Vendor classes
 */
public class VendorManager {
  
  // List of supported vendors
  private Vendor[] vendorList = new Vendor[]{
    new CodeMessagingVendor()
  };
  
  /**
   * Initialize vendor status at startup
   * @param context current context
   */
  public void setup(Context context) {
    for (Vendor vendor : vendorList) {
      vendor.setup(context);
    }
  }
  
  /**
   * Set up Vendor configuration preference screen
   * @param context current context
   * @param pref preference to be set up with vendor config menu
   */
  public void setupPreference(Context context, PreferenceScreen pref) {
    for (Vendor vendor : vendorList) {
      pref.addPreference(new VendorPreference(context, vendor));
    }
  }
  
  /**
   * Called by CD2MReceiver when a new registration ID is defined
   * @param context current context
   * @param registrationId new registration ID
   */
  public void registerC2DMId(Context context, String registrationId) {
    for (Vendor vendor : vendorList) {
      vendor.registerC2DMId(context, registrationId);
    }
  }
  
  /**
   * Called by CD2MReceiver when phone is unregistered from C2DM services
   * @param context current context
   * @param registrationId old registration ID
   */
  public void unregisterC2DMId(Context context, String registrationId) {
    
    // Loop through the vendor list to see if any of them are still enabled
    boolean reregister = false;
    for (Vendor vendor : vendorList) {
      if (vendor.isEnabled()) {
        reregister = true;
        break;
      }
    }
    
    // If any are, we need to request a new registration ID
    if (reregister) C2DMReceiver.register(context);
  }
  
  public void vendorRequest(Context context, String type, String vendorCode,
                              String account, String token) {

    // Identify the correct vendor and pass request to them
    Vendor vendor = findVendor(vendorCode);
    if (vendor == null) return;
    vendor.vendorRequest(context, type, account, token);
  }
  
  /**
   * Append vendor status info to logging buffer 
   * @param sb String buffer accumulated log information
   */
  public void addStatusInfo(StringBuffer sb) {
    for (Vendor vendor : vendorList) vendor.addStatusInfo(sb);
  }
  
  /**
   * Find vendor with matching vendor code
   * @param vendorCode vendor code
   * @return matching vendor object, or null if none found.
   */
  public Vendor findVendor(String vendorCode) {
    for (Vendor vendor : vendorList) {
      if (vendorCode.equals(vendor.getVendorCode())) return vendor;
    }
    return null;
  }

  
  // Support singleton instance of VendorManager
  private static final VendorManager instance = new VendorManager();
  
  public static VendorManager instance() {
    return instance;
  }

}
