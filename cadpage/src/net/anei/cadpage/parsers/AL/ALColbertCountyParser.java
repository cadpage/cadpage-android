package net.anei.cadpage.parsers.AL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Colbert County, AL
Contact: "Michael Smith" <colbertema@gmail.com>
Sender: 911alert@comcast.net

MISSING PERSON\n 2564150099\n3804 HATCH BLVD, SHEFFIELD
SUICIDAL PERSON\n 6622123327\n105 FORREST DR, CHEROKEE\n43 YOF
BREATHING PROBLEM\nCHEROKEE FAMILY CLINIC 2563594516\n1080 2ND ST, CHEROKEE\n62 YOF
SEIZURE\n 2568566665\n8685 HIGHWAY 72, CHEROKEE\n21F
MISSING PERSON\nATKISSON, TAMARA 2564123685\n603 PASADENA AV, A, MUSCLE SHOALS  (also includes Apartment #)
MVC-Injury\n 2564125319\nWOODWARD AV && 6TH ST, MUSCLE SHOALS\n2 CARS

Contact: support@active911.com
[E911] MEETING\n \nCHEROKEE FIRE DEPT\n6:30 IMPORTANT MEETING,\n
[E911] WEATHER\n \nWEATHER\nFLASH FLOODING TILL 5:00\n
[E911] TRAINING\n \nSPR AT 6 PM AT STATION 1\n
[E911] MVC WITHOUT INJURY\nJJS\n

[E911] PATIENT TRANSFER\nHELEN KELLER HOSPITAL 2563811766\n1300 S MONTGOMERY AV, SHEFFIELD\n315 EULA\n
[E911] STROKE\nHOUSTON BOLTON 2563596427\n5280 OLD LEE HWY, CHEROKEE\n83M\n
[E911] PASSED OUT\n 2565772031\n290 FORREST DR, CHEROKEE\n25 YOM\n
[E911] OVERDOSE\nADAY, SHANE 2563602442\n145 ADAY DR, CHEROKEE\n15 YOM\n
[E911] FIRE - UNKNOWN\nNELIA STAFFORD 2563594739\n445 NORTH PKE, CHEROKEE\nACROSS THE STREET FROM CALLER\n
[E911] MVC / C INJURIES\n 2564128754\n1080 NORTH PKE, CHEROKEE\n
[E911] CHEST PAIN\nMONTEZ DAVIS 2563594174\n190 JOHNSON DR, CHEROKEE\n68F\n
[E911] PASSED OUT\n 2565779317\n1350 OLD COVER BRIDGE RD W, CHEROKEE\n40M\n
[E911] VOMITING\nNELLAREE W DODSON 2563596248\n800 CROSS ST, CHEROKEE\n83/F\n
[E911] FIRE - GRASS/WOODS\n \nMT HESTER RD MILE S OF 72 B4 CEDAR LN\n
[E911] FALL\nN MCGEE 2563594003\n765 CROSS ST, CHEROKEE\n60/M\n
[E911] HEART PROBLEM\n 2564129804\n125 SPRING VALLEY LN, CHEROKEE\n66 YOM\n
[E911] BREATHING PROBLEM\n 2567023439\n7455 ALLSBORO RD, CHEROKEE\n54/F\n
[E911] DRILL\nSHOALS FLIGHT CENTER 2563812869\n1729 T ED CAMPBELL DR, MUSCLE SHOALS\nA4\n
[E911] DISTURBANCE\nALTHEA LONG 2563814676\n911 SE 18TH ST, SHEFFIELD\n
[E911] LOST PERSON\n FREEDOM HILLS RD\n
[E911] NOSE BLEED\nGAIL STEVENSON 890 DOBBS ST, CHEROKEE\n60 YOF\n
[E911] MVC /C UNKNOWN INJ\n HIGHWAY 72 @ MM 5, CHEROKEE\n
[E911] MISSING PERSON\n NATCHEZ TRACE PKWY @ MP 319\n
[E911] HEMORRHAGE/LACERATION\nADAY, SHANE 145 ADAY DR\n49M\n
[E911] BREATHING PROBLEM\nPARADISE FOODMART AND PACKAGE NO 7060 HIGHWAY 72, CHEROKEE\n55 YOM\n
[E911] AMPUTATION\nADAY, SHANE 145 ADAY DR, CHEROKEE\n
[E911] HEMORRHAGE/LACERATION\nMRS MILDRED PUGH 2480 WHITE PKE, CHEROKEE\n67M\n
[E911] AMPUTATION\nADAY, SHANE 145 ADAY DR, CHEROKEE

*/
public class ALColbertCountyParser extends FieldProgramParser {
  
  public ALColbertCountyParser() {
    super("COLBERT COUNTY", "AL",
           "CALL ( ADDR END | NAMEPH? ADDR INFO )");
  }
  
  @Override
  public String getProgram() {
    return "CALL PHONE NAME PLACE ADDR CITY INFO";
  }
  
  @Override
  public String getFilter() {
    return "911alert@comcast.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String flds[] = body.split("\n");
    if (!subject.equals("E911") && flds.length < 3) return false;
    if (!parseFields(flds, data)) return false;
    
    // SOmetimes, what we interpreted as a name should be a place
    if (checkPlace(data.strName)) {
      data.strPlace = data.strName;
      data.strName = "";
    }
    return true;
  }
  
  /**
   * Determine if this is a personal name or a place name
   * @param field field to be checked
   * @return true if should be place name
   */
  private boolean checkPlace(String field) {
    if (field.contains(",")) return false;
    if (field.toUpperCase().startsWith("MR")) return false;
    int cnt = 0;
    char last = 'X';
    for (char chr : field.toCharArray()) {
      if (chr == ' ' && last != ' ') cnt++;
      last = chr;
    }
    return cnt >= 2;
  }

  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}$");
  private static final Pattern DIGIT_PTN = Pattern.compile("\\b\\d{1,7}\\b");
  private class NamePhoneField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // A comma followed by a legitimate name indicates this is really an
      // address field, which we should not recognize
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        String sCity = field.substring(pt+1).trim().toUpperCase();
        if (CITY_SET.contains(sCity)) return false;
      }
      
      // Ditto if it contains an @
      if (field.indexOf('@') >= 0) return false;
      
      // Or a number with fewer than 8 digits
      if (DIGIT_PTN.matcher(field).find()) return false;
      
      parse(field, data);
      return true;
    }
    
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group();
        field = field.substring(0,match.start()).trim();
      }
      data.strName = field;
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private static final Pattern CITY_PTN = Pattern.compile(", *([A-Z]+ ?[A-Z]*)$", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT_PTN = Pattern.compile(", *(\\w+)$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("&&", "&");
      
      Matcher match = CITY_PTN.matcher(field);
      if (match.find()) {
        data.strCity = match.group(1).trim(); 
        field = field.substring(0,match.start()).trim();
      }
      
      match = APT_PTN.matcher(field);
      if (match.find()) {
        data.strApt = match.group(1);
        field = field.substring(0,match.start()).trim();
      }
      
      String tail = "";
      int pt = field.indexOf('@');
      if (pt >= 0) {
        tail = field.substring(pt);
        field = field.substring(0,pt).trim();
      }
      
      StartType st = (data.strName.length() > 0 ? StartType.START_ADDR : StartType.START_PLACE);
      parseAddress(st, FLAG_ANCHOR_END, field, data);
      if (st == StartType.START_PLACE){ 
        if (data.strAddress.length() == 0) {
          data.strAddress = data.strPlace;
        } else {
          data.strName = data.strPlace;
        }
        data.strPlace = "";
      }
      data.strAddress = append(data.strAddress, " ", tail);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NAMEPH")) return new NamePhoneField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{

      // Cities
      "MUSCLE SHOALS",
      "SHEFFIELD",
      "TUSCUMBIA",
      
      // Towns
      "CHEROKEE",
      "LEIGHTON",
      "LITTLEVILLE",
      
      // Unincorporated 
      "ALLSBORO",
      "BARTON",
      "BUZZARD ROOST",
      "COLBERT HEIGHTS",
      "FORD CITY",
      "WHITE OAK"
  }));
}
