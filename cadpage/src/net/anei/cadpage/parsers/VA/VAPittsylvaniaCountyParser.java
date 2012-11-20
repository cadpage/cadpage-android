package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class VAPittsylvaniaCountyParser extends DispatchOSSIParser {
 
  private static final Pattern LEADER = Pattern.compile("^\\d+:(?!CAD:)");
  public VAPittsylvaniaCountyParser() {
    super(CITY_CODES, "PITTSYLVANIA COUNTY", "VA",
           "ID: CALL ADDR! CITY! ID? X? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pittgov.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = LEADER.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.end()) + "CAD:" + body.substring(match.end());
    }
    return super.parseMsg(body, data);
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{10}"));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }

  private static final Properties CITY_CODES= buildCodeTable(new String[]{
      "BLA","Blairs",
      "DAN","Danville",
      "GRE","Gretna",
      "CHA","Chatham",
      "CAL","Callands",
      "CAS","Cascade",
      "DRY","Dry Fork",
      "HUR","Hurt",
      "JAV","Java",
      "KEE","Keeling",
      "PIT","Pittsville",
      "RIN","Ringgold",
      "SAN","Sandy Level",
      "SUT","Sutherlin",
      "LON","Long Island",
  });
}
