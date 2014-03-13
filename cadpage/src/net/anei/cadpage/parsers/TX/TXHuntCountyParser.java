package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

public class TXHuntCountyParser extends DispatchProQAParser {
    
  public TXHuntCountyParser() {
    super(CITY_LIST, "HUNT COUNTY", "TX",
          "( FIRE_SERVICE PRI CALL | ) ADDR ( EXTRA/Z CITY UNKNOWN? | CITY UNKNOWN? | EXTRA/Z UNKNOWN | EXTRA? UNKNOWN? ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "smtppagingntxcad@emsc.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    String city = MISSPELLED_CITIES.getProperty(data.strCity.toUpperCase());
    if (city != null) data.strCity = city;
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("FIRE_SERVICE")) return new SkipField("Fire Service", true);
    if (name.equals("PRI")) return new PriorityField("(\\d)-.*", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("EXTRA")) return new MyExtraField();
    if (name.equals("UNKNOWN")) return new  SkipField("<Unknown>", true);
    return super.getField(name);
  }
  
  private static final Pattern CALL_CODE_PTN = Pattern.compile("(.*) - +(\\d+-[A-Z]-\\d+)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_CODE_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strCode = match.group(2);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL CODE";
    }
  }
  
  private static final Pattern EXTRA_RESID = Pattern.compile("RESID *(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXTRA_X_PTN = Pattern.compile("(?:X|CROSS)[ -]+(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXTRA_APT_PTN = Pattern.compile("APT +([^ ]+) *(.*)|LOT .*", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXTRA_X2_PTN = Pattern.compile("(?:NORTH|SOUTH|EAST|WEST) OF .*|BETWEEN .*|CORD .*", Pattern.CASE_INSENSITIVE);
  private class MyExtraField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      return checkParse(field, data, true);
    }
    
    @Override
    public void parse(String field, Data data) {
      checkParse(field, data, false);
    }
      
    public boolean checkParse(String field, Data data, boolean optional) {
        
      if (field.equals("<Unknown>") || field.equals("NO CROSS STREET") ||
          field.equals("NO X STREET") || field.equals("NO X GIVEN") ||
          field.equalsIgnoreCase("X")) return true;
      
      boolean status = !optional;
      Matcher match = EXTRA_RESID.matcher(field);
      if (match.matches()) {
        status = true;
        field = match.group(1);
      }
      
      match = EXTRA_X_PTN.matcher(field);
      if (match.matches()) {
        data.strCross = match.group(1);
        return true;
      }
      
      match = EXTRA_X2_PTN.matcher(field);
      if (match.matches()) {
        data.strCross = field;
        return true;
      }
      
      if (checkAddress(field) > 0) {
        data.strCross = field;
        return true;
      }
      
      match = EXTRA_APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = match.group(1);
        if (data.strApt != null) {
          status = true;
          field = match.group(2);
        } else {
          data.strApt = field;
          return true;
        }
      }
      
      if (!status) return false;
      
      data.strPlace = field;
      return true;
    }

    @Override
    public String getFieldNames() {
      return "X APT PLACE";
    }
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CADDO MILLS",
    "CAMPBELL",
    "CASH",
    "CELESTE",
    "COMMERCE",
    "FLOYD",
    "GREENVILLE",
    "HAWK COVE",
    "LONE OAK",
    "MERIT",
    "NEYLANDVILLE",
    "QUILAN",  // typo
    "QUINLAN",
    "ROYCE CITY",  // Typo
    "ROYSE CITY",
    "TAWAKONI",
    "UNION VALLEY",
    "WEST TAWAKONI",
    "WOLFE CITY",
    
    // Kaufman County
    "TERRELL",
    
    // Van Zandt County
    "WILLS POINT",
    "WILLIS POINT"  // typo
  };
  
  private static final Properties MISSPELLED_CITIES = buildCodeTable(new String[]{
      "QUILAN",        "QUINLAN",
      "ROYCE CITY",    "ROYSE CITY",
      "WILLIS POINT",  "WILLS POINT"
  });
}
