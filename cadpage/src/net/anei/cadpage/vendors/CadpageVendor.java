package net.anei.cadpage.vendors;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
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
          "http://paging.cadpage.net",
          null,
          null);
  }
//
//  @Override
//  boolean isAvailable() {
//    return true;
//  }

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
    builder.appendQueryParameter("expDate", calcExpireDate());
    
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
    updateCadpageStatus(context);
    return true;
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
