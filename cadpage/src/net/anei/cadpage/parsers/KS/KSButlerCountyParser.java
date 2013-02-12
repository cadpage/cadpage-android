package net.anei.cadpage.parsers.KS;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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
  
  private static final String[] PROQA_TERMS = new String[]{
    "ProQA Medical Dispatch Message Sent; ",
    "ProQA Dispatch Message Sent; ",
    "ProQA Medical Key Questions have been completed; "
  };
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      for (String term : PROQA_TERMS) {
        field = field.replace(term, "");
        if (term.startsWith(field)) return;
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "COUNTY",
    
    "EL DORADO", "ANDOVER", "AUGUSTA", "ROSE HILL", "DOUGLASS", "TOWANDA", 
    "BENTON", "LEON", "WHITEWATER", "POTWIN", "ELBING", "LATHAM", "CASSODAY",
    "BEAUMONT", "BOIS D'ARC", "BRAINERD", "CHELSEA", "DEGRAFF","GORDON", 
    "HAVERFILL", "HOPKINS", "KEIGHLEY", "LORENA", "PONTIAC", "PROSPECT", 
    "PROVIDENCE", "ROSALIA", "SALTER", "SMILEYBERG", "VANORA"
  };
}
