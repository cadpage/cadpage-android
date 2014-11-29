package net.anei.cadpage.parsers.TX;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Missouri City, TX
 */
public class TXMissouriCityParser extends DispatchOSSIParser {
  public TXMissouriCityParser() {
    super("MISSOURI CITY", "TX",
        "FYI? APT? ADDR ( X/Z X/Z CALL! MAP? | X/Z CALL! MAP? | CALL! MAP? | X/Z X/Z CALL/Z MAP! | X/Z CALL/Z MAP! | CALL/Z MAP! | X+? CALL MAP? ) INFO+");
  }
  
  public String getFilter() {
    return "CAD@missouricitytx.gov";
  }
 
  @Override
  protected Field getField(String name) {
    if (name.equals("APT")) return new AptField("APT +(.*)", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("MAP")) return new MapField("[A-Z]\\d{2}[A-Z]", true);
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!CALL_SET.contains(field)) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  @Override
  public boolean checkCall(String call) {
    return CALL_SET.contains(call);
  }

  private static Set<String> CALL_SET = new HashSet<String>(Arrays.asList(new String[]{
      "ALARM FIRE",
      "EXTINGUISHED STRUCTURE FIRE",
      "GAS ODOR INSIDE",
      "GRASS FIRE LARGE",
      "LOCK IN",
      "MAJOR ACCIDENT",
      "MEDICAL CALL",
      "MUTUAL AID MISC LOCATION",
      "ROLLOVER,TRAP,AUTO-PED,EJECT",
      "ROLL,TRAP,AUTO-PED,EJECT COUN",
      "SERVICE CALL ASSIST",
      "STRUCTURE FIRE",
      "TRASH FIRE",
      "UNDETERMINED TYPE CALL",
      "UNKNOWN MAJOR MINOR ACCIDENT"
 }));
}
