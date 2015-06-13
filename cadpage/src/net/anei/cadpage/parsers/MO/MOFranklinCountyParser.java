package net.anei.cadpage.parsers.MO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOFranklinCountyParser extends HtmlProgramParser {
  public MOFranklinCountyParser() {
    super("FRANKLIN COUNTY", "MO",
          "MARK! Workstation:SKIP! Print_Time:SKIP! User:SKIP! Location:ADDR! Response_Type:CALL! Zone_Name:MAP! Status_Name:SKIP! Status_Time:DATETIME! Handling_Unit:UNIT! Agency:SRC! NOTES+");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MARK")) return new SkipField("Franklin Co Response Email Report", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} +\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("NOTES")) return new MyNotesField();
    return super.getField(name);
  }

  
  private static final Pattern TRAIL_APT_PTN = Pattern.compile("#([^\\(\\)#]*)$");
  private static final Pattern TRAIL_CROSS_PTN = Pattern.compile("\\(([^\\(\\)]*?)\\)$");
  private static final Pattern ZIP_PTN = Pattern.compile("\\d{5}");
  private static final Pattern STATE_PTN = Pattern.compile("[A-Z]{2}");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|LOT|RM|ROOM|SUITE) *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String apt = "";
      String cross = "";
      Matcher match = TRAIL_APT_PTN.matcher(field);
      if (match.find()) {
        apt = match.group(1).trim();
        field = field.substring(0,match.start()).trim();
      }
      match = TRAIL_CROSS_PTN.matcher(field);
      if (match.find()) {
        cross = match.group(1).trim();
        field = field.substring(0,match.start()).trim();
      }
      String addr = field;
      
      if (addr.startsWith("@")) {
        data.strPlace = addr;
        addr = cross;
        cross = "";
      }
      
      cross = stripFieldStart(cross, "/");
      cross = stripFieldEnd(cross, "/");
      data.strCross = cross;
      
      String city = null;
      String zip = null;
      for (String part : addr.split("/")) {
        part = part.trim();
        boolean first = true;
        for (String seg : part.split(",")) {
          seg = seg.trim();
          if (first) {
            data.strAddress = append(data.strAddress, " & ", seg);
            first = false;
          } 
          else if (STATE_PTN.matcher(seg).matches()) {
            data.strState = seg;
          }
          else if (ZIP_PTN.matcher(seg).matches()) {
            zip = seg;
          } else {
            city = seg;
          }
        }
      }
      
      if (city != null) {
        data.strCity = convertCodes(city, CITY_CODES);
      } else if (zip != null) {
        data.strCity = zip;
      }
      
      if (apt.length() > 0) {
        if (apt.endsWith("MM")) {
          apt = "MM " + apt.substring(0,apt.length()-2).trim();
          data.strAddress = append(data.strAddress, " ", apt);
        } else if (apt.startsWith("MM")) {
          data.strAddress = append(data.strAddress, " ", apt);
        } else if (isValidAddress(apt)) {
          data.strCross = append(data.strCross, " / ", apt);
        } else {
          match = APT_PTN.matcher(apt);
          if (match.matches()) apt = match.group(1);
          data.strApt = append(data.strApt, "-", apt);
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY ST X APT";
    }
  }
  
  private static final Pattern NOTES_PTN = Pattern.compile("Notes: *(?:\\[\\d+\\] *)?(.*)");
  private class MyNotesField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = NOTES_PTN.matcher(field);
      if (!match.matches()) return;
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[] {
    "FRNKLN CNTY",  "FRANKLIN COUNTY"
  });
 }