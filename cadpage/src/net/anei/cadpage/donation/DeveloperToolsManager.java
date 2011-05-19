package net.anei.cadpage.donation;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
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
  
  
  private static class DeveloperListPreference extends ListPreference {
    
    private static final String[] entryList = new String[]{
      "Stat: Donate paid",
      "Stat: Demo",
      "Stat: Demo expired"
    };
    
    private static final String[] valueList = new String[]{
      "1", "2", "3"
    };

    public DeveloperListPreference(Context context) {
      super(context);
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
      
      case 1:     // Stat: Donate paid
        ManagePreferences.setFreeRider(true);
        break;
      
      case 2:     // Stat: Demo
        ManagePreferences.setFreeRider(false);
        setInstallDate(-10);
        break;
        
      case 3:     // Stat: Demo expired
        ManagePreferences.setFreeRider(false);
        setInstallDate(-(DonationManager.DEMO_LIMIT_DAYS+1));
        break;
        
      }
      MainDonateEvent.instance().actionComplete();
    }
    
    
    private void setInstallDate(int dayOffset) {
      Calendar cal = new GregorianCalendar();
      cal.add(Calendar.DAY_OF_YEAR, dayOffset);
      ManagePreferences.setInstallDate(cal.getTime());
    }
    
  }
  
  
  
  
  private static DeveloperToolsManager instance = new DeveloperToolsManager();
  
  public static DeveloperToolsManager instance() {
    return instance;
  }

}
