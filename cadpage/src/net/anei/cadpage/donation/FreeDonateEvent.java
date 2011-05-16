package net.anei.cadpage.donation;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class FreeDonateEvent extends DonateScreenEvent {
  
  public FreeDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_free_title, R.string.donate_free_text);
  }
  
  @Override
  public boolean isEnabled() {
    return ManagePreferences.freeRider();
  }
  
  private static final FreeDonateEvent instance = new FreeDonateEvent();
  
  public static FreeDonateEvent instance() {
    return instance;
  }

}
