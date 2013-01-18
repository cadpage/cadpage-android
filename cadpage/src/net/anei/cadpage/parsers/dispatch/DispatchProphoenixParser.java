package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchProphoenixParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:(\\d+)|(?:[ A-Z0-9]+ +\\(#(\\d+)\\) +)?([- A-Z0-9]+):) +");
  private static final Pattern TRAILER_PTN = Pattern.compile(" *;[A-Z0-9]+ +STOP$"); 
  
  private Properties cityCodes;
  
  public DispatchProphoenixParser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchProphoenixParser(Properties cityCodes, String defCity, String defState) {
    super(defCity, defState,
           "DATETIME CALL ADDR! Units:UNIT+ Comments:INFO+");
    this.cityCodes = cityCodes;
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // There are two kinds of headers.  Possibly one for text pages and another for SMTP pages
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    if (data.strCallId == null) {
      data.strCallId = match.group(2);
      if (data.strCallId == null) data.strCallId = "";
      data.strSource = match.group(3).trim();
    }
    body = body.substring(match.end());
    
    match = TRAILER_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start());
    
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID SRC " + super.getProgram();
  }
  
  private static final Pattern ID_DATE_TIME_PTN = 
    Pattern.compile("\\{(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)\\}");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
    }
  }
  
  private static final Pattern CALL_PTN = Pattern.compile("([A-Z ]+) *- *(.*?) *\\{(\\d)\\}");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCode = match.group(1).trim();
      data.strCall = match.group(2).trim();
      data.strPriority = match.group(3);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL PRI";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(';');
      String apt = p.getLastOptional(',');
      super.parse(p.get(), data);
      data.strApt = append(data.strApt, "-", apt);
      if (cityCodes != null && city.length() > 0) {
        data.strCity = convertCodes(city, cityCodes);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field.replaceAll("  +", " "));
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\{ *([A-Z0-9]+) *\\}");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      // First pick out any unit designation in curly braces.
      // These are added to the unit field if they are not already present there
      int lastPt = 0;
      Matcher match = UNIT_PTN.matcher(field);
      while (match.find()) {
        String sUnit = match.group(1);
        lastPt = match.end();
        Pattern ptn = Pattern.compile("\\b" + sUnit + "\\b");
        if (!ptn.matcher(data.strUnit).find()) data.strUnit = append(data.strUnit, " ", sUnit);
      }
      
      // Ignore everything up to the last unit
      field = field.substring(lastPt).trim();
      
      if (field.startsWith(",")) field = field.substring(1).trim();
      
      // Filter out stuff we aren't interested in
      if (field.contains("Units Recommended:")) return;
      if (field.contains("Toner Alert Instantiated")) return;
      int pt = field.indexOf("Update reviewed by dispatcher");
      if (pt >= 0) field = field.substring(0,pt).trim();
      
      // ANything else is information
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
