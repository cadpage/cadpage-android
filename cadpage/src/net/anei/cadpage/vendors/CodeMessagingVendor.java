package net.anei.cadpage.vendors;

import net.anei.cadpage.R;

class CodeMessagingVendor extends Vendor {
  
  CodeMessagingVendor() {
    super(R.string.code_messaging_title,
           R.string.code_messaging_summary,
           R.string.code_messaging_text,
           R.drawable.code_messaging_vendor,
           R.drawable.code_messaging_logo,
           "http://www.CodePassport.net/CodePassport.asp?wci=Android",
           ">CMG");
  }

  @Override
  boolean isSponsored() {
    return true;
  }

  @Override
  boolean isAvailable() {
    return false;
  }
  
}
