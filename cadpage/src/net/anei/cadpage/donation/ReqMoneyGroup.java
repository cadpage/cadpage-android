package net.anei.cadpage.donation;


/**
 * Group of events presented when we we are looking for money
 */
public class ReqMoneyGroup extends EventGroup {
  
  public ReqMoneyGroup() {
    super(AndroidDonateEvent.instance(), AndroidDonateBetaEvent.instance(),
          AndroidDonateProblemEvent.instance());
  }
  
  private static final ReqMoneyGroup instance = new ReqMoneyGroup();
  
  public static ReqMoneyGroup instance() {
    return instance;
  }

}
