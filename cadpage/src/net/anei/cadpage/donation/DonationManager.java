package net.anei.cadpage.donation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.vendors.VendorManager;

public class DonationManager {
  
  // How long user can run after initial install
  public static final int DEMO_LIMIT_DAYS = 30;
  
  // How long before subscription expires do we start warning users
  public static final int EXPIRE_WARN_DAYS = 30;
  
  // How many times expires users can ask for another day
  public static final int MAX_EXTRA_DAYS = 10;
  
  // How long a release exemption lasts
  public static final int REL_EXEMPT_DAYS = 10;
  
  private enum Status {GOOD, WARN, BLOCK}
  public enum DonationStatus {FREE(Status.GOOD), LIFE(Status.GOOD), AUTH_DEPT(Status.GOOD), NEW(Status.GOOD), 
                               PAID(Status.GOOD), PAID_WARN(Status.WARN), PAID_EXPIRE(Status.BLOCK), PAID_LIMBO(Status.WARN), 
                               SPONSOR(Status.GOOD), SPONSOR_WARN(Status.WARN), SPONSOR_EXPIRE(Status.BLOCK), SPONSOR_LIMBO(Status.WARN), 
                               DEMO(Status.WARN), DEMO_EXPIRE(Status.BLOCK), EXEMPT(Status.WARN);
    private Status status;
    DonationStatus(Status status) {
      this.status = status;
    }
    
    public Status getStatus() {
      return status;
    }
  };
  
  // Cached calculated values are only valid until this time
  private long validLimitTime = 0L;
  
  // Cached expiration date
  private Date expireDate;
  
  // Cached days since install
  private int daysSinceInstall;
  
  // cached days until Cadpage expires
  private int daysTillExpire;
  
  // Cached donation status
  private DonationStatus status;
  
  // Cached enable Cadpage status
  private boolean enabled;
  
  // Cached Sponsor name
  private String sponsor;
  
  // Cached overpaid days
  private int overpaidDays;
  
  /**
   * Calculate all cached values
   */
  private void calculate() {
    
    // If this is the free version of Cadpage, we can skip all of the hard stuff
    if (this.getClass().getName().contains(".cadpagefree")) {
      status = DonationStatus.FREE;
      return;
    }
    
    // If the current day hasn't changed, we can use the cached values
    long curTime = System.currentTimeMillis();
    if (curTime < validLimitTime) return;
    
    // Save the previous hold status so we can tell if it has been cleared
    boolean oldAlert = (status != null && status.getStatus() == Status.BLOCK);
    
    // Convert current time to a JDate, and set the cache limit to midnight
    // of that day
    Date curDate = new Date(curTime);
    JulianDate curJDate = new JulianDate(curDate);
    validLimitTime = curJDate.validUntilTime();
    
    // Get sponsor name and expiration date from either the
    // Vendor manager or the current parser
    sponsor = VendorManager.instance().getSponsor();
    JulianDate regJDate = null;
    if (sponsor != null) {
      Date regDate = ManagePreferences.registerDate();
      if (regDate == null) {
        ManagePreferences.setRegisterDate();
        regJDate = curJDate;
      } else {
        regJDate = new JulianDate(regDate);
      }
    }
    expireDate = null;
    if (!VendorManager.instance().isRegistered()) {
      MsgParser parser = ManagePreferences.getCurrentParser();
      sponsor = parser.getSponsor();
      expireDate = parser.getSponsorDate();
      if (expireDate != null) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(expireDate);
        cal.add(Calendar.YEAR, +1);
        expireDate = cal.getTime();
      }
    }

    // Life gets complicated because we may be dealing with two sponsors, one that came from direct
    // paging or parser sponsoring vendors, and the other that was reported by the authorization server
    // and we won't know which one should be in the final result until we check on the subscription
    // expiration status.  So save the first sponsor as the sponsoring vendor so it can be recovered.
    String sponsoringVendor = (expireDate == null ? sponsor : null);
    daysSinceInstall = ManagePreferences.calcAuthRunDays(sponsoringVendor == null ? curDate : null);
    int daysTillDemoEnds = DEMO_LIMIT_DAYS - daysSinceInstall;
    
    // Calculate subscription expiration date
    // (one year past the purchase date anniversary in the last paid year)
    // ((Use install date if there is no purchase date))
    overpaidDays = 0;
    int daysTillSubExpire = -99999;
    int paidYear = ManagePreferences.paidYear();
    if (paidYear > 0) {
      Date tDate = ManagePreferences.purchaseDate();
      if (tDate == null) tDate = ManagePreferences.installDate();
      Calendar cal = new GregorianCalendar();
      cal.setTime(tDate);
      cal.set(Calendar.YEAR, paidYear+1);
      tDate = cal.getTime();
      
      // If there is a sponsored vendor register date and they have a paid subscription
      // expiration date, compute the number of days between them.  This is the number 
      // of days they have been doubled billed by both us and the vendor
      if (regJDate != null) {
        overpaidDays = regJDate.diffDays(new JulianDate(tDate)); 
      }
      
      // If we have both a subscription and sponsor expiration date, choose the
      // latest one
      if (expireDate == null || tDate.after(expireDate)) {
        sponsor = ManagePreferences.sponsor();
        expireDate = tDate;
      }
    }
    
