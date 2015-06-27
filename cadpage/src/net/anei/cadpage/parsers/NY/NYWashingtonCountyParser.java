package net.anei.cadpage.parsers.NY;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA56Parser;

public class NYWashingtonCountyParser extends DispatchA56Parser {

  public NYWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "NY");
  }
  
  @Override public String getFilter() {
    return "DISPATCH@co.washington.ny.us";
  }

  private static final Pattern SUBJECT_PTN = Pattern.compile("\\[\\w+\\] +([A-Z]+)");
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    
    if (!super.parseMsg(body, data)) return false;
    String oldUnit = data.strUnit;
    data.strUnit = "";
    Set<String> unitSet = new HashSet<String>();
    for (String unit : oldUnit.split(",")) {
      unit = unit.trim().toUpperCase();
      int pt = unit.lastIndexOf(' ');
      if (pt > 0 && "DISPATCH".startsWith(unit.substring(pt+1))) {
        unit = unit.substring(0,pt).trim();
      }
      unit = unit.replace(' ', '_');
      if (unitSet.add(unit)) data.strUnit = append(data.strUnit, ",", unit);
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
}
