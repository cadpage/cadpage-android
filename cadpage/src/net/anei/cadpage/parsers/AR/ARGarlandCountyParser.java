package net.anei.cadpage.parsers.AR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;


public class ARGarlandCountyParser extends DispatchProQAParser {
  
  public ARGarlandCountyParser() {
    super(CITY_LIST, "GARLAND COUNTY", "AR",
           "PRI ADDR! APT? ( PLACE CITY/Z ZIP | CITY/Z ZIP | ( PLACE CITY | CITY | ) CALL1! CALL2+? ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@lifenetems.org";
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " CALL";
  }

  @Override
  public Field getField(String name) {
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("ZIP")) return new SkipField("[0-9]{5}", true);
    if (name.equals("CALL1")) return new MyCall1Field();
    if (name.equals("CALL2")) return new MyCall2Field();
    return super.getField(name);
  }
  
  private static final Pattern PRIORITY_PTN = Pattern.compile("(\\d)-(.*)");
  private class MyPriorityField extends PriorityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PRIORITY_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strPriority = match.group(1);
      
      // Call field is overridden by a later field in newer calls.  But
      // we copy it here just in case this is an older call
      data.strCall = match.group(2).trim();
    }
  }
  
  private class MyAptField extends AptField {
    public MyAptField() {
      setPattern(Pattern.compile("(?:LOT|APT)? *.{1,4}", Pattern.CASE_INSENSITIVE), true);
    }
  }
  
  private class MyCall1Field extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = field;
    }
  }
  
  private class MyCall2Field extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("You are responding")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "/", field);
    }
  }
  
  private static final String[] CITY_LIST = new String[]{
    "HOT SPRINGS",
    "MOUNTAIN PINE",
    "FOUNTAIN LAKE",
    "JESSIEVILLE",
    "LONSDALE",
    "HOT SPRINGS",
    "LAKE HAMILTON",
    "PEARCY",
    "PINEY",
    "ROCKWELL",
    "ROYAL",
    "HALE TWP",
    "HOT SPRINGS TWP",
    "LAKE HAMILTON TWP",
    "WHITTINGTON TWP",
    
    // Hot springs county
    "BONNERDALE"
  };
}
