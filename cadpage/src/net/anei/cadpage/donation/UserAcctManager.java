package net.anei.cadpage.donation;

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
        String name = acct.name.toLowerCase();
        if (userEmail == null) userEmail = acct.name;
        if (Arrays.binarySearch(freeList, name) >= 0) {
          userEmail = acct.name;
          ManagePreferences.setFreeRider(true);
        }
        if (Arrays.binarySearch(paid2011List, name) >= 0) {
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
  
  
  private static UserAcctManager instance = null;
  
  public static void setup(Context context) {
    instance = new UserAcctManager(context);
  }
  
  public static UserAcctManager instance() {
    return instance;
  }
}
