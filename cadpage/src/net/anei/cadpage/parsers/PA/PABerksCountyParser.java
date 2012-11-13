package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PABerksCountyParser extends FieldProgramParser {
  
  public PABerksCountyParser() {
    super("BERKS COUNTY", "PA",
           "UNITCALL! ADDR/iSXa! PLACE! X! CITY INFO DATETIME");
  }
  
  @Override
  public String getFilter() {
    return "@berks.alertpa.org,@rsix.roamsecure.net,14100";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Strip off message trailer
    int pt = body.indexOf("Sent by Berks County RSAN");
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (body.endsWith("=")) body = body.substring(0,body.length()-1).trim();
    
    // There used to be a Muni: field label.  Which we remove from old  messages
    body = body.replace("; Muni:", ";");
    
    return parseFields(body.split(";"), data);
  }
  
  private static final Pattern UNIT_CALL_PTN = Pattern.compile("Unit:([-A-Z0-9]+) Status:(?:Dispatched|Enroute) (.*)");
  private class MyUnitCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strUnit = match.group(1);
      String call = match.group(2).trim();
      String desc = CALL_CODES.getProperty(call);
      if (desc != null) call = call + " - " + desc;
      data.strCall = call;
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CALL";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" RES")) {
        field = field.substring(0,field.length()-4).trim();
        parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, field, data);
        data.strName = getLeft();
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " NAME";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern INFO_CITY_COUNTY_PTN  = Pattern.compile("(.*)-(.*)/(.*)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_CITY_COUNTY_PTN.matcher(field);
      if (match.matches()) {
        data.strCity = match.group(1).trim() + ',' + match.group(2).trim();
        field = match.group(3).trim();
      }
      super.parse(field, data);
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      if (!DATE_TIME_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("UNITCALL")) return new MyUnitCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "MF", "Misc",
      "MVAENT", "Accident w/ entrapment",
      "MVAUNK", "Accident unknown inj",
      "MVAWITH", "Accident w/ injury",
      "SF", "Structure Fire",
      "RSF", "Reading Structure Fire",
      "RAFA", "Reading Fire Alarm",
      "REMERG", "Reading Emerge",
      "RMISC", "Reading Misc",
      "RBF", "Reading Brush Fire",
      "BF", "Brush Fire",
      "CMA", "Carbon Monoxide",
      "AFA", "Fire Alarm",
      "VF", "Vehicle Fire",
      "FS", "Fire Service",
      "FSB", "Fire Scene Standby"
  });
  
}
