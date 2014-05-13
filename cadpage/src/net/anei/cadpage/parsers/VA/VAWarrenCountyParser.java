package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Warren County, VA
 */
public class VAWarrenCountyParser extends DispatchSouthernParser {
  
  private static final Pattern VERIFY_X_PTN = Pattern.compile("\\*([ A-Z0-9]+?) +\\(Verify\\)");
  
  public VAWarrenCountyParser() {
    super(CITY_LIST, "WARREN COUNTY", "VA", DSFLAG_OPT_DISPATCH_ID | DSFLAG_FOLLOW_CROSS);
  }
  
  @Override
  public String getFilter() {
    return "mailbox@warrencountysheriff.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strCross = VERIFY_X_PTN.matcher(data.strCross).replaceAll("$1").trim();
    return true;
  }

  private static final String[] CITY_LIST = new String[]{
    "FRONT ROYAL",
    "ASHBY",
    "BENTONVILLE",
    "BETHEL",
    "BROWNTOWN",
    "BUCKTON",
    "CEDARVILLE",
    "HAPPY CREEK",
    "HOWELLSVILLE",
    "KARO",
    "LIMETON",
    "LINDEN",
    "MILLDALE",
    "NINEVEH",
    "OVERALL",
    "RELIANCE",
    "RIVERTON",
    "ROCKLAND",
    "WATERLICK",
    
    // Frederick County
    "MIDDLETOWN"
  };
}