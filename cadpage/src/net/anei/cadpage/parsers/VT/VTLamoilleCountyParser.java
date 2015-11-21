package net.anei.cadpage.parsers.VT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class VTLamoilleCountyParser extends FieldProgramParser {
  private static final int MAX_UNITS = 3;
  private String timeString;
  private boolean unitInfo;
  private String[] unitId;
  
  public VTLamoilleCountyParser() {
    super(CITY_LIST,
          "LAMOILLE COUNTY", "VT",
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
    unitId = new String[MAX_UNITS];
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

  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      int ndx = data.strApt.indexOf(',');
      if (ndx >=0) data.strApt = data.strApt.substring(0, ndx);
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
      int unitNumber;
      String unitName;
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
          unitName = m.group(2).trim();
          unitNumber = Integer.parseInt(m.group(1));
          if (unitNumber <= MAX_UNITS) unitId[unitNumber-1] = unitName;
          data.strUnit = append(data.strUnit, ",", unitName);
          return;
        }
        m = UNIT_INFO_PATTERN_2.matcher(field);
        if (m.matches()) {
          String entry = m.group(1);
          unitNumber = Integer.parseInt(m.group(2));
          String dt = m.group(3),
                 tm = m.group(4);
          if (entry.equals("On Scene")) data.msgType = MsgType.RUN_REPORT;
          timeString = append(dt, " ", tm);
          if (unitNumber <= MAX_UNITS) {
            field = unitId[unitNumber-1]+" "+entry+" "+timeString;
          }
        }
        else field = "";
      }
      data.strSupp = append(data.strSupp, "\n", field);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" UNIT";
    }
  }
  
  private static final String[] CITY_LIST = {
      "BARRE",
      "BARRE TOWN",
      "BELVIDERE",
      "BERLIN",
      "BURLINGTON",
      "CABOT",
      "CAMBRIDGE",
      "CORINTH",
      "EDEN",
      "ELMORE",
      "GRANITEVILLE",
      "HYDE PARK",
      "JOHNSON",
      "ORANGE",
      "MARSHFIELD",
      "MORETOWN",
      "MORRISTOWN",
      "MORRISVILLE",
      "MOSCOW",
      "NORTHFIELD",
      "SHIRE TOWN",
      "STOWE",
      "TOPSHAM",
      "WAITSFIELD",
      "WARREN",
      "WASHINGTON",
      "WATERBURY",
      "WATERVILLE",
      "WHITE RIVER JUNCTION",
      "WILLIAMSTOWN",
      "WOLCOTT"
  };
}
