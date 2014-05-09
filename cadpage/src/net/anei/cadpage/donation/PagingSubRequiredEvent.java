package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
    
    Paging service requires a paid subscription
    
    Cadpage paging service is only available to users with current paid subscriptions.
    We have to pay to support each user on this service, we can not afford give
    it away.


 */
public class PagingSubRequiredEvent extends DonateScreenEvent {

  protected PagingSubRequiredEvent() {
    super(null, R.string.paging_sub_required_title, R.string.paging_sub_required_text,
          AndroidDonateEvent.instance(), 
          DonateAndroidUnsuportedEvent.instance(), 
          AndroidDonateBetaEvent.instance(),
          AndroidDonateProblemEvent.instance(),
          DonateResetMarketEvent.instance(),
          Android16DonateEvent.instance(),
          NoUserDonateEvent.instance(), 
          WrongUserDonateEvent.instance());
  }
  
  @Override
  protected boolean overrideWindowTitle() {
    return true;
  }

  private static final PagingSubRequiredEvent instance = new PagingSubRequiredEvent();
  public static PagingSubRequiredEvent instance() {
    return instance;
  }
}
