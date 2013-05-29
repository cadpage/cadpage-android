package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class TXDentonCountyParser extends DispatchOSSIParser {
  
  public TXDentonCountyParser() {
    super(CITY_LIST, "DENTON COUNTY", "TX",
          "ID?: ( CANCEL ADDR SRC! INFO+ | FYI? ID ( DATIME ( SRC CALL ( ADDR/Z CITY! | NAME? ADDR! X/Z+? CITY ) | CALL NAME? ADDR/Z CITY! X/Z+? SRC UNIT? INFO+ ) | ADDR X/Z+? CITY SRC CALL! ) )");
  }
  
  @Override
  public String getFilter() {
    return "CAD@dentoncounty.com";
  }
  
  @Override
  public String getSponsor() {
    return "Lake Cities Fire Department";
  }
  
  private static final Pattern ADDR_PTN = Pattern.compile("\\d+ .*");
  private static final Pattern SERV_PTN = Pattern.compile("\\bSERV\\b");
  private class MyAddressField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!ADDR_PTN.matcher(field).matches() && checkAddress(field) == 0) return false;
      parse(field, data);
      return true;
    }
    
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL", true);
    if (name.equals("ID")) return new IdField("\\d{9}", true);
    if (name.equals("DATIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{2}FD");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("UNIT")) return new UnitField("[A-Z]+\\d+(?:,[A-Z]+\\d+)*", true);
    return super.getField(name);
  }


  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("Message Forwarded by PageGate") && !body.startsWith("CAD:")) body = "CAD:" + body;
    return super.parseMsg(body, data);
  }

private static final String[] CITY_LIST = new String[]{
    "ARGYLE",
    "BARTONVILLE",
    "COPPER CANYON",
    "CORRAL CITY",
    "CORINTH",
    "DENTON",
    "DOUBLE OAK",
    "FLOWER MOUND",
    "JUSTIN",
    "HICKORY CREEK",
    "KRUM",
    "LAKE DALLAS",
    "LEWISVILLE",
    "LITTLE ELM",
    "NORTHLAKE",
    "HICKORY CREEK",
    "PILOT POINT",
    "SANGER",
    "SHADY SHORES",
    "THE COLONY",
    "TROPHY CLUB",
    
    "DENTON COUNTY"
    
  };
}
//  
//  @Override
//  public String getProgram() {
//    return super.getProgram().replace(" CITY ", " SRC CITY ");
//  }
//  
//  private class MyCity2Field extends CityField {
//    @Override
//    public boolean checkParse(String field, Data data) {
//      if (field.length() == 4) return false;
//      return super.checkParse(field, data);
//    }
//  }
//  
//  private static final Pattern SOURCE_PTN = Pattern.compile("[A-Z]{2}FD"); 
//  private class MySourceField extends SourceField {
//    public MySourceField() {
//      setPattern(SOURCE_PTN);
//    }
//  }
  
//  
//  private class MyInfoField extends InfoField {
//    @Override
//    public void parse(String field, Data data) {
//      Matcher match = SOURCE_PTN.matcher(field);
//      if (match.matches()) {
//        data.strSource = field;
//        if (data.strCity.length() == 0) data.strCity = field;
//        return;
//      }
//      if (checkAddress(field) > 0) {
//        data.strCross = append(data.strCross, " & ", field);
//      } else {
//        super.parse(field, data);
//      }
//    }
//    
//    @Override
//    public String getFieldNames() {
//      return "SRC CITY X INFO";
//    }
//  }
  
//  
//  private static final Properties CITY_CODES = buildCodeTable(new String[]{
//      "ARFD", "ARGYLE",
//      "CORI", "CORINTH",
//      "LAKE", "LAKE DALLAS",
//      "LEFD", "LITTLE ELM",
//      "LVFD", "LEWISVILLE",
//      "HICK", "HICKORY CREEK",
//      "PPFD", "PILOT POINT",
//      "SHAD", "SHADY SHORES",
//      "TCFD", "THE COLONY",
//      "LCFD", "LAKE CITIES",
//  });
  
//    "ARFD", 
//    "CORI", 
//    "LAKE", 
//    "LEFD",
//    "LVFD", 
//    "HICK", 
//    "SHAD", 
//    "PPFD",    
//    "TCFD",
//    "LCFD",
