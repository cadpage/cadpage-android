package net.anei.cadpage.donation;

import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;

/**
 

 */
public class GeneralParserDonateEvent extends DonateScreenEvent {
  
  public GeneralParserDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_general_parser_title, 
                              R.string.donate_general_parser_text,
          EmailReportProblemEvent.instance());
  }
  
  @Override
  protected boolean overrideWindowTitle() {
    return true;
  }

  @Override
  public boolean isEnabled(SmsMmsMessage msg) {
    return msg != null && msg.getLocation().equals("General");
  }
  
  private static final GeneralParserDonateEvent instance = new GeneralParserDonateEvent();
  
  public static GeneralParserDonateEvent instance() {
    return instance;
  }
}
