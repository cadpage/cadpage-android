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
           "ID?: EMPTY? CALL ADDR! CITY! ID? X? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pittgov.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_DIRO;
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
  
  @Override
  public String adjustMapAddress(String addr) {
    return US_PTN.matcher(addr).replaceAll("US");
  }
  private static final Pattern US_PTN = Pattern.compile("\\bU S\\b", Pattern.CASE_INSENSITIVE);

  private static final Properties CITY_CODES= buildCodeTable(new String[]{
      "BLA","Blairs",
      "CAL","Callands",
      "CAS","Cascade",
      "CHA","Chatham",
      "DAN","Danville",
      "DRY","Dry Fork",
      "GRE","Gretna",
      "HUR","Hurt",
      "JAV","Java",
      "KEE","Keeling",
      "LON","Long Island",
      "PIT","Pittsville",
      "RIN","Ringgold",
      "RNC","RNC",
      "RNG","Ringgold",
      "SAN","Sandy Level",
      "SUT","Sutherlin",
      
      // Henry County
      "AXT","Axton",
      
      "FRA","Franklin County"

  });
}
