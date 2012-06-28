
package net.anei.cadpage.parsers.FL;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*

Call_Number: 1806 | Inc_Number:  | Units: CFD,Engine 2, | Complaint: MUTUAL AID | Location: Second Ave | Address: 481    | Disposition:  | Box:  | Time_Dispatched: 2012-06-25 07:20:20 | Narrative: stump on fire 10 ft from a residence actual site is across | This_Unit: Engine 2
Call_Number: 1805 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Adams (100-748) | Address:  Adams DR  | Disposition:  | Box: 1 | Time_Dispatched: 2012-06-25 01:47:29 | Narrative: 305 adams dr near bob sikes school | This_Unit: Rescue 3


Contact: "David Maxey" <dmaxey09@vt.edu>
*/

public class FLCrestviewParser extends FieldProgramParser {


  public FLCrestviewParser() {
    super("Crestview", "FL",
        "Call_Number:ID Inc_Number:SKIP Units:UNIT Complaint:CALL Location:PLACE Address:ADDR Disposition:SKIP Box:BOX Time_Dispatched:DATETIME Narrative:INFO This_Unit:SRC");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }


  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("_", " "); 
    body = body.replaceAll(",", " ");
    if (!parseFields(body.split("\\|"), 10, data)) return false;  
    if (data.strDate.equals("FL")) data.strDate = ""; 
    return true;

  }

  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d{4}-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d", true);

    return super.getField(name);
  }
}