package net.anei.cadpage.parsers.MI;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MIMuskegonCountyParser extends DispatchOSSIParser {
  
  public MIMuskegonCountyParser() {
    super(CITY_CODES, "MUSKEGON COUNTY", "MI",
           "( FYI STRUCTFIRE? | CALL ) ( ADDR/S! | PLACE ADDR/S! ) CITY? X? X? CITY? CALL? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@mcd911.net,9300";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "Unknown";
    return true;
  }
  
  private class MyCallField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strCall.length() > 0) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private static final Pattern CITY_PTN = Pattern.compile("[A-Z]{4}");
  private class MyCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!CITY_PTN.matcher(field).matches()) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("STRUCTFIRE")) return new CallField("STRUCTURE FIRE");
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "EGTW",   "EGELSTON TWP",
      "MCTW",   "MUSKEGON CHARTER TWP",
      "MUCT",   "MUSKEGON",
      "NSCT",   "NORTON SHORES",
      "RPCT",   "ROOSEVELT PARK"
  });
}