    // If we have an expiration date, see if it has expired.  And if it has see
    // if we are in the limbo state where user can keep running Cadpage until they
    // install a release published after the expiration date
    boolean limbo = false;
    if (expireDate != null) {
      JulianDate jExpireDate = new JulianDate(expireDate);
      daysTillSubExpire = curJDate.diffDays(jExpireDate);
      if (daysTillSubExpire < 0) {
        JulianDate jReleaseDate = new JulianDate(ManagePreferences.releaseDate());
        limbo = jReleaseDate.diffDays(jExpireDate) >= 0;
      }
    }
    daysTillExpire = Math.max(daysTillDemoEnds, daysTillSubExpire);
    
    // OK, we have calculated all of the intermediate stuff.  Now use that to
    // determine the overall status
    String location = ManagePreferences.location();
    if (ManagePreferences.freeRider()) status = DonationStatus.LIFE;
    else if (ManagePreferences.authLocation().equals(ManagePreferences.location())) {
      status = DonationStatus.AUTH_DEPT;
    } else if (expireDate != null) {
      if (daysTillExpire > EXPIRE_WARN_DAYS) {
        status = (sponsoringVendor == null && sponsor != null ? DonationStatus.SPONSOR : DonationStatus.PAID);
      }
      else if (sponsoringVendor != null) status = DonationStatus.SPONSOR;
      else if (daysTillExpire >= 0) {
        if (daysTillExpire == daysTillSubExpire) {
          status = (sponsor != null ? DonationStatus.SPONSOR_WARN : DonationStatus.PAID_WARN);
        } else {
          status = DonationStatus.DEMO;
        }
      } else if (limbo) {
        status = (sponsor != null ? DonationStatus.SPONSOR_LIMBO : DonationStatus.PAID_LIMBO);
      }
      else status = (sponsor != null ? DonationStatus.SPONSOR_EXPIRE : DonationStatus.PAID_EXPIRE);
    } 
    else if ((location == null || location.startsWith("General")) &&
              ManagePreferences.filter().trim().length()<=1 &&
              !VendorManager.instance().isRegistered()) {
      status = DonationStatus.NEW;
    } else if (sponsor != null) status = DonationStatus.SPONSOR;
    else {
      if (daysTillExpire >= 0) status = DonationStatus.DEMO;
      else status = DonationStatus.DEMO_EXPIRE;
    }
    
    // If we did have a  master unexpiring vendor, and the final status indicates
    // a Vendor paid status, clean things up by reporting the correct vendor and
    // null expiration date
    if (sponsoringVendor != null && status == DonationStatus.SPONSOR) {
      sponsor = sponsoringVendor;
      expireDate = null;
    }
    
    // If they don't have a clear green status, check for a special release exemption
    if (status.getStatus() != Status.GOOD) {
      
      // This only returns a exempt date if it is still is valid for the current release
      // And it is only valid for period of time after the release was shipped
      Date exemptDate = ManagePreferences.authExemptDate();
      if (exemptDate != null) {
        JulianDate exJDate = new JulianDate(exemptDate);
        int days = exJDate.diffDays(curJDate);
        if (days <= REL_EXEMPT_DAYS) {
          status = DonationStatus.EXEMPT;
          daysTillExpire = REL_EXEMPT_DAYS - days;
        }
      }
    }
    
    // Cadpage should be enabled unless something has expired
    // If status changed from expired to non-expired, reset the extra day count
    enabled = (status.getStatus() != Status.BLOCK);
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
   * @return return sponsor paying for support
   */
  public String sponsor() {
    return sponsor;
  }
  
  /**
   * @return true if this is the free (unsupported) version of Cadpage
   */
  public boolean isFreeVersion() {
    return status() == DonationStatus.FREE;
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
  
  /**
   * @return number of overpaid days
   */
  public int getOverpaidDays() {
    return overpaidDays;
  }
  
  // Singleton instance
  private static DonationManager instance = new DonationManager();
  
  /**
   * @return singleton instance of DonationManager
   */
  public static DonationManager instance() {
    return instance;
  }

  /**
   * Determine if a user entered code is a valid authorization code
   * @param code entered code
   * @return type of valid auth string if it is a valid authorization code,
   * 0 if not a valid authorization code
   */
  public static int validateAuthCode(String code) {
    
    // Switch to upper case
    code = code.toUpperCase();
    
    // See if it matches todays hash code
    JulianDate jDate = new JulianDate(new Date());
    int type = validateAuthCode(code, jDate);
    if (type > 0) return type;
    
    // No luck, see if it matches yesterdays has code
    jDate = new JulianDate(jDate, -1);
    type = validateAuthCode(code, jDate);
    if (type > 0) return type;
    
    // OK, now that Jeanie can enter future codes, let's check
    // tommorrow's codes
    jDate = new JulianDate(jDate, 2);
    return validateAuthCode(code, jDate);
  }
  
  private static int validateAuthCode(String code, JulianDate jDate) {
    for (int type = 1; type < 3; type++) {
      if (code.equals(calcAuthCode(type, jDate))) return type;
    }
    return 0;
  }
  
  
  
  /**
   * @return Today's authorization code
   */
  public static String getAuthCode(int type) {
    return getAuthCode(type, new Date());
  }
  
  public static String getAuthCode(int type, Date date) {
    return calcAuthCode(type, new JulianDate(date));
  }
  
  /**
   * Return a hash authorization code from a date
   * @param date date to be hashed
   * @return return hashed authorization string
   */
  private static String calcAuthCode(int type, JulianDate jdate) {
    Random rnd = new Random(jdate.hashCode());
    for (int ndx = 1; ndx < type; ndx++) rnd.nextInt();
    int val = Math.abs(rnd.nextInt());
    StringBuffer sb = new StringBuffer();
    for (int j = 0; j < 8; j++) {
       sb.append((char)('A'+ (val % 26)));
       val = val / 26;
    }
    return sb.toString();
  }
}
