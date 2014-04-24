package net.anei.cadpage.parsers.NJ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;


public class NJAtlanticareEMSParser extends DispatchProQAParser {
  
  public NJAtlanticareEMSParser() {
    super(CITY_LIST, "", "NJ",
           "CALL CALLEXT+? ADDR XPLACE+? CITY! TIME!");
  }
  
  @Override
  public String getFilter() {
    return "medcom@medcom.com,medcom@atlanticare.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Parser p = new Parser(subject);
    data.strSource = p.get(" - ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALLEXT")) return new CallExtField();
    if (name.equals("XPLACE")) return new CrossPlaceField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d");
    return super.getField(name);
  }
  
  private class CallExtField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override public boolean checkParse(String field, Data data) {
      if (!EXT_CALL_LIST.contains(field)) return false;
      data.strCall = append(data.strCall, "/", field);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("\\d+[A-Z]?");
  private class CrossPlaceField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.toUpperCase().startsWith("X ")) {
        data.strCross = append(data.strCross, " & ", field.substring(2).trim());
      } else if (APT_PTN.matcher(field).matches()) {
        data.strApt = append(data.strApt, "-", field);
      } else {
        data.strPlace = append(data.strPlace, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
  }
  
  private static final Set<String> EXT_CALL_LIST = new HashSet<String>(Arrays.asList(
      "CHEST PAIN",
      "HEART PROBLEMS",
      "SYNCOPE",
      "UNCONSCIOUS PERSON"
  ));
  
  private static String[] CITY_LIST = new String[] {
  // Atlantic County
    "ABSECON",    
    "ATLANTIC",
    "ATLANTIC CITY",
    "BRIGANTINE",
    "BUENA VISTA TWP",
    "BUENA VISTA TOWNSHIP",
    "COLLINGS LAKES",
    "RICHLAND",
    "BUENA",
    "CORBIN",
    "EGG HARBOR",
    "EGG HARBOR TWP",
    "EGG HARBOR TOWNSHIP",
    "ESTELL MANOR",
    "FOLSOM",
    "GALLOWAY TWP",
    "GALLOWAY TOWNSHIP",
    "POMONA",
    "HAMILTON TWP",
    "MAYS LANDING",
    "HAMMONTON",
    "LINWOOD",
    "LONGPORT",
    "MARGATE",
    "MULLICA TWP",
    "MULLICA TOWNSHIP",
    "ELWOOD-MAGNOLIA",
    "NORTHFIELD",
    "PLEASANTVILLE",
    "PORT REPUBLIC",
    "SOMERS POINT",
    "VENTNOR",
    "WEYMOUTH TWP",
    "WEYMOUTH TOWNSHIP",
    
  // Cape May County
    "AVALON",
    "CAPE MAY POINT",
    "CAPE MAY",
    "DENNIS TWP",
    "DENNIS TOWNSHIP",
    "DENNISVILLE",
    "OCEAN VIEW",
    "SOUTH DENNIS",
    "LOWER TWP",
    "LOWER TOWNSHIP",
    "DIAMOND BEACH",
    "ERMA",
    "NORTH CAPE MAY",
    "VILLAS",
    "MIDDLE TWP",
    "MIDDLE TOWNSHIP",
    "CAPE MAY COURT HOUSE",
    "GOSHEN",
    "GREEN CREEK",
    "RIO GRANDE",
    "WHITESBORO-BURLEIGH",
    "NORTH WILDWOOD",
    "OCEAN",
    "SEA ISLE",
    "STONE HARBOR",
    "UPPER TWP",
    "UPPER TOWNSHIP",
    "BEESLEYS POINT",
    "MARMORA",
    "STRATHMERE",
    "TUCKAHOE",
    "WEST CAPE MAY",
    "WEST WILDWOOD",
    "WILDWOOD CREST",
    "WILDWOOD",
    "WOODBINE",
  };
}
