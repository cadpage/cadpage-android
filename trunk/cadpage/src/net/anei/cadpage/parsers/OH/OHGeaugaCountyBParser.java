package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHGeaugaCountyBParser extends FieldProgramParser {
 
  public OHGeaugaCountyBParser() {
    super("GEAUGA COUNTY", "OH",
          "SRC! Addr:ADDR! Type:CALL!");
  }
  
  @Override
  public String getFilter() {
    return "OH_GC_ENS@CO.GEAUGA.OH.US";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Alert Notification")) return false;
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{4}");
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_APT_PTN = Pattern.compile("(?:Apt|Rm|Room|Lot|Suite) *(.*)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {

      String apt = "";
      while (true) {
        int pt = field.lastIndexOf(';');
        if (pt < 0) break;
        String tmp = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (data.strCity.length() == 0) {
          String city = cleanCityName(tmp);
          if (city != null) {
            data.strCity = city;
            continue;
          }
        }
        Matcher match = ADDR_APT_PTN.matcher(tmp);
        if (match.matches()) {
          apt = append(match.group(1), "-", apt);
          continue;
        }
        data.strPlace = append(tmp, "-", data.strPlace);
      }
      super.parse(field, data);
      data.strApt = append(data.strApt, "-", apt);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE APT CITY";
    }
  }

  private String cleanCityName(String city) {
    
    // Clean up extraneous prefixs and suffixs
    city = stripFieldStart(city, "City of ");
    city = stripFieldStart(city, "City Of ");
    city = stripFieldEnd(city, " #1");
    city = stripFieldEnd(city, " #2");
    city = stripFieldEnd(city, " Village");
    
    // Now comes the hard part. 
    // Checking to see if this is a truncated city that needs
    // to be expanded.
    String result = null;
    for (String tCity : CITY_LIST) {
      if (city.equals(tCity)) return city;
      if (tCity.startsWith(city)) {
        if (result == null) {
          result = tCity;
        } else {
          if (!tCity.equals(result + " Twp")) {
            result = "";
            break;
          }
        }
      }
    }
    
    return result;
  }
  
  private static final String[] CITY_LIST = new String[]{
    // Cities
    "Aquilla",
    "Burton",
    "Chardon",
    "Hunting Valley",
    "Middlefield",
    "South Russell",

    // Townships
    "Auburn Twp",
    "Bainbridge Twp",
    "Burton Twp",
    "Chardon Twp",
    "Chester Twp",
    "Claridon Twp",
    "Hambden Twp",
    "Huntsburg Twp",
    "Middlefield Twp",
    "Montville Twp",
    "Munson Twp",
    "Newbury Twp",
    "Parkman Twp",
    "Russell Twp",
    "Thompson Twp",
    "Troy Twp",

    // Census-designated places
    "Bainbridge",
    "Chesterland",

    // Other localities
    "East Claridon",
    "Materials Park",
    "Montville",
    "Parkman",
    "Novelty",
    "Welshfield"
  };
}
