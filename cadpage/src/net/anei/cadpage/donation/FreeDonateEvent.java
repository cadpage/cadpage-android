package net.anei.cadpage.donation;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.R;
import android.content.Context;

/**
 * This is the nice top level donation event that appears when user is on
 * the free rider donate list
 */
public class FreeDonateEvent extends DonateEvent {
  
  public FreeDonateEvent() {
    super(AlertStatus.GREEN, R.string.donate_free_title);
  }
  
  @Override
  public boolean isEnabled() {
    return ManagePreferences.freeRider();
  }

  @Override
  protected void doEvent(Context ctx) {
  }
  
  private static final FreeDonateEvent instance = new FreeDonateEvent();
  
  public static FreeDonateEvent instance() {
    return instance;
  }

}
