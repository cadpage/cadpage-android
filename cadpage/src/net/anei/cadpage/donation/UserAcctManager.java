package net.anei.cadpage.donation;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.anei.cadpage.HttpService;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.billing.BillingManager;
import net.anei.cadpage.donation.UserAcctManager;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class UserAcctManager {
  
  // Authorization recheck interval (30 days in msecs)
  private static final long AUTH_CHECK_INTERVAL = (long)30*24*60*60*1000;
  
  private static final DateFormat DATE_FMT = new SimpleDateFormat("MM/dd/yyyy");
  
  Context context;
  private String[] userEmails = null;
  private String phoneNumber = null;
  private String meid = null;
  
  public void setContext(Context context) {
    this.context = context;
    TelephonyManager tMgr =(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    phoneNumber = tMgr.getLine1Number();
    if (phoneNumber == null) phoneNumber = tMgr.getVoiceMailNumber();
    if (phoneNumber != null) {
      phoneNumber = cleanName(phoneNumber);
      if (phoneNumber.startsWith("+")) phoneNumber = phoneNumber.substring(1);
      if (phoneNumber.startsWith("1")) phoneNumber = phoneNumber.substring(1);
    }
    meid = tMgr.getDeviceId();
    
    List<String> emailList = new ArrayList<String>();
    for (Account acct :  AccountManager.get(context).getAccountsByType("com.google")) {
      emailList.add(acct.name);
    }
    userEmails = emailList.toArray(new String[emailList.size()]);
    
    // See if it is time to perform an automatic reload
    // If this is a lifetime user, don't bother
    if (!ManagePreferences.freeRider()) {
      
      // if not, get the current time and last authorization check time
      long lastTime = ManagePreferences.authLastCheckTime();
      long curTime = System.currentTimeMillis();
      
      // If the last check time is zero, we check to see if the initialized flag has been
      // set.  If not, this is the first time the user has launched Cadpage and we should do
      // an immediate payment status reload to see if they have been a subscriber on another phone.
      if (lastTime <= 0 && ManagePreferences.initialized()) {
        
        // Likewise, if Cadpage has been initialized but the purchase and install dates are the same
        // the purchase date is not trustworthy and we need to reload the payment status immediately
        if (ManagePreferences.paidYear() == 0 ||
            !ManagePreferences.purchaseDate().equals(ManagePreferences.installDate())) {
            
          // Otherwise, we will try to spread out the load by timing the next authorization check 
          // at a random time within the next 30 days
          
            lastTime = curTime - (long)(Math.random()*AUTH_CHECK_INTERVAL);
            ManagePreferences.setAuthLastCheckTime(lastTime);
        }
      }
      
      // Having done all of that, if the different between the current time and the
      // latched checked time exceeds the 30 day intervals, perform an automatic reload
      if (curTime - lastTime > AUTH_CHECK_INTERVAL) {
        
        // Request status reload from android market and authorization server
        UserAcctManager.instance().reloadStatus(context);
      }
    }
  }

  /**
   * Clean extraneous stuff from user name / phone #
   * @param name
   * @return
   */
  private String cleanName(String name) {
    int pt = name.indexOf('<');
    if (pt >= 0) name = name.substring(0,pt);
    name = name.replace("-",  "");
    if (name.startsWith(".")) name = name.substring(1);
    if (name.endsWith(".")) name = name.substring(0,name.length()-1);
    return name;
  }
  
  public void reloadStatus(Context context) {
//    
//    // Lock payment status for 5 seconds to avoid transient reports of
//    // an unpaid status
//    DonationManager.instance().lockStatus(5000);
//    
//    // Rest the basic billing information
//    ManagePreferences.setPaidYear(0);
//    ManagePreferences.setPurchaseDateString(null);
//    ManagePreferences.setFreeSub(false);
//    ManagePreferences.setSponsor(null);
    
    // Request purchase information from Android Market
    // When this information is returned, listeners will pass it to
    // processSubscription(), just like we will.
    BillingManager.instance().initialize(context, true);
    
    // Build query with all of the possible account and phone ID's
    Uri.Builder builder = Uri.parse(context.getString(R.string.donate_server_url)).buildUpon();
    Account[] accounts = AccountManager.get(context).getAccountsByType("com.google");
    for (Account acct : accounts) {
      builder.appendQueryParameter("id", cleanName(acct.name));
    }
    builder.appendQueryParameter("id", phoneNumber);
    
    // Send it to the server and see what comes back
    HttpService.addHttpRequest(context, new HttpRequest(builder.build(), true){

      @Override
      public void processBody(String body) {
        for (String line : body.split("<br>")) {
          
          String flds[] = line.split(",");
          if (flds.length < 2) continue;
          String stat = flds[1].trim();
          String purchaseDate = (flds.length < 3 ? null : flds[2].trim().replace("/", ""));
          String sponsor = (flds.length < 4 ? null : flds[3].trim());
          processSubscription(stat, purchaseDate, sponsor);
        }
        
        // Set the authorization last checked date
        ManagePreferences.setAuthLastCheckTime();

        // Recalculate payment status and refresh display
        DonationManager.instance().reset();
        MainDonateEvent.instance().refreshStatus();

      }
    });
  }
  
  /**
   * Process one subscription request, this can come from the Android market interface
   * or from the Cadpage authorization server response.
   * @param stat - Subscription status, either a subscription year or "LIFE".
   * @param purchaseDateStr - puchase date in MMDDYYY format.
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
    }
  }
  
  
  /**
   * @return true if account management is supported by this version of Android
   */
  public boolean isAcctSupport() {
    return true;
  }

  /**
   * @return identified user account name
   */
  public String getUser() {
    if (userEmails == null || userEmails.length == 0) return null;
    return userEmails[0];
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getMEID() {
    return meid;
  }
  
  /**
   * Append account information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addAccountInfo(StringBuilder sb) {
    sb.append('\n');
    if (userEmails == null || userEmails.length == 0) {
      sb.append("\nNo active email addresses");
    } else {
      for (String email : userEmails) {
        sb.append("\nUser:");
        sb.append(email);
      }
    }
    sb.append('\n');
    sb.append("Phone:");
    sb.append(getPhoneNumber());
    sb.append("\nMEID:");
    sb.append(getMEID());
    int overpaidDays = DonationManager.instance().getOverpaidDays();
    if (overpaidDays > 0) {
      sb.append("\nOverpaid:");
      sb.append(overpaidDays);
    }
  }

  /**
   * Convert user account name to MD5 has
   * @param input user account name
   * @return MD5 hash
   */
  public static String calcHash(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(input.toLowerCase().getBytes("UTF8"));
      byte[] digest = md.digest();
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) {
        sb.append(hexDigit(b>>4));
        sb.append(hexDigit(b));
      }
      return sb.toString();
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }
  
  private static char hexDigit(int i) {
    i &= 0xF;
    return (char)(i < 10 ? '0'+i : 'a'+(i-10));
  }
 
  
  private static UserAcctManager instance = null;
  
  public static void setup(Context context) {
    instance = new UserAcctManager();
    instance.setContext(context);
  }
  
  public static UserAcctManager instance() {
    return instance;
  }
}
