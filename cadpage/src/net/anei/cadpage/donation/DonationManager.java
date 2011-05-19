package net.anei.cadpage.donation;

import java.util.Date;

import net.anei.cadpage.ManagePreferences;

public class DonationManager {
  
  public static final int DEMO_LIMIT_DAYS = 30;
  
  // Singleton instance
  private static DonationManager instance = new DonationManager();
  
  // Cached calculated values are only valid until this time
  private long validLimitTime = 0L;
  
  // cached days since Cadpage was installed
  private int daysSinceInstall;
  
  
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
    JulianDate installJDate = new JulianDate(ManagePreferences.installDate());
    
    // And calculated cached values
    daysSinceInstall = installJDate.diffDays(curJDate);
  }
  
  private void doReset() {
    validLimitTime = 0;
    calculate();
  }
  

  /**
   * @return number of days since Cadpage was installed
   */
  private int getDaysSinceInstall() {
    calculate();
    return daysSinceInstall;
  }
  
  /**
   * Reset all cached day calculations.  This should be called when
   * any of the preferences values that control the date calculations are changed
   */
  public static void reset() {
    instance.doReset();
  }

  /**
   * @return number of days since Cadpage was installed
   */
  public static int daysSinceInstall() {
    return instance.getDaysSinceInstall();
  }
}
