package net.anei.cadpage.vendors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
           null);
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
  String getResponseMenu(int index) {
    switch (index) {
    case 1:
      return "R=Respond;A=Arrive;Y=Available;N=Unavailable;C=Cancel";
    
    default:
      return null;
    }
  }
  
  @Override
  int getVersion() {
    return 1;
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
  
  @Override
  int getGCMStatus() {
    return 1;
  }

  @Override
  boolean isVendorAddress(String address) {
    if (address.startsWith("+")) address = address.substring(1);
    return PHONE_SET.contains(address);
  }
  
  private static final Set<String> PHONE_SET = new HashSet<String>(Arrays.asList(new String[]{
      "15123376259",
      "19145173586",
      "17272191279",
      "15417047704",
      "18434800223",
      "17172203767",
      "13364058803",
      "17783836218",
      "12027690862",
      "12032083335",
      "12052010901",
      "12072093315",
      "12706810905",
      "12765240572",
      "13046587002",
      "13072222635",
      "13134010041",
      "13172967331",
      "13603424100",
      "14012973063",
      "14029881004",
      "14046926092",
      "14052534266",
      "14062244055",
      "14242208369",
      "14433202484",
      "14805356958",
      "15013131847",
      "15046621719",
      "15052065036",
      "15132024579",
      "15744008669",
      "16013452163",
      "16052207124",
      "16086207759",
      "16093087467",
      "16122000004",
      "16156252978",
      "16363233043",
      "16418470032",
      "16783903000",
      "17012044024",
      "17196025911",
      "17572062724",
      "17736146018",
      "17752307392",
      "18019006459",
      "18022304149",
      "19134989068",
      "19783931289"
  }));
}
