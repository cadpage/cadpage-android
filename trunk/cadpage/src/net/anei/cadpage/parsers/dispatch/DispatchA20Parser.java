package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Butte County, CA
 */
public class DispatchA20Parser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Dispatched Call \\(([A-Z0-9]+)\\)(?:\\|.*)?");
  
  private Properties codeLookupTable;

  public DispatchA20Parser(String defCity, String defState) {
    this(null, defCity, defState);
  }

  public DispatchA20Parser(Properties codeLookupTable, String defCity, String defState) {
    super(defCity, defState,
           "ADDRCITYST PLACE X APT CODE! MAP ID? INFO");
    this.codeLookupTable = codeLookupTable;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Replace paren terms that might have gotten stripped off the beginning
    // of the message
    String[] subParts = subject.split("\\|");
    subject = subParts[0];
    for (int jj = subParts.length-1; jj>0; jj--) {
      body = '(' + subParts[jj] + ')' + body;
    }
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    if (body.endsWith("*")) body = body + " ";
    if (!parseFields(body.split(" \\* ", -1), 5, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "ALERT";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITYST")) return new MyAddressCityStField();
    if (name.equals("ID")) return new IdField("#(\\d+)", true);
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private class MyAddressCityStField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLast(',');
      if (city.length() == 2) {
        if (!city.equals(data.defState)) data.strState = city;
        city = p.getLast(',');
      }
      String addr = p.get();
      if (addr.length() == 0) abort();
      super.parse(addr, data);
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY ST";
    }
  }
  
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      if (codeLookupTable != null) data.strCall = convertCodes(field, codeLookupTable);
    }
    
    @Override
    public String getFieldNames() {
      return (codeLookupTable == null ? "CODE" : "CODE CALL");
    }
  }
  
  private static final Pattern INFO_DELIM = Pattern.compile(" *\n+ *|  +| *, *(?!.*\\.$)");
  private static final Pattern UNIT_PTN = Pattern.compile("ENG .*", Pattern.CASE_INSENSITIVE);
  private static final Pattern GPS_PTN = Pattern.compile("(?:LAT|LON):(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT_PTN = Pattern.compile("\\d+ ?[A-Z]?|ROOM.*|RM.*|BLDG.*", Pattern.CASE_INSENSITIVE);
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      String gpsLoc = "";
      for (String line : INFO_DELIM.split(field)) {
        if (line.startsWith("Service Class:")) continue;
        if ("Service Class:".startsWith(line)) continue;
        int pt = line.indexOf("Cellular E911 Call:");
        if (pt == 0) continue;
        if (pt > 0) line = line.substring(0,pt).trim();
        Matcher match;
        if (UNIT_PTN.matcher(line).matches()) {
          data.strUnit = line;
        } else if (APT_PTN.matcher(line).matches()) {
          data.strApt = append(data.strApt, "-", line); 
        } else if ((match = GPS_PTN.matcher(line)).matches()) {
          gpsLoc = append(gpsLoc, ",", match.group(1)); 
        } else if (data.strCall.length() == 0) {
          data.strCall = line;
        } else {
          super.parse(line, data);
        }
      }
      setGPSLoc(gpsLoc, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT APT CALL GPS INFO";
    }
  }
}
