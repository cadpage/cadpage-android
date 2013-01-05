package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Butte County, CA
 */
public class CAOrovilleParser extends FieldProgramParser {
  
  public CAOrovilleParser() {
    super("OROVILLE", "CA",
           "ADDRCITY PLACE X APT SRC! EMPTY INFO");
  }
  
  @Override
  public String getFilter() {
    return "@OROPD.ORG";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Dispatched Call")) return false;
    if (body.endsWith("*")) body = body + " ";
    if (!parseFields(body.split(" \\* ", -1), 5, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "ALERT";
    return true;
  }
  
  private static final Pattern INFO_DELIM = Pattern.compile(" *\n+ *|  +| *, *(?!.*\\.$)");
  private static final Pattern UNIT_PTN = Pattern.compile("ENG .*", Pattern.CASE_INSENSITIVE);
  private static final Pattern GPS_PTN = Pattern.compile("(?:LAT|LON):(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT_PTN = Pattern.compile("\\d+ ?[A-Z]?|ROOM.*|RM.*|BLDG.*", Pattern.CASE_INSENSITIVE);
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
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
          data.strGPSLoc = append(data.strGPSLoc, ",", match.group(1)); 
        } else if (data.strCall.length() == 0) {
          data.strCall = line;
        } else {
          super.parse(line, data);
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT APT CALL GPS INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
