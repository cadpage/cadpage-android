package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class WVHarrisonCountyBParser extends SmartAddressParser {
  
  public WVHarrisonCountyBParser() {
    super(CITY_LIST, "HARRISON COUNTY", "WV");
    setFieldList("ID CALL ADDR APT CITY UNIT");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MWORD_STREET_LIST);
  }
  
  @Override
  public String getFilter() {
    return "dispatch@centrale911.com";
  }
  
  private static final Pattern SALEM_UNIT_PTN = Pattern.compile("\\b(SALEM) (\\d{2})\\b");
  private static final Pattern MASTER = Pattern.compile("Call Number: *(\\d+) (.*?)((?: (?:[A-Z]+\\d+|\\d{3,4}))+)");
  private static final Pattern MBLANK_PTN = Pattern.compile("  +");
  private static final Pattern COUNTY_ABRV_PTN = Pattern.compile("(.*) (?:DODD|HARR)");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    
    body = SALEM_UNIT_PTN.matcher(body).replaceAll("$1$2");
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    String addr = match.group(2).trim();
    data.strUnit = match.group(3).trim();
    
    addr = MBLANK_PTN.matcher(addr).replaceAll(" ");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_EMPTY_ADDR_OK | FLAG_ANCHOR_END, addr, data);
    
    match = COUNTY_ABRV_PTN.matcher(data.strAddress);
    if (match.matches()) data.strAddress = match.group(1).trim();
    
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    
    return true;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = WV_STATE_PTN.matcher(addr).replaceAll("WV");
    return super.adjustMapAddress(addr);
  }
  
  private static final Pattern WV_STATE_PTN = Pattern.compile("\\bWV STATE\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "BIG BATTEL",
    "BIG BATTLE",
    "BIG FLINT",
    "BROAD RUN",
    "CHURCH HILL",
    "FRANKS RUN",
    "INDIAN CREEK",
    "MACELROY CREEK",
    "NAZARETH FARM",
    "PLEASANT HILL",
    "SKELTON RUN"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
    "ASSIST OTHER AGENCY/OFFICER",
    "ATV/FARM VEH ACCIDENT",
    "AUTO/MVA NO INJURIES",
    "AUTO/MVA WITH ENTRAPMENT",
    "AUTO/MVA WITH INJURIES",
    "BREATHING DIFFICULTY",
    "BRUSH FIRE",
    "CHEST PAINS",
    "DISABLED VEH/SIG 20",
    "ELECTRICAL FIRE",
    "EXPLOSION/SIG 82",
    "FIRE ALARM INVESTIGATION",
    "HEAD INJURY",
    "HEMORRHAGE/BLEEDING",
    "NATURAL GAS/OIL LEAK",
    "OBSTETRICS/BIRTH",
    "ODOR INVESTIGATION",
    "POWER LINES",
    "POWER LINES DOWN",
    "PUBLIC SERVICE",
    "ROADWAY",
    "ROADWAY OBSTRUCTION",
    "SEIZURES",
    "SMOKE INVESTIGATION",
    "STROKE/CVA",
    "STRUCTURE FIRE",
    "TRANSPORTATION ACCIDENT/WITH INJURIES",
    "TRANSPORTATION ACCIDENT/WITH NO INJURIES",
    "UNKNOWN TYPE FIRE",
    "UNRESPONSIVE PERSON",
    "VEHICLE FIRE",
    "WELFARE CHECK"
  );
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "BRIDGEPORT",
    "CLARKSBURG",
    "SALEM",
    "SHINNSTON",
    "STONEWOOD",

    // Towns
    "ANMOORE",
    "LOST CREEK",
    "LUMBERPORT",
    "NUTTER FORT",
    "WEST MILFORD",

    // Census-designated places
    "DESPARD",
    "ENTERPRISE",
    "GYPSY",
    "HEPZIBAH",
    "SPELTER",
    "WOLF SUMMIT",

    // Unincorporated communities
    "ARLINGTON",
    "GLEN FALLS",
    "GYPSY",
    "JIMTOWN",
    "MOUNT CLARE",
    
    // Counties
    "BARBOUR CO",
    "BARBOUR COUNTY",
    "DODRIDGE CO",
    "DODDRIDGE COUNTY",
    "HARRISON CO",
    "HARRISON COUNTY",
    "LEWIS CO",
    "LEWIS COUNTY",
    "MARION CO",
    "MARION COUNTY",
    "RITCHIE CO",
    "RITCHIE COUNTY",
    "TAYLOR CO",
    "TAYLOR COUNTY",
    "TYLER CO",
    "TYLER COUNTY",
    "UPSHUR CO",
    "UPSHUR COUNTY",
    "WETZEL CO",
    "WETZEL COUNTY",
    
    // Doddridge County
    "ASHLEY",
    "CENTER POINT",
    "NEW MILTON",
    "SMITHBURG",
    "WEST UNION",
    
    // Richie County
    "CAIRO"
  };

}
