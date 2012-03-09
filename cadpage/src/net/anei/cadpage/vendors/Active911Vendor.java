package net.anei.cadpage.vendors;

import android.net.Uri;
import net.anei.cadpage.R;

class Active911Vendor extends Vendor {
  
  Active911Vendor() {
    super(R.string.active911_title,
           R.string.active911_summary,
           R.string.active911_text,
           R.drawable.active_911_vendor,
           R.drawable.active_911_logo,
           "http://www.active911.com",
           ">A91",
           "support@active911.com");
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
  Uri getBaseURI(String req) {
    Uri uri = super.getBaseURI();
    if (req.equals("register") || req.equals("info") || req.equals("profile")) {
      return uri.buildUpon().appendPath("cadpage_registration").build();
    } else {
      return uri.buildUpon().appendPath("interface").appendPath("cadpage_api.php").build();
    }
  }
}
