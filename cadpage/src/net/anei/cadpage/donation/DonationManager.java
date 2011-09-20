package net.anei.cadpage.donation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.anei.cadpage.ManagePreferences;

public class DonationManager {
  
  public static final int DEMO_LIMIT_DAYS = 30;
  public static final int EXPIRE_WARN_DAYS = 30;
  
  public enum DonationStatus {FREE, AUTH_DEPT, PAID, PAID_WARN, PAID_EXPIRE, DEMO, DEMO_EXPIRE};
  
  // Singleton instance
  private static DonationManager instance = new DonationManager();
  
  // Cached calculated values are only valid until this time
  private long validLimitTime = 0L;
  
  // cached days since Cadpage was installed
  private int daysSinceInstall;
  
  // Cached expiration date
  private Date expireDate;
  
  // cached days until Cadpage expires
  private int daysTillExpire;
  
  // Cached donation status
  DonationStatus status;
  
  
  /**
   * Calculate all cached values
   */
  private void calculate() {
    
    // If the current day hasn't changed, we can use the cached values
    long curTime = System.currentTimeMillis();
    if (curTime < validLimitTime) return;
    
    // Convert current time to a JDate, and set the cache limit to midnight
    // of that day
    JulianDate curJDate = new JulianDate(new Date(curTime));
    validLimitTime = curJDate.validUntilTime();
    
    // Get the install JDate
    Date installDate = ManagePreferences.installDate();
    JulianDate installJDate = new JulianDate(installDate);
    
    // And calculated cached values
    daysSinceInstall = installJDate.diffDays(curJDate);
    
    // Calculate expiration date
    // (one year past the install date anniversary in the last paid year)
    int paidYear = ManagePreferences.paidYear();
    if (paidYear > 0) {
      Date tDate = ManagePreferences.purchaseDate();
      if (tDate == null) tDate = ManagePreferences.installDate();
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
  }
  
  private void doReset() {
    validLimitTime = 0;
  }
  
  /**
   * @return overall donation status
   */
  public DonationStatus getStatus() {
    calculate();
    return status;
  }
  

  /**
   * @return number of days since Cadpage was installed
   */
  private int getDaysSinceInstall() {
    calculate();
    return daysSinceInstall;
  }
  
  /**
   * @return number of days until Cadpage expires (may be negative)
   */
  public int getDaysTillExpire() {
    calculate();
    return daysTillExpire;
  }
  
  /**
   * @return expiration date
   */
  public Date getExpireDate() {
    calculate();
    return expireDate;
  }
  
  /**
   * Reset all cached day calculations.  This should be called when
   * any of the preferences values that control the date calculations are changed
   */
  public static void reset() {
    instance.doReset();
  }
  
  /**
   * @return overall donation status
   */
  public static DonationStatus status() {
    return instance.getStatus();
  }

  /**
   * @return number of days since Cadpage was installed
   */
  public static int daysSinceInstall() {
    return instance.getDaysSinceInstall();
  }
  
  /**
   * @return days to subscription expires (can be negative)
   */
  public static int daysTillExpire() {
    return instance.getDaysTillExpire();
  }
  
  /**
   * @return subscription expiration date (null in no subscription)
   */
  public static Date expireDate() {
    return instance.getExpireDate();
  }
  
}
