package net.anei.cadpage.donation;


/**
 * Group of events presented when we we are looking for money
 */
public class ReqMoneyGroup extends EventGroup {
  
  public ReqMoneyGroup() {
    super(VendorEvent.instance(2),
          AndroidDonateEvent.instance(), 
          DonateAndroidUnsuportedEvent.instance(), 
          AndroidDonateBetaEvent.instance(),
          AndroidDonateProblemEvent.instance(),
          DonateResetMarketEvent.instance(),
          NeedAcctPermissionDonateEvent.instance(),
          NoUserDonateEvent.instance(), 
          WrongUserDonateEvent.instance(),
          InactiveSponsorDonateEvent.instance(),
          SobStoryDonateEvent.instance());
  }
  
  private static final ReqMoneyGroup instance = new ReqMoneyGroup();
  
  public static ReqMoneyGroup instance() {
    return instance;
  }

}
