package net.anei.cadpage.donation;

import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.Log;
import net.anei.cadpage.ManagePreferences;

public class DonationCalculator {
  
  int type;
  int year = 0;
  String purchaseDateStr = null;
  String sponsor = null;
  
  private static final Object LOCK = new Object();

  /**
   * Create new donation calculator
   * @param type 0 - overall donation status<br>
   *             1 - Google Play Store donation status
   *             2 - Authorization server donation status
   */
  public DonationCalculator(int type) {
    this.type = type;
  }
  
  /**
   * Load current subscription status information
   */
  public void load() {
    
    year = ManagePreferences.paidYear(type);
    purchaseDateStr = ManagePreferences.purchaseDateString(type);
    sponsor = ManagePreferences.sponsor(type);
    
    if (type == 0) {
      if (ManagePreferences.freeRider()) year = 9999;
      if (ManagePreferences.freeSub()) sponsor = "FREE";
    }
  }
  
  /**
   * Process one subscription request, this can come from the Android market interface
   * or from the Cadpage authorization server response.
   * @param stat - Subscription status, either a subscription year or "LIFE".
   * @param purchaseDateStr - purchase date in MMDDYYY format.
   * @param sponsor
   */
  public void subscription(String stat, String purchaseDateStr, String sponsor) {
    
    Log.w("Donation Subscription type:" + type + " stat:" + stat + " date:" + purchaseDateStr + " sponsor:" + sponsor);
    
    // Clean up inputs
    if (purchaseDateStr != null && purchaseDateStr.length() < 4) purchaseDateStr = null;
    if (sponsor != null && sponsor.length() == 0) sponsor = null;
    
    // Evaluate the status field.  Value of LIFE translates to year 9999
    int year = -1;
    if (stat.equalsIgnoreCase("LIFE")) {
      year = 9999;
    } else {
      try {
        year = Integer.parseInt(stat);
      } catch (NumberFormatException ex) {}
      if (year < 2011 && year > 2050) year = -1;
    }
    
    subscription(year, purchaseDateStr, sponsor);
  }

  
  /**
   * Process one subscription request, this can come from the Android market interface
   * or from the Cadpage authorization server response.
   * @param year - paid year or 9999 for lifetime subscriptions
   * @param purchaseDateStr - purchase date in MMDDYYY format.
   * @param sponsor
   */
  private void subscription(int year, String purchaseDateStr, String sponsor) {
    // if this year is less than current year, ignore everything
    // completely ignore everything
    if (year < this.year) return;
    
    // Next get the current and new free subscriber status
    boolean freeSub = sponsor != null && sponsor.equalsIgnoreCase("FREE");
    boolean curFreeSub = this.sponsor != null && this.sponsor.equalsIgnoreCase("FREE");
    
    // if payment year is the same then
    if (year == this.year) {
      
      // free subscriptions never override paid subscriptions
      if (freeSub && !curFreeSub) return;
      
      // If free subscription status is same, older purchase dates never 
      // override new purchase dates.  We only compare the first 4 digits
      // of the purchase dates, the purchase year is not relevant
      if (freeSub == curFreeSub && this.purchaseDateStr != null && purchaseDateStr != null && 
          this.purchaseDateStr.substring(0,4).compareTo(purchaseDateStr.substring(0,4))>0) return;
    }
    
    // OK, we have decided the new subscription purchase overrides the existing
    // one, so update everything accordingly.
    this.year = year;
    this.purchaseDateStr = purchaseDateStr;
    this.sponsor = sponsor;
  }
  
  /**
   * Save subscription status information
   */
  public void save() {
    
    // Synchronize on a global lock to avoid problems with simultaneous
    // access from two different threads
    synchronized (LOCK) {
      
      // Save current preferences
      // only the purchase date string is common to global and subcomponent 
      // donation status.  The rest require special handling for the global
      // donation status
      
      if (type == 0) {
        if (year == 9999) {
          ManagePreferences.setFreeRider(true);
          ManagePreferences.setPaidYear(0);
        } else {
          ManagePreferences.setFreeRider(false);
          ManagePreferences.setPaidYear(year);
        }
        
        ManagePreferences.setPurchaseDateString(type, purchaseDateStr);
        
        if (sponsor != null && sponsor.equalsIgnoreCase("FREE")) {
          ManagePreferences.setFreeSub(true);
          ManagePreferences.setSponsor(null);
        } else {
          ManagePreferences.setFreeSub(false);
          ManagePreferences.setSponsor(sponsor);
        }
      }
      
      // Subcomponent status are saved normally
      // But after that is done, we need to update the global donation status
      // and recalculate and redisplay the global donation status
      else {
        
        // Save subcomponent status
        ManagePreferences.setPaidYear(type, year);
        ManagePreferences.setPurchaseDateString(type, purchaseDateStr);
        ManagePreferences.setSponsor(type, sponsor);

        // Save the current global donation status
        DonationCalculator saveCalc = new DonationCalculator(0);
        saveCalc.load();
      
        // Recalculate the new global donation status
        DonationCalculator calc = new DonationCalculator(0);
        for (int ii = 1; ii <= 2; ii++) {
          calc.subscription(ManagePreferences.paidYear(ii), 
                            ManagePreferences.purchaseDateString(ii), 
                            ManagePreferences.sponsor(ii));
        }
        
        // See if final result is a donation status downgrade
        // if it is, log the event
        if (saveCalc.compareTo(calc) < 0) {
          EmailDeveloperActivity.logSnapshot(CadPageApplication.getContext(), "Payment Status Downgrade");
        }
        
        // Otherwise save the new status and update everything
        calc.save();
        DonationManager.instance().reset();
        MainDonateEvent.instance().refreshStatus();
      }
    }
  }

  private int compareTo(DonationCalculator calc) {
    int delta = calc.year - year;
    if (delta != 0) return delta;
    
    boolean freeSub1 = sponsor != null && sponsor.equalsIgnoreCase("FREE");
    boolean freeSub2 = calc.sponsor != null && calc.sponsor.equalsIgnoreCase("FREE");
    if (freeSub1 && !freeSub2) return 1;
    if (!freeSub1 && freeSub2) return -1;
    
    if (purchaseDateStr == null || calc.purchaseDateStr == null) return 0;
    if (purchaseDateStr.length() < 4 || calc.purchaseDateStr.length() < 4) return 0;
    return purchaseDateStr.substring(0,4).compareTo(calc.purchaseDateStr.substring(0,4));
  }
}
