package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

public class TXHuntCountyParser extends DispatchProQAParser {
    
  public TXHuntCountyParser() {
    super(CITY_LIST, "HUNT COUNTY", "TX",
          "( FIRE_SERVICE PRI CALL | ) ADDR EXTRA? CITY UNKNOWN? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "smtppagingntxcad@emsc.net";
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
  private static final Pattern EXTRA_X_PTN = Pattern.compile("X[ -]+(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXTRA_APT_PTN = Pattern.compile("APT +([^ ]+) *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyExtraField extends Field {

    @Override
    public void parse(String field, Data data) {
      
      if (field.equals("<Unknown>") || field.equals("NO CROSS STREET")) return;
      
      Matcher match = EXTRA_RESID.matcher(field);
      if (match.matches()) field = match.group(1);
      
      match = EXTRA_X_PTN.matcher(field);
      if (match.matches()) {
        data.strCross = match.group(1);
        return;
      }
      
      match = EXTRA_APT_PTN.matcher(field);
      
      data.strPlace = field;
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
    "QUINLAN",
    "ROYSE CITY",
    "UNION VALLEY",
    "WEST TAWAKONI",
    "WOLFE CITY",
    
    // Kaufman County
    "TERRELL",
    
  };
}
