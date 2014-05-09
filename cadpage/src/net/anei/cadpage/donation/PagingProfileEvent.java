package net.anei.cadpage.donation;

import android.app.Activity;
import android.content.Context;
import net.anei.cadpage.R;
import net.anei.cadpage.vendors.VendorManager;

/*
    Cadpage Paging Service Profile
    
      You are registered to receive direct pages from Cadpage 
      Paging Services.  
      
      Your dispatch email address is
      %s
      
      Any email sent to this address will be appear as a Cadpage dispatch alert.

 */
public class PagingProfileEvent extends DonateScreenEvent {

  protected PagingProfileEvent() {
    super(null, R.string.paging_profile_title, R.string.paging_profile_text,
          SendDispatchAddressEvent.instance(),
          ResetDispatchAddressEvent.instance());
  }
  
  @Override
  protected boolean overrideWindowTitle() {
    return true;
  }
  
  @Override
  protected Object[] getTextParms(int type) {
    switch (type) {
    case PARM_TEXT:
      return new Object[]{VendorManager.instance().getEmailAddress("Cadpage")};
      
    default:
      return null;
    }
  }

  private static final PagingProfileEvent instance = new PagingProfileEvent();
  public static PagingProfileEvent instance() {
    return instance;
  }
}
