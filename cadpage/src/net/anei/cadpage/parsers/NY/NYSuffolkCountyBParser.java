package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYSuffolkCountyBParser extends FieldProgramParser {
  
  public NYSuffolkCountyBParser() {
    super(CITY_LIST, "SUFFOLK COUNTY", "NY",
           "ADDR/SP! CS:X? ADTML:CODE? TOA:TIMEDATE TYPE:INFO LOC:SKIP");
    setupMultiWordStreets("INDIAN HEAD");
  }
  
  @Override
  public String getFilter() {
    return "@firerescuesystems.xohost.com,scmproducts@optonline.net,paging@bcfa.xohost.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt1 = body.indexOf("***");
    if (pt1 < 0) return false;
    boolean good = (pt1 == 0);
    int pt2 = body.indexOf("***",pt1+3); 
    if (pt2 < 0) return false;
    data.strCall = append(body.substring(pt1+3, pt2).trim(), " - ", body.substring(0,pt1));
    body = body.substring(pt2+3).trim();
    if (! super.parseMsg(body, data)) return false;
    if (!good && data.strCross.length() == 0 && data.strTime.length() == 0) return false;
    if (data.strPlace.endsWith("*")) data.strPlace = data.strPlace.substring(0, data.strPlace.length()-1).trim();
    if (data.strAddress.length() == 0) {
      data.strAddress = data.strPlace;
      data.strPlace = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }

  private static final Pattern TIME_DATE = Pattern.compile("^(\\d\\d:\\d\\d)(?: (\\d\\d[-/]\\d\\d[-/]\\d\\d))?\\b");
  private static final Pattern ANGLE_BKT_PTN = Pattern.compile("<[^<>]*>");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{4}-\\d{6}\\b");
  private static final Pattern DISTRICT_PTN = Pattern.compile("\\b(?:NORTH BABYLON FC|AMITYVILLE FD|DEER PARK FIRE DISTRICT|PT JEFFERSON)\\b");
  private class MyTimeDateField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_DATE.matcher(field);
      if (!match.find()) abort();
      data.strTime = match.group(1);
      data.strDate = getOptGroup(match.group(2));
      field = field.substring(match.end()).trim();
      field = ANGLE_BKT_PTN.matcher(field).replaceAll("");
     match = DISTRICT_PTN.matcher(field);
      if (match.find()) {
        data.strSource = match.group();
        field = field.substring(0,match.start()) + field.substring(match.end());
      }
      match = ID_PTN.matcher(field);
      if (match.find()) {
        data.strCallId = match.group();
        field = field.substring(0,match.start()) + field.substring(match.end());
      }
      field = field.trim().replaceAll("  +", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "TIME DATE SRC ID INFO";
    }
  }
  
  private static final Pattern CALL_DELIM_PTN = Pattern.compile("\\(|  ");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() <= 2) {
        Matcher match = CALL_DELIM_PTN.matcher(field);
        int pt = match.find() ? match.start() : field.length();
        data.strCall = append(data.strCall, " - ", field.substring(0,pt).trim());
        field = field.substring(pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIMEDATE")) return new MyTimeDateField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BELLE TERRE", 
    "COMMACK",
    "CORAM",
    "E NORTHPORT",
    "MOUNT SINAI", 
    "MILLER PLACE",
    "PORT JEFFERSON",
    "SMITHTOWN",
    "STONY BROOK" 
  };
}
