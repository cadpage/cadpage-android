package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Erie County, NY (Variant B)
Contact: Mike ECFW <webmaster@ecfwire.com>
Sender:IPN <IPN@IPN911.net>

NYK| Erie County (Lancaster)| Technical Rescue| | Como Park|PD O/S reporting pedestrian walk bridge collapse- 1 victim with leg trapped- request FD with saws| NYK109| 16:54
NYK / NYK| Buffalo| 1 Alarm Fire| | 63 Crestwood Ave|F20 O/S reporting fire in a dwelling-victims rescued-ACW| NYK109| 12:13\n\n
NYK| Erie County (Lancaster)| 1 Alarm Fire| 453.500| 17 E Drullard Ave|Lancaster FD O/S Rep Fire in a 2 Story Occ Brick Apt Bldg. AHW| NYK004| 22:29
NYK| Erie County (Concord)| Major Accident| | New York 39 & Mortons Corners|ECSD / NYSP O/S Rollover MVA with Entrapment. Veh Rep on Fire. Mercy Flight Enroute.| NYK004| 13:42
NYK / NYK| Buffalo| 1 Alarm Fire| | 63 Crestwood Ave|F20 O/S reporting fire in a dwelling-victims rescued-ACW| NYK109| 12:13\n\n
NYK| Buffalo| 1 Alarm Fire| 424.350| 63 Crestwood ave|U/D: E-38 updated size up 2.5 story dwelling. Heavy Fire 2nd floor and attic. Extra 2 & 1 req.| NYK016| 12:17

 */


public class NYErieCountyBParser extends FieldProgramParser {
  
  public NYErieCountyBParser() {
    super("ERIE COUNTY", "NY",
           "SRC CITY CALL PLACE ADDR INFO UNIT SKIP");
  }
  
  @Override
  public String getFilter() {
    return "IPN <IPN@IPN911.net>";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    String[] flds = body.split("\\|");
    if (flds.length < 7) return false;
    return parseFields(flds, data);
  }
  
  private static final Pattern PAREN_PTN = Pattern.compile("\\((.*)\\)"); 
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PAREN_PTN.matcher(field);
      if (match.find()) field = match.group(1);
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
}
