package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class WVMineralCountyParser extends FieldProgramParser {
  
  public WVMineralCountyParser() {
    super(CITY_LIST, "MINERAL COUNTY", "WV",
           "SRCID DATETIME ALERTED CALL ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "xdc@mineralcounty911.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split(" >"), 5, data);
  }

  private static final Pattern SOURCE_ID_PTN = Pattern.compile("\\?\\?\\? ([A-Z]{3,4}):(\\d{4}:\\d{4})");
  private class SourceIdField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = SOURCE_ID_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strSource = match.group(1);
      data.strCallId = match.group(2);
    }
    
    @Override
    public String getFieldNames() {
      return "SRC ID";
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    public MyDateTimeField() {
      super("\\d{4}-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d", true);
    }
    @Override
    public void parse(String field, Data data) {
      data.strDate = field.substring(5,7) + '/' + field.substring(8,10) + '/' + field.substring(0,4);
      data.strTime = field.substring(11);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("(;)")) field = field.substring(0,field.length()-3).trim();
      if (field.endsWith(", MNRL WV")) field = field.substring(0, field.length()-9).trim();
      Parser p = new Parser(field);
      data.strCross = p.getLastOptional(", BETWEEN");
      data.strCity =  p.getLastOptional(',');
      String sAddr = p.getLast(';');
      data.strSupp = p.get();
      if (data.strCity.length() > 0) {
        parseAddress(sAddr, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
      }
      if (data.strCity.equalsIgnoreCase("WESTERNPORT")) data.strState = "MD";
    }
    
    @Override
    public String getFieldNames() {
      return "INFO ADDR APT CITY ST X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRCID")) return new SourceIdField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ALERTED")) return new SkipField("ALERTED", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "KEYSER",
    "PIEDMONT",
    "RIDGELEY",
    "CARPENDALE",
    "ELK GARDEN",

    "ANTIOCH",
    "ATLANTIC HILL",
    "BARNUM",
    "BERYL",
    "BLAINE",
    "BURLINGTON",
    "CHAMPWOOD",
    "CLAYSVILLE",
    "CROSS",
    "DANS RUN",
    "EMORYVILLE",
    "FOOTE STATION",
    "FORGE HILL",
    "FORT ASHBY",
    "FOUNTAIN",
    "HAMPSHIRE",
    "HARTMANSVILLE",
    "HEADSVILLE",
    "KEYMONT",
    "LAUREL DALE",
    "LIMESTONE",
    "MARKWOOD",
    "NETHKIN",
    "NEW CREEK",
    "OAKMONT",
    "PATTERSON CREEK",
    "REESES MILL",
    "RIDGELEY",
    "RIDGEVILLE",
    "ROCKET CENTER",
    "RUSSELLDALE",
    "SHORT GAP",
    "SKYLINE",
    "SULPHUR CITY",
    "WAGONER",
    "WILEY FORD",
    
    "WESTERNPORT"
  };
}
