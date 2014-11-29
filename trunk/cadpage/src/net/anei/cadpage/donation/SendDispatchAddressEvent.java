package net.anei.cadpage.donation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/**
 * Generate an email to the developers
 */
public class SendDispatchAddressEvent extends DonateEvent {
  
  public SendDispatchAddressEvent() {
    super(null, R.string.email_address_title);
  }

  @Override
  protected void doEvent(Activity activity) {
    String emailAddress = VendorManager.instance().getEmailAddress("Cadpage");
    if (emailAddress != null) emailDispatchAddress(activity, emailAddress);
  }

  /**
   * Generate an Email message with the current registration ID
   * @param context current context
   */
  private static void emailDispatchAddress(Context context, String emailAddress) {
    
    // Build send email intent and launch it
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.email_address_subject));
    intent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.email_address_text, emailAddress));
    intent.setType("message/rfc822");
    context.startActivity(Intent.createChooser(
        intent, context.getString(R.string.email_address_title)));
  }
  
  private static final SendDispatchAddressEvent instance = new SendDispatchAddressEvent();
  
  public static SendDispatchAddressEvent instance() {
    return instance;
  }

}
