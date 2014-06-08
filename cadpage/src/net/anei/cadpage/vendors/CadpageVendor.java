package net.anei.cadpage.vendors;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import net.anei.cadpage.C2DMService;
import net.anei.cadpage.HttpService;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import net.anei.cadpage.HttpService.HttpRequest;
import net.anei.cadpage.donation.DonationManager;
import net.anei.cadpage.donation.PagingProfileEvent;
import net.anei.cadpage.donation.PagingSubRequiredEvent;
import net.anei.cadpage.donation.DonationManager.DonationStatus;
import net.anei.cadpage.donation.UserAcctManager;

class CadpageVendor extends Vendor {
  
  CadpageVendor() {
    super(R.string.cadpage_title,
          R.string.cadpage_summary,
          R.string.cadpage_text,
          R.drawable.ic_launcher,
          R.drawable.cadpage_logo,
          "http://register.cadpage.org/cp/Cadpage.ASP?wci=AndroidX",
          null,
          "dewey@generationconsultants.com");
  }

  @Override
  boolean isAvailable() {
    return true;
  }

  @Override
  void profileReq(Activity activity) {
    PagingProfileEvent.instance().open(activity);
  }

  @Override
  Uri getBaseURI(String req) {
    if (req.equals("info")) return Uri.parse("http://www.cadpage.org/paging-service");
    return super.getBaseURI(req);
  }

  @Override
  void sendRegisterReq(Context context, String registrationId) {
    
    // Check that user really does have a paid subscription
    if (!DonationManager.instance().isPaidSubscriber()) {
      PagingSubRequiredEvent.instance().open(context);
      return;
    }
    Uri uri = buildRequestUri("register", registrationId);
    Uri.Builder builder = uri.buildUpon();
    
    String phone = UserAcctManager.instance().getPhoneNumber();
    if (phone != null) builder.appendQueryParameter("phone", phone);
    
    String meid = UserAcctManager.instance().getMEID();
    if (meid != null) builder.appendQueryParameter("MEID",meid);
    
    String expireDate = calcExpireDate();
    if (expireDate != null) builder.appendQueryParameter("expDate", expireDate);
    
    uri = builder.build();
    HttpService.addHttpRequest(context, new HttpRequest(uri){});
  }
  
  
  /**
   * Update Cadpage services status.
   * Called when either the activation status or expiration date has changed
   * and should be reported to servers
   * @param context current context
   */
  @Override
  void updateCadpageStatus(Context context) {
    
    if (!isEnabled()) return;
    
    Uri uri = buildRequestUri("update", null);
    Uri.Builder builder = uri.buildUpon();
    builder.appendQueryParameter("active", DonationManager.instance().isPaidSubscriber() ? "Y" : "N");
    String expDate = calcExpireDate();
    if (expDate != null) {
      builder.appendQueryParameter("expDate", calcExpireDate());
    }
    
    uri = builder.build();
    HttpService.addHttpRequest(context, new HttpRequest(uri){});
  }
  
  /**
   * Called when a new or changed C2DM registration ID is reported
   * @param context current context
   * @param registrationId registration ID
   * @param userReq true if user requested this action
   * @return true if we actually did anything
   */
  @Override
  boolean registerC2DMId(final Context context, String registrationId, boolean userReq) {
    if (!super.registerC2DMId(context, registrationId, userReq)) return false;
    if (!DonationManager.instance().isStatusUnstable()) {
      updateCadpageStatus(context);
    }
    return true;
  }
 
  /**
   * Called when a direct page alert is received to determine if we are in
   * a consistent state when messages should be received
   * @param context current context
   * @return true if everything is OK, false if message should be suppressed.
   */
  @Override
  boolean checkVendorStatus(Context context) {
    
    // If the current subscription status is untrustworthy, just let it go
    if (DonationManager.instance().isStatusUnstable()) return true;
    
    // Ditto if we are just starting an uninitialized app
    if (! ManagePreferences.initialized()) return true;
    
    
    // If service is not enabled, we have two recovery options
    if (!isEnabled()) {
      
      // If we have currently paid up, send another register request and hope
      // that the server will match on the phone or MEID and restore everything
      if (DonationManager.instance().isPaidSubscriber()) {
        registerReq(context);
        return true;
      }
      
      // If service is not enabled, and no current paid subscription, 
      // drastic action is required.  We do not have
      // any trustworthy account information to pass to the server.  The only way
      // we can pretty reliably break the connection is by unregistering the
      // current registration ID and getting a new one
      else {
        C2DMService.unregister(context);
        return false;
      }
    }
    
    // If service is enabled, but we no longer have a current paid subscription
    // We only need to tell the server this service is no longer active
    else {
      if (!DonationManager.instance().isPaidSubscriber()) {
        updateCadpageStatus(context);
        return false;
      }
      
      // Otherwise, everything is hunky dory
      else {
        return true;
      }
    }
  }

  /**
   * Calculate the expiration date to report
   * @return  calculated expiration date or "LIFE" if lifetime subscriber
   */
  private String calcExpireDate() {
    
    DonationStatus status = DonationManager.instance().status(); 
    String expireDate = null;
    if (status == DonationManager.DonationStatus.LIFE) expireDate = "LIFE";
    else {
      Date expDate = DonationManager.instance().expireDate();
      if (expDate != null) {
        expireDate = DATE_FORMAT.format(expDate);
      } else {
        expireDate = null;
      }
    }
    return expireDate;
  }

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMddyyyy");
}
