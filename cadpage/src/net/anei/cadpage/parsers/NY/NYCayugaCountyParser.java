package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class NYCayugaCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("  +");
  
  public NYCayugaCountyParser() {
    super(CITY_LIST, "CAYUGA COUNTY", "NY",
          "ADDR_PFX+? ADDR/iSC INFO/N+? UNIT DATETIME!");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BAPTIST HILL",
        "BUCK POINT",
        "BURTIS POINT",
        "CENTER STREET",
        "CHERRY STREET",
        "CHESTNUT RIDGE",
        "COUNTY HOUSE",
        "COUNTY LINE",
        "FRANKLIN STREET",
        "GENESEE STREET",
        "GRANT AVENUE",
        "JOHN SMITH",
        "MUTTON HILL",
        "PINE RIDGE",
        "SAND BEACH",
        "SUNSET BEACH",
        "TOWN HALL",
        "TWELVE CORNERS",
        "WEEDSPORT SENNETT",
        "WEST LAKE",
        "WHITE BIRCH"
    );
  }
  
  @Override
  public String getFilter() {
    return "911cad@cayugacounty.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("From 911 Center")) return false;
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR_PFX")) return new MyAddressPrefixField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  // Directions in the street address tend to be followed by an extraneous 
  // double blank which splits the address into multiple fields that we have to
  // merge back together
  private static final Pattern TRAIL_DIR_PTN = Pattern.compile(".* [NSEW]");
  private class MyAddressPrefixField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    public boolean checkParse(String field, Data data) {
      if (!TRAIL_DIR_PTN.matcher(field).matches()) return false;
      data.strAddress = append(data.strAddress, " ", field);
      return true;
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = append(data.strAddress, " ", field);
      data.strAddress = "";
      super.parse(field, data);
      data.strCity = convertCodes(data.strCity, MISTYPED_CITIES);
    }
  }
  
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("E911 Info - .*|.* Uncertainity:|Confidence:.*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (INFO_JUNK_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ALARM - CO",
      "ALARM - FIRE",
      "ALARM - MEDICAL",
      "ASSIST BY EMS",
      "ASSIST BY FIRE",
      "BLEEDING",
      "CARDIAC",
      "CHOKING",
      "CITIZEN ASSIST - FIRE",
      "DIFFICULTY BREATHING/SOB",
      "DOA",
      "FAINTING",
      "GAS LEAK",
      "GENERAL ILLNESS",
      "HAZARD - FIRE",
      "INJURY FROM A FALL",
      "MEDICAL EMERGENCY",
      "MVAPI",
      "OUTSIDE FIRE",
      "OVERDOSE",
      "PAIN - GENERAL",
      "PERSONAL INJURY",
      "SEIZURES",
      "SERVICE CALL",
      "STROKE",
      "STRUCTURE FIRE",
      "SUICIDE",
      "UNCONSCIOUS PERSON",
      "VEHICLE FIRE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "AUBURN",
    "AURELIUS", 
    "CAYUGA",
    "BRUTUS", 
    "WEEDSPORT",
    "CATO", 
    "MERIDIAN",
    "CONQUEST", 
    "FLEMING",
    "GENOA",
    "IRA",
    "LEDYARD", 
    "AURORA",
    "LOCKE",
    "MENTZ", 
    "PORT BYRON",
    "MONTEZUMA",
    "MORAVIA", 
    "MORAVIL",              // Typo
    "NILES", 
    "OWASCO",
    "SCIPIO",
    "SEMPRONIUS",
    "SENNETT",
    "SPRINGPORT", 
    "UNION SPRINGS",
    "STERLING", 
    "FAIR HAVEN",
    "SUMMERHILL",
    "THROOP",
    "VENICE",
    "VICTORY",
    
    "ONONDAGA COUNTY",
    "SKANEATELES",
    "SKANEATELES ONONDAGA COUNTY",
    
    "WAYNE COUNTY"
  };
  
  private static Properties MISTYPED_CITIES = buildCodeTable(new String[]{
      "MORAVIL",      "MORAVIA"
  });
}
	