package net.anei.cadpage.donation;

import android.app.Activity;
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
  
  public MainDonateEvent() {
    super(null, 0, 0,
        FreeDonateEvent.instance(),
        LifeDonateEvent.instance(),
        AuthDonateEvent.instance(),
        PaidDonateEvent.instance(),
        NewUserDonateEvent.instance(),
        CadpageDonateEvent.instance(),
        CadpageAUDonateEvent.instance(),
        CadpageUKDonateEvent.instance(),
        SponsorDonateEvent.instance(),
        DonateExemptEvent.instance(),
        PaidWarnDonateEvent.instance(),
        PaidLimboDonateEvent.instance(),
        PaidExpireDonateEvent.instance(),
        DemoDonateEvent.instance(),
        DemoExpireDonateEvent.instance());
  }

  /**
   * Recalculate and redisplay donation status
   */
  public void refreshStatus() {
    if (activity != null) {
      setPreference(activity, pref);
      setButton(activity, button);
    }
  }

  @Override
  public boolean setPreference(Activity activity, Preference pref) {
    this.activity = activity;
    this.pref = pref;
    if (pref != null) {
      for (DonateEvent event : getEvents()) {
        if (event.setPreference(activity, pref)) return true;
      }
    }
    return false;
  }

  @Override
  public boolean setButton(Activity activity, Button button) {
    this.activity = activity;
    this.button = button;
    if (button != null) {
      for (DonateEvent event : getEvents()) {
        if (event.setButton(activity, button)) return true;
      }
      button.setVisibility(Button.GONE);
    }
    return false;
  }

  @Override
  public void doEvent(Activity activity) {
    for (DonateEvent event : getEvents()) {
      if (event.isEnabled()) {
        event.doEvent(activity);
        break;
      }
    }
  }

  private static final MainDonateEvent instance = new MainDonateEvent();
  
  public static MainDonateEvent instance() {
    return instance;
  }

}
