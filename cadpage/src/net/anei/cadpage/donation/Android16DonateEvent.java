package net.anei.cadpage.donation;

import net.anei.cadpage.R;

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
