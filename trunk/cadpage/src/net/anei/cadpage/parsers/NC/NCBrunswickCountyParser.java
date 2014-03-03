package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;
/**
 * Brunswick County, NC
 */
public class NCBrunswickCountyParser extends DispatchSouthernPlusParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("\\d+:(\\d\\d-\\d{6})[,;] *(.*)");
  
  public NCBrunswickCountyParser() {
    super(CITY_LIST, "BRUNSWICK COUNTY", "NC", 
          DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_NO_NAME_PHONE);
    setupMultiWordStreets("GEORGE II");
  }
  
  @Override
  public String getFilter() {
    return "pagegate@brunswickes.com,vtext.com@returns.groups.yahoo.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    subject = subject.trim();
    if (subject.startsWith("[") && subject.endsWith("]")) {
      data.strSource = subject.substring(1,subject.length()-1).trim();
      subject = "";
    }
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strPlace = match.group(2);
      return true;
    }
    
    return super.parseMsg(subject, body,  data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_AT_PLACE;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = fixParenField(field, true);
      super.parse(field, data);
      data.strPlace = fixParenField(data.strPlace, false);
      data.strAddress = fixParenField(data.strAddress, false);
      String apt = fixParenField(data.strApt, false);
      if (apt.startsWith("(")) {
        data.strAddress = append(data.strAddress, " ", apt);
        data.strApt = "";
      }
    }
  }
  
  private static String fixParenField(String field, boolean encode) {
    Matcher match = (encode ? PAREN_FLD1 : PAREN_FLD2).matcher(field);
    if (!match.find()) return field;
    StringBuffer sb = new StringBuffer();
    do {
      String term = match.group();
      if (encode) {
        term = term.replace("(", "_<_").replace(")", "_>_").replace(' ', '_');
      } else {
        term = term.replace("_<_", "(").replace("_>_", ")").replace('_', ' ');
      }
      match.appendReplacement(sb, term);
    } while (match.find());
    match.appendTail(sb);
    return sb.toString();
  }
  private static final Pattern PAREN_FLD1 = Pattern.compile("(\\([^\\(\\)]*\\))");
  private static final Pattern PAREN_FLD2 = Pattern.compile("(_<_[^<>]*_>_)");

  private static final String[] CITY_LIST = new String[]{
    "LOCKWOODS FOLLY",
    "NORTHWEST",
    "SHALLOTTE",
    "SMITHVILLE",
    "TOWN CREEK",
    "WACCAMAW",

    "BALD HEAD ISLAND",
    "BELVILLE",
    "BOILING SPRING LAKES           ",
    "BOLIVIA",
    "CALABASH",
    "CAROLINA SHORES",
    "CASWELL BEACH",
    "HOLDEN BEACH",
    "LELAND",
    "NAVASSA",
    "NORTHWEST",
    "OAK ISLAND",
    "OCEAN ISLE BEACH",
    "SANDY CREEK",
    "SHALLOTTE",
    "SOUTHPORT",
    "ST JAMES",
    "SUNSET BEACH",
    "VARNAMTOWN",

    "ANTIOCH",
    "ASH",
    "BATARORA",
    "BELL SWAMP",
    "BISHOP",
    "BIVEN",
    "BONAPARTE LANDING",
    "BOONES NECK",
    "BOWENSVILLE",
    "BRUNSWICK STATION",
    "CAMP BRANCH",
    "CEDAR GROVE",
    "CEDAR HILL",
    "CIVIETOWN",
    "CLAIRMONT",
    "CLARENDON",
    "COOLVALE",
    "DOE CREEK",
    "EASTBROOK",
    "EASY HILL",
    "PINEY GROVE",
    "SUPPLY",
    "SUNSET HARBOR",
    "WINNABOW",
  };

}
