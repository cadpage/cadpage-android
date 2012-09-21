package net.anei.cadpage.parsers.PA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lackawanna County, PA (alternate - Lackawanna Ambulance)
Contact: Pat Gillott <pgill107@gmail.com>
Sender: lead@ladisp.us

06:34AM Sat 04/28 INC#:1219146-1 FROM:320 EMMETT ST, SCRANTON CITY RM:16D  TYPE:CHEST PAIN  to:
01:03PM Thu 05/03 INC#:1219963-1 FROM:345 PHELPS ST, SCRANTON CITY  TYPE:EMERGENT EVAL  to:
11:16AM Thu 05/03 INC#:1219939-1 FROM:1435 N WASHINGTON AVE, SCRANTON CITY RM:Kwik mart  TYPE:EMERGENT EVAL  to:
10:06AM Thu 05/03 INC#:1219924-1 FROM:APT - LUTHERWOOD- 1 LAKE SCR RD RM:211  TYPE:PUBLIC ASSIST  to:
08:14AM Thu 05/03 INC#:1219854-1 FROM:EVERGREEN H.C.C. - formerly MTH Skilled RM:7  TYPE:DR APPOINTMENT PT:Barbara Martin  to: DELTA MEDIX -
06:23AM Thu 05/03 INC#:1219903-1 FROM:1020 MULBERRY ST, SCRANTON CITY RM:Nelvelle Hall Rm 107  TYPE:UNKNOWN  to:

*** No idea what this is **
00 Meade St, Dunmore  1000 MEADE ST, DUNMORE, PA  MODE:BLS  PU: 0915 (02/02)

 */


public class PALackawannaCountyAmbulanceParser extends FieldProgramParser {
  
  public PALackawannaCountyAmbulanceParser() {
    super("LACKAWANNA COUNTY", "PA",
           "DATETIME INC#:ID! FROM:ADDRCITY! RM:APT? TYPE:CALL! to:INFO");
  }
  
  @Override
  public String getFilter() {
    return "lead@ladisp.us";
  }

  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("hh:mmaa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      setTime(DATE_TIME_FMT, p.get(' '), data);
      data.strDate = p.getLast(' ');
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
}
