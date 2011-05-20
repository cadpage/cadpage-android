package net.anei.cadpage.donation;

import net.anei.cadpage.R;

public class WrongUserDonateEvent extends DonateScreenEvent {

  protected WrongUserDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_wrong_user_title, R.string.donate_wrong_user_text,
           EmailDonateEvent.instance());
  }

  @Override
  public boolean isEnabled() {
    return UserAcctManager.instance().getUser() != null;
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    switch (type) {
    case PARM_TEXT:
      return new Object[]{UserAcctManager.instance().getUser()};
      
    default:
      return null;
    }
  }

  private static final WrongUserDonateEvent instance = new WrongUserDonateEvent();
  public static WrongUserDonateEvent instance() {
    return instance;
  }

}
