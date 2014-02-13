
package net.anei.cadpage.parsers.AZ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Mesa, AZ (Maricopa County)
 */

public class AZMaricopaCountyParser extends FieldProgramParser {

  public AZMaricopaCountyParser() {
    super(CITY_CODES, "MARICOPA COUNTY", "AZ",
           "( Location:ADDR/S! EVENT:ID! TYPE_CODE:CODE! TIME:TIME! CALLER_NAME:NAME! CALLER_ADDR:SKIP! | " +
           "DATETIME Event_num:ID! Event_type:CODE! Location:ADDR/S! Units:UNIT! EMPTY INFO ) Comments:INFO SPECIAL_ADDRESS_COMMENT:INFO? Grid:MAP Plat:MAP Block:BLOCK INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad.admin@mesaaz.gov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    String[] flds = body.split("\n");
    if (flds.length >= 5) {
      return parseFields(flds, data);
    } else {
      return super.parseMsg(body, data);
    }
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("BLOCK")) return new MyBlockField();
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String extra = p.getLastOptional(": @");
      String apt = p.getLastOptional(',');
      super.parse(p.get(), data);
      
      if (apt.equals("INT")) {
        StringBuilder sb = new StringBuilder();
        for (String road : extra.split("/")) {
          road = road.trim();
          if (!data.strAddress.contains(road)) {
            if (sb.length() > 0) sb.append(" & ");
            sb.append(road);
          }
        }
        data.strCross = sb.toString();
      }
      
      else {
        data.strApt = apt;
        data.strPlace = extra;
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT PLACE X";
    }
  }
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d+?(2N1M|[A-Z]+\\d*)");
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      data.strCode = field;
      Matcher match = CODE_PTN.matcher(field);
      if (match.matches()) field = match.group(1);
      data.strCall = convertCodes(field, CALL_CODES);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }

  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private static final Pattern BLOCK_PTN = Pattern.compile("(?:(\\d+ [NSEW])|N/A)\\b(?: +(.*))?");
  private class MyBlockField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = BLOCK_PTN.matcher(field);
      if (match.matches()) {
        data.strMap = append(data.strMap, "-", getOptGroup(match.group(1)));
        field = getOptGroup(match.group(2));
      }
      super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }

  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "2N1M",       "MAJOR MEDICAL INCIDENT",
      "AAID",       "AUTOMATIC AID",
      "AIRMED",     "INBOUND FLIGHT EMERGENCY",
      "ALLCALL",    "ENCODE ALL MRDC STATIONS",
      "ALT1",       "AIRCRAFT STANDBY REQUEST",
      "ALT2",       "AIRCRAFT TROUBLE INDICATION",
      "ALT3",       "AIRCRAFT DOWN",
      "ALT3D",      "ALT3 DRILL",
      "AZMA",       "ARIZONA MUTUAL AID",
      "BEES",       "BEE SWARM",
      "BRUSH",      "WILDLAND FIRE",
      "CARF",       "CAR FIRE",
      "CHAPLAIN",   "CHAPLAIN REQ",
      "CODE",       "NONBREATHER",
      "DROWN",      "DROWNING",
      "FIELD",      "FIELD FIRE",
      "HAZ",        "MINOR HAZ INCIDENT",
      "HAZMED",     "HAZARDOUS INCIDENT WITH VICTIMS",
      "HZMAT",      "MAJOR HAZARDOUS MATERIALS INCIDENT",
      "LABOR",      "CHILDBIRTH",
      "LR",         "LIGHT RAIL INCIDENT",
      "MAID",       "MUTUAL AID REQUEST",
      "MAIDCT",     "MUTUAL AID REQUEST COUNTRY THUNDER",
      "MED",        "MEDICAL INCIDENT",
      "MED2",       "MEDICAL INCIDENT CODE 2 RESPONSE",
      "MEDRET",     "MED RETRIEVAL ACTIVATION",
      "MOVEUP",     "DEPLOYMENT COVER ASSIGNMENT",
      "NBCT",       "NUKE/BIO/CHEM/TERROR",
      "SERVICE",    "SERVICE CALL",
      "SNAKE",      "SNAKE REMOVAL",
      "SPEC",       "SPECIAL DUTY",
      "SPEC2",      "SPECIAL DUTY CODE 2 RESPONSE",
      "SPECG",      "SPECIAL DUTY GAS LINE BREAK",
      "STROKE",     "STROKE",
      "STRU",       "STRUCTURE FIRE",
      "TASER",      "PERSON TASED BY PD",
      "TLOOPS",     "TLO OPS",
      "TRASH",      "TRASH FIRE",
      "TRT",        "TECHNICIAL RESCUE",
      "VARMINT",    "VARMINT REMOVAL/RELOCATION",
      "WORK",       "WORKING FIRE",
      "ZMED",       "ZULU MED",
      "ZMED2",      "ZULU MED2"
  }); 
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
  "SCOT", "SCOTTSDALE",
  "SNLK", "SUN LAKES",
  "APJU", "APACHE JUNCTION",
  "CHAN", "CHANDLER",
  "GILB", "GILBERT",
  "MARI", "MARICOPA",
  "MESA", "MESA",
  "PINA", "PINAL",
  "QNCR", "QUEEN CREEK",
  "TEMP", "TEMPE"
  });
}
