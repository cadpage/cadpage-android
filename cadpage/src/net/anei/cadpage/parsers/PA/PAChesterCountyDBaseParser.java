package net.anei.cadpage.parsers.PA;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/*
 * Base class for Chest County, PA (D variants)
 * Mostly this provides the address parsing and city lookup logic that is common
 * to all D variants
 */ 


public class PAChesterCountyDBaseParser extends FieldProgramParser {

  private static final Pattern ADDR_PTN = Pattern.compile("(.*),(\\d\\d)");
  
  public PAChesterCountyDBaseParser(String program) {
    super("CHESTER COUNTY", "PA", program);
  }

  public boolean parseChesterAddress(String field, Data data) {
    Matcher match = ADDR_PTN.matcher(field);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    
    int ndx = Integer.parseInt(match.group(2));
    if (ndx < CITY_LIST.length) data.strCity = CITY_LIST[ndx];
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    /* 00 */ "",
    /* 01 */ "WEST CHESTER",
    /* 02 */ "MALVERN",
    /* 03 */ "KENNETT SQUARE",
    /* 04 */ "AVONDALE",
    /* 05 */ "WEST GROVE",
    /* 06 */ "OXFORD",
    /* 07 */ "ATGLEN",
    /* 08 */ "PARKESBURG",
    /* 09 */ "SOUTH COATESVILLE",
    /* 10 */ "",
    /* 11 */ "DOWNINGTOWN",
    /* 12 */ "HONEY BROOK",
    /* 13 */ "",
    /* 14 */ "SPRING CITY",
    /* 15 */ "PHOENIXVILLE",
    /* 16 */ "COATESVILLE CITY",
    /* 17 */ "NORTH COVENTRY TWP",
    /* 18 */ "EAST COVENTRY TWP",
    /* 19 */ "",
    /* 20 */ "POTTSTOWN",
    /* 21 */ "EAST VINCENT TWP",
    /* 22 */ "",
    /* 23 */ "",
    /* 24 */ "",
    /* 25 */ "WEST VINCENT TWP",
    /* 26 */ "EAST PIKELAND TWP",
    /* 27 */ "SCHUYLKILL TWP",
    /* 28 */ "WEST CALN TWP",
    /* 29 */ "WEST BRANDYWINE TWP",
    /* 30 */ "",                // BRANDYWINE REGIONAL POLICE
    /* 31 */ "",
    /* 32 */ "UPPER UWCHLAN TWP",
    /* 33 */ "UWCHLAN TWP",
    /* 34 */ "WEST PIKELAND TWP",
    /* 35 */ "",
    /* 36 */ "WEST SADSBURY TWP",
    /* 37 */ "SADSBURY TWP",
    /* 38 */ "VALLEY TWP",
    /* 39 */ "CALN TWP",
    /* 40 */ "",
    /* 41 */ "WEST WHITELAND TWP",
    /* 42 */ "EAST WHITELAND TWP",
    /* 43 */ "TREDYFFRIN TWP",
    /* 44 */ "WEST FALLOWFIELD TWP",
    /* 45 */ "HIGHLAND TWP",
    /* 46 */ "",
    /* 47 */ "EAST FALLOWFIELD TWP",
    /* 48 */ "",
    /* 49 */ "",
    /* 50 */ "",
    /* 51 */ "",
    /* 52 */ "WEST GOSHEN TWP ",
    /* 53 */ "",
    /* 54 */ "WILLISTOWN TWP",
    /* 55 */ "EASTTOWN TWP",
    /* 56 */ "",
    /* 57 */ "",
    /* 58 */ "",
    /* 59 */ "",
    /* 60 */ "NEW GARDEN TWP",
    /* 61 */ "EAST MARLBOROUGH TWP",
    /* 62 */ "KENNETT TWP",
    /* 63 */ "",
    /* 64 */ "",
    /* 65 */ "BIRMINGHAM TWP",
    /* 66 */ "",
    /* 67 */ "WESTTOWN-EAST GOSHEN REGIONAL PD",
    /* 68 */ "WEST NOTTINGHAM TWP",
    /* 69 */ "",
    /* 70 */ "",
    /* 71 */ "",
    /* 72 */ "",
    /* 73 */ "",
    /* 74 */ "",
    /* 75 */ "WEST CHESTER",    // WEST CHESTER UNIVERSITY PD 
    /* 76 */ "OXFORD",          // LINCOLN UNIVERSITY 
    /* 77 */ "COATESVILLE",     // COATESVILLE VA MEDICAL CENTER POLICE
    /* 78 */ "WEST CHESTER",    // WEST CHESTER AREA SCHOOL DISTRICT SECURITY
    /* 79 */ "COATESVILLE",     // COATESVILLE AREA SCHOOL DISTRICT POLICE
    /* 80 */ "",
    /* 81 */ "",                // PENNSYLVANIA FISH AND BOAT COMMISSION
    /* 82 */ "DOWNINGTON",      // MARSH CREEK STATE PARK RANGERS
    /* 83 */ "POTTSDOWN",       // WARWICK COUNTY PARK
    /* 84 */ "COATESVILLE",     // HIBERNIA COUNTY PARK
    /* 85 */ "NOTTINGHAM",      // NOTTINGHAM COUNTY PARK
    /* 86 */ "GLENMOORE"        // SPRINGTON MANOR COUNTY PARK
  };
} 
