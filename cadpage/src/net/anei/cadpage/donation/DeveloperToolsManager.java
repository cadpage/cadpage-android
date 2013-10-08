package net.anei.cadpage.donation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.BugReportGenerator;
import net.anei.cadpage.C2DMService;
import net.anei.cadpage.ContentQuery;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;
import net.anei.cadpage.SmsMsgLogBuffer;
import net.anei.cadpage.SmsReceiver;
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
    UserAcctManager acctMgr = UserAcctManager.instance();
    if (acctMgr == null) return false;
    String user = acctMgr.getUser();
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
    "Stat: Lifetime",
    "Stat: Donate paid",
    "Stat: Donate warn",
    "Stat: Donate limbo",
    "Stat: Donate expired",
    "Stat: Demo",
    "Stat: Demo expired",
    "Stat: Free subscription",
    "Stat: Toggle sponsor",
    "Reset release info",
    "Content Query",
    "Recent Tasks",
    "Stat: Roll Last Date",
    "Build Test Message",
    "Status test",
    "Generate Bug Report"
    
  };
  
  private static final String[] valueList = new String[]{
    "31", "32", "33", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"
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
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        ManagePreferences.setPaidYear(-1);
        ManagePreferences.setPurchaseDateString(null);
        ManagePreferences.setAuthRunDays(0);
        ManagePreferences.setInitBilling(false);
        ManagePreferences.setFreeSub(false);
        BillingManager.instance().initialize(context);
        break;
      
      case 1:     // Stat: Donate free
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(true);
        ManagePreferences.setFreeSub(false);
        break;
        
      case 2:     // Stat: Donate paid
        ManagePreferences.setAuthRunDays(100);
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(0);
        setPurchaseDate(-20, -1);
        ManagePreferences.setInstallDate(ManagePreferences.purchaseDate());
        ManagePreferences.setAuthLastCheckTime(0L);
        ManagePreferences.setFreeSub(false);
        break;
        
      case 3:     // Stat: Donate warn
        ManagePreferences.setAuthRunDays(100);
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(-1);
        setPurchaseDate(DonationManager.EXPIRE_WARN_DAYS-2, -3);
        ManagePreferences.setFreeSub(false);
        break;
        
      case 4:     // Stat: Donate Limbo
      case 5:     // Stat: Donate expire
        ManagePreferences.setAuthRunDays(100);
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        Date releaseDate = ManagePreferences.releaseDate();
        setPaidYear(-1, releaseDate);
        int dayDelta = (val == 4 ? 0 : -1);
        setPurchaseDate(dayDelta, -1, releaseDate);
        ManagePreferences.setFreeSub(false);
        break;
      
      case 6:     // Stat: Demo
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear();
        ManagePreferences.setAuthRunDays(10);
        ManagePreferences.setFreeSub(false);
        break;
        
      case 7:     // Stat: Demo expired
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear();
        ManagePreferences.setAuthRunDays(DonationManager.DEMO_LIMIT_DAYS+1);
        ManagePreferences.setFreeSub(false);
        break;
        
      case 8:    // Stat: Free subscriber
        ManagePreferences.setAuthRunDays(100);
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setAuthLocation(null);
        setPaidYear(0);
        setPurchaseDate(-20, -1);
        ManagePreferences.setInstallDate(ManagePreferences.purchaseDate());
        ManagePreferences.setAuthLastCheckTime(0L);
        ManagePreferences.setFreeSub(true);
        break;
        
      case 9:     // Stat: Toggle Sponsor
        String sponsor = ManagePreferences.sponsor();
        sponsor = (sponsor == null ? "Philomath Fire & Rescue" : null);
        ManagePreferences.setSponsor(sponsor);
        break;
        
      case 10:     // Reset release info
        ManagePreferences.setRelease("");
        break;
        
      case 11:     // Content Query
        ContentQuery.query(context);
        break;
        
      case 12:     // Recent tasks
        ContentQuery.dumpRecentTasks(context);
        break;
        
      case 13:    // Roll last date
        ManagePreferences.rollLastAuthDate("01012000");
        break;
        
      case 14:    // Build test message
        
        SmsMmsMessage message = 
          new SmsMmsMessage("Active911", "Test Message", "The SKy is falling", System.currentTimeMillis(),
                            "Cadpage", "Active911", "ARNL2/5/5", "https://cadpageweb.appspot.com/lookup", 
                            null, null, null);
        
        // Add to log buffer
        if (!SmsMsgLogBuffer.getInstance().add(message)) return;
        
        // See if the current parser will accept this as a CAD page
        boolean isPage = message.isPageMsg(SmsMmsMessage.PARSE_FLG_FORCE);
        
        // This should never happen, 
        if (!isPage) return;
        
        // Process the message
        SmsReceiver.processCadPage(context, message);
        break;
        
      case 15:    // Situation specific status test
        ManagePreferences.setPaidYear(2013);
        ManagePreferences.setInstallDate(buildDate("09162013"));
        ManagePreferences.setPurchaseDate(buildDate("09162013"));
        ManagePreferences.setFreeRider(false);
        ManagePreferences.setSponsor(null);
        ManagePreferences.setFreeSub(false);
        ManagePreferences.setAuthLocation(null);
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setAuthExemptDate(null);
        ManagePreferences.setAuthRunDays(0);
        ManagePreferences.setAuthLastCheckTime(1379942474422L);
        break;
        
      case 16:    // generate bug report
        BugReportGenerator.generate();
        break;
        
      case 31:    // C2DM Register
        C2DMService.register(context);
        break;
        
      case 32:    // C2DM Unregister
        C2DMService.unregister(context);
        break;
        
      case 33:    // C2DM: Report
        C2DMService.emailRegistrationId(context);
        break;
      }
      MainDonateEvent.instance().refreshStatus();
    }
    
    private void setPurchaseDate(int dayOffset, int yearOffset, Date baseDate) {
      ManagePreferences.setPurchaseDate(calcDate(dayOffset, yearOffset, baseDate));
    }
    
    private void setPurchaseDate(int dayOffset, int yearOffset) {
      ManagePreferences.setPurchaseDate(calcDate(dayOffset, yearOffset));
    }
    
    private Date calcDate(int dayOffset, int yearOffset) {
      return calcDate(dayOffset, yearOffset, null);
    }
    
    private Date calcDate(int dayOffset, int yearOffset, Date baseDate) {
      if (baseDate == null) baseDate = new Date();
      Calendar cal = new GregorianCalendar();
      cal.setTime(baseDate);
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
      setPaidYear(yearOffset, null);
    }
    
    private void setPaidYear(int yearOffset, Date baseDate) {
      if (baseDate == null) baseDate = new Date();
      Calendar cal = new GregorianCalendar();
      cal.setTime(baseDate);
      int year = cal.get(Calendar.YEAR);
      year = yearOffset == Integer.MIN_VALUE ? 0 : year+yearOffset;
      ManagePreferences.setPaidYear(year);
    }
    
  }
  
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMddyyyy");
  private Date buildDate(String dateStr) {
    try {
      return DATE_FORMAT.parse(dateStr);
    } catch (ParseException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  
  
  private static DeveloperToolsManager instance = new DeveloperToolsManager();
  
  public static DeveloperToolsManager instance() {
    return instance;
  }

}
