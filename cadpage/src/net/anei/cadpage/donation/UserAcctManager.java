package net.anei.cadpage.donation;

import java.security.MessageDigest;
import java.util.Arrays;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;

public class UserAcctManager implements OnAccountsUpdateListener {
  
  Context context;
  private String userEmail = null;
  
  private UserAcctManager(Context context) {
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
        String hash = calcHash(acct.name);
        if (userEmail == null) userEmail = acct.name;
        if (Arrays.binarySearch(freeList, hash) >= 0) {
          userEmail = acct.name;
          ManagePreferences.setFreeRider(true);
        }
        if (Arrays.binarySearch(paid2011List, hash) >= 0) {
          ManagePreferences.setPaidYear(2011);
          if (userEmail == null) userEmail = acct.name;
        }
      }
    }
  }

  /**
   * @return identified user account name
   */
  public String getUser() {
    return userEmail;
  }
  

  /**
   * Append account information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addAccountInfo(StringBuilder sb) {
    sb.append("User:");
    sb.append(userEmail);
    sb.append('\n');
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
    instance = new UserAcctManager(context);
  }
  
  public static UserAcctManager instance() {
    return instance;
  }
}
