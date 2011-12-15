package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsPopupUtils;
import net.anei.cadpage.billing.BillingManager;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class AndroidDonateEvent extends DonateEvent {
  
  public AndroidDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_android_title);
  }

  @Override
  public boolean isEnabled() {
    if (CadPageApplication.isBetaRelease()) return false;
    if (!BillingManager.instance().isPurchaseAvail()) return false;
    return true;
  }

  @Override
  protected void doEvent(Activity activity) {
    if (!SmsPopupUtils.haveNet(activity)) return;
    BillingManager.instance().startPurchase(activity);
    closeEvents(activity);
  }
  
  private static final AndroidDonateEvent instance = new AndroidDonateEvent();
  
  public static AndroidDonateEvent instance() {
    return instance;
  }

}
