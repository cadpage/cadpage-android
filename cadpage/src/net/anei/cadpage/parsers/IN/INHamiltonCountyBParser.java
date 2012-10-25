package net.anei.cadpage.parsers.IN;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
 * Hamilton County, IN (variant B)
 */
public class INHamiltonCountyBParser extends DispatchOSSIParser {
 
  public INHamiltonCountyBParser() {
    super(CITY_CODES, "HAMILTON COUNTY", "IN",
           "MASH INFO+");
    setupCallList();
  }
  
  @Override
  public String getFilter() {
    return "CAD@noblesville.in.us";
  }
  
  private static final Pattern MASH_MASTER = Pattern.compile("(\\d) +([A-Z0-9,]+) +(.*?) +(?:\\(S\\) *(.*?) *\\(N\\) +)?(\\d+)");
  private class MashField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("Event spawned from");
      if (pt >= 0) field = field.substring(0,pt).trim();
      Matcher match = MASH_MASTER.matcher(field);
      if (!match.matches()) abort();
      data.strPriority = match.group(1);
      data.strUnit = match.group(2);
      String addr = match.group(3).trim();
      data.strCross = getOptGroup(match.group(4));
      data.strSource = match.group(5);
      
      parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, addr, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PRI UNIT CALL PLACE ADDR APT CITY X SRC";
    }
    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MASH")) return new MashField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "WES", "WESTFIELD"
  });
  
  private void setupCallList() {
    setupCallList(
        "BCK PAIN",
        "METNL PT",
        "RESD ALM",
        "SEIZURE"
    );
    
  }
}
