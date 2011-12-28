package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Anderson County, TN
Contact: justin massengill <acs0680@gmail.com>
Sender: page@tnacso.net

(E911) Fire - Residential - 782 BRUSHY VALLEY RD ANDERSONVILLE, TN - REC:04:51 DISP:04:51 RESP:04:53 ONSC:05:09 INSRV:08:13 TRK#:178730
(E911) Fire Alarm-Residential - 1534 MOUNTAIN RD ANDERSONVILLE, TN 
(E911) Fire - Residential - 778 BRUSHY VALLEY RD ANDERSONVILLE, TN
(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN - REC:14:25 DISP:14:25 RESP:14:25 ONSC:14:30 INSRV:14:30 TRK#:178572
(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN
(E911) MVA - Hazards - BETHEL RD CLINTON, TN -REC:03:15 DISP:03:17 RESP:03:19 ONSC:03:35 INSRV:04:03 TRK#:178399
(E911) MVA - Hazards - BETHEL RD CLINTON, TN
(E911) CVFD FIRST RESP - 3259 W WOLF VALLEY ROAD CLINTON, TN - FALL INJURIES
(E911) RESC - I75 SB @ MM 119 CLINTON, TN - MVA
(E911) MVA - Injury - I75 SB @ MM 119 CLINTON, TN - REC:02:41 DISP:02:41 RESP:02:45 ONSC: INSRV:02:51 TRK#:179132
(E911) MARFVD FIRST RESP - 1508 LAUREL RD CLINTON, TN - DIFFICULTY BREATHING
(E911) EMS Assist - 1508 LAUREL RD CLINTON, TN - REC:20:21 DISP:20:23 RESP:20:24 ONSC:20:31 INSRV:20:39 TRK#:179119
(E911) Mutual Aid Request - 838 OLIVER SPRINGS HIGHWAY CLINTON, TN
(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN
(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN - REC:14:25 DISP:14:25 RESP:14:25 ONSC:14:30 INSRV:14:30 TRK#:178572

Contact: Cousin Skeeter <skeeter1380@gmail.com>
E911 / MARFVD - FROST BOTTOM ROAD  OLIVER SPRINGS, TN - MVA\n\n
E911 / MARFVD FIRST RESP - 1180 DUTCH VALLEY ROAD  CLINTON, TN - DIFFICULTY  BREATHING\n\n
E911 / Fire Alarm-Residential - 351 WOODLAND HILLS ROAD CLINTON, TN - REC:12:11 DISP:12:12 RESP:12:16 ONSC: INSRV:12:17 TRK#:188459\n\n

 */

public class TNAndersonCountyParser extends FieldProgramParser {
  
  public TNAndersonCountyParser() {
    super(CITY_LIST, "ANDERSON COUNTY", "TN",
           "CALL+? ADDR/S! INFO");
  }
  
  @Override
  public String getFilter() {
    return "page@tnacso.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    // Dummy loop
    do {
      if (subject.equals("E911")) break;
      if (body.startsWith("E911 / ")) {
        body = body.substring(6).trim();
        break;
      }
      return false;
    } while (false);
    
    body = body.replace(" -REC:", " - REC:");
    return parseFields(body.split(" - "), data);
  }
  
  // Call field appends to previous call field with - separator
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }

  // Address field is identified by trailing , TN
  // ANd needs to replace @ with &
  private class MyAddressField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.endsWith(", TN")) return false;
      field = field.substring(0, field.length()-4).trim();
      field = field.replace('@', '&');
      super.parse(field, data);
      return true;
    }
  }
  
  // The info field has to do all kinds of strange things
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      
      // If this starts with REC:, then it is some time and tracking
      // information marking the end of call
      if (field.startsWith("REC:")) {
        data.strCall = data.strCall + " (END)";
        data.strSupp = field;
      }
      
      // Anything else, this is really the call description
      // and what we thought was the call description is really the department
      else {
        data.strSource = data.strCall;
        data.strCall = field;
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ANDERSONVILLE",
    "BRICEVILLE",
    "CLAXTON",
    "CLINTON",
    "DEVONIA",
    "FORK MOUNTAIN",
    "FRATERVILLE",
    "LAKE CITY",
    "MARLOW",
    "NORRIS",
    "OAK RIDGE",
    "OLIVER SPRINGS",
    "ROSEDALE"
  };
}
