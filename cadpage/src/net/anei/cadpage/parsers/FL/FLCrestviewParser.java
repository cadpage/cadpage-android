
package net.anei.cadpage.parsers.FL;


import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Crestview, FL
Contact: "David Maxey" <dmaxey09@vt.edu>
Sender: @c-msg.net

Call_Number: 1806 | Inc_Number:  | Units: CFD,Engine 2, | Complaint: MUTUAL AID | Location: Second Ave | Address: 481    | Disposition:  | Box:  | Time_Dispatched: 2012-06-25 07:20:20 | Narrative: stump on fire 10 ft from a residence actual site is across | This_Unit: Engine 2
Call_Number: 1805 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Adams (100-748) | Address:  Adams DR  | Disposition:  | Box: 1 | Time_Dispatched: 2012-06-25 01:47:29 | Narrative: 305 adams dr near bob sikes school | This_Unit: Rescue 3
Call_Number: 1871 | Inc_Number: 1536 | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Lloyd -N (100-1708) | Address: 966 NLloyd ST  | Disposition:  | Box: 1 | Time_Dispatched: 2012-07-01 14:14:13 | Narrative: unknown aged male possible stroke | This_Unit: Rescue 3
Call_Number: 1869 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Griffith -E Avenue    (200-664) | Address: 503 EGriffith AVE  | Disposition:  | Box: 1 | Time_Dispatched: 2012-07-01 13:16:45 | Narrative: 53 yo male having seizures | This_Unit: Rescue 3

*/

public class FLCrestviewParser extends FieldProgramParser {


  public FLCrestviewParser() {
    super("Crestview", "FL",
        "Call_Number:ID! Inc_Number:SKIP! Units:UNIT! Complaint:CALL! Location:PLACE! Address:ADDR! Disposition:SKIP! Box:BOX! Time_Dispatched:DATETIME! Narrative:INFO! This_Unit:SKIP!");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }


  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("_", " "); 
    if (!parseFields(body.split("\\|"), 10, data)) return false;
    
    // They do weird things splitting address up between Address and Location fields :(
    if (NUMERIC.matcher(data.strAddress).matches()) {
      data.strAddress = append(data.strAddress, " ", data.strPlace);
      data.strPlace = "";
    }
    return true;
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
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
    return super.getField(name);
  }
}