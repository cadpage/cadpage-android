package net.anei.cadpage.donation;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import net.anei.cadpage.HttpService;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.donation.UserAcctManager;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.net.Uri;
import android.telephony.TelephonyManager;

public abstract class UserAcctManager {
  
  public abstract void setContext(Context context);
  
  public abstract void reloadStatus(Context context);

  /**
   * @return true if account management is supported by this version of Android
   */
  public abstract boolean isAcctSupport();

  /**
   * @return identified user account name
   */
  public abstract String getUser();
  
  /**
   * @return device phone number
   */
  public abstract String getPhoneNumber();
  
  /**
   * Append account information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addAccountInfo(StringBuilder sb) {
    sb.append("User:");
    sb.append(getUser());
    sb.append('\n');
    sb.append("Phone:");
    sb.append(getPhoneNumber());
  }

  // This really is used, but we have to invoke the class at runtime because it
  // references API calls that do not exist in Android 1.6
  public static class RealUserAcctManager extends UserAcctManager implements OnAccountsUpdateListener {
    
    private static final DateFormat DATE_FMT = new SimpleDateFormat("MM-dd-yyyy");
    
    Context context;
    private String userEmail = null;
    private String phoneNumber = null;
    
    @Override
    public void setContext(Context context) {
      this.context = context;
      AccountManager.get(context).addOnAccountsUpdatedListener(this, null, true);
      TelephonyManager tMgr =(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
      phoneNumber = tMgr.getLine1Number();
      if (phoneNumber == null) phoneNumber = tMgr.getVoiceMailNumber();
      phoneNumber = cleanName(phoneNumber);
      checkAccount(phoneNumber, false);
    }
  
    @Override
    public void onAccountsUpdated(Account[] accts) {
      userEmail = null;
      for (Account acct : accts) {
        if (acct.type.equals("com.google")) {
          String name = cleanName(acct.name);
          if (userEmail == null) userEmail = name;
          checkAccount(name, true);
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
      if (name.startsWith(".")) name = name.substring(1);
      if (name.endsWith(".")) name = name.substring(0,name.length()-1);
      return name;
    }
    
    /**
     * Check an account number/phone number against precompiled lists of users
     * @param acct account number/phone number
     * @param isAcct true if account number, false if phone number
     */
    private void checkAccount(String acct, boolean isAcct) {
      String[] freeList = context.getResources().getStringArray(R.array.free_rider_list);
      String[] paid2011List = context.getResources().getStringArray(R.array.paid_2011_list);
      String hash = calcHash(acct);
      if (Arrays.binarySearch(freeList, hash) >= 0) {
        if (isAcct) userEmail = acct;
        ManagePreferences.setFreeRider(true);
      }
      if (Arrays.binarySearch(paid2011List, hash) >= 0) {
        ManagePreferences.setPaidYear(2011, true);
        if (ManagePreferences.purchaseDate() == null) {
          ManagePreferences.setPurchaseDate(new Date());
        }
        if (isAcct && userEmail == null) userEmail = acct;
      }
    }
    
    @Override
    public void reloadStatus(Context context) {
      
      // For now, only developers get do this
      if (! DeveloperToolsManager.instance().isDeveloper(context)) return;
      
      // Build query with all of the possible account and phone ID's
      Uri.Builder builder = Uri.parse(context.getString(R.string.donate_server_url)).buildUpon();
      Account[] accounts = AccountManager.get(context).getAccountsByType("com.google");
      for (Account acct : accounts) {
        builder.appendQueryParameter("id", cleanName(acct.name));
      }
      builder.appendQueryParameter("id", phoneNumber);
      
      // Send it to the server and see what comes back
      HttpService.addHttpRequest(context, new HttpRequest(builder.build()){

        @Override
        public void processBody(String body) {
          String flds[] = body.split(",");
          if (flds.length < 2) return;
          Date purchaseDate = null;
          try {
            purchaseDate = DATE_FMT.parse(flds[0].trim());
          } catch (ParseException ex) {}
          if (purchaseDate != null) {
            ManagePreferences.setPurchaseDate(purchaseDate);
          }
          
          String stat = flds[1].trim();
          if (stat.equals("LIFE")) {
            ManagePreferences.setFreeRider(true);
          } else {
            int year = -1;
            try {
              year = Integer.parseInt(stat);
            } catch (NumberFormatException ex) {}
            if (year >=2011 && year <= 2050) ManagePreferences.setPaidYear(year);
          }
        }
      });
    }
    
    
    /**
     * @return true if account management is supported by this version of Android
     */
    @Override
    public boolean isAcctSupport() {
      return true;
    }
  
    /**
     * @return identified user account name
     */
    @Override
    public String getUser() {
      return userEmail;
    }

    @Override
    public String getPhoneNumber() {
      return phoneNumber;
    }
  }

  private static class DummyUserAcctManager extends UserAcctManager {
    
    public void setContext(Context context) {}
    
    /**
     * @return true if account management is supported by this version of Android
     */
    @Override
    public boolean isAcctSupport() {
      return false;
    }

    @Override
    public void reloadStatus(Context context) {
    }
  
    /**
     * @return identified user account name
     */
    @Override
    public String getUser() {
      return null;
    }

    @Override
    public String getPhoneNumber() {
      return null;
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
    try {
      String className = UserAcctManager.class.getName() + "$RealUserAcctManager";
      instance = (UserAcctManager)Class.forName(className).newInstance();
      instance.setContext(context);
    } catch (Exception ex) {
      instance = new DummyUserAcctManager();
    }
  }
  
  public static UserAcctManager instance() {
    return instance;
  }
}
