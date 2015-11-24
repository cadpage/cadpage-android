package net.anei.cadpage.parsers.VT;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class VTLamoilleCountyParser extends FieldProgramParser {
  private String timeString;
  private boolean unitInfo;
  private Map<String, String> unitName;
  
  public VTLamoilleCountyParser() {
    super("LAMOILLE COUNTY", "VT",
          "SKIP SKIP SKIP SKIP SKIP SKIP Address:ADDRCITY Incident_Number:ID Call_Type:CALL Narratives:INFO+");
  }

  @Override
  public String getFilter() {
    return "valcournotification@gmail.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    timeString = "";
    unitInfo = false;
    unitName = new HashMap<String, String>();
    if (!parseFields(body.split("\n"), data)) return false;
    if (data.msgType == MsgType.RUN_REPORT) {
      data.strSupp = append(timeString, "\n", data.strSupp);
    }
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("ID")) return new IdField("\\d\\d[A-Z]{2,4}\\d{6}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static final Pattern ADDRESS_CITY_PATTERN
    = Pattern.compile("(.*?)(?:,(.*?))?(?:, *([A-Za-z]{2}))?(?:, *(\\d{5}))?");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = ADDRESS_CITY_PATTERN.matcher(field);
      if (m.matches()) {
        String a = m.group(1),
            c = getOptGroup(m.group(2));
        if (c.contains(",") && !c.equals(",")) {
          int ndx = c.indexOf(',');
          if (ndx == c.length())
            ndx--;
          parseAddress(append(a, ",", c.substring(0, ndx+1)), data);
            data.strCity = c.substring(ndx+1).trim();
        }
        else {
          parseAddress(m.group(1).trim(), data);
          data.strCity = getOptGroup(m.group(2)).trim();
        }
        if (data.strCity.equals(""))
          data.strCity = getOptGroup(m.group(4));
        data.strState = getOptGroup(m.group(3));
      }
      else
        super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" ST";
    }
  }
  
  private static final Pattern UNIT_INFO_PATTERN_1
  = Pattern.compile("Unit Id +(\\d):(.*)"),
                              UNIT_INFO_PATTERN_2
  = Pattern.compile("(Dispatched|Enroute|On Scene|Cleared) +(\\d): +(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d)"),
                              UNIT_INFO_PATTERN_3
  = Pattern.compile("(?:Medical|Fire) \\d:.*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      String uName = "";
      if (field.equals("")) return;
      if (field.startsWith("-----") && field.endsWith("-----")) return;
      if (field.equals("Units")) {
        unitInfo = true;
        return;
      }
      if (unitInfo) {
        Matcher m = UNIT_INFO_PATTERN_3.matcher(field);
        if (m.matches()) return;
        m = UNIT_INFO_PATTERN_1.matcher(field);
        if (m.matches()) {
          uName = m.group(2).trim();
          unitName.put(m.group(1), uName);
          data.strUnit = append(data.strUnit, ",", uName);
          return;
        }
        m = UNIT_INFO_PATTERN_2.matcher(field);
        if (m.matches()) {
          String entry = m.group(1);
          if (entry.equals("Dispatched")) {
            data.strDate = m.group(3);
            data.strTime = m.group(4);
            timeString = append(data.strDate, " ", data.strTime);
          }
          if (entry.equals("On Scene"))
            data.msgType = MsgType.RUN_REPORT;
          uName = getOptGroup(unitName.get(m.group(2)));
          if (uName.equals(""))
            uName = "Unit "+m.group(2);
          field = uName+" "+entry+" "+timeString;
          }
          else field = "";
        }
        data.strSupp = append(data.strSupp, "\n", field);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" UNIT DATE TIME";
    }
  }
}