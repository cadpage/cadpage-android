package net.anei.cadpage.donation;

import net.anei.cadpage.CadPageApplication;
import net.anei.cadpage.R;

/**
I can"'"t make Android Market donations

Bummer, let"'"s see what we can do about it.
 */
public class AndroidDonateProblemEvent extends DonateScreenEvent {
  
  public AndroidDonateProblemEvent() {
    super(AlertStatus.YELLOW, R.string.donate_android_problem_title, 
           R.string.donate_android_problem_text,
           DonateResetMarketEvent.instance(),
           EmailMarketProblemEvent.instance(),
           PaypalDonateEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return ! CadPageApplication.isBetaRelease();
  }
  
  private static final AndroidDonateProblemEvent instance = new AndroidDonateProblemEvent();
  
  public static AndroidDonateProblemEvent instance() {
    return instance;
  }

}
