package net.anei.cadpage.parsers.MT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MTFlatheadCountyParser extends FieldProgramParser {
  
  private static final Pattern MISSED_BLANK_PTN = Pattern.compile("(?<! )(?=Call Type:)");

  public MTFlatheadCountyParser() {
    super("FLATHEAD COUNTY", "MT",
           "Unit:UNIT Status:SKIP Location:ADDR/SXP! Gen:PLACE Call_Type:CALL! Call_Time:TIME! Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@communicationcenter.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Information")) return false;
    body = MISSED_BLANK_PTN.matcher(body).replaceAll(" ");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("U:")) field = field.substring(2).trim();
      Matcher match = CITY_PTN.matcher(field);
      if (match.find()) {
        data.strCity = match.group();
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
      if (NUMERIC.matcher(data.strPlace).matches()) {
        data.strApt = append(data.strApt, "-", data.strPlace);
        data.strPlace = "";
      }
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CITY_PTN.matcher(field);
      if (match.find()) {
        data.strCity = match.group();
        field = field.substring(0,match.start());
      }
      if (data.strAddress.length() == 0) {
        parseAddress(field, data);
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE CITY";
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("MAP ")) field = field.substring(4).trim();
      data.strMap = append(data.strMap, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  private static final Pattern CITY_PTN = 
      Pattern.compile("(?:COLUMBIA FALLS|KALISPELL|WHITEFISH|BIGFORK|CORAM|EVERGREEN|HUNGRY HORSE|LAKESIDE|MARTIN CITY|NIARADA|OLNEY|SOMERS|POLEBRIDGE|WEST GLACIER)$", Pattern.CASE_INSENSITIVE);
}
