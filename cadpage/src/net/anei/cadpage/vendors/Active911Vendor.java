package net.anei.cadpage.vendors;

import net.anei.cadpage.R;

class Active911Vendor extends Vendor {
  
  Active911Vendor() {
    super(R.string.active911_title,
           R.string.active911_summary,
           R.string.active911_text,
           R.drawable.active_911_vendor,
           R.drawable.active_911_logo,
           "https://www.active911.com/cadpage_registration",
           ">A91");
  }

  @Override
  boolean isSponsored() {
    return true;
  }

  @Override
  boolean isAvailable() {
    return true;
  }
  
  
}
