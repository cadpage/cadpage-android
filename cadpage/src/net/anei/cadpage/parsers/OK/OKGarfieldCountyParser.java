package net.anei.cadpage.parsers.OK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OKGarfieldCountyParser extends FieldProgramParser {
  
  private static final Pattern INCIDENT_NO_PTN = Pattern.compile("YIncident No.: *(\\d+) +");
  private static final Pattern MISSED_DELIM_PTN = Pattern.compile(" (?=Complaint No.:|Category:|Fire:|EMS:)");
  
  public OKGarfieldCountyParser() {
    super(CITY_LIST, "GARFIELD COUNTY", "OK",
           "Incident_No.:ID! Complaint_No.:SKIP? Category:CALL! Address:ADDR/SXXa! Open_DateTime_/_DSN:SKIP! Dispatch_DateTime:DATETIME! Police:SKIP! Fire:SRC! EMS:SKIP! Business_Name:PLACE? Incident_Notes:INFO INFO+?");
  }
  
  @Override
  public String getFilter() {
    return "911firedispatch@enid.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Call")) return false;
    
    if (body.contains("\nArrival DateTime: ")) {
      data.strCall = "RUN REPORT";
      Matcher match = INCIDENT_NO_PTN.matcher(body);
      if (match.find()) {
        data.strCallId = match.group(1);
        body = body.substring(match.end());
      }
      data.strPlace = body;
      return true;
    }
    
    body = MISSED_DELIM_PTN.matcher(body).replaceAll("\n");
    return parseFields(body.split("\n"), data);
  }

  private static final Pattern INFO_SKIP_PTN = Pattern.compile("Call Received on .*|");
  private static final Pattern INFO_END_PTN = Pattern.compile("Log Date Time .*|City: .*");
  private class MyInfoField extends InfoField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (INFO_END_PTN.matcher(field).matches()) return false;
      parse(field, data);
      return true;
    }
    
    @Override 
    public void parse(String field, Data data) {
      if (INFO_SKIP_PTN.matcher(field).matches()) return;
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return HWY412_PTN.matcher(address).replaceAll("US 412");
  }
  private static final Pattern HWY412_PTN = Pattern.compile("\\bHWY *412\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{
    "BISON",
    "BRECKENRIDGE",
    "CARRIER",
    "COVINGTON",
    "DOUGLAS",
    "DRUMMOND",
    "ENID",
    "FAIRMONT",
    "GARBER",
    "HILLSDALE",
    "HUNTER",
    "KREMLIN",
    "LAHOMA",
    "NORTH ENID",
    "WAUKOMIS",
    
    "GARFIELD COUNTY"
  };

}
