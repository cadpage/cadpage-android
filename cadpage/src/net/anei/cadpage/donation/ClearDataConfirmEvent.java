package net.anei.cadpage.donation;

import net.anei.cadpage.R;

/*
Reinstall Cadpage

This will also your 30 day demo period.  Bit it will also erase all app data, 
including your call history and settings.  Are you sure you want to do this?
 */
public class ClearDataConfirmEvent extends DonateScreenEvent {

  protected ClearDataConfirmEvent() {
    super(AlertStatus.YELLOW, R.string.clear_data_title, R.string.clear_data_text,
           ClearDataEvent.instance());
  }
  
  private static final ClearDataConfirmEvent instance = new ClearDataConfirmEvent();
  public static ClearDataConfirmEvent instance() {
    return instance;
  }

}
