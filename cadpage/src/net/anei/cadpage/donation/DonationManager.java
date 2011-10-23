package net.anei.cadpage.donation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.anei.cadpage.ManagePreferences;

public class DonationManager {
  
  public static final int DEMO_LIMIT_DAYS = 30;
  public static final int EXPIRE_WARN_DAYS = 30;
  public static final int MAX_EXTRA_DAYS = 5;
  
  public enum DonationStatus {FREE, AUTH_DEPT, PAID, PAID_WARN, PAID_EXPIRE, DEMO, DEMO_EXPIRE};
  
  // Cached calculated values are only valid until this time
  private long validLimitTime = 0L;
  
  // cached days since Cadpage was installed
  private int daysSinceInstall;
  
  // Cached expiration date
  private Date expireDate;
  
  // cached days until Cadpage expires
  private int daysTillExpire;
  
  // Cached donation status
  private DonationStatus status;
  
  // Cached enable Cadpage status
  private boolean enabled;
  
  
  /**
   * Calculate all cached values
   */
  private void calculate() {
    
    // If the current day hasn't changed, we can use the cached values
    long curTime = System.currentTimeMillis();
    if (curTime < validLimitTime) return;
    
    // Save the previous hold status so we can tell if it has been cleared
    boolean oldAlert = status == DonationStatus.DEMO_EXPIRE || status == DonationStatus.PAID_EXPIRE;
    
    // Convert current time to a JDate, and set the cache limit to midnight
    // of that day
    JulianDate curJDate = new JulianDate(new Date(curTime));
    validLimitTime = curJDate.validUntilTime();
    
    // Get the install JDate
    Date installDate = ManagePreferences.installDate();
    Date minInstallDate = ManagePreferences.minInstallDate();
    if (minInstallDate != null && minInstallDate.after(installDate)) installDate = minInstallDate;
    JulianDate installJDate = new JulianDate(installDate);
    
    // And calculated cached values
    daysSinceInstall = installJDate.diffDays(curJDate);
    
    // Calculate expiration date
    // (one year past the purchase date anniversary in the last paid year)
    // ((Use install date if there is no purchase date))
    expireDate = null;
    daysTillExpire = 0;
    int paidYear = ManagePreferences.paidYear();
    if (paidYear > 0) {
      Date tDate = ManagePreferences.purchaseDate();
      if (tDate == null) tDate = ManagePreferences.installDate();
      Date minPurchaseDate = ManagePreferences.minPurchaseDate();
      if (minPurchaseDate != null && minPurchaseDate.after(tDate)) tDate = minPurchaseDate;
      Calendar cal = new GregorianCalendar();
      cal.setTime(tDate);
      cal.set(Calendar.YEAR, paidYear+1);
      expireDate = cal.getTime();
      daysTillExpire = curJDate.diffDays(new JulianDate(expireDate));
    }
    
    if (ManagePreferences.freeRider()) status = DonationStatus.FREE;
    else if (ManagePreferences.authLocation().equals(ManagePreferences.location())) {
      status = DonationStatus.AUTH_DEPT;
    } else if (expireDate != null) {
      if (daysTillExpire > EXPIRE_WARN_DAYS) status = DonationStatus.PAID;
      else if (daysTillExpire >= 0) status = DonationStatus.PAID_WARN;
      else status = DonationStatus.PAID_EXPIRE;
    } else {
      if (daysSinceInstall <= DEMO_LIMIT_DAYS) status = DonationStatus.DEMO;
      else status = DonationStatus.DEMO_EXPIRE;
    }
    
    // Cadpage should be enabled unless something has expired
    // If status changed from expired to non-expired, reset the extra day count
    enabled = (status != DonationStatus.DEMO_EXPIRE && status != DonationStatus.PAID_EXPIRE);
    if (enabled && oldAlert) ManagePreferences.resetAuthExtra();
    
    // If status is not enabled, check for the loopholes
    // First if if user has asked for an extra day
    if (!enabled) {
      Date extraDate = ManagePreferences.authExtraDate();
      if (extraDate != null && new JulianDate(extraDate).equals(curJDate)) enabled = true;
    }
  }

  /**
   * Reset donation status
   */
  public void reset() {
    validLimitTime = 0;
  }
  
  /**
   * @return overall donation status
   */
  public DonationStatus status() {
    calculate();
    return status;
  }


  /**
   * @return number of days since Cadpage was installed
   */
  public int daysSinceInstall() {
    calculate();
    return daysSinceInstall;
  }
  
  /**
   * @return days to subscription expires (can be negative)
   */
  public int daysTillExpire() {
    calculate();
    return daysTillExpire;
  }
  
  /**
   * @return subscription expiration date (null in no subscription)
   */
  public Date expireDate() {
    calculate();
    return expireDate;
  }
  
  /**
   * @return number of extra day authorizations left
   */
  public int extraAuthLeft() {
    return MAX_EXTRA_DAYS - ManagePreferences.authExtraCnt();
  }
  
  /**
   * @return true if full Cadpage functionality should be enabled.
   */
  public boolean isEnabled() {
    calculate();
    return enabled;
  }
  
  // Singleton instance
  private static DonationManager instance = new DonationManager();
  
  /**
   * @return singleton instance of DonationManager
   */
  public static DonationManager instance() {
    return instance;
  }
  
}
