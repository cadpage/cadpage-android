package net.anei.cadpage.parsers.FL;



import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



/*
Lake County, FL
Contact: 3522354040@messaging.sprintpcs.com
Sender: varies


Call_Number: PFD12CAD003118 | Units: L11, | Complaint: PUBLIC ASSISTANCE | Location: X2[SCOTT ST E] | Address: 2400 N 7TH AV  | Xst 1:  YONGE ST E | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 2400 N 7TH AV | CAddress2: X2[SCOTT ST E] | Loc_Display: 2400 N 7TH AV [X2[SCOTT ST E]]  x[YONGE ST E]    [PENSACOLA] | Time_Dispatched: 2012-06-25 09:33:23 | Narrative:  | This_Unit: L11
Call_Number: PFD12CAD003114 | Units: ENG2, | Complaint: RESCUE | Location: X2[9TH AV N] | Address: 813  WOODLAND DR  | Xst 1:  ACACIA DR | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 813 WOODLAND DR | CAddress2: X2[9TH AV N] | Loc_Display: 813 WOODLAND DR [X2[9TH AV N]]  x[ACACIA DR]    [PENSACOLA] | Time_Dispatched: 2012-06-25 00:58:02 | Narrative: CHEST PAINS | This_Unit: ENG2
Call_Number: PFD12CAD003116 | Units: ENG2, | Complaint: RESCUE | Location: X2[KENNETH ST] | Address: 611  BERKLEY DR  | Xst 1:  BOXWOOD DR | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 611 BERKLEY DR | CAddress2: X2[KENNETH ST] | Loc_Display: 611 BERKLEY DR [X2[KENNETH ST]]  x[BOXWOOD DR]    [PENSACOLA] | Time_Dispatched: 2012-06-25 08:05:47 | Narrative: EMS 12-25415 | This_Unit: ENG2
Call_Number: PFD12CAD003117 | Units: ENG1, | Complaint: RESCUE | Location: X2[LANCELOT DR] | Address: 7965  GAWIN DR  | Xst 1:  KING ARTHUR DR | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 7965 GAWIN DR | CAddress2: X2[LANCELOT DR] | Loc_Display: 7965 GAWIN DR [X2[LANCELOT DR]]  x[KING ARTHUR DR]    [PENSACOLA] | Time_Dispatched: 2012-06-25 09:18:55 | Narrative:  | This_Unit: ENG1
Call_Number: PFD12CAD003115 | Units: ENG1, | Complaint: RESCUE | Location: X2[C ST N] | Address: 815 W LA RUA ST  | Xst 1:  B ST N | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 815 W LA RUA ST | CAddress2: X2[C ST N] | Loc_Display: 815 W LA RUA ST [X2[C ST N]]  x[B ST N]    [PENSACOLA] | Time_Dispatched: 2012-06-25 03:32:10 | Narrative:  | This_Unit: ENG1
Call_Number: PFD12CAD003111 | Units: ENG6, | Complaint: RESCUE | Location: THE FLATS AT 9TH AVENUE  308-5345 X2[BEAU TERRA LN] | Address: 7601 N 9TH AV 107 | Xst 1:  I10 | Xst 2:   | City: PENSACOLA | State: FL | CAddress1 : 7601 N 9TH AV | CAddress2: THE FLATS AT 9TH AVENUE  308-5345 X2[BEAU TERRA LN] | Loc_Display: 7601 N 9TH AV [THE FLATS AT 9TH AVENUE  308-5345 X2[BEAU TERRA LN]]  x[I10]    [ | Time_Dispatched: 2012-06-24 23:18:28 | Narrative:  | This_Unit: ENG6


Contact: "David Maxey" <dmaxey09@vt.edu>
*/

public class FLPensacolaParser extends FieldProgramParser {
	
  
  public FLPensacolaParser() {
    super("PENSACOLA", "FL",
        "Call_Number:ID! Units:UNIT! Complaint:CALL! Location:PLACE! Address:ADDR! Xst_1:X! Xst_2:SKIP! City:CITY! State:ST! CAddress1:SKIP! CAddress2:SKIP! Loc_Display:SKIP! Time_Dispatched:DATETIME! Narrative:INFO! This_Unit:SRC!");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }


  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("_", " "); 
    body = body.replaceAll(",", "");
    body = body.replaceAll("X2", "");
    if (!parseFields(body.split("\\|"), 14, data)) return false;  
    if (data.strDate.equals("FL")) data.strDate = ""; 
    return true;

  }


  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d{4}-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
}