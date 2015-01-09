package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;

public class MIBerrienCountyParser extends FieldProgramParser {

  public MIBerrienCountyParser() { 
    super("BERRIEN COUNTY", "MI", "Unit:UNIT? Status:DISPATCHED? Location:ADDR! Common_Name:PLACE? Call_Type:CALL! Call_Time:DATETIME! Call_Number:ID! Quadrant:MAP? District:SRC? Narrative:INFO?!" );
    setupMultiWordStreets(MULTI_WORD_STREET_LIST);
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    //check subj
    if (!subject.equals("Incident")) return false;
    if (parseMsg(body, data)) return true;
    data.parseGeneralAlert(this, body);
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DISPATCHED")) return new SkipField("Dispatched", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  //city pattern excludes city code and sector. could add logic to capture and check these if false positives arise
  private static Pattern CITY = Pattern.compile("(.*), \\d{2} (.*?)(?: - [NS]?[EW]? SECTOR)?", Pattern.CASE_INSENSITIVE);
  private static Pattern APT = Pattern.compile("([a-z](?:-?\\d+)?)(?: (.*))?");
  private static Pattern NOT_APT = Pattern.compile("\\d*(?:1ST|2ND|3RD|[04-9]TH|1[1-3]TH)");
  private static Pattern TRAIL_DIR = Pattern.compile("(.*) ([NSEW])");
  private static Pattern MID_DIR = Pattern.compile(".*[A-Z]( +)[NSEW] .*");
  private static Pattern CLEAN_ADDR_STREET_NAME = Pattern.compile("(?:\\d+ +|.*& *)?(?:[NSEW] +)?(.*?)(?: +(?:AVE|BLVD|CIR|CT|DR|HWY|LN|PATH|PL|RD|ST|TRL|WAY))?");
  private static Pattern SINGLE_BLANK = Pattern.compile("[^ ]+(?<!^M)( +)[^ ]+");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      //parse trailing CITY
      Matcher mat = CITY.matcher(field);
      if (mat.matches()) {
        field = mat.group(1).trim();
        data.strCity = mat.group(2).trim();
      }
      
      // field contained a combination of the original address, a possible apt, followed
      // by possible cross street information.  All of which gets all mixed together because
      // the street names do not always have the proper street suffix.  Sorting that all
      // out is going to take a lot of work.
      parseAddress(StartType.START_ADDR, FLAG_OPT_STREET_SFX, field, data);
      String left = getLeft();
      boolean comma = isCommaLeft();
      
      // Did I mention that cross street information might contain commma before and/or after
      // the slash?  
      
      // Coming out of the parseAddress call anything after the first comma ends up in left.  Anything
      // before that starting with the first slash goes into the cross street.
      
      // Lets see what we can do with the leftover stuff
      if (left.length() > 0) {

        // If there was a comma in front of it, replace it
        if (comma) left = ", " + left;
        
        // If we found a cross street, append the leftover stuff to that
        if (data.strCross.length() > 0) {
          if (!comma) left = " " + left;
          data.strCross = data.strCross + left;
          left = "";
        }
        
        // If no slash or comma was found, see if we can find an apt at the beginning of the leftovers
        else {
          if (!comma && data.strApt.length() == 0) {
            mat = APT.matcher(left); 
            if (mat.matches()) {
              data.strApt = mat.group(1);
              left = getOptGroup(mat.group(2));
            }
          }
          
          // If the leftover indicates that there is no cross street information
          // things get so much simpler
          if (left.equals("No Cross Streets Found")) return;
          
          // Otherwise put leftovers into cross street for now
          data.strCross = left;
        }
      }
      
      // That takes care of the leftovers.  Now all we have is the address and the 
      // apt and cross street.  Which still need some fiddling with

      // Let's look at what the parser put in the apt field.  If it does not look
      // like a a real apartment, move it to the cross street
      if (NOT_APT.matcher(data.strApt).matches()) {
        if (data.strCross.startsWith(",")) {
          data.strCross = data.strApt + data.strCross;
        } else if (data.strCross.contains("/")) {
          data.strCross = data.strApt + ' ' + data.strCross;
        } else {
          data.strCross = append(data.strApt, " / ", data.strCross);
        }
        data.strApt = "";
      }
      
      // If we have any cross street information, and the address ends with a direction
      // move the direction to the cross street
      if (data.strCross.length() > 0 && !data.strCross.startsWith(",")) {
        mat = TRAIL_DIR.matcher(data.strAddress);
        if (mat.matches()) {
          data.strAddress = mat.group(1).trim();
          data.strCross = mat.group(2) + ' ' + data.strCross;
        }
      }

      // Almost there.  But if what we have in the cross street looks incomplete, 
      if ((data.strCross.length() == 0 && !data.strAddress.contains("&")) || 
          data.strCross.startsWith(",") || 
          (data.strCross.length() > 0 && !data.strCross.contains("/"))) {
        int pt = breakAddress(data.strAddress);
        if (pt >= 0) {
          String cross = data.strAddress.substring(pt+1).trim();
          data.strAddress = data.strAddress.substring(0,pt);
          if (!data.strCross.startsWith(",")) cross += " / ";
          data.strCross =  cross + data.strCross;
        } 

        // Strict testing is only enabled during unit tests
        else if (isTestMode() && data.strCross.length() > 0) {
          if (!data.strCross.equals("milton") && !data.strCross.equals("cass") && !data.strCross.equals("BP SBN 22")) abort();
        }
      }
    }
    
