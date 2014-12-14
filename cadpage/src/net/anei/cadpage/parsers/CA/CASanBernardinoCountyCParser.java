package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * San Bernardino County, CA
 */
public class CASanBernardinoCountyCParser extends FieldProgramParser {
  
  private static final Pattern SUBJ_SRC_PTN = Pattern.compile("[A-Z]{3,4}");
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("CLOSE: *([^ ]+)\n.*", Pattern.DOTALL);
  private static final Pattern GPS_PTN = Pattern.compile("\\?q=(-?\\d+\\.\\d{6},-?\\d+.\\d{6})\\b");
  
  public CASanBernardinoCountyCParser() {
    super("SAN BERNARDINO COUNTY", "CA",
           "CALL ADDRCITY! CROSS:X! RA:MAP! MAP:MAP! UNIT INFO!");
  }
  
  @Override
  public String getFilter() {
    return "bducad@FIRE.CA.GOV,messaging@iamresponding.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS | MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (SUBJ_SRC_PTN.matcher(subject).matches()) {
      data.strSource = subject;
    }
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strUnit = match.group(1);
      return true;
    }
    
    int pt = body.lastIndexOf(" <a");
    if (pt >= 0) {
      match = GPS_PTN.matcher(body.substring(pt));
      if (match.find()) {
        setGPSLoc(match.group(1), data);
      }
      body = body.substring(0,pt).trim();
    }
    body = body.replace(")- ", ") - "); 
    return parseFields(body.split(" - "), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram() + " GPS";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_PLACE_PTN = Pattern.compile("(.*?)\\((.*)\\)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_PLACE_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strPlace = match.group(2).trim();
      }
      super.parse(field, data);
      data.strCity = data.strCity.replace('_', ' ');
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
}
