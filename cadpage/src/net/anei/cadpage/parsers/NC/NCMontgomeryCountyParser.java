package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCMontgomeryCountyParser extends DispatchSouthernParser {
  
  
  public NCMontgomeryCountyParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "NC", DSFLAG_ID_OPTIONAL | DSFLAG_LEAD_PLACE);
    allowBadChars("()");
    removeWords("LA");
  }
  
  @Override
  public String getFilter() {
    return "@montgomerycountync.com";
  }
  
  private static final Pattern BAD_MSG_PTN = Pattern.compile(".*;.*;.*;.*");
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Reject anything that looks like a Davidson County call
    if (BAD_MSG_PTN.matcher(body).matches()) return false;
    
    body = stripFieldStart(body, "CAD:");
    if (!super.parseMsg(body, data)) return false;
    
    // Fixups for name field
    if (data.strName.length() > 0) {
      data.strName = stripFieldStart(data.strName, "/");
      if (data.strCity.length() == 0 && isCity(data.strName)) {
        data.strCity = data.strName;
        data.strName = "";
      } else if (data.strPlace.length() == 0) {
        data.strPlace = data.strName;
        data.strName = "";
      }
    }
    
    if (data.strCity.equalsIgnoreCase("MONT CO")) {
      data.strCity = "MONTGOMERY COUNTY";
    } else if (data.strCity.endsWith(" CO")) {
      data.strCity += "UNTY";
    } else if (data.strCity.endsWith(" Co") || data.strCity.endsWith(" co")) {
      data.strCity += "unty";
    }
    return true;
  }
  
  @Override
  protected void parseExtra(String sExtra, Data data) {
    Parser p = new Parser(sExtra);
    data.strCall = p.get(" - ");
    data.strSupp = p.get();
  }

  @Override
  protected boolean isNotExtraApt(String apt) {
    if (apt.startsWith("(")) return true;
    return super.isNotExtraApt(apt);
  }



  private static final String[] CITY_LIST = new String[] {
    "MONT CO",
    
    "BISCOE",
    "BLACK ANKLE",
    "CANDOR",
    "CHEEK CREEK",
    "ELDORADO",
    "ETHER",
    "JACKSON SPRINGS",
    "LITTLE RIVER",
    "MOUNT GILEAD",
    "MT GILEAD",
    "NEW LONDON",
    "OKEEWEMEE",
    "OPHIR",
    "PEE DEE",
    "ROCKY SPRINGS",
    "SEAGROVE",
    "STAR",
    "STEEDS",
    "TROY",
    "UWHARRIE",
    "WINDBLOW",
    
    // Davidson County
    "DAVIDSON CO",
    "DENTON",
    
    // Mecklenburg County
    "MECKLENBURG CO",
    "DAVIDSON",
    
    // Randolph County
    "RANDOLPH CO",
    "ASHEBORO",
    
    // Richmond County
    "RICHMOND CO",
    "RICHMOND",
    
    // Stanly County
    "STANLY CO",
    "NORWOOD"
    
    
  };
}
