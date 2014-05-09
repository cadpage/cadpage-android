package net.anei.cadpage.donation;

import net.anei.cadpage.SmsMmsMessage;
import android.app.Activity;
import android.content.Context;
import android.preference.Preference;
import android.widget.Button;

/**
 * This is a dummy root node of the screen menu tree that is used to set
 * the main preference
 */
public class MainDonateEvent extends DonateScreenEvent {
  
  private Activity activity;
  private Preference pref;
  private Button button;
  private SmsMmsMessage msg;
  
  public MainDonateEvent() {
    super(null, 0, 0,
        FreeDonateEvent.instance(),
        LifeDonateEvent.instance(),
        AuthDonateEvent.instance(),
        PaidDonateEvent.instance(),
        NewUserDonateEvent.instance(),
        CadpageDonateEvent.instance(),
        CadpageAUDonateEvent.instance(),
        CadpageNZDonateEvent.instance(),
        CadpageSEDonateEvent.instance(),
        CadpageUKDonateEvent.instance(),
        SponsorNoExpDonateEvent.instance(),
        SponsorDonateEvent.instance(),
        DonateExemptEvent.instance(),
        SponsorWarnRequiredDonateEvent.instance(),
        SponsorWarnDonateEvent.instance(),
        PaidWarnRequiredDonateEvent.instance(),
        PaidWarnDonateEvent.instance(),
        SponsorLimboDonateEvent.instance(),
        PaidLimboDonateEvent.instance(),
        SponsorExpireRequiredDonateEvent.instance(),
        SponsorExpireDonateEvent.instance(),
        PaidExpireRequiredDonateEvent.instance(),
        PaidExpireDonateEvent.instance(),
        DemoDonateEvent.instance(),
        DemoExpireDonateEvent.instance(),
        Active911MissingParserDonateEvent.instance(),
        Active911ParseWarnDonateEvent.instance());
  }

  /**
   * Recalculate and redisplay donation status
   */
  public void refreshStatus() {
    if (activity != null && !activity.isFinishing()) {
      setPreference(activity, pref);
      setButton(activity, button, msg);
    }
  }

  @Override
  public boolean setPreference(Activity activity, Preference pref) {
    this.activity = activity;
    this.pref = pref;
    if (pref != null) {
      DonateEvent event = findEvent(false, null);
      if (event != null) {
        if (event.setPreference(activity, pref)) return true;
      }
    }
    return false;
  }

  @Override
  public boolean setButton(Activity activity, Button button, SmsMmsMessage msg) {
    this.activity = activity;
    this.button = button;
    this.msg = msg;
    if (button == null) return false;
    DonateEvent event = findEvent(true, msg);
    if (event != null) {
      if (event.setButton(activity, button, msg)) return true;
    }
    button.setVisibility(Button.GONE);
    return false;
  }

  @Override
  public void doEvent(Activity activity, SmsMmsMessage msg) {
    DonateEvent event = findEvent(false, msg);
    if (event != null) event.doEvent(activity, msg);
  }
  
  
  @Override
  public void open(Context context) {
    DonateEvent event = findEvent(false, null);
    if (event != null) ((DonateScreenBaseEvent)event).open(context);
  }

  /**
   * Find the current active alert with the highest warning level
   * @param warn true if only events with at least a yellow alert level
   * should be reported
   * @return the donate event if found, null otherwise
   */
  private DonateEvent findEvent(boolean warn, SmsMmsMessage msg) {
    DonateEvent result = null;
    int resultRank = (warn ? AlertStatus.GREEN.ordinal() : Integer.MIN_VALUE);
    for (DonateEvent event : getEvents()) {
      int rank = event.getAlertStatus().ordinal();
      if (rank > resultRank) {
        if (event.isEnabled(msg)) {
          result = event;
          resultRank = rank;
        }
      }
    }
    return result;
  }

  private static final MainDonateEvent instance = new MainDonateEvent();
  
  public static MainDonateEvent instance() {
    return instance;
  }

}
