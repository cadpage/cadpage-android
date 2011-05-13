package net.anei.cadpage.donation;

import java.util.Arrays;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.preference.Preference;

public class DonationManager implements OnAccountsUpdateListener {
  
  // Flag to disable untested logic for production runs
  private static final boolean DISABLE = true;
  
  Context context;
  private String userEmail = null;
  
  private DonationManager(Context context) {
    this.context = context;
    AccountManager.get(context).addOnAccountsUpdatedListener(this, null, true);
  }

  @Override
  public void onAccountsUpdated(Account[] accts) {
    userEmail = null;
    String[] freeList = context.getResources().getStringArray(R.array.free_rider_list);
    for (Account acct : accts) {
      if (acct.type.equals("com.google")) {
        if (userEmail == null) userEmail = acct.name;
        if (Arrays.binarySearch(freeList, acct.name.toLowerCase()) >= 0) {
          userEmail = acct.name;
          ManagePreferences.setFreeRider(true);
        }
      }
    }
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
   * Set up the donation status preference in the preference settings
   * @param context current context
   * @param pref Donation status preference
   */
  public static void setPreference(Context context, Preference pref) {
    if (DISABLE) {
      pref.setShouldDisableView(true);
      pref.setEnabled(false);
    }
    for (DonateEvent event : events) {
      if (event.setPreference(context, pref)) return;
    }
  }

  // List of toplevel donate events
  private static final DonateEvent[] events = new DonateEvent[]{
    FreeDonateEvent.instance(),
    DemoDonateEvent.instance()
  };
  
  
  private static DonationManager instance = null;
  
  public static void setup(Context context) {
    instance = new DonationManager(context);
  }
  
  public static DonationManager instance() {
    return instance;
  }

}
