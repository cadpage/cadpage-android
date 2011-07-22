package net.anei.cadpage.parsers.OH;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Shelby County, OH
Contact: "Sgt Michael Wick" <mike.wick@shelbycountysheriff.com>
Sender: cad@shelbycountysheriff.com
System: CivicaCMI, Inc

11-005105|28 - DRO|CAR CRASHED INTO WATER@11 WATER ST
11-008684|11:09:00|:28 - SF|MICROWAVE ON FIRE @ 301 ELIZABETH ST RUSSIA BETW FIRST ST & CUL DE SAC|PHLIPOT
11-008838|05:35:00|:28 - MIS|UKNOWN TYPE FIRE ON EAST SIDE OF ROAD NORTH OF CARDO NEAR LOY RD @ 8000-B SR 66 FT LORAMIE BETW LOY RD & BASINBURG RD|
11-009441|21:37:00|:29 - EMS|ELDERLY FEMALE FALL VICTIM  NO INJURY NEEDS HELP  GETTING UP @ 7533 HOYING RD ANNA BETW WRIGHT PUTHOFF RD & THAMAN RD|PLAS
11-009690|05:32:00|:58 - EMS|SHOT HIMSELF IN THE HEAD, HE IS GONE @ 18590 SR 29 NEW KNOXVILLE BETW BOTKINS RD & WIERWILLE RD|
11-009558|23:34:00|:29 - EMS|FEMALE WITH AN ALLERGIC REACTION @ 202 S VANDEMARK RD SIDNEY BETW SHAWNEE DR & APACHE DR|SAUNDERS

 */


public class OHShelbyCountyParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[]{
    "SIDNEY",
    "ANNA",
    "BOTKINS",
    "FT LORAMIE",
    "JACKSON CENTER",
    "KETTLERSVILLE",
    "LOCKINGTON",
    "PORT JEFFERSON",
    "RUSSIA",
    "CLINTON TWP",
    "CYNTHIAN TWP",
    "DINSMORE TWP",
    "FRANKLIN TWP",
    "GREEN TWP",
    "JACKSON TWP",
    "LORAMIE TWP",
    "MCLEAN TWP",
    "ORANGE TWP",
    "PERRY TWP",
    "SALEM TWP",
    "TURTLE CREEK TWP",
    "VAN BUREN TWP",
    "WASHINGTON TWP",
    "NEWPORT",
    "HOUSTON",
    "KIRKWOOD",
    "MAPLEWOOD",
    "MCCARTYVILLE",
    "MONTRA",
    "MOUNT JEFFERSON",
    "PEMBERTON",
    "ST PATRICK",
    "SWANDERS",
    "TAWAWA",
    "NEW KNOXVILLE"
  };
  
  public OHShelbyCountyParser() {
    super(CITY_LIST, "SHELBY COUNTY", "OH",
           "ID TIME? CALL ADDR/S NAME");
  }
  
  @Override
  public String getFilter() {
    return "cad@shelbycountysheriff.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\\|"), data);
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d\\d-\\d{6}"), true);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d:\\d\\d"));
    }
  }
  
  private class MyCallField extends CallField {
    
    public MyCallField() {
      setPattern(Pattern.compile(":?\\d\\d - [A-Z]+"), true);
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(":")) field = field.substring(1);
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strSupp = p.getOptional('@');
      if (data.strSupp.length() == 0) abort();
      super.parse(p.get(" BETW "), data);
      data.strCross = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "INFO " + super.getFieldNames() + " X";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
