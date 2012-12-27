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
    String[] flds = body.split(" >");
    if (flds.length < 5) flds = body.split("\n");
    return parseFields(flds, 5, data);
  }

  private static final Pattern SOURCE_ID_PTN = Pattern.compile("(?:\\?\\?\\? )?([A-Z]{3,5}):(\\d{4}:\\d{4})");
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
  
  private static final Pattern ADDR_DELIM = Pattern.compile(" *[,;] *");
  private static final Pattern NEXT_TO_PTN = Pattern.compile("NEXT TO (.*) INTERSECTION", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("(;)")) field = field.substring(0,field.length()-3).trim();
      String[] parts = ADDR_DELIM.split(field);
      int ndx = 0;
      Result res = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS, parts[0]);
      if (parts.length > 1) {
        Result res2= parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS, parts[1]);
        if (res2.getStatus() > res.getStatus()) {
          ndx = 1;
          res = res2;
          data.strPlace = parts[0];
        }
      }
      res.getData(data);
      data.strSupp = res.getLeft();
      
      for (ndx++; ndx < parts.length; ndx++) {
        String part = parts[ndx];
        String upPart = part.toUpperCase();
        if (upPart.equals("MNRL WV")) continue;
        if (upPart.startsWith("BETWEEN ")) {
          data.strCross = append(data.strCross, " / ", part.substring(8).trim());
          continue;
        }
        if (isCity(upPart)) {
          data.strCity = part;
          continue;
        }
        Matcher match = NEXT_TO_PTN.matcher(part);
        if (match.matches()) {
          data.strAddress = data.strAddress + " & " + match.group(1);
          continue;
        }
        data.strSupp = append(data.strSupp, " / ", part);
      }
      if (data.strCity.equalsIgnoreCase("MCOOLE")) data.strCity = "MCCOOLE";
      else if (data.strCity.equalsIgnoreCase("FROST BURG")) data.strCity = "FROSTBURG";
      if (data.strCity.equalsIgnoreCase("WESTERNPORT") ||
          data.strCity.equalsIgnoreCase("MCCOOLE") ||
          data.strCity.equalsIgnoreCase("FROSTBURG")) data.strState = "MD";
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR APT CITY ST X INFO";
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
    
    "FROST BURG",
    "FROSTBURG",
    "MCOOLE",
    "MCCOOLE",
    "WESTERNPORT"
  };
}
