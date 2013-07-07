package net.anei.cadpage.parsers.WV;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * NOTES: In general this dispatcher uses a '-' as a field delimiter as well
 * as labels.  However, there were a couple of cases where a field is blank,
 * in which case it does not have a '-' before the next field, so I decided to 
 * process by the field names and remove excess dashes.  
 */
public class WVBooneCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("\\[([0-9]-[0-9]{1,2})\\]-- - Nature");
  private static final Pattern MISSING_DELIM_PTN = Pattern.compile("(?<! -) (Comments:)");
  
  public WVBooneCountyParser() {
    super(CITY_LIST, "BOONE COUNTY", "WV",
           "Nature:CALL! CALL+ Location:ADDR/S! Comments:INFO INFO+");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@boonewv.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
  
    // Check to see which type of subject heading we have.
    Matcher subjectUnit = SUBJECT_PTN.matcher(subject);
    
    // If the subject heading looks like "[1-13]-- - Nature", add to body with a :
    if(subjectUnit.find()) {
      data.strUnit = subjectUnit.group(1).trim();
      if (body.startsWith("donotreply:")) body = body.substring(11).trim(); 
      body = "Nature: " + body;
    }
    // Otherwise our subject contains the unit only
    else {
      data.strUnit = subject;
      if (!body.startsWith("-- - ")) return false;
      body = body.substring(5).trim();
    }
    
    // One sample has "Loca" instead of "Location:"
    body = body.replace("Loca ", "Location: ");
    
    // Occasional missing delimiter before Comment:
    body = MISSING_DELIM_PTN.matcher(body).replaceAll(" - $1");
    
    return super.parseFields(body.split(" - "), data);
  }
  
  @Override 
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  
  private class MyCallField extends CallField {
    @Override 
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  
  private static final Pattern STREET_NUM_PTN = Pattern.compile("([0-9]{1,5}).0+\\b");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      // Remove the 0's found after the '.' in the address
      field = STREET_NUM_PTN.matcher(field).replaceAll("$1");
      field = field.replace("Suite:APT", "APT");
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapCity(String city) {
    return convertCodes(city, MAP_CITIES);
  }
  
  private static final String[] CITY_LIST = {
    
    // Incorporated Cities
    "DANVILLE",
    "MADISON",
    "SYLVESTER",
    "WHITESVILLE",
    
    // Unincorporated towns and cities - Many of which Google cannot find!
    "ANDREW",
    "ASHFORD",
    "BALD KNOB",
    "BANDYTOWN",
    "BARRETT",
    "BIGSON",
    "BIM",
    "BLOOMINGROSE",
    "BLUE PENNANT",
    "BOB WHITE",
    "BRADLEY",
    "BRUSHTON",
    "CAMEO",
    "CAZY",
    "CLINTON",
    "CLOTHIER",
    "COMFORT",
    "COOPERTOWN",
    "DARTMONT",
    "DODSON JUNCTION",
    "DRAWDY",
    "EASLY",
    "EDEN",
    "ELK RUN JUNCTION",
    "EMMONS (PART)",
    "FOCH",
    "FOSTER",
    "FOSTER HOLLOW",
    "FOSTER HOLLOW LEFT",
    "FOSTERVILLE",
    "GARRISON",
    "GORDON",
    "GREENVIEW",
    "GRIPPE",
    "HAVANA",
    "HEWETT",
    "HOPKINS FORK",
    "JANIE",
    "JEFFREY",
    "JULIAN",
    "KEITH",
    "KIRBYTON",
    "KOHLSAAT",
    "LANTA",
    "LICK CREEK",
    "LINDYTOWN",
    "LOW GAP",
    "MANILA",
    "MARNIE",
    "MARTHATOWN",
    "MAXINE",
    "MEADOW FORK",
    "MILLTOWN",
    "MORRISVALE",
    "NELSON",
    "NELLIS",
    "ORGAS",
    "OTTAWA",
    "PEYTONA",
    "PONDCO",
    "POWELL CREEK",
    "PRENTER",
    "PRICE HILL",
    "QUINLAND",
    "RACINE",
    "RAMAGE",
    "RIDGEVIEW",
    "RUMBLE",
    "SECOAL",
    "SETH",
    "SHARLOW",
    "SOUTH MADISON",
    "TONEYS BRANCH",
    "TURTLE CREEK",
    "TWILIGHT",
    "UNEEDA",
    "VAN",
    "WASHINGTON HEIGHTS",
    "WHARTON",
    "WILLIAMS MOUNTAIN"
  };
  
  private static final Properties MAP_CITIES = buildCodeTable(new String[]{
    "DRAWDY",        "1",
    "MANILA",        "2",
    "MAXINE",        "1",
    "MEADOW FORK",   "2",
    "QUINLAND",      "2",
    "TONEYS BRANCH", "1"
  });
}
