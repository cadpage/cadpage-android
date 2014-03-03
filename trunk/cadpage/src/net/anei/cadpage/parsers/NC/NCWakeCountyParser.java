package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.StandardCodeTable;



public class NCWakeCountyParser extends FieldProgramParser {
  
  public NCWakeCountyParser() {
    super(CITY_CODES, "WAKE COUNTY", "NC",
           "Inc:CALL! Map:MAP! Add:ADDR! Loc:PLACE! Apt:APT! CS:X? Unt:UNIT! TG:CH! Cty:CITY! Comm:INFO INFO+");
  }
  
  @Override
  public String getFilter() {
    return "wcps@wakegov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("WCPS")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(":")) field = field.substring(0,field.length()-1).trim();
      String call = CALL_CODES.getCodeDescription(field);
      if (call != null) {
        data.strCode = field;
        field = call;
      }
      data.strCall = field;
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(",", "");
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("  +", " ");
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(",")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final CodeTable CALL_CODES = new StandardCodeTable(
                  
      "F1",         "ADDRESS CHECK",
      "F102",       "SHOOTING",
      "F25",        "SIGNAL 25",
      "F50AC",      "AIRCRAFT ACCIDENT",
      "F50BI",      "BOAT ACCIDENT/INJURIES",
      "F50BUS",     "ACCIDENT-BUS",
      "F50D",       "VEHICLE ACCIDENT/DAMAGE ONLY",
      "F50I",       "10-50/INJURIES",
      "F50IC",      "10-50/INJURIES COUNTY ONLY",
      "F50IP",      "10-50/INJURIES/PINNED",
      "F50MC",      "10-50/INJURIES/MOTORCYCLE",
      "F50OD",      "10-50/OVERTURNED/DAMAGE",
      "F50OI",      "10-50/OVERTURNED/INJURIES",
      "F50OP",      "10-50/OVERTURNED/PINNED/INJURIES",
      "F50P",       "10-50/PEDESTRIAN STRUCK",
      "F50TI",      "10-50/TRAIN/INJURIES",
      "F57OD",      "10-57/OVERTURNED/DAMAGE",
      "FALM2",      "RFD SECOND ALARM",
      "FALM3",      "RFD THIRD ALARM",
      "FALM4",      "RFD FOURTH ALARM",
      "FALM5",      "RFD FIFTH ALARM",
      "FAME",       "MEDICAL ALARM - FIRE",
      "FAR",        "ALLERGIC REACTION",
      "FASLT",      "ASSAULT",
      "FBD",        "RESPIRATORY DISTRESS",
      "FBURNS",     "SUBJECT BURNED",
      "FC7",        "DECEASED PERSON",
      "FCAD",       "CAD DOWN/TEST",
      "FCHOKE",     "SUBJECT CHOKING",
      "FCIF",       "CHECK IN WITH FIRE",
      "FCODE",      "CODE BLUE",
      "FCVA",       "CVA/STROKE",
      "FDIAB",      "DIABETIC CRISIS",
      "FDROWN",     "DROWNING",
      "FEXPOS",     "EXPOSURE HEAT/COLD",
      "FHE",        "HAZARDOUS EXPOSURE",
      "FHEART",     "CARDIAC",
      "FHEMS",      "HEMORRHAGE SERIOUS",
      "FIPO",       "INJURED PERSON - OTHER",
      "FIPS",       "INJURED PERSON SERIOUS",
      "FMED",       "MEDICAL NATURE UNKNOWN",
      "FMESS",      "MESSAGE ONLY",
      "FNOTI",      "NOTIFICATION ONLY",
      "FOBF",       "OBSTETRICS",
      "FOD",        "OVERDOSE",
      "FPOIS",      "POISONING",
      "FPSYC",      "PSYCHIATRIC",
      "FRDU1",      "FIRST ALARM - RDU",
      "FRDU2",      "SECOND ALARM - RDU",
      "FRDU3",      "THIRD ALARM - RDU",
      "FRDU4",      "FOURTH ALARM - RDU",
      "FSEIZ",      "SEIZURE",
      "FSHOCK",     "ELECTROCUTION",
      "SFICKF",     "SICK CALL FIRST RESPONDER",
      "FSTAB",      "STABBING",
      "FTEST",      "TEST",
      "FUNCON",     "UNCONSCIOUS/FAINTING",
      "FWALK",      "WALK IN",
      "FWF",        "WORKING FIRE",
      "FWHF",       "WORKING HIGH RISE FIRE",
      "FWHF2",      "HIGH RISE FIRE 2ND ALARM",
      "FWHF3",      "HIGH RISE FIRE 3RD ALARM",
      "FWHF4",      "HIGH RISE FIRE 4TH ALARM",
      "FWHF5",      "HIGH RISE FIRE 5TH ALARM"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AN",     "ANGIER",
      "WCAN",   "ANGIER",
      "AP",     "APEX",
      "WCAP",   "APEX",
      "CA",     "CARY",
      "WCCA",   "CARY",
      "WCCL",   "CLAYTON",
      "WCCR",   "CREEDMOOR",
      "WCDU",   "DURHAM",
      "FV",     "FUQUAY-VARINA",
      "WCFV",   "FUQUAY-VARINA",
      "GR",     "GARNER",
      "WCGR",   "GARNER",
      "HS",     "HOLLY SPRINGS",
      "WCHS",   "HOLLY SPRINGS",
      "KD",     "KNIGHTDALE",
      "WCKD",   "KNIGHTDALE",
      "MV",     "MORRISVILLE",
      "WCMV",   "MORRISVILLE",
      "WCNH",   "NEW HILL",
      "RA",     "RALEIGH",
      "WCRA",   "WAKE COUNTY", // "RALEIGH",
      "RDU",    "RDU",
      "RO",     "ROLESVILLE",
      "WCRO",   "ROLESVILLE",
      "WF",     "WAKE FOREST",
      "WCWF",   "WAKE FOREST",
      "WD",     "WENDELL",
      "WCWD",   "WENDELL",
      "WCWS",   "WILLOW SPRINGS",
      "WCYV",   "YOUNGSVILLE",
      "ZB",     "ZEBULON",
      "WCZB",   "ZEBULON"
  });
}
