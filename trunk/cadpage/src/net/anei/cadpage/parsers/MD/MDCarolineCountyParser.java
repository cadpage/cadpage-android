package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAegisParser;



public class MDCarolineCountyParser extends DispatchAegisParser {
  
  public MDCarolineCountyParser() {
    super(CITY_LIST, "CAROLINE COUNTY", "MD",
          "CODE? CALL ADDR/S! Cross_STS:X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "msg@cfmsg.com,alert@cfmsg.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = body.replace(" XSts:", " Cross STS:");
    return super.parseMsg(subject, body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE"))  return new CodeField("\\d{1,2}(?:[A-Z]\\d{1,2}[A-Z]?)?", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  
  private static final Pattern ADDR_CITY_PTN = Pattern.compile("(.*), MD(?: +(\\d{5}))?");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      // Strip off state and optional zip code
      String zip = "";
      Matcher match = ADDR_CITY_PTN.matcher(field);
      if (match.matches()) {
        zip = getOptGroup(match.group(2));
        field = match.group(1).trim();
      }
      super.parse(field, data);
      if (data.strCity.length() == 0) data.strCity = zip;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "DENTON",
    "FEDERALSBURG",
    "GOLDSBORO",
    "GREENSBORO",
    "HENDERSON",
    "HILLSBORO",
    "MARYDEL",
    "PRESTON",
    "RIDGELY",
    "TEMPLEVILLE",

    // Towns
    "CHOPTANK",
    "WEST DENTON",
    "WILLISTON",

    // Unincorporated Communities
    "AMERICAN CORNER",
    "ANDERSONTOWN",
    "BALTIMORE CORNER",
    "BETHLEHEM",
    "BURRSVILLE",
    "GILPIN POINT",
    "GROVE",
    "HARMONY",
    "HICKMAN",
    "HOBBS",
    "JUMPTOWN",
    "LINCHESTER",
    "OAKLAND",
    "OIL CITY",
    "TANYARD",
    "TWO JOHNS",
    "RELIANCE",
    "WHITELEYSBURG"
    
  };
}
