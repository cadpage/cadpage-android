package net.anei.cadpage.donation;

import android.app.Activity;
import android.preference.Preference;
import android.view.ViewGroup;

/**
 * Collection event that does nothing itself, but refers all actions to one
 * or more of it's child events
 */
public abstract class EventGroup extends DonateEvent {

  // List of child events
  private DonateEvent[] events;
  
  public EventGroup(DonateEvent ... events ) {
    super(null, 0);
    this.events = events;
  }
  

  @Override
  public boolean setPreference(Activity activity, Preference pref) {
    for (DonateEvent event : events) {
      if (event.setPreference(activity, pref)) return true;
    }
    return false;
  }


  @Override
  public boolean addButton(Activity activity, ViewGroup parent) {
    boolean result = false;
    for (DonateEvent event : events) {
      if (event.addButton(activity, parent)) result = true;
    }
    return result;
  }


  @Override
  protected void doEvent(Activity activity) {
  }

}
