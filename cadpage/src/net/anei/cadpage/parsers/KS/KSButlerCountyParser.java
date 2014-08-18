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
    return "dispatch@bucoks.com,Test@bucoks.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.contains("Incident Notification")) return false;
    body = PARENS.matcher(body).replaceAll(" $1:");
    body = body.replace(" (RP PHONE NUMBER) ", " RP PHONE NUMBER: "); 
    if (super.parseMsg(body, data)) {
      
      // They use "COUNTY" as a generic city name when the alert is in
      // Butler County.  But they also put the name of a neighboring
      // count in the address for mutual aid calls.  In both cases the
      // "County" city name should go away, but in the later case it
      // should be appended back to the address.
      if (data.strCity.equalsIgnoreCase("COUNTY")) {
        if (!data.strAddress.contains(" ")) data.strAddress = append(data.strAddress, " ", data.strCity);
        data.strCity = "";
      }
    } else {
      data.parseGeneralAlert(this, body);
    }
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
