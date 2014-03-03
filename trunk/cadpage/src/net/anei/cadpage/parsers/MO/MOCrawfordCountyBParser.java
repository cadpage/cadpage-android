package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MOCrawfordCountyBParser extends FieldProgramParser {
 
  public MOCrawfordCountyBParser() {
    super(CITY_LIST, "CRAWFORD COUNTY", "MO",
      "Location:ADDR/S! Category:CALL! Note:INFO+");
  }
  
  @Override
  public String getProgram() {
    return append(super.getProgram(), " ", "ID PLACE");
  }
  
  @Override
  public String getFilter() {
    return "CRAWFORDCO@PUBLICSAFETYSOFTWARE.NET";
  }
  
  private static final Pattern INCIDENT_PATTERN
    = Pattern.compile("Incident Number\\:(.*?)\\n(.*)", Pattern.DOTALL);
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    // I guess these are RUN REPORTs
    Matcher m = INCIDENT_PATTERN.matcher(body);
    if (m.matches()) {
      data.strCall = "RUN REPORT";
      data.strCallId = m.group(1);
      data.strPlace = m.group(2);
      return true;
    }
    
    // North Crawford County Ambulance Dist. has "CALL" for subject
    if (subject.equals("CALL"))
      body = fixBody(body);
    if (parseFields(body.split("\n"), data)) {
      if (data.strCity.equalsIgnoreCase("INDIAN HILLS")) {
        data.strPlace = append(data.strPlace, " - ", "INDIAN HILLS");
        data.strCity = "CUBA";
      }
      else if (data.strCity.equalsIgnoreCase("STEELVILE")) data.strCity = "STEELVILLE";
      return true;
    }
    return false;
  }
  
  private static final Pattern CCAD_BODY_PATTERN
    = Pattern.compile("Location(.*?)\\:(.*?)Category\\:(.*)", Pattern.DOTALL);
  private String fixBody(String body) {
    Matcher m = CCAD_BODY_PATTERN.matcher(body);
    if (m.matches())
      return "Location: "+m.group(1)+"Category: "+m.group(2)+"Note: "+m.group(3);
    return body;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO"))
      return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " ", field);
    }
  }
  
  private static final String[] CITY_LIST = {
      "BENTON",
      "BERRYMAN",
      "BOONE",
      "BOURBON",
      "CHERRYVILLE",
      "COOK STATION",
      "COURTOIS",
      "CUBA",
      "DAVISVILLE",
      "DILLARD",
      "FANNING",
      "HUZZAH",
      "INDIAN HILLS",
      "KNOBVIEW",
      "LEASBURG",
      "LIBERTY",
      "MERAMEC",
      "OAK HILL",
      "OSAGE",
      "OWENSVILLE",
      "ST. CLOUD",
      "ST CLOUD",
      "SAINT CLOUD",
      "STEELVILE",    // Mispelled
      "STEELVILLE",
      "SULLIVAN",
      "UNION",
      "WESCO",
      "WEST SULLIVAN",
      "W SULLIVAN",
      "W. SULLIVAN"
  };
}