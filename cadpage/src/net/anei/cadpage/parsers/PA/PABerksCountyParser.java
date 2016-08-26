package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PABerksCountyParser extends FieldProgramParser {
  
  public PABerksCountyParser() {
    super("BERKS COUNTY",        "PA",
           "UNITCALL! ADDR/iSXa! PLACE! X! CITY INFO DATETIME");
    removeWords("STREET");
  }
  
  @Override
  public String getFilter() {
    return "@berks.alertpa.org,@c-msg.net,@rsix.roamsecure.net,1410,12101,411912,777,99538";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Strip off message trailer(s)
    body = stripFieldStart(body, "Berks County DES:");
    int pt = body.indexOf("\n\nSent ");
    if (pt < 0) pt = body.indexOf("\nReply ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    boolean force = body.startsWith("<!DOCTYPE");
    if (force) {
      body = cleanDocHeaders(body);
      if (body == null) return false;
    }
    body = stripFieldEnd(body, "=");
    
    // There used to be a Muni: field label.  Which we remove from old  messages
    body = body.replace("; Muni:",        ";");
    
    if (parseFields(body.split(";"), data)) return true;
    if (!force) return false;
    setFieldList("INFO");
    data.parseGeneralAlert(this, body);
    return true;
  }
  
  private String cleanDocHeaders(String body) {
    int ifCnt = 0;
    for (String line : body.split("\n")) {
      if (line.contains("<!--[if ")) ifCnt++;
      else if (line.contains("<![endif]")) ifCnt--;
      else if (ifCnt == 0) return line;
    }
    return null;
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
  
  private static final Pattern UNIT_CALL_PTN = Pattern.compile("Unit:([-A-Za-z0-9]+) Status:(?:Dispatched|Enroute|En Route|Notify|Arrived On Location|(Stand By)) (.*)");
  private class MyUnitCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strUnit = match.group(1);
      String qual = match.group(2);
      String call = match.group(3).trim();
      String desc = CALL_CODES.getProperty(call);
      if (qual != null) call = qual + " - " + call;
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
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "AFA",      "Fire Alarm",
      "BF",       "Brush Fire",
      "CMA",      "Carbon Monoxide",
      "FS",       "Fire Service",
      "FSB",      "Fire Scene Standby",
      "MF",       "Misc",
      "MVAENT",   "Accident w/ entrapment",
      "MVAUNK",   "Accident unknown inj",
      "MVAWITH",  "Accident w/ injury",
      "RAFA",     "Reading Fire Alarm",
      "RBF",      "Reading Brush Fire",
      "REMERG",   "Reading Emerge",
      "RMISC",    "Reading Misc",
      "RSF",      "Reading StructureFire",
      "SF",       "Structure Fire",
      "VF",       "Vehicle Fire"
  });
  
}
