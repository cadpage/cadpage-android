package net.anei.cadpage.donation;

import android.app.Activity;
import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;

/**
We do not know who you are

You have not given Cadpage permission to access your account and phone information.
Without this permission, Cadpage can not confirm if you have purchased a Cadpage
subscription. 

 */
public class AllowAcctPermissionDonateEvent extends DonateEvent {
  
  public AllowAcctPermissionDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_allow_acct_permission_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    ManagePreferences.checkPermAccountInfo(null, R.string.perm_acct_info_for_donate_status);
    MainDonateEvent.instance().refreshStatus();
    closeEvents(activity);
  }
  
  private static final AllowAcctPermissionDonateEvent instance = new AllowAcctPermissionDonateEvent();
  
  public static AllowAcctPermissionDonateEvent instance() {
    return instance;
  }

}
