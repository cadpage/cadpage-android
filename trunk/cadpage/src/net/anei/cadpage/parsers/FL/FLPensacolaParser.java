package net.anei.cadpage.parsers.FL;



import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



/*
Pensacola, FL
Contact: CodeMessaging

Call_Number: PFD12CAD003118 | Units: L11, | Complaint: PUBLIC ASSISTANCE | Location: X2[SCOTT ST E] | Address: 2400 N 7TH AV  | Xst 1:  YONGE ST E | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 2400 N 7TH AV | CAddress2: X2[SCOTT ST E] | Loc_Display: 2400 N 7TH AV [X2[SCOTT ST E]]  x[YONGE ST E]    [PENSACOLA] | Time_Dispatched: 2012-06-25 09:33:23 | Narrative:  | This_Unit: L11
Call_Number: PFD12CAD003114 | Units: ENG2, | Complaint: RESCUE | Location: X2[9TH AV N] | Address: 813  WOODLAND DR  | Xst 1:  ACACIA DR | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 813 WOODLAND DR | CAddress2: X2[9TH AV N] | Loc_Display: 813 WOODLAND DR [X2[9TH AV N]]  x[ACACIA DR]    [PENSACOLA] | Time_Dispatched: 2012-06-25 00:58:02 | Narrative: CHEST PAINS | This_Unit: ENG2
Call_Number: PFD12CAD003116 | Units: ENG2, | Complaint: RESCUE | Location: X2[KENNETH ST] | Address: 611  BERKLEY DR  | Xst 1:  BOXWOOD DR | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 611 BERKLEY DR | CAddress2: X2[KENNETH ST] | Loc_Display: 611 BERKLEY DR [X2[KENNETH ST]]  x[BOXWOOD DR]    [PENSACOLA] | Time_Dispatched: 2012-06-25 08:05:47 | Narrative: EMS 12-25415 | This_Unit: ENG2
Call_Number: PFD12CAD003117 | Units: ENG1, | Complaint: RESCUE | Location: X2[LANCELOT DR] | Address: 7965  GAWIN DR  | Xst 1:  KING ARTHUR DR | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 7965 GAWIN DR | CAddress2: X2[LANCELOT DR] | Loc_Display: 7965 GAWIN DR [X2[LANCELOT DR]]  x[KING ARTHUR DR]    [PENSACOLA] | Time_Dispatched: 2012-06-25 09:18:55 | Narrative:  | This_Unit: ENG1
Call_Number: PFD12CAD003115 | Units: ENG1, | Complaint: RESCUE | Location: X2[C ST N] | Address: 815 W LA RUA ST  | Xst 1:  B ST N | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 815 W LA RUA ST | CAddress2: X2[C ST N] | Loc_Display: 815 W LA RUA ST [X2[C ST N]]  x[B ST N]    [PENSACOLA] | Time_Dispatched: 2012-06-25 03:32:10 | Narrative:  | This_Unit: ENG1
Call_Number: PFD12CAD003111 | Units: ENG6, | Complaint: RESCUE | Location: THE FLATS AT 9TH AVENUE  308-5345 X2[BEAU TERRA LN] | Address: 7601 N 9TH AV 107 | Xst 1:  I10 | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 7601 N 9TH AV | CAddress2: THE FLATS AT 9TH AVENUE  308-5345 X2[BEAU TERRA LN] | Loc_Display: 7601 N 9TH AV [THE FLATS AT 9TH AVENUE  308-5345 X2[BEAU TERRA LN]]  x[I10]    [ | Time_Dispatched: 2012-06-24 23:18:28 | Narrative:  | This_Unit: ENG6

Call_Number: PFD12CAD003213 | Units: ENG5, | Complaint: RESCUE | Location: | Address: 690 E HEINBERG ST  | Xst 1:  10TH AV N | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 690 E HEINBERG ST | CAddress2:  | Loc_Display: 690 E HEINBERG ST x[10TH AV N]    [PENSACOLA] | Time_Dispatched: 2012-07-01 03:01:20 | Narrative:  | This_Unit: ENG5
Call_Number: PFD12CAD003211 | Units: ENG6,ENG2,ENG1, | Complaint: ACTIVATED FIRE ALARM | Location: CORDOVA MALL  477-1663 X2[AIRPORT BLVD] | Address: 5100 N 9TH AV  | Xst 1:  BAYOU BLVD | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 5100 N 9TH AV | CAddress2: CORDOVA MALL  477-1663 X2[AIRPORT BLVD] | Loc_Display: 5100 N 9TH AV [CORDOVA MALL  477-1663 X2[AIRPORT BLVD]]  x[BAYOU BLVD]    [PENSA | Time_Dispatched: 2012-06-30 23:03:28 | Narrative:  | This_Unit: ENG2

*/

public class FLPensacolaParser extends FieldProgramParser {
	
  
  public FLPensacolaParser() {
    super("PENSACOLA", "FL",
        "Call_Number:ID! Units:UNIT! Complaint:CALL! Location:PLACE! Address:ADDR! Xst_1:X! Xst_2:SKIP! City:CITY! State:ST! CAddress1:SKIP! CAddress2:SKIP! Loc_Display:SKIP! Time_Dispatched:DATETIME! Narrative:INFO! This_Unit:SKIP!");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("_", " "); 
    if (!parseFields(body.split("\\|"), 14, data)) return false;  
    if (data.strState.equals("FL")) data.strState = ""; 
    return true;
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(",")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern PLACE_X_PTN = Pattern.compile("\\bX2\\[([^\\[\\]]+)\\]$");
  private static final Pattern PHONE_PTN = Pattern.compile("\\b(?:\\d{3}-?)?\\d{3}-?\\d{4}$");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PLACE_X_PTN.matcher(field);
      if (match.find()) {
        data.strCross = match.group(1).trim();
        field = field.substring(0,match.start()).trim();
      }
      match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group().trim();
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE PHONE X";
    }
  }


  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
    return super.getField(name);
  }
}