package net.anei.cadpage.donation;

import net.anei.cadpage.R;
/*
Hey, I've already contributed

Our sincere apologies.  Cadpage tracks you by your Google Market account
and you don't seem to have one.  Try logging into the Android Market with
your Paypal account and see if that helps.
 */
public class NoUserDonateEvent extends DonateScreenEvent {

  protected NoUserDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_no_user_title, R.string.donate_no_user_text,
           DoneDonateEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return UserAcctManager.instance().isAcctSupport() &&
            UserAcctManager.instance().getUser() == null;
  }
  
  private static final NoUserDonateEvent instance = new NoUserDonateEvent();
  public static NoUserDonateEvent instance() {
    return instance;
  }

}
