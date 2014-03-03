package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Pulaski County, MO
 */
public class MOPulaskiCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("\nComplete: *\\d{1,2}:\\d{1,2}:\\d{1,2}$");
  
  public MOPulaskiCountyParser() {
    super(CITY_TABLE, "PULASKI COUNTY", "MO",
           "ADDR/SC! CrossStreets:X! Call_Received_Time:SKIP Dispatch:DATETIME Dispatch:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "911dispatch@embarqmail.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (RUN_REPORT_PTN.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(", ", " ");
      String[] parts = field.split("  +");
      if (parts.length == 3) {
        data.strCall = parts[0];
        parseAddress(parts[1], data);
        data.strCity = parts[2];
      } else if (parts.length == 2) {
        data.strCall = parts[0];
        parseAddress(StartType.START_ADDR, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, parts[1], data);
      } else {
        super.parse(field, data);
      }
      
      if (data.strCity.equalsIgnoreCase("PULASKI COUNTY")) data.strCity = "";
      if (data.strAddress.endsWith(" UNIT")) {
        data.strAddress = data.strAddress.substring(0, data.strAddress.length()-5).trim();
      }
      if (data.strApt.endsWith("UNIT")) {
        data.strApt = data.strApt.substring(0, data.strApt.length()-4).trim();
      }
      
      int pt = data.strAddress.indexOf(" - ");
      if (pt >= 0) {
        data.strPlace = data.strAddress.substring(pt+3).trim();
        data.strAddress = data.strAddress.substring(0,pt).trim();
      }
    }
  }
  
  // Unit codes will be nnnn, or xFDn, or Mnn
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(\\d{4}(?!\\.)|[A-Z]{1,2}[FP]D\\d?|M\\d\\d|MARIES|DAD)\\b");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      
      // Cross street field contains cross streets and units and extra stuff that we discard
      Matcher match = UNIT_PTN.matcher(field);
      if (!match.find()) {
        data.strCross = field;
      } else {
        data.strCross = field.substring(0,match.start()).trim();
        data.strUnit = field.substring(match.start());
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = HIST_PTN.matcher(addr).replaceAll("HISTORIC");
    addr = HIST_RT_PTN.matcher(addr).replaceAll("HISTORIC US");
    return addr;
  }
  private static final Pattern HIST_PTN = Pattern.compile("\\bHIST\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern HIST_RT_PTN = Pattern.compile("HISTORIC RT", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_TABLE = new String[]{
    "PULASKI COUNTY",
    "BIG PINEY",
    "CROCKER",
    "DEVILS ELBOW",
    "DIXON",
    "GASCOZARK",
    "HOOKER",
    "LAQUEY",
    "RICHLAND",
    "ST ROBERT",
    "SWEDEBORG",
    "WAYNESVILLE"
  };
}
