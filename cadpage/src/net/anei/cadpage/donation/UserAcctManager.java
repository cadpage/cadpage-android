package net.anei.cadpage.donation;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;

public abstract class UserAcctManager {
  
  public abstract void setContext(Context context);
  
  /**
   * @return true if account management is supported by this version of Android
   */
  public abstract boolean isAcctSupport();

  /**
   * @return identified user account name
   */
  public abstract String getUser();
  
  /**
   * Append account information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addAccountInfo(StringBuilder sb) {
    sb.append("User:");
    sb.append(getUser());
    sb.append('\n');
  }

  // This really is used, but we have to invoke the class at runtime because it
  // references API calls that do not exist in Android 1.6
  public static class RealUserAcctManager extends UserAcctManager implements OnAccountsUpdateListener {
    
    Context context;
    private String userEmail = null;
    
    @Override
    public void setContext(Context context) {
      this.context = context;
      AccountManager.get(context).addOnAccountsUpdatedListener(this, null, true);
    }
  
    @Override
    public void onAccountsUpdated(Account[] accts) {
      userEmail = null;
      String[] freeList = context.getResources().getStringArray(R.array.free_rider_list);
      String[] paid2011List = context.getResources().getStringArray(R.array.paid_2011_list);
      for (Account acct : accts) {
        if (acct.type.equals("com.google")) {
          String name = acct.name;
          int pt = name.indexOf('<');
          if (pt >= 0) name = name.substring(0,pt);
          if (name.startsWith(".")) name = name.substring(1);
          if (name.endsWith(".")) name = name.substring(0,name.length()-1);
          String hash = calcHash(acct.name);
          if (userEmail == null) userEmail = name;
          if (Arrays.binarySearch(freeList, hash) >= 0) {
            userEmail = name;
            ManagePreferences.setFreeRider(true);
          }
          if (Arrays.binarySearch(paid2011List, hash) >= 0) {
            ManagePreferences.setPaidYear(2011, true);
            if (ManagePreferences.purchaseDate() == null) {
              ManagePreferences.setPurchaseDate(new Date());
            }
            if (userEmail == null) userEmail = name;
          }
        }
      }
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
  
    /**
     * @return identified user account name
     */
    @Override
    public String getUser() {
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
      String className = "net.anei.cadpage.donation.UserAcctManager$RealUserAcctManager";
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
