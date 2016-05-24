package net.anei.cadpage.donation;

import android.os.Build;
import net.anei.cadpage.R;
import net.anei.cadpage.SmsMmsMessage;

/**
 
We need to hear from you!!!

We are considering dropping Cadpage support for some very old versions of Android.
Your device is currently running one of these old versions, and we need to hear from
you want us to continue supporting Cadpage on your device.

 */
public class ObsoleteSupportDonateEvent extends DonateScreenEvent {
  
  public ObsoleteSupportDonateEvent() {
    super(AlertStatus.RED, R.string.donate_obsolete_support_parser_title, 
                           R.string.donate_obsolete_support_parser_text,
          EmailObsoleteSupportEvent.instance());
  }
  
  @Override
  protected boolean overrideWindowTitle() {
    return true;
  }

  @Override
  public boolean isEnabled(SmsMmsMessage msg) {
    return msg != null && Build.VERSION.SDK_INT <= 10;
  }
  
  private static final ObsoleteSupportDonateEvent instance = new ObsoleteSupportDonateEvent();
  
  public static ObsoleteSupportDonateEvent instance() {
    return instance;
  }
}
