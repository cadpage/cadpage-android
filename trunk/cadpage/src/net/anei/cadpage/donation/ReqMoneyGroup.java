package net.anei.cadpage.donation;


/**
 * Group of events presented when we we are looking for money
 */
public class ReqMoneyGroup extends EventGroup {
  
  public ReqMoneyGroup() {
    super(Vendor2Event.instance(),
          AndroidDonateEvent.instance(), 
          DonateAndroidUnsuportedEvent.instance(), 
          AndroidDonateBetaEvent.instance(),
          AndroidDonateProblemEvent.instance(),
          DonateResetMarketEvent.instance(),
          SobStoryDonateEvent.instance());
  }
  
  private static final ReqMoneyGroup instance = new ReqMoneyGroup();
  
  public static ReqMoneyGroup instance() {
    return instance;
  }

}
