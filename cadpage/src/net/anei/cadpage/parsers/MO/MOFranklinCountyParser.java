package net.anei.cadpage.parsers.MO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOFranklinCountyParser extends HtmlProgramParser {
  public MOFranklinCountyParser() {
    super("FRANKLIN COUNTY", "MO",
          "MARK! Workstation:SKIP! Print_Time:SKIP! User:SKIP! Location:ADDR! Response_Type:CALL! Zone_Name:MAP! Status_Name:SKIP! Status_Time:DATETIME! Handling_Unit:UNIT! Agency:SRC!");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MARK")) return new SkipField("Franklin Co Response Email Report", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} +\\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }

  private static final Pattern APT_PTN = Pattern.compile("(?:APT|LOT|RM|ROOM|SUITE) *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String apt = p.getLastOptional('#');
      
      String cross = p.getLastParenItem();
      cross = stripFieldStart(cross, "/");
      cross = stripFieldEnd(cross, "/");
      data.strCross = cross;
      
      String city = p.getLastOptional(',');
      if (city.length() == 5 && NUMERIC.matcher(city).matches()) {
        String zip = city;
        city = p.getLastOptional(',');
        if (city.length() == 0) city = zip;
      }
      data.strCity = convertCodes(city, CITY_CODES);
      
      parseAddress(p.get(), data);
      
      if (apt.length() > 0) {
        if (apt.endsWith("MM")) {
          apt = "MM " + apt.substring(0,apt.length()-2).trim();
          data.strAddress = append(data.strAddress, " ", apt);
        } else if (apt.startsWith("MM")) {
          data.strAddress = append(data.strAddress, " ", apt);
        } else if (isValidAddress(apt)) {
          data.strCross = append(data.strCross, " / ", apt);
        } else {
          Matcher match = APT_PTN.matcher(apt);
          if (match.matches()) apt = match.group(1);
          data.strApt = append(data.strApt, "-", apt);
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY X";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[] {
    "FRNKLN CNTY",  "FRANKLIN COUNTY"
  });
 }