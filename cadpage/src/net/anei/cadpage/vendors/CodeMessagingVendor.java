package net.anei.cadpage.vendors;

import java.util.Properties;

import net.anei.cadpage.R;
import net.anei.cadpage.parsers.MsgParser;

class CodeMessagingVendor extends Vendor {
  
  CodeMessagingVendor() {
    super(R.string.code_messaging_title,
           R.string.code_messaging_summary,
           R.string.code_messaging_text,
           R.drawable.code_messaging_vendor,
           R.drawable.code_messaging_logo,
           "http://www.CodePassport.net/CodePassport.asp?wci=Android",
           ">CMG",
           "dewey@generationconsultants.com");
  }

  @Override
  boolean isSponsored() {
    return true;
  }

  @Override
  boolean isAvailable() {
    return true;
  }

  @Override
  boolean isVendorAddress(String address) {
    return address.endsWith("@c-msg.net");
  }

  @Override
  public boolean infoButtonOptional() {
    return true;
  }
  
  @Override
  int getMoreInfoResId() {
    return R.string.response_check_text;
  }

  @Override
  protected boolean isActiveSponsor(String account, String token) {
    return true;
//    return account != null && ACTIVE_ACCTS.getProperty(account) != null;
  }
  
  private static final Properties ACTIVE_ACCTS = MsgParser.buildCodeTable(new String[]{
      "895", "06072016",
      "187", "06072016",
  });
}
