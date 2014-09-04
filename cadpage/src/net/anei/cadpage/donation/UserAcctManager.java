package net.anei.cadpage.donation;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import net.anei.cadpage.HttpService;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.R;
import net.anei.cadpage.donation.UserAcctManager;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class UserAcctManager {
  
  Context context;
  private String[] userEmails = null;
  private String phoneNumber = null;
  private String meid = null;
  
  public void setContext(Context context) {
    this.context = context;
    TelephonyManager tMgr =(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    phoneNumber = tMgr.getLine1Number();
    if (phoneNumber == null) phoneNumber = tMgr.getVoiceMailNumber();
    if (phoneNumber != null) {
      phoneNumber = cleanName(phoneNumber);
      if (phoneNumber.startsWith("+")) phoneNumber = phoneNumber.substring(1);
      if (phoneNumber.startsWith("1")) phoneNumber = phoneNumber.substring(1);
    }
    meid = tMgr.getDeviceId();
    
    List<String> emailList = new ArrayList<String>();
    for (Account acct :  AccountManager.get(context).getAccountsByType("com.google")) {
      emailList.add(acct.name);
    }
    userEmails = emailList.toArray(new String[emailList.size()]);
    
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

    // Place status recalc hold until this completes successfully
    DonationManager.instance().holdRecalc(true, "ServerQuery");
    
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
        for (String line : body.split("<br>")) {
          
          String flds[] = line.split(",");
          if (flds.length < 2) continue;
          String stat = flds[1].trim();
          String purchaseDate = (flds.length < 3 ? null : flds[2].trim().replace("/", ""));
          String sponsor = (flds.length < 4 ? null : flds[3].trim());
          DonationManager.processSubscription(stat, purchaseDate, sponsor);
        }
        DonationManager.instance().holdRecalc(false, "ServerQuery");
      }
    });
  }
  
  
  /**
   * @return true if account management is supported by this version of Android
   */
  public boolean isAcctSupport() {
    return true;
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
    instance = new UserAcctManager();
    instance.setContext(context);
  }
  
  public static UserAcctManager instance() {
    return instance;
  }
}
