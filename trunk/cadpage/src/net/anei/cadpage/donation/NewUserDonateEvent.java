package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/**
  
  New User
  
  Cadpage will not do anything with your current default settings.  You need to go
  into the Location Settings and either select a location corresponding to your 
  area or set the From: (filter) to the email address or phone number that sends
  you your text pages
  
 */
public class NewUserDonateEvent extends DonateScreenEvent {
  
  public NewUserDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_new_user_title, R.string.donate_new_user_text,
           MagicWordEvent.instance(),
           DonateResetMarketEvent.instance());
  }
  
  @Override
  public boolean isEnabled() {
    return (DonationManager.instance().status() == DonationManager.DonationStatus.NEW);
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    return new Object[]{
        DonationManager.instance().sponsor()
    };
  }

  private static final NewUserDonateEvent instance = new NewUserDonateEvent();
  
  public static NewUserDonateEvent instance() {
    return instance;
  }

}
