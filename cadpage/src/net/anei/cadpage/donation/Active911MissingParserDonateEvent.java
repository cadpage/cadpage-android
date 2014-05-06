package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;

/**
 
No Cadpage Parser is available for this alert

Cadpage does not currently include a message parser that can handle this alert.
Please use the "Report Problem button below to report this so we can get it fixed.

 */
public class Active911MissingParserDonateEvent extends DonateScreenEvent {
  
  public Active911MissingParserDonateEvent() {
    super(AlertStatus.RED, R.string.donate_active911_missing_parser_title, 
                           R.string.donate_active911_missing_parser_text,
          Active911ParseInfoDonateEvent.instance());
  }
  
  @Override
  protected boolean overrideWindowTitle() {
    return true;
  }

  @Override
  public boolean isEnabled(SmsMmsMessage msg) {
    return msg != null && msg.getMissingParsers() != null;
  }
  
  private static final Active911MissingParserDonateEvent instance = new Active911MissingParserDonateEvent();
  
  public static Active911MissingParserDonateEvent instance() {
    return instance;
  }
}
