package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class TXDentonCountyParser extends DispatchOSSIParser {

  private static final Pattern SUBJECT_PTN = Pattern.compile("FYI|Update|Cancel|\\d{9};\\d\\d/\\d\\d/\\d{4} \\d\\d");
  
  public TXDentonCountyParser() {
    super(CITY_LIST, "DENTON COUNTY", "TX",
          "ID?: ( CANCEL ADDR SHORT_CITY! " +
               "| FYI? ( ID ( DATIME ( SRC CALL ( ADDR/Z CITY! | ADDR/Z END | PLACE? ADDR! X/Z+? CITY/Y ) " + 
                                    "| CALL ( ADDR/Z ( END | UNIT | NO_MORE_CITY ) " + 
                                           "| PLACE/Z? ADDR/Z CITY/Y! X/Z+? ( SRC UNIT? | UNIT ) ) ) " + 
                           "| ADDR ( SRC CALL | X/Z+? CITY SRC CALL! ) ) " + 
                      "| CALL ADDR SHORT_CITY/Y ) " +
               ") " +
           "INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@dentoncounty.com";
  }
  
  @Override
  public String getSponsor() {
    return "Lake Cities Fire Department";
  }
  
  @Override
  public String getSponsorDateString() {
    return "02172014";
  }

  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("Message Forwarded by PageGate") && !body.startsWith("CAD:")) body = "CAD:" + body;
    else if (subject.length() > 0 && body.startsWith("CAD:")) {
      String extra = null;
      if (SUBJECT_PTN.matcher(subject).matches()) {
        extra = "CAD:" + subject + ":";
        if (!body.startsWith(extra)) body = extra + body.substring(4);
      }
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL|.* ENROUTE", true);
    if (name.equals("SHORT_CITY")) return new MyShortCityField();
    if (name.equals("ID")) return new IdField("\\d{9}", true);
    if (name.equals("DATIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{1,2}[FP]D|B\\d+|CNTY");
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("UNIT")) return new UnitField("[A-Z]+\\d+(?:,[A-Z]+\\d+)*", true);
    if (name.equals("NO_MORE_CITY")) return new MyNoMoreCityField();
    return super.getField(name);
  }
  
  private class MyShortCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      String city = CITY_CODES.getProperty(field);
      if (city != null) {
        data.strCity = city;
        return true;
      }
      if (isCity(field)) {
        data.strCity = field;
        return true;
      }
      return false;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }

  private class MyPlaceField extends PlaceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!isValidPlace(field)) return false;
      super.parse(field, data);
      return true;
    }
    
    private boolean isValidPlace(String field) {
      int stat1 = checkAddress(field);
      if (stat1 >= STATUS_STREET_NAME) return false;
      String nxtFld = getRelativeField(+1);
      int stat2 = checkAddress(nxtFld);
      if (stat2 > STATUS_STREET_NAME) return true;
      return stat1 == STATUS_NOTHING && !field.contains("/");
    }
    
  }
  
  private static final Pattern SERV_PTN = Pattern.compile("\\bSERV\\b");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = SERV_PTN.matcher(field).replaceAll("FRONTAGE");
      super.parse(field, data);
    }
  }
 
  // Throw an error if  cross fields contain more than 2 streets
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCross.contains("&")) abort();
      super.parse(field, data);
    }
  }
  
  private class MyNoMoreCityField extends InfoField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override 
    public boolean checkParse(String field, Data data) {
      if (isCity(field)) return false;
      if (isCity(getRelativeField(+1))) return false;
      if (isCity(getRelativeField(+2))) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARGY", "ARGYLE",
      "AUBR", "AUBREY",
      "BART", "BARTONVILLE",
      "CORI", "CORINTH",
      "DC",   "DENTON COUNTY",
      "DENT", "DENTON",
      "DOUB", "DOUBLE OAK",
      "HICK", "HICKORY CREEK",
      "LAKE", "LAKE DALLAS",
      "LITT", "LITTLE ELM",
      "NORT", "NORTH LAKE",
      "PILO", "PILOT POINT",
      "SANG", "SANGER"
  });

  private static final String[] CITY_LIST = new String[]{
      "ARGYLE",
      "AUBREY",
      "BARTONVILLE",
      "BOLIVAR",
      "CARROLLTON",
      "COPPELL",
      "COPPER CANYON",
      "CORINTH",
      "CORRAL CITY",
      "CROSS ROADS",
      "DALLAS",
      "DENTON",
      "DISH",
      "DOUBLE OAK",
      "ELIZABETHTOWN",
      "FLOWER MOUND",
      "FORT WORTH",
      "FRISCO",
      "HACKBERRY",
      "HASLET",
      "HEBRON",
      "HICKORY CREEK",
      "HIGHLAND VILLAGE",
      "JUSTIN",
      "KRUGERVILLE",
      "KRUM",
      "LAKE DALLAS",
      "LAKEWOOD VILLAGE",
      "LEWISVILLE",
      "LINCOLN PARK",
      "LITTLE ELM",
      "NORTHLAKE",
      "OAK POINT",
      "PILOT POINT",
      "PLANO",
      "PONDER",
      "PROSPER",
      "PROVIDENCE VILLAGE",
      "ROANOKE",
      "SANGER",
      "SHADY SHORES",
      "SOUTHLAKE",
      "THE COLONY",
      "TROPHY CLUB",
      "WESTLAKE",
      
      "COOKE COUNTY",
      "COLLIN COUNTY",
      "DALLAS COUNTY",
      "DENTON COUNTY",
      "GRAYSON COUNTY",
      "TARRANT COUNTY",
      "WISE COUNTY"
  };
}
