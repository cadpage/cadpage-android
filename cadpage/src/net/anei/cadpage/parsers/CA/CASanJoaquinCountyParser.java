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
  
  private static final Pattern RUN_REPORT_PTN1 = Pattern.compile("([-A-Z0-9]+) +(?:(\\d{8}|[A-Z]{3}-\\d{6}) +)?Dispatched:.*?Enroute:.*?On Scene:.*?AOR:.*");
  private static final Pattern RUN_REPORT_PTN2 = Pattern.compile("RUN REPORT CAD ?#(\\d{8}|[A-Z]{3}-\\d{6}) +([-\\(\\)A-Z0-9]{1,10}) *(?:Dispatched:.*Enroute:.*On Scene:.*AOR:|Disp:.*Resp:.*On Scene:.*TX:.*Dest:.*AOR:).*");
  private static final Pattern MASTER1 = Pattern.compile("(?:((?![A-Z]{3}-\\d+)[A-Z][-\\(\\)A-Z0-9]*+) ++)?+((?:[A-Z]{3}-\\d{6}|\\d{8})(?=  )|\\d{8}-\\d{6}) *(.*?)  +(.*?)(?:  +(.*?))?Bldg: *(.*?)Apt: *(.*?)(?:Assigned Units: *(.*))?");
  private static final Pattern MASTER2 = Pattern.compile("(?:([A-Z][-A-Z0-9]*+) ++)?+(\\d{8}) {5}([^ ].*)");
  private static final Pattern UNIT_GPS_CH_PTN = Pattern.compile("(.*?)GPS:(\\d{2})(\\d{6}) +&(\\d{3})(\\d{6})\\b *(.*)");
  private static final Pattern CHANNEL_PTN = Pattern.compile("(.*?) *((?:CMD |XSJ ).*)");
  
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
    return "LifecomCellPaging@amr.net,VRECC.CAD@donotreply.com";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    Matcher match = MAP_ADDR_PTN.matcher(addr);
    if (match.matches()) addr = match.group(1);
    return super.adjustMapAddress(addr);
  }
  private static final Pattern MAP_ADDR_PTN = Pattern.compile("[1-3] - +(.*)");

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // First see if this looks like a run report
    Matcher match = RUN_REPORT_PTN1.matcher(body); 
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strUnit = match.group(1);
      data.strCallId = getOptGroup(match.group(2));
      return true;
    }
    
    match = RUN_REPORT_PTN2.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = match.group(1);
      data.strUnit = match.group(2);
      return true;
    }
    
    // Try the fixed format fields first
    do {
      FParser p = new FParser(body);
      String unit = p.get(10);
      String callId = p.get(15);
      String call;
      boolean variant1 = p.check("Loc:");
      if (variant1) {
        call = "ALERT";
      } else {
        call = p.get(30);
        if (!p.check("Loc:")) break;
      }
      String place = p.get(50);
      String addr = p.get(50);
      
      String cross, apt1, apt2, city, respPlan, left;
      if (variant1) {
        cross = p.get(20);
        if (!p.check("Bldg:")) break;
        apt1 = p.get(10);
        if (!p.check("Apt:")) break;
        apt2 = p.get(10);
        if (!p.check("City:")) break;
        city = p.get();

        setFieldList("UNIT ID CALL PLACE ADDR X APT CITY");
        respPlan = left = "";
      }
      
      else {
        if (!p.check("City:")) break;
        city = p.get(15);
        cross = p.get(20);
        if (!p.check("Bldg:")) break;
        apt1 = p.get(10);
        if (!p.check("Apt:")) break;
        apt2 = p.get(10);
        if (!p.check("Assigned Units:Resp Plan:")) break;
        respPlan = p.get(50);
        if (respPlan.length() > 0) respPlan = "Resp Plan:" + respPlan;
        if (!p.check("All Units Assigned:")) break;
        left = p.get();
      }
      
      setFieldList("UNIT ID CALL PLACE ADDR CITY X APT INFO GPS CH");
      data.strUnit = unit;
      data.strCallId = callId;
      data.strCall = call;
      data.strPlace = place;
      parseAddress(addr, data);
      data.strCity = city;
      data.strCross = cleanCrossField(cross);
      data.strApt = append(apt1, "-", data.strApt);
      data.strApt = append(data.strApt, "-", apt2);
      data.strSupp = respPlan;
      
      String channel;
      if ((match = UNIT_GPS_CH_PTN.matcher(left)).matches()) {
        addUnitField(match.group(1), data);
        setGPSLoc(match.group(2)+'.'+match.group(3)+','+match.group(4)+'.'+match.group(5), data);
        channel = match.group(6);
      }
      else if ((match = CHANNEL_PTN.matcher(left)).matches()) {
        addUnitField(match.group(1), data);
        channel = match.group(2);
      }
      else {
        addUnitField(left, data);
        channel = "";
      }
      data.strChannel = channel.replaceAll("  +", " ");
      return true;
    } while (false);
    
    do {
      FParser p = new FParser(body);
      String unit = p.get(10);
      if (p.check(",You have been assigned to post at:")) {
        setFieldList("UNIT CALL ADDR INFO");
        data.strUnit = unit;
        data.strCall = "Post assignment";
        data.strAddress = p.get(80);
        data.strSupp = p.get();
        return true;
      }
      if (!p.check("CAD ID#:")) break;
      String callId = p.get(10);
      if (p.check("*SECURITY CHECK - 20 MINUTES*")) {
        setFieldList("UNIT ID CALL INFO");
        data.strUnit = unit;
        data.strCallId = callId;
        data.strCall = "SECURITY CHECK - 20 MINUTES";
        data.strSupp = p.get();
        return true;
        
      }
      boolean variant1 = p.check("     Run(PCR#):Loc:");
      if (!variant1) {
        if (!p.check("Run(PCR#):")) break;
        callId = append(callId, "/", p.get(8));
        if (p.check("*RUN REPORT*Tcr/")) {
          data.strUnit = unit;
          data.strCallId = callId;
          data.strCall = "RUN REPORT";
          data.strPlace = body;
          return true;
        }
      }
      String place = p.get(50);
      String addr = p.get(30);

      String call, cross, apt1, apt2, city, gps, map;
      if (variant1) {
        call = "ALERT";
        cross = p.get(40);
        if (!p.check("Bldg:")) break;
        apt1 = p.get(10);
        if (!p.check("Apt:")) break;
        apt2 = p.get(10);
        if (!p.check("City:")) break;
        city = p.get();
        gps = map = "";
        setFieldList("UNIT ID PLACE ADDR X CALL APT CITY APT");

      }
      
      else {
        if (p.check("**CANCEL RESPONSE**")) {
          call = "CANCEL - " + p.get(15);
          if (!p.check("Tcr/")) break;

          setFieldList("UNIT ID PLACE ADDR APT CALL");
          data.strUnit = unit;
          data.strCallId = callId;
          data.strPlace = place;
          parseAddress(addr, data);
          data.strCall = call;
          return true;
        }
        boolean addrChange = p.check("**RESPONSE ADDRESS CHANGE**");
        if (!addrChange && !p.check("**NEW CALL ASSIGNMENT**")) break;
        if (!p.check("X:")) break;
        cross = p.get(40);
        call = p.get(30);
        if (!p.check(" ")) break;
        call = append(call, "/", p.get(30));
        city = p.get(15);
        if (addrChange) {
          if (p.get(20).length() > 0) break;
          if (!p.check("Apt#:")) break;
        } else { 
          if (!p.check("Apt #")) break;
        }
        apt2 = p.get(10);
        if (!p.check("BLDG#")) break;
        if (addrChange && !p.check(":")) break;
        apt1 = p.get(10);
        if (!p.check("GPS:")) break;
        gps = p.get(2)+'.'+p.get(6);
        if (!p.check("  &")) break;
        gps = gps+','+p.get(3)+'.'+p.get(6);
        if (addrChange) {
          map = "";
        } else {
          if (!p.check("      ProQA Code:Map:")) break;
          map = p.get();
        }
        
        setFieldList("UNIT ID PLACE ADDR X CALL CITY APT GPS MAP");
      }
      data.strUnit = unit;
      data.strCallId = callId;
      data.strPlace = place;
      parseAddress(addr, data);
      data.strCross = cleanCrossField(cross);
      data.strCall = call;
      data.strCity = city;
      data.strApt = append(apt1, "-", data.strApt);
      data.strApt = append(data.strApt, "-", apt2);
      setGPSLoc(gps, data);
      data.strMap = map;
      return true;
    } while (false);
    
    do {
      FParser p = new FParser(body);
      String call = p.get(30);
      String place = p.get(30);
      String addr = p.get(50);
      String city = p.get(12);
      if (!p.check("CAD #")) break;
      String callId = p.get(16);
      String unit = p.get(10);
      if (!p.check("Bldg:")) break;
      String apt1 = p.get(10);
      if (!p.check("Apt:")) break;
      String apt2 = p.get(10);
      String cross = p.get(30);
      String source = p.get(30);
      
      setFieldList("CALL PLACE ADDR CITY ID UNIT PLACE APT X SRC");
      data.strCall = call;
      data.strPlace = place;
      parseAddress(addr, data);
      data.strCity = city;
      data.strCallId = callId;
      data.strUnit = unit;
      data.strApt = append(apt1, "-", data.strApt);
      data.strApt = append(data.strApt, "-", apt2);
      data.strCross = cleanCrossField(cross);
      data.strSource = source;
      return true;
    } while (false);
    
    // There are two types of CAD page, check for the first one
    match = MASTER1.matcher(body);
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
      Matcher match = CHANNEL_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strChannel = match.group(2);
      }
      field = cleanCrossField(field);
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "X CH";
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
