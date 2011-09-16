package net.anei.cadpage.donation;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

//import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.content.Context;
import android.preference.ListPreference;
import android.preference.PreferenceGroup;

/**
 * Handles special debugging tools and dialogs available only to developers
 */
public class DeveloperToolsManager {
  
  private boolean enableBilling = false;
  
  // private constructor
  private DeveloperToolsManager() {}
  
  
  /**
   * @return true if current user is a developer
   * @Param context current context
   */
  public boolean isDeveloper(Context context) {
    
    // Get current user account name
    String user = UserAcctManager.instance().getUser();
    if (user == null) return false;
    
    // See if it is in our developer list
    String[] developers = context.getResources().getStringArray(R.array.donate_devel_list);
    if (developers == null) return false;
    return Arrays.asList(developers).contains(user);
  }
  
  /**
   * @return true if in-app billing menu should be enabled
   */
  public boolean isBillingEnabled() {
    return enableBilling;
  }
  
  public boolean addPreference(Context context, PreferenceGroup group) {
    if (!isDeveloper(context)) return false;
    group.addPreference(new DeveloperListPreference(context));
    
    return true;
  }
  
  
  private static final String[] entryList = new String[]{
    "Stat: Free",
    "Stat: Donate paid",
    "Stat: Donate warn",
    "Stat: Donate expired",
    "Stat: Demo",
    "Stat: Demo expired",
    "Reset release info",
    "Toggle In-app Billing",
    "Content Query",
    "Recent Tasks"
    
  };
  
  private static final String[] valueList = new String[]{
    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
  };
  
  private class DeveloperListPreference extends ListPreference {
    
    private Context context;

    public DeveloperListPreference(Context context) {
      super(context);
      this.context = context;
      setTitle("Developer Debug Tools");
      setSummary("Only available for developers");
      setEntries(entryList);
      setEntryValues(valueList);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
      super.onDialogClosed(positiveResult);
      if (!positiveResult) return;
      
      int val = Integer.parseInt(getValue().toString());
      switch (val) {
      
      case 1:     // Stat: Donate free
        ManagePreferences.setFreeRider(true);
        break;
        
      case 2:     // Stat: Donate paid
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(0);
        setInstallDate(-20, -1);
        break;
        
      case 3:     // Stat: Donate warn
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(-1);
        setInstallDate(DonationManager.EXPIRE_WARN_DAYS-2, -3);
        break;
        
      case 4:     // Stat: Donate expire
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(-1);
        setInstallDate(-1, -3);
        break;
      
      case 5:     // Stat: Demo
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear();
        setInstallDate(-10, 0);
        break;
        
      case 6:     // Stat: Demo expired
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear();
        setInstallDate(-(DonationManager.DEMO_LIMIT_DAYS+1), 0);
        break;
        
      case 7:     // Reset release info
        ManagePreferences.setRelease("");
        break;
        
      case 8:     // toggle in-app billing
        enableBilling = !enableBilling;
        break;
        
      case 9:     // Content Query
        ContentQuery.query(context);
        break;
        
      case 10:     // Recent tasks
        ContentQuery.dumpRecentTasks(context);
        break;
      }
      MainDonateEvent.instance().refreshStatus();
    }
    
    
    private void setInstallDate(int dayOffset, int yearOffset) {
      Calendar cal = new GregorianCalendar();
      cal.set(Calendar.HOUR, 0);
      cal.set(Calendar.MINUTE, 0);
      cal.set(Calendar.SECOND, 0);
      cal.set(Calendar.MILLISECOND, 0);
      cal.add(Calendar.DAY_OF_YEAR, dayOffset);
      cal.add(Calendar.YEAR, yearOffset);
      ManagePreferences.setInstallDate(cal.getTime());
    }
    
    private void setPaidYear() {
      setPaidYear(Integer.MIN_VALUE);
    }
    
    private void setPaidYear(int yearOffset) {
      Calendar cal = new GregorianCalendar();
      int year = cal.get(Calendar.YEAR);
      year = yearOffset == Integer.MIN_VALUE ? 0 : year+yearOffset;
      ManagePreferences.setPaidYear(year);
    }
    
  }
  
  
  
  
  private static DeveloperToolsManager instance = new DeveloperToolsManager();
  
  public static DeveloperToolsManager instance() {
    return instance;
  }

}
