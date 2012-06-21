package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/***
Louisa County, VA
Contact: Lisa Burruss <medic725@gmail.com>
Contact: "Jason Slater" <jaiebo@yahoo.com>
Contact: george hill <glhill1964@gmail.com>
Sender: 911@louisa.org,CADEMS4@louisa.org

(Incident Notification) Call#: -1994 ; EMS-Extremity Injury ; 118 FREESTYLE LN ; ; Box 407 ; Info:  DOG ON SITE...  Closed APCO Case: -1994  APCO Narrative: Is the p
(Incident Notification) Call#: -2165 ; EMS-Chest Pain/Cardiac Problem ; 16247 JONES FARM RD ; ; Box 509 ; Info:  EMD/PAS  NO DRUGS USED  NOT FAINTED - HE IS WEAK AND
(Incident Notification) Call#: -2121 ; MVC-Injury ; 2752 BUMPASS RD ; ; Box 306 ; Info:  MEDIC2 CONTACT SPOTSY FOR CLOSER UNIT  CALLING SPOTSYLVANIA FOR ANOTHER EMS
(Incident Notification) Call#: -1994 ; EMS-Extremity Injury ; 118 FREESTYLE LN ; ; Box 407 ; Info:  DOG ON SITE...  Closed APCO Case: -1994  APCO Narrative: Is the p
(Incident Notification) Call#: -1991 ; MVC-Injury ; JEFFERSON HWY ; ; Box 501 ; Info:  SPOKE TO VSP DISPATCH -- RESCUE NEEDED -- NO DEPUTY  CALLER WAS A PASSERBY WHO
(Incident Notification) Call#: -1979 ; EMS-Chest Pain/Cardiac Problem ; 3411 HOLLY GROVE DR ; ; Box 405 ; Info:  Opened APCO Case: -1979  E911 Info - Class of Servic
(Incident Notification) Call#: -1763 ; F-Alarm-Residential ; 7265 CROSS COUNTY RD ; ; Box 407 ; Info:  KEYPAD FIRE ALARM GAIL COOLEY TRIED TO CALL WENT TO  VM
(Incident Notification) Call#: -1668 ; EMS-Pregnancy/Childbirth ; 298 WINDYKNIGHT RD CTOR ; ; Box 509 ; Info:  HAS NO IDEA IF SHE FEELS LIKE SHE WANTS TO PUSH  23 YO
(Incident Notification) Call#: -1542 ; EMS-Seizure ; 342 SHELTON HILL RD ; ; Box 501 ; Info:  E911 Info - Class of Service: WPH2 Special Response Info: (540) 511-701
(Incident Notification) Call#: -2095 ; EMS-Seizure ; 172 DAVIS HWY ; DOLLAR GENERAL - MINERAL; Box 201 ; Info:  GREY VAN  3YOM SIEZING
Subject:Incident Notification\nCall#: -3239 ; EMS-Trauma with Injury ; 17383 JEFFERSON HWY ; ; Box 509 ; Info: \r
(Incident Notification) Call#: -1991 ; MVC-Injury ; JEFFERSON HWY ; ; Box 501 ; Info:  SPOKE TO VSP DISPATCH -- RESCUE NEEDED -- NO DEPUTY  CALLER WAS A PASSERBY WHO
(Incident Notification) Call#: -3951 ; EMS-Chest Pain/Cardiac Problem ; 1503 BETHANY CHURCH RD ; ; ; Info:  NO HX OF HEART PROBLEMS  NO RECENT INJURY OR TRAUMA  AWAK
(Incident Notification) Explosion ; 1219 JACKSON RD ; ; Box 512 ; Info:  NO SMOKES  FROM HER HOUSE ON THE RIGHT HAND SIDE//SEES RED SPARKLES  UNABLE TO UNDERSTAN

Contact: Bradley Melson <tvfrchief@gmail.com>
Sender: Dispatch@louisa.org
 1 of 4\nFRM:Dispatch@louisa.org\nSUBJ:Incident Notification\nMSG:MVC-No Injuries ; 3329 S SPOTSWOOD TRL ; ; Box 605 ; Info:  3329 S SPOTSWOOD TRL,\n(Con't) 2 of 4\nMVC--1 CAR, NO SMOKE OR FLAMES, OVERTURNED, UNK EJECTION, 1 PERSON STILL IN VEH, OTHER IS OUT, EXPLORER, 540-223-6700  HER SON CALLED AND\n(Con't) 3 of 4\nSTATED THEY ARE NOT INJURED//MARIE MCCADE--5409670983  IS IN A YARD, NOT IN THE ROADWAY  CALLER DID NOT STOP AND CHECK - OTHER PEOPLE ARE\n(Con't) 4 of 4\nTHERE  ABOUT HALF MILE NORTH  LT TAN SUV  VEH ON IT'S SIDE (End)
 1 of 2\nFRM:Dispatch@louisa.org\nSUBJ:Incident Notification\nMSG:EMS-Abdominal Pain ; 1055 PEACH GROVE RD ; ; Box 601 ; Info:  63YOM COMP OF\n(Con't) 2 of 2\nABDOMINAL PAINS  E911 Info - Class of Service: RESD Special Response Info: FRM 669 TK RGHT ON 613 TO LF (End)

***/

public class VALouisaCountyParser extends FieldProgramParser {

  
  public VALouisaCountyParser() {
    super(CITY_CODES, "LOUISA COUNTY", "VA",
           "ID? CALL! ADDR/S! PLACE BOX! Info:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "911@louisa.org,Dispatch@louisa.org,CADEMS4@louisa.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Incident Notification")) return false;
    int pt = body.indexOf(" Closed APCO Case:");
    if (pt < 0) pt = body.indexOf(" Opened APCO Case:");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(body.split(";"), data);
  }
  
  // ID field, confirm has correct form
  private static final Pattern CALL_ID_PTN = Pattern.compile("Call#: *-(\\d+)");
  private class MyIdField extends IdField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = CALL_ID_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCallId = match.group(1);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (!field.startsWith("Box ")) abort();
      field = field.substring(4).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CTOR", ""
  });
}
