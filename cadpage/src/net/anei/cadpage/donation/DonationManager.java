package net.anei.cadpage.donation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import android.content.Context;
import android.os.Handler;
import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.EmailDeveloperActivity;
import net.anei.cadpage.Log;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.billing.BillingManager;
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

  private static final Random RANDOM = new Random();
  
  // Cached calculated values are only valid until this time
  private long validLimitTime = 0L;
  
  // Cached expiration date
  private Date expireDate;
  
  // Cached days since install
  private int daysSinceInstall;
  
  // cached days until Cadpage expires
  private int daysTillExpire;
  
  // Cached donation status
  private DonationStatus status = null;
  
  // Cached enable Cadpage status
  private boolean enabled;
  
  // Cached Sponsor name
  private String sponsor;
  
  // Cached overpaid days
  private int overpaidDays;
  
  // Cached paid subscriber status
  private boolean paidSubscriber;
  
  private Handler handler = new Handler();
  private boolean recalcInProgress = false;
  private int recalcCount = 0;
  private boolean priorPaidSubscriber = false;
  private Date priorExpireDate = null;
  
  /**
   * Reload payment status
   */
  public void reloadStatus() {
    
    Log.v("Payment status recalc requested");
    
    // For one thing, we are not going to allow recursive recalcs
    if (recalcInProgress) return;
    
    // Do not do anything until Market billing is up and runing
    BillingManager.instance().runWhenSupported(new ReloadStatusEvent());
  }

  // ReloadStatusEven is run when billing services are up and running
  private class ReloadStatusEvent implements Runnable {
    @Override
    public void run() {
      
      Log.v("Payment status recalc starting");
      
      // Lock current status and defer recalculation for 5 seconds
      // Then recalculate status and refresh all displays
      calculate();
      recalcInProgress = true;
      recalcCount = 0;
      priorPaidSubscriber = paidSubscriber;
      priorExpireDate = expireDate;
      
      ManagePreferences.setPaidYear(0);
      ManagePreferences.setPurchaseDateString(null);
      ManagePreferences.setFreeSub(false);
      ManagePreferences.setSponsor(null);
      
      // Defer the final calculation for 10 seconds to give
      // everything time to come in.
      handler.postDelayed(new CloseReloadStatusEvent(), 10000);
      
      refreshStatus(CadPageApplication.getContext());
    }
  }
  
  /**
   * Runnable event executed 5 seconds after recalculation is initiated
   * to close things up
   */
  private class CloseReloadStatusEvent implements Runnable {
    @Override
    public void run() {
      reset();
      recalculate();
      
      // Set the authorization last checked date
      ManagePreferences.setAuthLastCheckTime();

      // Display any status changes
      DonationManager.instance().reset();
      MainDonateEvent.instance().refreshStatus();
      
      // The recalculate process has been known to drop market subscription information
      // We believe we have identified and fixed at least one reason why this happens
      // but just in case we missed one, we will check to see if user
      // has lost a paid subscription status and if they have, retry loading
      // both subscriber sources up to 2 times at 60-90 second intervals
      if (priorPaidSubscriber && !paidSubscriber) {
        EmailDeveloperActivity.logSnapshot(CadPageApplication.getContext(), "Payment Status Downgrade");
        if (recalcCount < 2) {
          recalcCount++;
          long delay = 60 + RANDOM.nextInt(30);
          Log.v("Schedule followup reload #" + recalcCount + " in " + delay + " seconds");
          handler.postDelayed(new RetryReloadStatusEvent(), delay*1000L);
          return;
        }
      }
      // If everything is solid and stable, update the Cadpage Paging service status
      updatePagingStatus(priorPaidSubscriber, priorExpireDate);
      
      // And reset the calculation in progress flag
      recalcInProgress = false;
      
      Log.v("Recalculation of Payment Status completed");
    }
  }
  
  /**
   * Runnable event scheduled 60-90 seconds after an undesirable recalculation
   * outcome.  Makes another attempt to reload the subscription information
   */
  private class RetryReloadStatusEvent implements Runnable {
    @Override
    public void run() {
      Log.v("Reloading subscription information");
      handler.postDelayed(new CloseReloadStatusEvent(), 5000);
      refreshStatus(CadPageApplication.getContext());
    }
  }
  /**
   * Refresh payment status with latest information from market and from authorization server
   * @param context
   */
  public void refreshStatus(Context context) {
    // Request purchase information from Android Market
    // When this information is returned, listeners will pass it to
    // processSubscription()
    BillingManager.instance().restoreTransactions();
    
    // Request authorization information from authorization server
    // this will also call our processSubscription() method
    UserAcctManager.instance().reloadStatus(context);
  }
  
  /**
   * Process one subscription request, this can come from the Android market interface
   * or from the Cadpage authorization server response.
   * @param stat - Subscription status, either a subscription year or "LIFE".
   * @param purchaseDateStr - purchase date in MMDDYYY format.
   * @param sponsor
   */
  public static void processSubscription(String stat, String purchaseDateStr, String sponsor) {
    
    // This gets called from multiple threads, so we had better lock internal processing
    synchronized (UserAcctManager.class) {
      
      // Evaluate the status field.  Value of LIFE translates to year 9999
      int year = -1;
      if (stat.toUpperCase().equals("LIFE")) {
        year = 9999;
      } else {
        try {
          year = Integer.parseInt(stat);
        } catch (NumberFormatException ex) {}
        if (year < 2011 && year > 2050) year = -1;
      }
      
      // get the current status year.  If better than this status, we can
      // completely ignore everything
      int paidYear = ManagePreferences.freeRider() ? 9999 : ManagePreferences.paidYear();
      if (year < paidYear) return;
      
      // Next get the current and new free subscriber status
      boolean freeSub = sponsor != null && sponsor.equals("FREE");
      boolean curFreeSub = ManagePreferences.freeSub();

      // if this year is better than current year, update current paid year status
      if (year > paidYear) {
        if (year == 9999) {
          ManagePreferences.setFreeRider(true);
        } else {
          ManagePreferences.setPaidYear(year, true);
        }
      }
      
      // If years are the same, a free subscription request can not override
      // an existing paid request
      else if (year == paidYear && freeSub && !curFreeSub) return;
      
      // Purchase date processing, only if we have one of course
      if (purchaseDateStr != null) {
        
        // If subscription year is better than last, this purchase date takes
        // priority.  If year is the same,  use this purchase date if it is
        // later than the current date.  Unless the current purchase date was
        // a free subscription and this one was not.
        //
        // The purchase date comparison only compares the month and day.  The
        // purchase year is not relevant
        if (year == paidYear && (freeSub || !curFreeSub)) {
          String curPurchaseDateStr  = ManagePreferences.purchaseDateString();
          if (curPurchaseDateStr != null && 
              curPurchaseDateStr.substring(0,4).compareTo(purchaseDateStr.substring(0,4))>0) {
            purchaseDateStr = curPurchaseDateStr;
          }
        }
        ManagePreferences.setPurchaseDateString(purchaseDateStr);
      }
      
      // Set sponsor and free subscription status
      if (freeSub || (sponsor != null && sponsor.length() == 0)) sponsor = null;
      ManagePreferences.setFreeSub(freeSub);
      ManagePreferences.setSponsor(sponsor);
      
      // Call calculation on the off chance this is not part of a recalculation
      DonationManager.instance().reset();
      MainDonateEvent.instance().refreshStatus();
    }
  }
  
  /**
   * Calculate all cached values
   * and report any status changes to paging service
   */
  private void calculate() {
    
    // Status remains locked while a status recalculation is in progress
    if (recalcInProgress) return;
    
    boolean startup = (status == null);
    final boolean oldPaidSubscriber = paidSubscriber;
    final Date oldExpireDate = expireDate;
    
    recalculate();
    
    if (!startup) {
      updatePagingStatus(oldPaidSubscriber, oldExpireDate);
    }
    
  }
  
  /**
   * Calculate all cached values
   * But do not report any status changes to Paging Service
   */
  private void recalculate() {

    // If this is the free version of Cadpage, we can skip all of the hard stuff
    if (this.getClass().getName().contains(".cadpagefree")) {
      status = DonationStatus.FREE;
      paidSubscriber = false;
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
    
    // See if user is subscribed to Capage paging.  that can change the status
    // in some circumstances
    boolean paidSubReq = VendorManager.instance().isPaidSubRequired();
    
    // Get sponsor name and expiration date from either the
    // Vendor manager or the current parser.  Neither counts as a paid
    // subscription for Cadpage paging service
    sponsor = null;
    JulianDate regJDate = null;
    expireDate = null;
    if (!paidSubReq) {
      sponsor = VendorManager.instance().getSponsor();
      if (sponsor != null) {
        Date regDate = ManagePreferences.registerDate();
        if (regDate == null) {
          ManagePreferences.setRegisterDate();
          regJDate = curJDate;
        } else {
          regJDate = new JulianDate(regDate);
        }
      }
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
    paidSubscriber = false;
    int paidYear = ManagePreferences.paidYear();
    if (paidYear > 0) {
      Date tDate = ManagePreferences.purchaseDate();
      if (tDate == null) tDate = ManagePreferences.installDate();
      Calendar cal = new GregorianCalendar();
      cal.setTime(tDate);
      cal.set(Calendar.YEAR, paidYear+1);
      tDate = cal.getTime();
      JulianDate tJDate = new JulianDate(tDate);
      
      // If there is a sponsored vendor register date and they have a paid subscription
      // expiration date, compute the number of days between them.  This is the number 
      // of days they have been doubled billed by both us and the vendor
      if (regJDate != null) {
        overpaidDays = regJDate.diffDays(tJDate); 
      }
      
      // They only get the coverted paid subscriber status if this is a real
      // paid subscription and this expiration date has not passed
      if (!ManagePreferences.freeSub()) {
        if (curJDate.diffDays(tJDate) >= 0) paidSubscriber = true;
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
      if (!paidSubReq && daysTillSubExpire < 0) {
        JulianDate jReleaseDate = new JulianDate(ManagePreferences.releaseDate());
        limbo = jReleaseDate.diffDays(jExpireDate) >= 0;
      }
    }
    daysTillExpire = Math.max(daysTillDemoEnds, daysTillSubExpire);
    
    // OK, we have calculated all of the intermediate stuff.  Now use that to
    // determine the overall status
    String location = ManagePreferences.location();
    if (ManagePreferences.freeRider()) {
      status = DonationStatus.LIFE;
      paidSubscriber = true;
    }
    else if (paidSubReq && !paidSubscriber) {
      status = (sponsor == null ? DonationStatus.PAID_EXPIRE : DonationStatus.SPONSOR_EXPIRE);
    }
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
    
    // None of the exceptions apply if they are using paging service
    if (!paidSubReq) {

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
   * Report any status changes that would affect the cadpage paging service
   * @param oldPaidSubscriber
   * @param oldExpireDate
   */
  private void updatePagingStatus(boolean oldPaidSubscriber, Date oldExpireDate) {
    
    // If the aren't registered with our paging service, nothing needs to be done
    if (!VendorManager.instance().isPaidSubRequired()) return;

    // If neither the paid subscriber or expiration date have changed
    // nothing needs to be done
    boolean expDateSame = (expireDate == null ? oldExpireDate == null :
                           oldExpireDate == null ? false :
                           expireDate.equals(oldExpireDate));
    if (paidSubscriber == oldPaidSubscriber && expDateSame) return;

    // Report whatever changed to the Cadpage service vendor
    Context context = CadPageApplication.getContext();
    VendorManager.instance().updateCadpageStatus(context);
    
    // If the paid subscriber status had changed, this should be reported
    // to the user
    if (paidSubscriber != oldPaidSubscriber) {
      if (paidSubscriber) {
        PagingProfileEvent.instance().open(context);
      } else {
        MainDonateEvent.instance().open(context);
      }
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
    if (recalcInProgress) return true;
    calculate();
    return enabled;
  }
  
  /**
   * @return number of overpaid days
   */
  public int getOverpaidDays() {
    return overpaidDays;
  }
  
  /**
   * @return true if user is a real true paid subscriber
   */
  public boolean isPaidSubscriber() {
    calculate();
    return paidSubscriber;
  }
  
  /**
   * @return true if current paid subscriber status is currently in the
   * process of being evaluated and should not, therefore, be trusted
   */
  public boolean isStatusUnstable() {
    return recalcInProgress;
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
      if (code.equals(DonationUtil.calcAuthCode(type, jDate))) return type;
    }
    return 0;
  }
}
