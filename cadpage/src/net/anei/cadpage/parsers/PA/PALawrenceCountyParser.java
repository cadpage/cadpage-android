package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class PALawrenceCountyParser extends DispatchB2Parser {
  
  private static final Pattern CALL_ADDR_PTN = Pattern.compile("(.* (?:ALPHA|BRAVO|CHARLIE?|DELTA)) +(.*)", Pattern.CASE_INSENSITIVE);
  
  public PALawrenceCountyParser() {
    super("911-CENTER:",CITY_LIST, "LAWRENCE COUNTY", "PA");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MWORD_STREET_LIST);
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@leoc.net,test@leoc.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BOR")) data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    return true;
  }

  @Override
  protected Pattern getCallPattern() {
    return CALL_ADDR_PTN;
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "BEAGLE CLUB",
    "BIG RUN CREEK",
    "BREAKNECK BRIDGE",
    "CASTLE MERCER",
    "CENTER CHURCH",
    "COCHRAN HILL",
    "COUNTY LINE",
    "COVERED BRIDGE",
    "EASTBROOK HARLANSBURG",
    "EASTBROOK NESHANNOCK FALLS",
    "EASTBROOK VOLANT",
    "FAIRVIEW SCHOOL",
    "FAYETTE NESHANNOCK FALLS",
    "FREW MILL",
    "GARDNER CENTER",
    "GEORGE WASHINGTON",
    "GOLF COURSE",
    "GRANGE HALL",
    "GREEN ACRES",
    "GREEN MEADOWS",
    "HARMONY BAPTIST",
    "HICKORY HILL",
    "J J WHEELSHOP",
    "KITTERY RIDGE",
    "LAKEWOOD GARDENS",
    "LAKEWOOD NESHANNOCK FALLS",
    "LEESBURG GROVE CITY",
    "LEESBURG VOLANT",
    "MCCONNELLS MILL",
    "MERCER NEW WILMINGTON",
    "MOHAWK SCHOOL",
    "MOORES CORNER",
    "MOUNT AIR",
    "MOUNT HERMAN CHURCH",
    "PIN OAK",
    "PINE SPRING",
    "PLAIN GROVE",
    "PLAIN GROVE N LIBERTY",
    "POLLOCK STORE",
    "POTTER RUN",
    "RABBIT HAVEN",
    "ROCK SPRINGS",
    "ROSE POINT HARLANSBURG",
    "SAVANNAH GARDNER",
    "SPRING HILL",
    "SPRING VALLEY",
    "TALL MAPLES",
    "THE BOULEVARD",
    "WEST DRIVE"
    
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL PAINS CHARLIE",
      "ALLERGIES/ENVENOMATIONS ALPHA",
      "ALLERGIES/ENVENOMATIONS BRAVO",
      "ALLERGIES/ENVENOMATIONS CHARLI",
      "ALLERGIES/ENVENOMATIONS DELTA",
      "ALLERGIES/ENVENOMATIONS ECHO",
      "AREA CHECK",
      "ASSIST",
      "BACK PAIN CHARLIE",
      "BACK PAIN DELTA",
      "BREATHING PROBLEMS ALPHA",
      "BREATHING PROBLEMS BRAVO",
      "BREATHING PROBLEMS CHARLIE",
      "BREATHING PROBLEMS DELTA",
      "BREATHING PROBLEMS ECHO",
      "BRUSH/RUBBISH FIRE",
      "CARBON MONOXIDE CALL",
      "CARDIAC ARREST/DEATH ALPHA",
      "CARDIAC ARREST/DEATH BRAVO",
      "CARDIAC ARREST/DEATH CHARLIE",
      "CARDIAC ARREST/DEATH DELTA",
      "CARDIAC ARREST/DEATH ECHO",
      "CHEST PAIN CHARLIE",
      "CHEST PAIN DELTA",
      "CHIMNEY FIRE",
      "CONVULSIONS/SEIZURES ALPHA",
      "CONVULSIONS/SEIZURES BETA",
      "CONVULSIONS/SEIZURES CHARLIE",
      "CONVULSIONS/SEIZURES DELTA",
      "CONVULSIONS/SEIZURES ECHO",
      "DIABETIC PROBLEMS ALPHA",
      "DIABETIC PROBLEMS BETA",
      "DIABETIC PROBLEMS CHARLIE",
      "DIABETIC PROBLEMS DELTA",
      "DIABETIC PROBLEMS ECHO",
      "DISTURBANCE/FIGHT",
      "FALLS ALPHA",
      "FALLS BRAVO",
      "FALLS CHARLIE",
      "FALLS DELTA",
      "FALLS ECHO",
      "FIRE ALARM-COMMERCIAL",
      "FIRE ALARM - INSTITUTIONAL",
      "FIRE ALARM MULTI FAMILY",
      "FIRE ALARM-RESIDENTIAL",
      "HEADACHE ALPHA",
      "HEADACHE BRAVO",
      "HEADACHE CHARLIE",
      "HEADACHE DELTA",
      "HEADACHE ECHO",
      "HEART PROBLEMS/AICD ALPHA",
      "HEART PROBLEMS/AICD BETA",
      "HEART PROBLEMS/AICD CHARLIE",
      "HEART PROBLEMS/AICD DELTA",
      "HEART PROBLEMS/AICD ECHO",
      "HEMORRHAGE/LACERATIONS ALPHA",
      "HEMORRHAGE/LACERATIONS BRAVO",
      "HEMORRHAGE/LACERATIONS CHARLIE",
      "HEMORRHAGE/LACERATIONS DELTA",
      "HEMORRHAGE/LACERATIONS ECHO",
      "MEDICAL ALARM ACTIVATION",
      "MEDICAL CALL",
      "MISSING PERSON",
      "MOTOR VEHICLE ACCIDENT >1 INJ",
      "MOTOR VEHICLE ACCIDENT INJ",
      "MOTOR VEHICLE ACCIDENT NEED FD",
      "MOTOR VEHICLE ACCIDENT NO INJ",
      "MOTOR VEHICLE ACCIDENT UNK INJ",
      "MUTUAL AID FIRE RESPONSE",
      "NATURAL GAS ODOR/LEAK",
      "OD/POISONING (INGESTION) ALPHA",
      "OD/POISONING (INGESTION) BRAVO",
      "OD/POISONING (INGESTION) CHARL",
      "OD/POISONING (INGESTION) DELTA",
      "OD/POISONING (INGESTION) ECHO",
      "PREGNANCY/CHILDBIRTH DELTA",
      "PSYC/ABN BEHAV/SUICIDE ALPHA",
      "PSYC/ABN BEHAV/SUICIDE BRAVO",
      "PSYC/ABN BEHAV/SUICIDE CHARLIE",
      "PSYC/ABN BEHAV/SUICIDE DELTA",
      "PSYC/ABN BEHAV/SUICIDE ECHO",
      "REFER TO OUTSIDE AGENCY",
      "SEARCH AND RESCUE",
      "SERVICE CALL",
      "SICK PERSON CHARLIE",
      "SICK PERSON DELTA",
      "SMOKE INV NO FIRE - INSIDE STR",
      "SMOKE INV NO FIRE - OUTSIDE",
      "STAB/GS/PENE TRAUMA ALPHA",
      "STAB/GS/PENE TRAUMA BRAVO",
      "STAB/GS/PENE TRAUMA CHARLIE",
      "STAB/GS/PENE TRAUMA DELTA",
      "STAB/GS/PENE TRAUMA ECHO",
      "STROKE (CVA) CHARLIE",
      "STRUCTURE FIRE-BARN/GARAGE/OTH",
      "STRUCTURE FIRE-COMMERCIAL",
      "STRUCTURE FIRE-MULTIFAMILY",
      "STRUCTURE FIRE-RESIDENTAL",
      "TRAUMATIC INJURIES ALPHA",
      "TRAUMATIC INJURIES BRAVO",
      "TRAUMATIC INJURIES CHARLIE",
      "TRAUMATIC INJURIES DELTA",
      "TRAUMATIC INJURIES ECHO",
      "TREE DOWN",
      "UNCONSCIOUS/FAINTING ALPHA",
      "UNCONSCIOUS/FAINTING BRAVO",
      "UNCONSCIOUS/FAINTING CHARLIE",
      "UNCONSCIOUS/FAINTING DELTA",
      "UNCONSCIOUS/FAINTING ECHO",
      "UNKNOWN TYPE FIRE",
      "UNKNOWN PROB (MAN DOWN) ALPHA",
      "UNKNOWN PROB (MAN DOWN) BRAVO",
      "UNKNOWN PROB (MAN DOWN) CHARLI",
      "UNKNOWN PROB (MAN DOWN) DELTA",
      "UNKNOWN PROB (MAN DOWN) ECHO",
      "VEHICLE FIRE",
      "WIRES/TRANSFORMER DOWN FIRE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    
        // Cities
        "NEW CASTLE",
        
        //  Boroughs
        "BESSEMER BOR",
        "ELLPORT BOR",
        "ELLWOOD CITY BOR",
        "ENON VALLEY BOR",
        "NEW BEAVER BOR",
        "NEW WILMINGTON BOR",
        "SNPJ BOR",
        "SOUTH NEW CASTLE BOR",
        "VOLANT BOR",
        "WAMPUM BOR",
        
        //  Townships
        "HICKORY TWP",
        "LITTLE BEAVER TWP",
        "MAHONING TWP",
        "NESHANNOCK TWP",
        "NORTH BEAVER TWP",
        "PERRY TWP",
        "PLAIN GROVE TWP",
        "PULASKI TWP",
        "SCOTT TWP",
        "SHENANGO TWP",
        "SLIPPERY ROCK TWP",
        "TAYLOR TWP",
        "UNION TWP",
        "WASHINGTON TWP",
        "WAYNE TWP",
        "WILMINGTON TWP",
        
        // Butler County
        "WORTH TWP",
        
        // Mercer County
        "SPRINGFIELD",
        "SPRINGFIELD TWP"
   };
}
