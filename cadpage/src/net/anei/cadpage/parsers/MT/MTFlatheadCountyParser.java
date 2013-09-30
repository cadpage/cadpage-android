package net.anei.cadpage.parsers.MT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MTFlatheadCountyParser extends FieldProgramParser {

  private static final Pattern MASTER = 
      Pattern.compile("(?:([A-Z0-9_ ]+?) +)?" +
          "(Airport|KFD|Creston FD|Evergreen FD|Olney FD|South Kalispell  +FD|Somers FD|Whitefish ?FD)" +
          " *(.*_GPIA|.*?_KIDC|.*? Hydrant (?:Commer|Residential)|.*?(?:_Residential|_Commercial|_Res)\\)|\\(South\\))" +
          " +(.*?) +(\\d{4}-\\d{8})");
  
  private static final Pattern MISSED_BLANK_PTN = Pattern.compile("(?<! )(?=Call Type:)");
  
  private static final String CITY_PTN_LIST = "(BIGFORK|CORAM|COLUMBIA FALLS|EVERGREEN|GPIA|HUNGRY HORSE|KALISPELL|LAKESIDE|MARTIN CITY|NIARADA|OLNEY|POLEBRIDGE|SOMERS|WEST GLACIER|WHITEFISH)";
  private static final Pattern CITY_SPACE_PTN = Pattern.compile("(.*)" + CITY_PTN_LIST + " +(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern CITY_END_PTN = Pattern.compile(CITY_PTN_LIST + "$", Pattern.CASE_INSENSITIVE);
  private static final Pattern DIR_SUFFIX_PTN = Pattern.compile("^[EW][NS]\\b");
  private static final Pattern APT_PTN = Pattern.compile("[A-Z]\\d*", Pattern.CASE_INSENSITIVE);

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
    
    // Several different formats :(
    // Newest formats have to use master pattern matches
    Matcher match = MASTER.matcher(body);
    if (match.matches()) {
      
      setFieldList("UNIT SRC INFO ADDR APT PLACE CITY CALL ID");
      
      data.strUnit = getOptGroup(match.group(1));
      data.strSource = match.group(2);
      data.strSupp = match.group(3);
      body = match.group(4);
      data.strCallId = match.group(5);
      
      // What is left always contains a city, but we have to use pattern  matches
      // because there usually not preceded by a separating blank
      match = CITY_SPACE_PTN.matcher(body);
      if (!match.matches()) return false;
      body = match.group(1).trim();
      data.strCity = match.group(2);
      data.strCall = match.group(3).trim();
      
      // Now we are down to an address and place/apt
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, body, data);
      String left = getLeft();
      match = DIR_SUFFIX_PTN.matcher(left);
      if (match.find()) {
        data.strAddress = append(data.strAddress, " ", match.group());
        left = left.substring(match.end()).trim();
      }
      if (data.strApt.length() == 0 && APT_PTN.matcher(left).matches()) {
        data.strApt = left;
      } else {
        data.strPlace = left;
      }
      return true;
    }
    
    // Try older field delimited format
    body = MISSED_BLANK_PTN.matcher(body).replaceAll(" ");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("U:")) field = field.substring(2).trim();
      Matcher match = CITY_END_PTN.matcher(field);
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
      Matcher match = CITY_END_PTN.matcher(field);
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
  
}
