package net.anei.cadpage.donation;

import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class AndroidDonateBetaEvent extends DonateScreenEvent {
  
  public AndroidDonateBetaEvent() {
    super(AlertStatus.YELLOW, R.string.donate_android_title, R.string.donate_android_beta_text);
  }

  @Override
  public boolean isEnabled() {
    return CadPageApplication.isBetaRelease();
  }
  
  private static final AndroidDonateBetaEvent instance = new AndroidDonateBetaEvent();
  
  public static AndroidDonateBetaEvent instance() {
    return instance;
  }

}
