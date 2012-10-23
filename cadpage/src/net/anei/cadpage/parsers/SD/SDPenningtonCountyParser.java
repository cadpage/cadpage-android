package net.anei.cadpage.parsers.SD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Pennington County, SD
 */
public class SDPenningtonCountyParser extends FieldProgramParser {
 
  private static final Pattern TIME_PTN = Pattern.compile(" (\\d\\d:\\d\\d)$"); 
  
  public SDPenningtonCountyParser() {
    super(CITY_LIST, "PENNINGTON COUNTY", "SD",
           "Unit:UNIT! Status:STATUS! Problem:INFO Patient_info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.pennington.sd.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equalsIgnoreCase("page")) return false;
    
    Matcher match = TIME_PTN.matcher(body);
    if (match.find()) {
      data.strTime = match.group(1);
      body = body.substring(0,match.start()).trim();
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " TIME";
  }
  
  private static final Pattern CALLBACK_PTN = Pattern.compile("\\bCALLBK=([-0-9\\(\\)]+)\\b");
  private static final Pattern CODE_PTN = Pattern.compile("\\b\\d{1,2}-?[A-Za-z]-?\\d{1,2}[A-Za-z]?\\b");
  private class StatusField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" ProQA ");
      if (pt > 0) {
        Matcher match = CODE_PTN.matcher(field);
        if (match.find(pt+7)) {
          data.strCode = match.group();
        }
        field = field.substring(0,pt).trim();
      }
      
      StartType st = StartType.START_CALL;
      int flags = FLAG_PAD_FIELD | FLAG_IGNORE_AT | FLAG_IMPLIED_INTERSECT;
      
      Matcher match = CALLBACK_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        data.strCall = field.substring(0,match.start()).trim();
        field = field.substring(match.end()).trim();
        st = StartType.START_ADDR;
      }
      
      match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group();
        data.strSupp = field.substring(match.end()).trim();
        field = field.substring(0,match.start()).trim();
        flags |= FLAG_ANCHOR_END;
      }
      parseAddress(st, flags, field, data);
      data.strPlace = getPadField();
      if ((flags & FLAG_ANCHOR_END) == 0) data.strSupp = getLeft();
      if (data.strCity.equalsIgnoreCase("PENNCO")) data.strCity = "";
    }
    
    @Override
    public String getFieldNames() {
      return "CALL PHONE ADDR APT PLACE CITY INFO CODE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("STATUS")) return new StatusField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ASHLAND HEIGHTS",
    "COLONIAL PINE HILLS",
    "CREIGHTON",
    "GREEN VALLEY",
    "HILL CITY",
    "KEYSTONE",
    "NEW UNDERWOOD",
    "OWANKA",
    "QUINN",
    "RAPID CITY",
    "RAPID VALLEY",
    "WALL",
    "WASTA",
    "WICKSVILLE",
    "PENNCO",
    
    "ELK VALE",
    "ELLSWORTH AFB",
    "MUD BUTTE",
    "PIEDMONT",
    "TILFORD",
    "WHITE OWL",
    "BOX ELDER",
    "STURGIS",
    "BLACKHAWK",
    "SUMMERSET",
    "FAITH",
    "MEADCO"
  };
}
