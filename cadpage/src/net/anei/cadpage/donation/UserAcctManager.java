package net.anei.cadpage.donation;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import net.anei.cadpage.HttpService;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.Log;
import net.anei.cadpage.PermissionManager;
import net.anei.cadpage.R;
import net.anei.cadpage.donation.UserAcctManager;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;

public class UserAcctManager {
  
  Context context;
  private String[] userEmails = null;
  private String phoneNumber = null;
  private String meid = null;
  private boolean developer = false;
  
  private static final Pattern SDK_PTN = Pattern.compile(".*(?:^|[_\\W])sdk(?:$|[_\\W]).*");
  
  private UserAcctManager(Context context) {
    this.context = context;
    if (SDK_PTN.matcher(Build.PRODUCT).matches()) developer = true;
  }
  
  public void reset() {
    
    boolean readPhoneStatePerm = PermissionManager.isGranted(context, PermissionManager.READ_PHONE_STATE);
    
    TelephonyManager tMgr =(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    
    // Which permission is required to call getLine1Number() is inconsistent.  Nexus systems require READ_SMS
    // permission, Sprint phones require READ_PHONE_STATE.  Rather than try to figure out which one is
    // require, we will just call it can catch any thrown exceptions.
    phoneNumber = null;
    try {
      phoneNumber = tMgr.getLine1Number();
    } catch (Exception ex) {}
    
    if (phoneNumber == null && readPhoneStatePerm) {
      
      // One user one time reported a security exception abort with this operation
      // Should not have happened, but we will catch it just it case it happens again
      try {
        phoneNumber = tMgr.getVoiceMailNumber();
      } catch (SecurityException ex) {
        Log.e(ex);
      }
    }
    if (phoneNumber != null) {
      int pt = phoneNumber.indexOf(',');
      if (pt >= 0) phoneNumber = phoneNumber.substring(0,pt).trim();
      phoneNumber = cleanName(phoneNumber);
      if (phoneNumber.startsWith("+")) phoneNumber = phoneNumber.substring(1);
      if (phoneNumber.startsWith("1")) phoneNumber = phoneNumber.substring(1);
    }
    meid = readPhoneStatePerm ? tMgr.getDeviceId() : null;
    if (meid == null) meid = getSerialID();
    
    List<String> emailList = new ArrayList<String>();
    for (Account acct :  AccountManager.get(context).getAccountsByType("com.google")) {
      emailList.add(acct.name);
    }
    userEmails = emailList.toArray(new String[emailList.size()]);
    
    // If we are running in an emulator, assume developer status
    if (SDK_PTN.matcher(Build.PRODUCT).matches()) {
      developer = true;
    }
    
    // Otherwise, see if first email is on our developer list
    else {
      if (userEmails.length > 0) {
        String[] developers = context.getResources().getStringArray(R.array.donate_devel_list);
        if (developers != null) {
          developer = Arrays.asList(developers).contains(userEmails[0]);
        }
      }
    }

    // See if it is time to perform an automatic payment status recalculation
    DonationManager.instance().checkPaymentStatus(context);
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
        DonationCalculator calc = new DonationCalculator(2);
        for (String line : body.split("<br>")) {
          
          String flds[] = line.split(",");
          if (flds.length < 2) continue;
          String stat = flds[1].trim();
          if (!STATUS_PTN.matcher(stat).matches()) {
            Log.e("Invalid status:" + stat);
            return;
          }
          String purchaseDate  = null;
          if (flds.length >= 3) {
            purchaseDate = flds[2].trim();
            if (purchaseDate.length() > 0) {
              try {
                DATE_FMT.parse(purchaseDate);
              } catch (ParseException ex) {
                Log.e(ex);
                return;
              }
            }
            purchaseDate = purchaseDate.replace("/", "");
          }
          String sponsor = (flds.length >= 4 ? flds[3].trim() : null);
          calc.subscription(stat, purchaseDate, sponsor);
        }
        calc.save();
      }
    });
  }
  private static final Pattern STATUS_PTN = Pattern.compile("LIFE|\\d{4}", Pattern.CASE_INSENSITIVE);
  private static final DateFormat DATE_FMT = new SimpleDateFormat("MM/dd/yyyy");
  
  
  /**
   * @return true if user has allowed the app permission needed to support account management
   */
  public boolean isAcctSupport() {
    return PermissionManager.isGranted(context, PermissionManager.GET_ACCOUNTS) &&
           PermissionManager.isGranted(context, PermissionManager.READ_SMS) &&
           PermissionManager.isGranted(context, PermissionManager.READ_PHONE_STATE);
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
   * @return true if current user is a developer
   * @Param context current context
   */
  public boolean isDeveloper() {
    return developer;
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
  
  private String getSerialID() {
    return android.os.Build.SERIAL;
  }
  
  private static UserAcctManager instance = null;
  
  public static void setup(Context context) {
    instance = new UserAcctManager(context);
  }
  
  public static UserAcctManager instance() {
    return instance;
  }
}
