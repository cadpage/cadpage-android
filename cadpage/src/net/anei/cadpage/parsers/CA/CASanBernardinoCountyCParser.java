package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

/**
 * San Bernardino County, CA
 */
public class CASanBernardinoCountyCParser extends FieldProgramParser {
  
  private static final Pattern SUBJ_SRC_PTN = Pattern.compile("[A-Z]{3,4}");
  private static final Pattern GPS_PTN = Pattern.compile("\\?q=(-?\\d+\\.\\d{6},-?\\d+.\\d{6})\\b");
  
  public CASanBernardinoCountyCParser() {
    super("SAN BERNARDINO COUNTY", "CA",
          "( SELECT/RR CLOSE:UNIT! TIMES! Location:ADDRCITY " +
          "| CALL ADDRCITY! CROSS:X! RA:MAP! MAP:MAP! UNIT INFO! )");
  }
  
  @Override
  public String getFilter() {
    return "bducad@FIRE.CA.GOV,messaging@iamresponding.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (SUBJ_SRC_PTN.matcher(subject).matches()) {
      data.strSource = subject;
    }
    
    if (body.startsWith("CLOSE:")) {
      data.msgType = MsgType.RUN_REPORT;
      setSelectValue("RR");
      return parseFields(body.split("\n"), data);
    }
    
    setSelectValue("");
    
    int pt = body.lastIndexOf(" <a");
    if (pt >= 0) {
      Matcher match = GPS_PTN.matcher(body.substring(pt));
      if (match.find()) {
        setGPSLoc(match.group(1), data);
      }
      body = body.substring(0,pt).trim();
    }
    body = body.replace(")- ", ") - "); 
    body = body.replace("- CROSS:", " - CROSS:");
    return parseFields(body.split(" - "), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram() + " GPS";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("TIMES")) return new MyTimesField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_PLACE_PTN = Pattern.compile("(.*?)\\((.*)\\)");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_PLACE_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strPlace = match.group(2).trim();
      }
      super.parse(field, data);
      data.strCity = data.strCity.replace('_', ' ');
      data.strCity = convertCodes(data.strCity, CITY_CODES);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern TIMES_BRK_PTN = Pattern.compile(" *; *");
  private class MyTimesField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = TIMES_BRK_PTN.matcher(field).replaceAll("\n");
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
    "DHSP",         "DESERT HOT SPRINGS"
  });
}
