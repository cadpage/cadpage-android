package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MOPulaskiCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("\nComplete: *\\d{1,2}:\\d{1,2}:\\d{1,2}$");
  
  public MOPulaskiCountyParser() {
    super(CITY_TABLE, "PULASKI COUNTY", "MO",
           "ADDR/SC! CrossStreets:X! Call_Received_Time:SKIP! Dispatch:DATETIME Dispatch:SKIP");
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
      String[] parts = field.split("  +");
      if (parts.length == 3) {
        data.strCall = parts[0];
        parseAddress(cleanAddress(parts[1]), data);
        data.strCity = parts[2];
      } else if (parts.length == 2) {
        data.strCall = parts[0];
        parseAddress(StartType.START_ADDR, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, cleanAddress(parts[1]), data);
      } else {
        super.parse(cleanAddress(field), data);
      }
      
      if (data.strCity.equalsIgnoreCase("PULASKI COUNTY")) data.strCity = "";
      if (data.strAddress.endsWith(" UNIT")) {
        data.strAddress = data.strAddress.substring(0, data.strAddress.length()-5).trim();
      }
      if (data.strApt.endsWith("UNIT")) {
        data.strApt = data.strApt.substring(0, data.strApt.length()-4).trim();
      }
    }
    
    private String cleanAddress(String addr) {
      return addr.replace(" - ", "APT: ").replace(",", " ");
    }
  }
  
  // Unit codes will be nnnn, or xFDn, or Mnn
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(\\d{4}|[A-Z]{1,2}[FP]D\\d?|M\\d\\d|MARIES|DAD)\\b");
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
