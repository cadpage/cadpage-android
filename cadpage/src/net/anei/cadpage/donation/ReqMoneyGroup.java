package net.anei.cadpage.donation;


/**
 * Group of events presented when we we are looking for money
 */
public class ReqMoneyGroup extends EventGroup {
  
  public ReqMoneyGroup() {
    super(AndroidDonateEvent.instance(), 
          DonateAndroidUnsuportedEvent.instance(), 
          AndroidDonateBetaEvent.instance(),
          AndroidDonateProblemEvent.instance(),
          DonateResetMarketEvent.instance(),
          SobStoryDonateEvent.instance(),
          DonateWhatsUpEvent.instance());
  }
  
  private static final ReqMoneyGroup instance = new ReqMoneyGroup();
  
  public static ReqMoneyGroup instance() {
    return instance;
  }

}
