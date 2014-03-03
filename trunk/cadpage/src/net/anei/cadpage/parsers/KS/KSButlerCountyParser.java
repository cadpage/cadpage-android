package net.anei.cadpage.parsers.KS;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Butler County, KS
 */
public class KSButlerCountyParser extends FieldProgramParser {
  
  private static final String DEF_CITY = "BUTLER COUNTY";
  private static final String DEF_STATE = "KS";
  
  private static final Pattern PARENS = Pattern.compile("\\(([A-Z ]+)\\):");

  public KSButlerCountyParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE,
           "CALL! ADDRESS:ADDR/iS! MAP_PAGE:MAP CROSS_ST:X MAP_PAGE:MAP RP:NAME RP_PHONE_NUMBER:PHONE NARR:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@bucoks.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.contains("Incident Notification")) return false;
    body = PARENS.matcher(body).replaceAll(" $1:");
    body = body.replace(" (RP PHONE NUMBER) ", " RP PHONE NUMBER: "); 
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("COUNTY")) data.strCity = "";
    return true;
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      DispatchProQAParser.parseProQAData(false, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "COUNTY",
    
    "ANDOVER", 
    "AUGUSTA", 
    "BEAUMONT", 
    "BENTON", 
    "BOIS D'ARC", 
    "BRAINERD", 
    "CASSODAY",
    "CHELSEA", 
    "DEGRAFF",
    "DOUGLASS", 
    "EL DORADO", 
    "ELBING", 
    "GORDON", 
    "HAVERFILL", 
    "HOPKINS", 
    "KEIGHLEY", 
    "LATHAM", 
    "LEON", 
    "LORENA", 
    "PONTIAC", 
    "POTWIN", 
    "PROSPECT", 
    "PROVIDENCE", 
    "ROSALIA", 
    "ROSE HILL", 
    "SALTER", 
    "SMILEYBERG", 
    "TOWANDA", 
    "VANORA",
    "WHITEWATER" 
  };
}
