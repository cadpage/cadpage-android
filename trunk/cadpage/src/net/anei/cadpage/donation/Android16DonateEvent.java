package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
Hey, I've already contributed
 
Our sincere apologies.  Cadpage tracks you by your Google Market account
and you are running Android 1.6 which does not gives us the ability to 
determine your Google Market account.  The good news is that you get a free
ride as long as you are running Android 1.6.

 */
public class Android16DonateEvent extends DonateScreenEvent {

  protected Android16DonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_android16_title, R.string.donate_android16_text,
           DoneDonateEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return !UserAcctManager.instance().isAcctSupport();
  }
  
  private static final Android16DonateEvent instance = new Android16DonateEvent();
  public static Android16DonateEvent instance() {
    return instance;
  }

}
