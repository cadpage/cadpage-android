package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
I can't afford $10

    Tell us why you can't afford a $10 donation.  We're really easy on these.\n\n
    Is there anything we can do to make Cadpage easier to use?  Do you any
    suggestions on better ways we can finance the considerable costs of maintaining
    Cadpage?

 */
public class SobStoryDonateEvent extends DonateScreenEvent {

  protected SobStoryDonateEvent() {
    super(AlertStatus.YELLOW, R.string.donate_sob_story_title, R.string.donate_sob_story_text,
           EmailSobStoryEvent.instance());
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

  private static final SobStoryDonateEvent instance = new SobStoryDonateEvent();
  public static SobStoryDonateEvent instance() {
    return instance;
  }

}
