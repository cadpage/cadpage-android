package net.anei.cadpage.donation;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.C2DMReceiver;
import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.billing.BillingManager;
import android.content.Context;
import android.preference.ListPreference;
import android.preference.PreferenceGroup;

/**
 * Handles special debugging tools and dialogs available only to developers
 */
public class DeveloperToolsManager {
  
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
  
  public boolean addPreference(Context context, PreferenceGroup group) {
    if (!isDeveloper(context)) return false;
    group.addPreference(new DeveloperListPreference(context));
    
    return true;
  }
  
  
  private static final String[] entryList = new String[]{
    "C2DM: Register",
    "C2DM: Unregister",
    "C2DM: Report",
    "Stat: Reset",
    "Stat: Free",
    "Stat: Donate paid",
    "Stat: Donate warn",
    "Stat: Donate expired",
    "Stat: Demo",
    "Stat: Demo expired",
    "Reset release info",
    "Content Query",
    "Recent Tasks"
    
  };
  
  private static final String[] valueList = new String[]{
    "31", "32", "33", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
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
      
      case 0:     // Stat: Reset
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        ManagePreferences.setPaidYear(-1);
        ManagePreferences.setPurchaseDateString(null);
        ManagePreferences.setInitBilling(false);
        BillingManager.instance().initialize(context);
        break;
      
      case 1:     // Stat: Donate free
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(true);
        break;
        
      case 2:     // Stat: Donate paid
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(0);
        setPurchaseDate(-20, -1);
        break;
        
      case 3:     // Stat: Donate warn
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(-1);
        setPurchaseDate(DonationManager.EXPIRE_WARN_DAYS-2, -3);
        break;
        
      case 4:     // Stat: Donate expire
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(-1);
        setPurchaseDate(-1, -3);
        break;
      
      case 5:     // Stat: Demo
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear();
        setInstallDate(-10, 0);
        break;
        
      case 6:     // Stat: Demo expired
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setMinInstallDate((String)null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear();
        setInstallDate(-(DonationManager.DEMO_LIMIT_DAYS+1), 0);
        break;
        
      case 7:     // Reset release info
        ManagePreferences.setRelease("");
        break;
        
      case 8:     // Content Query
        ContentQuery.query(context);
        break;
        
      case 9:     // Recent tasks
        ContentQuery.dumpRecentTasks(context);
        break;
        
      case 31:    // C2DM Register
        C2DMReceiver.register(context);
        break;
        
      case 32:    // C2DM Unregister
        C2DMReceiver.unregister(context);
        break;
        
      case 33:    // C2DM: Report
        C2DMReceiver.emailRegistrationId(context);
        break;
      }
      MainDonateEvent.instance().refreshStatus();
    }
    
    private void setPurchaseDate(int dayOffset, int yearOffset) {
      ManagePreferences.setPurchaseDate(calcDate(dayOffset, yearOffset));
    }
    
    private void setInstallDate(int dayOffset, int yearOffset) {
      ManagePreferences.setInstallDate(calcDate(dayOffset, yearOffset));
    }
    
    private Date calcDate(int dayOffset, int yearOffset) {
      Calendar cal = new GregorianCalendar();
      cal.set(Calendar.HOUR, 0);
      cal.set(Calendar.MINUTE, 0);
      cal.set(Calendar.SECOND, 0);
      cal.set(Calendar.MILLISECOND, 0);
      cal.add(Calendar.DAY_OF_YEAR, dayOffset);
      cal.add(Calendar.YEAR, yearOffset);
      return cal.getTime();
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
