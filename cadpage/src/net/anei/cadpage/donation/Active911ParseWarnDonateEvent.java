package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;

/**
 
Active911 parsed alert

This alert was processed with a new parsing system that Active911 is setting
up to replace the Cadpage parsing system.  We are working with Active911 to
restore normal Cadpage parsing services for these alerts.  

 */
public class Active911ParseWarnDonateEvent extends DonateScreenEvent {
  
  public Active911ParseWarnDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_active911_parse_warn_title, R.string.donate_active911_parse_warn_text);
  }

  @Override
  public boolean isEnabled(SmsMmsMessage msg) {
    return msg != null && msg.isActive911ParsedMsg();
  }
  
  private static final Active911ParseWarnDonateEvent instance = new Active911ParseWarnDonateEvent();
  
  public static Active911ParseWarnDonateEvent instance() {
    return instance;
  }

}
