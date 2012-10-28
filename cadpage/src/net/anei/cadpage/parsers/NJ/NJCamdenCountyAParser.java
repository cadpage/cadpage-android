package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NJCamdenCountyAParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Dispatch (.*)"); 
  private static final Pattern SUBJECT2_PTN = Pattern.compile("Free (.*)");
  private static final Pattern SUBJECT3_PTN = Pattern.compile("Sta +(.+)");
  private static final Pattern REPORT_ID_PTN = Pattern.compile("\nMI#:(\\d+) *\n");
  private static final Pattern SINGLE_LINE_BRK = Pattern.compile("(?<!\n)\n(?!\n)");
  
  public NJCamdenCountyAParser() {
    super("CAMDEN COUNTY", "NJ",
           "CALL ADDR/SXP! #:APT X:X! ZN:MAP? CP:PLACE UNIT MI:ID RES:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "cccademail@camdencounty.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) {
      data.strUnit = match.group(1).trim();
    } else {
      match = SUBJECT3_PTN.matcher(subject);
      if (match.matches()) {
        data.strSource = subject.trim();
      } else {
        match = SUBJECT2_PTN.matcher(subject);
        if (!match.matches()) return false;
        data.strCall = "RUN REPORT";
        data.strPlace = body;
        data.strUnit = match.group(1);
        match = REPORT_ID_PTN.matcher(body);
        if (match.find()) data.strCallId = match.group(1);
        return true;
      }
    }
    
    // Search and destroy code messaging double line breaks
    match = SINGLE_LINE_BRK.matcher(body);
    if (!match.find()) body = body.replace("\n\n", "\n");
    
    body = body.replace("MI#:", "MI:").replace("RES#:", "RES:");
    return parseFields(body.split("\n"), data) && data.strAddress.length() > 0;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final Pattern CITY_PTN = Pattern.compile(",(\\d\\d)(?: \\d\\d)?$");
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(';');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      Matcher match = CITY_PTN.matcher(field);
      if (match.find()) {
        Integer ndx = Integer.parseInt(match.group(1));
        if (ndx > 0 && ndx <= CITY_LIST.length) {
          data.strCity = CITY_LIST[ndx-1]; 
        }
        field = field.substring(0,match.start()).trim();
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY"; 
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d{4})-(\\d\\d)-(\\d\\d) (\\d\\d:\\d\\d:\\d\\d)$");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        data.strDate = match.group(2) + "/" + match.group(3) + "/" + match.group(1);
        data.strTime = match.group(4);
        field = field.substring(0,match.start()).trim(); 
      }
      data.strPlace = append(data.strPlace, " ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE DATE TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  // X - remove empty /
  // Place strip off date/time

  private static final String[] CITY_LIST = new String[]{
    /* 01 */ "Audubon",
    /* 02 */ "Audubon Park",
    /* 03 */ "Barrington",
    /* 04 */ "Bellmawr",
    /* 05 */ "Berlin",
    /* 06 */ "Berlin Twp",
    /* 07 */ "Brooklawn",
    /* 08 */ "Camden City",
    /* 09 */ "Chesilhurst",
    /* 10 */ "Clementon",
    /* 11 */ "Collingswood",
    /* 12 */ "Cherry Hill",
    /* 13 */ "Gibbsboro",
    /* 14 */ "Gloucester City",
    /* 15 */ "Gloucester Twp",
    /* 16 */ "Haddon Twp",
    /* 17 */ "Haddonfield",
    /* 18 */ "Haddon Heights",
    /* 19 */ "Hi-Nella",
    /* 20 */ "Laurel Springs",
    /* 21 */ "Lawnside",
    /* 22 */ "Lindenwold",
    /* 23 */ "Magnolia",
    /* 24 */ "Merchantville",
    /* 25 */ "Mount Ephraim",
    /* 26 */ "Oaklyn",
    /* 27 */ "Pennsauken Twp",
    /* 28 */ "Pine Hill",
    /* 29 */ "Pine Valley",
    /* 30 */ "Runnemede",
    /* 31 */ "Somerdale",
    /* 32 */ "Stratford",
    /* 33 */ "Tavistock",
    /* 34 */ "Voorhees Twp",
    /* 35 */ "Waterford Twp",
    /* 36 */ "Winslow Twp",
    /* 37 */ "Woodlyne"
  };

}
