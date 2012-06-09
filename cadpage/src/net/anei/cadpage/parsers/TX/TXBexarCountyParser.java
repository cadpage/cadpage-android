package net.anei.cadpage.parsers.TX;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Bexar County, TX
Contact: "Dorian Davis (IT GUY)" <dorian@bexarcountyfire.org>
Contact: Adam Slater <adam@raymondmartin.com>
Sender: visinet.command@sanantonio.gov
System: Tritech
 
*** Main variant T1
Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared],
Med - Sick Person         - 17694 Shepherd Rd              - 711F7   -  31 yo female...knee pain cause by past injury pt says it's a cut[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107603,[BCLE] has closed their incident [BCSO-2012-0107603],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000122. [Shared],This incident LYTL-2012-0010282 has been sent to ACADIAN via the CAD2CAD Interface
Fire - Vehicle            Ih 10 W / Tarpon Dr            - 447A2   - engine smoking c has pulled to the side of the road...tan f350...wb on 10..doesn't seem to be leaking fluid[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF 446F.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:3511  AT&T MOBILITY-SE SECTOR-QF
Fire - Structure     - Stockport / Chipping           - 585E1 - comp states a house is on fire[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0105711,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000502. [Shared],Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000571. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000420. [Shared],Automatic Case Number(s) issued for Kirby FD: KIRB-2012-000000372. [Shared]
MVC                             W Loop 1604 S / Spurs Ranch     646B1    GVIL-2012-000001006  - crash, injuries, one car roll over.  On the access rd, sb side.[Shared],Invalid address received:61  SPRINT-N SECTOR-QF 646C4.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0107458,C is an off-duty officer with SAPD.  thinks the guy involved in crash is okay..but would like him checked out [Shared],Automatic Case Number(s)
Fire - Unauthorized Burn  9279 Aqua Dr                   - 447A3   - Unauth BUrning  to the left of location,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000283.
04/28 06:28 am - Med - Diabetic Problems   - 4455 Twin Valley            - 748E6   - C states her mother 72yo has low blood sugar..acad notifed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109820,Automatic Case Number(s) issued for Somerset FD: SOM-2012-000000292. [Shared],
MED - ASSAULT        - 7246 GLEN HILL                 - SA585 - ACADIAN: Unit:    740         9941959,ACADIAN: The cross street was verified by caller.,ACADIAN: Law enforcement on scene; it is safe for the crew to enter.,ACADIAN: assult to head unk age male,ACADIAN: [ProQA Session Aborted] Medical Professional,Transferred incident: Remote   Reference Number: 20120428-ZN16-0222 by Jacobs, Angela From ACADIAN,Interface has sent an ack message for CAM-2012-0010500 to the
Med - Unconscious Pe - 7838 Sun Forest                -       - 585C1   - 24 yo female went over to comps resd to visit his son; comp states female started drinking some wine and passed out; comp states she is breathing ; does not know what to do with female[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109700,This incident WIND-2012-0010491 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120428-ZN16-0059 [Shared],Unit - 76
Med - Sick Person    - 8216 Glen Boro                 - 553F8 - 50 YO F HAVING CHEST PAINS[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0109833,[BCLE] has closed their incident [BCSO-2012-0109833],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000521. [Shared],
Fire                            6126 Kimble Mill                577D3    GVIL-2012-000001031  - C thinks the grease fire in his pit is getting out of hand.  in his backyard[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110061,C has turned off burners [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001031. [Shared],
* BCFA Medical Emergency  - Ih 35 S Nb / Sb Ih 35 S Onrp S - 712A5   - unk where other fighters went[Shared],they have been drinking[Shared],no weapons[Shared],C says at los amigos there was a fight, three people are on the ground, req ems[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110791,Automatic Case Number(s) issued for Jarret FD: JARR-2012-000000207. [Shared],
Med - Possible Stroke           12446 Modena Bay                577D6    GVIL-2012-000001047  - 66 yom- poss stroke- acad advised[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110913,This incident GVIL-2012-0010627 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120429-ZN16-1184 [Shared],Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001047. [Shared],
MVC                       - 23101 - 24511 Campbellton - HICKORY WAY/RANCH TRAIL RD               - 783D1 - small dark colored suv[Shared],going north on cambellton, it will be on the left[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],C disconnected[Shared],C says there is a car, unoccupied, flipped over.[Shared],Invalid address received:1453  TMOBILE-SE SECTOR-QF 751A2.[Shared],A cellular re-bid has occurre
Med - Sick Person    - 6739 Glen Fair                 - 553E7 - C says her niece had a seizure, 34 yo.  fell onto concrete[Shared],Invalid address received:343  SPRINT-E SECTOR-QF 553C8.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110931,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000525. [Shared],
Alarm - Fire         - 9503 Millers Rdg               -       - 553E7   - POE;SMOKE DETECTOR;JOHN GILG @ 653-7947[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0111024,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000599. [Shared],Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000527. [Shared],Automatic Case Number(s) issued for Converse FD: CONV-2012-000000442. [Shared],
Med - Sick Person         - 16927 Ih 35 S Sb               - 711E6   -  23 YOF POSSIBLE BROKEN FOOT/FELL DOWN[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0112109,[BCLE] has closed their incident [BCSO-2012-0112109],Automatic Case Number(s) issued for Lytle FD: LYTL-2012-000000126. [Shared],
Alarm                - 8210 Ih 35 N                  -       - 552E8   Dept-E108,C145,E145B,120A - Automatic Case Number(s) issued for Windcrest FD: WIND-2012-000000612.,Automatic Case Number(s) issued for Camelot FD: CAM-2012-000000547.,FIRE ALARM-RED LOBSTERS REST.,Backed up C145 with E145B,SINGLE STORY LIGHT SMOKE SHOWING AND SMOKE IN KITCHEN,Automatic Case Number(s) issued for Gardendale FD: GARD-2012-000000134.,
Med - Sick Person               9615 Rainbow Crk                612C5      GVIL-2012-000001138  Dept-123C - Multi-Agency BCLE Incident #: BCSO-2012-0118460,Automatic Case Number(s) issued for Geronimo Village FD: GVIL-2012-000001138. [Shared],
Med - Sick Person         - 1460 Martinez Losoya           # SRST  - 717B8 Dept-141E - 6 YO F BROKE ARM[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0118435,Automatic Case Number(s) issued for South Bexar FD: SOBX-2012-000000251. [Shared],
Alarm - Fire              - 7406 Scintilla                 - 413F8   Dept-133A,126E,SPK activated general fire alarm,borene pd called this one in,Automatic Case Number(s) issued for Leon Springs FD: LSPR-2012-000000339.,Automatic Case Number(s) issued for Grey Forest FD: GRYF-2012-000000169.,
Med - Diabetic Problems   - 14085 Ih 35 S                  - 713B2   Dept-130C 67 yof diabetic feeling light headed[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0119030,This incident JARR-2012-0011429 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120508-ZN16-0205 [Shared],Unit - 709, status change to STATUS_DISPATCHED by ACADIAN at 05/08/2012 04:33:59 [Shared],trlr 15 [Shared],[BCLE] has closed their incident [BCSO-2012-011903
Med - Cardiac Arrest            2918 FISHERS GLADE              SA612/F8   GVIL-2012-000001157  Dept-123B - ACADIAN: Unit:    734         9963763,Transferred incident: Remote   Reference Number: 20120508-ZN16-0370 by Brunson, Savannah L. From ACADIAN,Interface has sent an ack message for GVIL-2012-0011432 to the remote CAD,9963763,This incident 20120508-ZN16-0370 has been sent to BCFA via the CAD2CAD Interface.,Unit - 734, status change to STATUS_RESPONDING by ACADIAN at 05/08/2012 06:25:35,Automatic Case Number
Med - Sick Person    - 8510 WINDY CROSS               -       - SA553/C Dept-145D - ACADIAN: Unit:    735         9975423,Transferred incident: Remote   Reference Number: 20120513-ZN16-0481 by Reed, Juliana E. From ACADIAN,Interface has sent an ack message for WIND-2012-0011843 to the remote CAD,9975423,This incident 20120513-ZN16-0481 has been sent to BCFA via the CAD2CAD Interface.,ACADIAN HAS CHANGED the CALL BACK PHONE# to:,Automatic Case Number(s) issued for Windcrest FD: WIND-2012-0
Med - Heart Problems - 8835 WILLMON WAY               -       - SA552/F Dept-145A - ACADIAN: The cross street was verified by caller.,ACADIAN: Unit:    733         9975214,ACADIAN: The patient's weight is below 300 pounds.,ACADIAN: [ProQA Script] Dispatch code: 19D02  You are responding to a patient  with heart problems.  The patient is a  66-year-old female, who is    conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Heart Problems / A.I.C.D..  DIFFICULTY SPE,AKING BETWEEN

*** Variant T2
07:35 pm   10410 Stallion Bay             :Rspnd for: Med - Sick Person    - 546C6   - D7FR-2012-000000330\r

*** Variant T2
Respond For MVC                           @30000 Smithson Valley Rd                     ;      ;                              Cross- VOGEL VALLEY/FM 1863                                                            ;418D7;BBUL-2012-000000497 ;Multi-Agency BCLE Incident #: BCSO-2012-0104123,e veh roll over, injuries [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000497. [Shared]
Respond For Med - Sick Person             @25715 Fan Flower                             ;      ;                              Cross- Dead End/BEAUTYBERRY                                                            ;452B7;BBUL-2012-000000532 ;C said a woman came by her house,is now seizing, 24 yo.[Shared],Invalid address received:520  AT&T MOBILITY -SE SECTOR-QF 451.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0110748,Automatic Case Number(s) issued for Bexa

** This variant is not currently parsed, waiting to see if it pops up more than once
a structure fire \nVALLEY RIDGE MOBILE PARK \n8671 Sw Loop 410, Unit 520 \nSB SW LP 410 OFRPOP RD/OLD PEARSALL RD \n*TAC2 \nDistrict: D2 \nE36, L36, E44, E35 and BC2

********************************************************************************************************
All of the above are in the process of being phased out and may be droppped  New text page format follows

Contact: "Dorian Davis (IT GUY)" <dorian@bexarcountyfire.org>
Sender: VisiNet.Command@sanantonio.gov
Med - Sick Person              ; 21746 Thunder Basin                           ;       ; 485B5 ; BBUL-2012-000000701  Dept-104B ;  mother is Emma Gardley, 90 yo.[Shared],C says his mother is mentally unstable, possibly violent, he cannot control her.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143660,This incident BBUL-2012-0013756 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120603-ZN16-1062 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000701
MVC                            ; Us Hwy 281 N / Bulverde Rd                    ;       ; 451D6 ; BBUL-2012-000000702  Dept-103D ;  sb side gold tahoe vs blk car /female with neck pain[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143974,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000702. [Shared],unk age of female [Shared],
Med - Choking                  ; 734 Ottawa Way St                             ;       ; 451A4 ; BBUL-2012-000000699  Dept-103D ;  35 yo.[Shared],C says that her father has a bone in his throat, choking.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143557,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000699. [Shared],
MVC - OTV                      ; 21415 Battle Crk                              ;       ; 484E6 ; BBUL-2012-000000698  Dept-104A ;  C says a pickup truck crashed, behind loc.\2sunk injuries.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0143514,white pickup [Shared],the vehicle crashed into some trees, vehicle is turned over [Shared],C says he may be trapped in the vehicle, people are attempting to get him out [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000698. [Shared],
Med - Sick Person              ; 849 Pine Eagle Ln                             ;       ; 451A4 ; BBUL-2012-000000704  Dept 103D ;  female trouble breathing 64yo[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0144879,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000704. [Shared],This incident BBUL-2012-0013867 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],
Med - Fall                     ; 855 Tecumseh Dr                               ;       ; 451A3 ; BBUL-2012-000000708  Dept 103C ;  68 yo female...fall now has sever body pain...170lb[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0145684,Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000708. [Shared], 
Med - Sick Person              ; 23238 Bison Canyon                            ;Apt      ; 484B3 ; BBUL-2012-000000723  Dept 104A ;  50 yom fell; and is sweating[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0148106,acadian notified [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000723. [Shared],
Alarm - Fire                   ; 24811 Bogey Rdg                               ;Apt      ; 482F1 ; HPK-2012-000000249   Dept 103D,129E,SPK ;  Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000726.,Automatic Case Number(s) issued for Hollywood Park FD: HPK-2012-000000249.,
Med - Chest Pain               ; 24539 Glass Canyon                            ;Apt      ; 482F1 ; BBUL-2012-000000729  Dept 104B ;  41 yo male, having chest pains.[Shared],Invalid address received:1  VERIZON-SE SECTOR-QF 450E7.[Shared],A cellular re-bid has occurred, check the ANI/ALI Viewer for details[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149066,awake and responsive [Shared],This incident BBUL-2012-0014236 has been sent to ACADIAN via the CAD2CAD Interface. [Shared],Acknowledgement Received from ACADIAN 20120608-ZN16-2020
Med - Seizure                  ; 4527 Echo Grove                               ;Apt      ; 484D6 ; BBUL-2012-000000730  Dept 104E ;  29 yoa female seizure[Shared],Invalid address received:3073  AT&T MOBILITY-SW SECTOR-QF 550F.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149117,starting to come out of it [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000730. [Shared],
Alarm - Medical                ; 838 Emerald Bay                               ;Apt      ; 482F1 ; BBUL-2012-000000732  Dept 103C ;  Multi-Agency BCLE Incident #: BCSO-2012-0149257,aud/medicl/res; analisa diaz/res'; 210-648-3962 [Shared],Automatic Case Number(s) issued for Bexar Bulverde FD: BBUL-2012-000000732. [Shared],
Med - Sick Person              ; 25675 Overlook Pkwy                           ;Apt2708  ; 451C8 ; BBUL-2012-000000731  Dept 104B ;  [Premise:  25675 OVERLOOK PKWY] [Medium] [Criminal Trespass Warning] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0149230,[Premise:  25675 Overlook Pkwy] VAN, SAMUEL JONES B/M DOB:09-04-1966 REFERENCE CASE 2011-BCSO-023624,26yr old female was drinking alcohol and now has rapid heart rate, feels like her throat is closing [Shared],This

Med - Fall           - 8502 GLEN BREEZE               - 553F8 Dept-108B - ACADIAN: Unit:    731         10041536,Transferred incident: Remote   Reference Number: 20120603-ZN16-1180 by Stinson, Nathaniel T. From ACADIAN,Interface has sent an ack message for CAM-2012-0013763 to the remote CAD,10041536,This incident 20120603-ZN16-1180 has been sent to BCFA via the CAD2CAD Interface.,Unit - 731, status change to STATUS_RESPONDING by ACADIAN at 06/03/2012 23:07:18,ACADIAN HAS CHANGED
Fire-Authorized Burn      - 24440 Loma Verde          - RED GATE DR/TOPALA DR                    - 783B3  Dept-138B - unk what is burning[Shared],C says she sees smoke coming from her neighbors yard.  Unk address.[Shared],Invalid address received:220  VERIZON-E SECTOR-QF 783A4.[Shared],Multi-Agency BCLE Incident #: BCSO-2012-0142874,Automatic Case Number(s) issued for Sandy Oaks FD: SOAK-2012-000000498. [Shared],


*/

public class TXBexarCountyParser extends FieldProgramParser {
  
  private static final String MAP_PATTERN = "(?:\\d{3}[A-Z]\\d|SA\\d{3}(?:/[A-Z]\\d?)?)";
  private static final Pattern DASH_DELIM_PTN = Pattern.compile(" +- ");
  private static final Pattern PROTECT_KEYWORD = Pattern.compile("(?<=:)  +(?=[^ ])");
  private static final Pattern BLANK_DELIM_PTN = Pattern.compile(" {4,}");
  private static final Pattern SHORT_BLANK_DELIM_PTN = Pattern.compile("(?<![ -])  +(?![ -])");
  private static final Pattern MAP_BLANK_DELIM_PTN = Pattern.compile(" " + MAP_PATTERN + " +(?=[^ -])");
  
  public TXBexarCountyParser() {
    super("BEXAR COUNTY", "TX",
          "( T1 DATETIME? CALL ( ADDR/Z MAP | CALL ADDR/Z APT/Z MAP | ADDR/Z APT MAP | CALL ADDR/Z MAP ) ID? | T2 DATETIME? ADDR CALL CALL? CODE ID | T3 X MAP ID ) INFO+");
  }
  
  public String getFilter() {
    return "visinet.command@sanantonio.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // All kinds of wierd special cases
    
    // One uncommon variant uses an @ at a fixed place marking the call from the address
    if (body.length() < 43) return false;
    if (body.charAt(42) == '@') {
      data.strCall = body.substring(0,41).trim();
      body = body.substring(43).trim();
      int pt = body.indexOf("Cross-");
      if (pt < 0) return false;
      String sAddr = body.substring(0,pt).trim();
      body = body.substring(pt+6).trim();
      pt = sAddr.indexOf(';');
      if (pt >= 0) sAddr = sAddr.substring(0,pt).trim();
      parseAddress(sAddr, data);
      body = "T3;" + body;
      return parseFields(body.split(";"), data);
    }
    
    String prefix = "T1";
    int pt = body.indexOf(":Rspnd for:");
    if (pt >= 0) {
      prefix = "T2";
      body = body.substring(0,pt) + body.substring(pt+11);
    }
    
    // The main format is usually dash delimited, but occasionally drops the dashes in favor on
    // long strings of blanks, which we will turn in regular dash delimiters
    // And then, they occasionally leave a single space delimiter after the Map field
    body = DASH_DELIM_PTN.matcher(body).replaceAll(" - ");
    body = PROTECT_KEYWORD.matcher(body).replaceAll(" ");
    body = BLANK_DELIM_PTN.matcher(body).replaceAll(" - ");
    body = MAP_BLANK_DELIM_PTN.matcher(body).replaceFirst("$0- ");
    
    pt = body.lastIndexOf(" - ");
    if (pt < 0) return false;
    body = SHORT_BLANK_DELIM_PTN.matcher(body.substring(0,pt)).replaceAll(" - ") + body.substring(pt);
    
    body = prefix + " - " + body;
    return parseFields(body.split(" - "), data);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d )?(\\d\\d:\\d\\d [ap]m)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("KK:mm aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = getOptGroup(match.group(1));
      setTime(TIME_FMT, match.group(2), data);
      return true;
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("*")) field = field.substring(1).trim();
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private static final Pattern IH_PTN = Pattern.compile("\\bIh\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = IH_PTN.matcher(field).replaceAll("I");
      super.parse(field, data);
    }
  }
  
  private class MyAptField extends AptField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() > 5) return false;
      parse(field, data);
      return true;
    }
  }
  
  // Info field tries to clean up some of the more useless information
  private static final Pattern ACADIAN_PTN = Pattern.compile("(?:\\bACADIAN:|\\[ProQA Script\\]) *");
  private static final Pattern SPEC_INFO_PTN = Pattern.compile("(?<=^|,) *Unit: *([^ ]+)\\b|" +                                // Unit:
                                                                  "(?<=^|,) *Dispatch code: *([^ ]+)\\b|" +                       // Dispatch code:
                                                                  "(?:(?:^|,)[^,]*?)?\\b([A-Z]{3,4}-\\d{4}-\\d{6,})\\b[^,]*");    // Call ID
  private static final Pattern TRASH_PTN = Pattern.compile("(?:^|,) *(?:A cellular re-bid |check the ANI/ALI |Invalid address received:|Automatic Case |\\[ProQA Session Aborted\\]|Transferred incident:|Acknowledgement Received |Reference Number:|status change to |This incident [-A-Z0-9]+ has been sent to |ACADIAN HAS CHANGED )[^,]*");
  private static final Pattern TRIM_PTN = Pattern.compile("^[, \\.]+|[, \\.]+$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = ACADIAN_PTN.matcher(field).replaceAll("");
      Matcher match = SPEC_INFO_PTN.matcher(field);
      StringBuffer sb = new StringBuffer();
      while (match.find()) {
        if (match.group(1) != null) {
          data.strUnit = append(data.strUnit, " ", match.group(1));
        } else if (match.group(2) != null) {
          data.strCode = match.group(2);
        } else {
          if (data.strCallId.length() == 0) data.strCallId = match.group(3);
        }
        match.appendReplacement(sb, "");
      }
      match.appendTail(sb);
      field = sb.toString();
      field = TRASH_PTN.matcher(field).replaceAll("");
      field = field.replace("[Shared]", "");
      field = TRIM_PTN.matcher(field).replaceAll("");
      data.strSupp = append(data.strSupp, " - ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CODE ID INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.startsWith("T") && name.length()==2) return new SkipField(name, true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("MAP")) return new MapField(MAP_PATTERN, true);
    if (name.equals("ID")) return new IdField("[A-Z]{3,4}-\\d{4}-\\d{6,}");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
