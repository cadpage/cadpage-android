package net.anei.cadpage.parsers.CA;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * San Joaquin County, CA
 */
public class CASanJoaquinCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile(".*? Dispatched:.*?Enroute:.*?On Scene:.*?AOR:.*|.* +Disp:.*?Resp:.*?On Scene:.*?TX:.*?Dest:.*|.*  +\\d\\d:\\d\\d:\\d{10}");
  private static final Pattern MASTER1 = Pattern.compile("(?:((?![A-Z]{3}-\\d+)[A-Z][-A-Z0-9]*+) ++)?+((?:[A-Z]{3}-\\d{6}|\\d{8})(?=  )|\\d{8}-\\d{6}) *(.*?)  +(.*?)(?:  +(.*?))?Bldg: *(.*?)Apt: *(.*?)(?:Assigned Units: *(.*))?");
  private static final Pattern MASTER2 = Pattern.compile("(?:([A-Z][-A-Z0-9]*+) ++)?+(\\d{8}) {5}([^ ].*)");
  
  public CASanJoaquinCountyParser() {
    super("SAN JOAQUIN COUNTY", "CA",
          "CALL! Location:PLACE! Address:ADDR! City:CITY! GPS:GPS? Bldg:PLACE! Apt:APT! CrossStreets:X! Plan:PLAN! Initial_Assignment:UNIT!");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA | MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public String getFilter() {
    return "LifecomCellPaging@amr.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // First see if this looks like a run report
    if (RUN_REPORT_PTN.matcher(body).matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    // There are two types of CAD page, check for the first one
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT ID CALL ADDR X MAP PLACE APT UNIT");
      addUnitField(getOptGroup(match.group(1)), data);
      data.strCallId = match.group(2);
      data.strCall = match.group(3).trim();
      parseAddress(match.group(4).trim(), data);
      data.strCross = cleanCrossField(getOptGroup(match.group(5)));
      data.strPlace = match.group(6).trim();
      data.strApt = match.group(7).trim();
      addUnitField(getOptGroup(match.group(8)), data);
      return true;
    }
    
    //  See if this matches the second pattern
    match = MASTER2.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT ID CALL ADDR APT X MAP UNIT");
      addUnitField(getOptGroup(match.group(1)), data);
      data.strCallId = match.group(2);
      String sAddr = match.group(3).trim();
      if (sAddr.length() <= 20) return false;
      data.strCall = sAddr.substring(0,16).trim();
      Parser p = new Parser(sAddr.substring(16).trim());
      addUnitField(p.getLastOptional("Assigned Units:"), data);
      data.strMap = p.getLast(' ');
      data.strCross = cleanCrossField(p.getLastOptional("  "));
      sAddr = p.get();
      if (data.strCross.length() > 0) {
        parseAddress(sAddr, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, sAddr, data);
        data.strCross = cleanCrossField(getLeft());
      }
      return true;
    }
    
    // OK, time to try the fixed field formats :(
    if (substring(body,122,127).equals("CAD #") &&
        substring(body,153,158).equals("Bldg:") && 
        substring(body,168,172).equals("Apt:") && 
        substring(body,242,256).equals("Response Plan:")) {
      setFieldList("CALL PLACE ADDR CITY ID UNIT PLACE APT X SRC");
      data.strCall = substring(body,0,30);
      data.strPlace = substring(body,30,60);
      parseAddress(substring(body,60,110), data);
      data.strCity = substring(body,110,122);
      data.strCallId = substring(body,127,143);
      addUnitField(substring(body,143,153), data);
      data.strPlace = append(data.strPlace, " - ", substring(body,158,162));
      data.strApt = substring(body,172,182);
      data.strCross = cleanCrossField(substring(body,182,212));
      data.strSource = substring(body,212,242);
      return true;
    }
    
    // Next try normal field based formats
    return super.parseMsg(body, data);
  }

  private String cleanCrossField(String field) {
    field = stripFieldStart(field, "No Cross Street/");
    int pt = field.lastIndexOf('/');
    if (pt >= 0) {
      if ("No Cross Street".startsWith(field.substring(pt+1).trim())) {
        field = field.substring(0,pt).trim();
      }
    } else {
      if ("No Cross Street".startsWith(field)) field = "";
    }
    return field;
  }
  
  private void addUnitField(String field, Data data) {
    
    if (field.length() == 0) return;
    
    Set<String> unitSet = new HashSet<String>();
    if (data.strUnit.length() > 0) {
      for (String unit : UNIT_DELIM_PTN.split(data.strUnit)) {
        unitSet.add(unit);
      }
    }
    
    for (String unit : UNIT_DELIM_PTN.split(field)) {
      if (unitSet.add(unit)) data.strUnit = append(data.strUnit, " ", unit);
    }
  }
  private static final Pattern UNIT_DELIM_PTN = Pattern.compile("[ ,]+");

  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("GPS")) return new MyGPSField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PLAN")) return new MyPlanField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      data.strPlace = append(data.strPlace, " - ", field);
    }
  }
  
  private static final Pattern CITY_PTN = Pattern.compile("(.*)\\(CAD INC#: ([^ ]+) *\\) \\[GROUP PAGE\\]");
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CITY_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCity = match.group(1).trim();
      data.strCallId = match.group(2);
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ID";
    }
  }
  
  private static final Pattern GPS_PTN = Pattern.compile("(\\d{2})(\\d{6}) & (\\d{3})(\\d{6})");
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = GPS_PTN.matcher(field);
      if (!match.matches()) abort();
      field = '+' + match.group(1) + '.' + match.group(2) + ',' + match.group(3) + '.' + match.group(4);
      setGPSLoc(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = cleanCrossField(field);
      super.parse(field, data);
    }
  }
  
  private class MyPlanField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      data.strSupp = "Plan: " + stripFieldEnd(field,  ",");
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) field = field.substring(0,pt);
      addUnitField(field, data);
    }
  }
}
