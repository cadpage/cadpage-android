package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.R;
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
    return DeveloperToolsManager.instance().isBillingEnabled() && 
            BillingManager.instance().isPurchaseAvail();
  }

  @Override
  protected void doEvent(Activity activity) {
    BillingManager.instance().startPurchase(activity);
    closeEvents(activity);
  }
  
  private static final AndroidDonateEvent instance = new AndroidDonateEvent();
  
  public static AndroidDonateEvent instance() {
    return instance;
  }

}
