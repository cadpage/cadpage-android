package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDAnneArundelCountyAnnapolisParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^INCIDENT (\\d+)\n\n");
  private static final Pattern DELIM = Pattern.compile("\\n{1,2}");
  
  
  public MDAnneArundelCountyAnnapolisParser() {
    super(CITY_CODES, "ANNE ARUNDEL COUNTY", "MD",
           "CALL1 ADDR/y MAP SKIP! X+? Nature:CALL! Call_back:PHONE? EXTRA+? UNIT HYDRANTS INFO+? TIMEDATE!");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@annapolis.gov";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("_subject_")) return false;
    
    // Check for duplicated page
    Matcher match = MARKER.matcher(body);
    if (!match.find())  return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end()).trim();
    int pt = body.indexOf(match.group());
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(DELIM.split(body), 7, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern CALL1_PTN = Pattern.compile("CODE +([A-Z0-9]+) +(.*?)( +ALARM 1)?");
  private class MyCall1Field extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL1_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCall = match.group(2).trim();
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get("   "), data);
      data.strPlace = p.getLast("   ");
      data.strApt = p.get();
      if (data.strApt.length() == 0 && NUMERIC.matcher(data.strPlace).matches()) {
        data.strApt = data.strPlace;
        data.strPlace = "";
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT PLACE";
    }
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("Grid +([^ ]+) +Map +([^ ]+) +Area ([^ ]+) +Preplan +([^ ]*) +Channel +([^ ]*) +MOA.*");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strMap = match.group(1) + '-' + match.group(2) + '-' + match.group(3);;
      String preplan = match.group(4);
      if (preplan.length() > 0) {
        data.strSupp = "Preplan:" + preplan;
      }
      data.strChannel = match.group(5).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "MAP CH";
    }
  }
  
  private static final Pattern CALL_PTN = Pattern.compile("([A-Z0-9]+)-(.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCode = match.group(1);
      data.strCall = append(data.strCall, " - ", match.group(2).trim());
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static final Pattern EXTRA_MARKER = Pattern.compile(" +\\([-0-9]+\\)$");
  private static final Pattern EXTRA_PHONE_PTN = Pattern.compile("\\d{10}");
  private static final Pattern EXTRA_SKIP_PTN = Pattern.compile("^VERIFY|^TAC CHANNEL|^Added unit |^Remove unit |^VOIP CALL QUERY|^WIRELESS CALLER VERIFY LOCATION|^New Fire Incident location:|^Fire service incident | changed from[ :]| Changed Via ProQA | had changed quarters for |'on air'");
  private class MyExtraField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("*")) field = field.substring(1).trim();
      Matcher match = EXTRA_MARKER.matcher(field);
      if (match.find()) field = field.substring(0, match.start());
      if (field.startsWith("Community of ")) {
        String city = field.substring(13).trim();
        if (city.endsWith(" CITY")) city = city.substring(0,city.length()-5).trim();
        if (city.equals("ANNAPOLIS")) {
          if (data.strCity.length() == 0) data.strCity = city;
        } 
        else if (data.strPlace.length() == 0) {
          data.strPlace = city;
        }
        return;
      }
      
      match = EXTRA_PHONE_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = field;
        return;
      }
      
      if (EXTRA_SKIP_PTN.matcher(field).find()) return;
      if (field.startsWith("ProQaA:")) field = field.substring(7).trim();
      data.strSupp = append(data.strSupp, "\n", field);
    }

    @Override
    public String getFieldNames() {
      return "PHONE PLACE INFO";
    }
  }
  
  private class HydrantsField extends MyInfoField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("HYDRANTS:")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.equals("HYDRANTS:  () &  ()")) return;
      if (field.equals("HYDRANTS:  (0) &  (0)")) return;
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  private static final Pattern TIME_DATE_PTN = Pattern.compile("TIME (\\d\\d:\\d\\d:\\d\\d) +DATE (\\d\\d/\\d\\d/\\d\\d)");
  private class MyTimeDateField extends TimeDateField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = TIME_DATE_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strTime = match.group(1);
      data.strDate = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
      super.parse(field, data);
    }
  }
  
  @Override
  public  Field getField(String name) {
    if (name.equals("CALL1")) return new MyCall1Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("X")) return new CrossField(".*? cross street - +(.*?)(?:-[A-Z]{2})?", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("EXTRA")) return new MyExtraField();
    if (name.equals("HYDRANTS")) return new HydrantsField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TIMEDATE")) return new MyTimeDateField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AN", "ANNAPOLIS",
      "EP", "ANNAPOLIS",
      "EW", "EDGEWATER",
      "SP", "SERVERNA PARK"
  });
}