    /**
     * Try to break up and address that is believed to be a combination of the real address
     * lacking a street suffix followed by a single cross street name
     * @param address combined address/cross street field
     * @return the identified end of the real address if found, -1 otherwise
     */
    private int breakAddress(String address) {
      
      // Clean off leading street number, direction, and trailing street suffix 
      Matcher mat = CLEAN_ADDR_STREET_NAME.matcher(address);
      int start = 0;
      if (mat.matches()) {
        start = mat.start(1);
        address = mat.group(1);
      }
      
      // See if there is an embedded direction in what is left
      mat = MID_DIR.matcher(address);
      if (mat.matches()) return start+mat.start(1);
      
      // See if we can use the multi-word street list to identify the break
      // This also checks to see if the entire address is on the list
      String street = FWD_MULTI_WORD_STREET_LIST.getCode(address, true);
      if (street != null) {
        if (street.length() == address.length()) return -1;
        return start+street.length();
      }
      
      // If what is left contains single blank, that is where we break things
      mat = SINGLE_BLANK.matcher(address);
      if (mat.matches()) return start+mat.start(1);
      
      // Try looking for a known multi-word list at end of address
      street = REV_MULTI_WORD_STREET_LIST.getCode(address, true);
      if (street != null) {
        int pt = address.length()-street.length()-1;
        while (address.charAt(pt-1) == ' ') pt--;
        return start+pt;
      }

      // no go
      return -1;
    }
    
    @Override public String getFieldNames() {
      return super.getFieldNames() + " X CITY";
    }
  }
  
  private static String[] MULTI_WORD_STREET_LIST = new String[]{
    "BLACK LAKE",
    "BROWN SCHOOL",
    "CAMPUS CIRCLE",
    "CLEAR LAKE",
    "COMMUNITY HALL",
    "COUNTRY KNOLL",
    "COUNTY LINE",
    "DANIEL BOONE",
    "DEANS HILL",
    "DEER PARK",
    "DIAMOND POINT",
    "EAU CLAIRE",
    "ELM VALLEY",
    "FOREST BEACH",
    "FOREST HILLS",
    "FOREST LAWN",
    "GOLDEN CREST",
    "HAGAR SHORE",
    "HARBOR COUNTRY",
    "HICKORY CREEK",
    "HIGH BRIDGE",
    "HIGH VIEW",
    "HIPPS HOLLOW",
    "INDIAN TRAIL",
    "JOHN BEERS",
    "LAKE BLUFF",
    "LAKE CHAPIN",
    "LAKE SHORE",
    "LAKE VIEW",
    "LEMON CREEK",
    "LINCOLN WOOD",
    "LITTLE PAW PAW LAKE",
    "LIVINGSTON HILLS",
    "LONG LAKE",
    "LONGMEADOW VILLAGE",
    "MARQUETTE WOODS",
    "MEDICAL PARK",
    "MT ZION",
    "NORTH BRANCH",
    "NOTRE DAME",
    "OAK LANE",
    "OLIVE BRANCH",
    "PAW PAW LAKE",
    "PAW PAW",
    "PUCKER STREET",
    "RANGE LINE",
    "RED ARROW",
    "RED BUD",
    "RIVERSIDE POINTE",
    "ROCKY WEED",
    "ROSE HILL",
    "SHAKER FARM",
    "SINGER LAKE",
    "SPRING CREEK",
    "SPRING HILL",
    "SPRING PARK",
    "ST JOSEPH RIVER",
    "ST JOSEPH VAL",
    "ST JOSEPH",
    "STATE LINE",
    "STELTER FARM",
    "THREE OAKS",
    "TOWER HILL",
    "TOWN HALL",
    "UNION PIER",
    "VALLEY VIEW",
    "WALTON E RIVERSIDE",
    "WARREN WOODS",
    "WILD DUNES"
 
  };
  
  private static CodeSet FWD_MULTI_WORD_STREET_LIST = new CodeSet(MULTI_WORD_STREET_LIST);
  private static ReverseCodeSet REV_MULTI_WORD_STREET_LIST = new ReverseCodeSet(MULTI_WORD_STREET_LIST);

}
