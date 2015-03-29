package net.anei.cadpage.parsers.KS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Butler County, KS
 */
public class KSButlerCountyParser extends FieldProgramParser {

  private static final Pattern ALT_MASTER = Pattern.compile("(?:([A-Z0-9]+)  )?([A-Z0-9]+) (.*) (\\d{4}-\\d{8})");
  private static final Pattern PARENS = Pattern.compile("\\((ADDRESS|MAP PAGE|CROSS ST|NAME|RP PHONE NUMBER|NARR)\\):?");

  public KSButlerCountyParser() {
    super(CITY_LIST, "BUTLER COUNTY", "KS",
           "CALL! ADDRESS:ADDR/iS! MAP_PAGE:MAP CROSS_ST:X MAP_PAGE:MAP NAME:NAME RP_PHONE_NUMBER:PHONE NARR:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@bucoks.com,Test@bucoks.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.contains("Incident Notification")) return false;
    
    Matcher match = ALT_MASTER.matcher(body);
    if (match.matches()) {
      setFieldList("SRC UNIT ADDR APT CITY CALL ID");
      data.strSource =  getOptGroup(match.group(1));
      data.strUnit = match.group(2);
      String sAddr = match.group(3).trim();
      data.strCallId = match.group(4);
      parseAddress(StartType.START_ADDR, sAddr, data);
      data.strCall = getLeft();
      if (data.strCall.length() == 0) {
        return data.parseGeneralAlert(this, body);
      }
    }
    
    else {
      body = body.replace("(RP)", "(NAME)");
      body = PARENS.matcher(body).replaceAll(" $1:");
      if (!super.parseMsg(body, data)) {
        return data.parseGeneralAlert(this, body);
      }
    }
    
    // They use "COUNTY" as a generic city name when the alert is in
    // Butler County.  But they also put the name of a neighboring
    // count in the address for mutual aid calls.  In both cases the
    // "County" city name should go away, but in the later case it
    // should be appended back to the address.
    if (data.strCity.equalsIgnoreCase("COUNTY")) {
      if (!data.strAddress.contains(" ")) data.strAddress = append(data.strAddress, " ", data.strCity);
      data.strCity = "";
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
