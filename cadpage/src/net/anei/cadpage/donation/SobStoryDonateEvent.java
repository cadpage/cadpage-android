package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
I can't afford $10

So, you are paying monthly charges for a smart phone, probably have a text
package and data package on top of that, which runs to how much a month?  
And you can't afford $10/year to pay hard working developers to keep Cadpage
up and running?

OK, we're suckers for a good story, and we don't wan\\'t to leave anyone
out.  Email us a good story about why you can't afford $10 and we will
probably give you a free subscription.  
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
