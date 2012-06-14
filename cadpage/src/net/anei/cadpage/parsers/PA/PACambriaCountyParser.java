package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Cambria County, PA
Contact: jacob berkey <jwb932@gmail.com>
Sender: alerts@cambria.ealertgov.com

[29] 11 Time: 15:02:29 Nature: 17A01G-Alpha FALL Location: 216 MAIN ST-JO | Sta 35
[29] 11 Time: 11:54:47 Nature: 29B01-Bravo VEH ACC WITH INJURIES Location: 110 PLAZA DR-LY | Sta 30, Sta 23, Sta 35
[29] 11 Time: 08:03:01 Nature: 10C02-Charlie CHEST PAIN Location: 315 LOCUST ST-JO | Sta 35 
[29] 11 Time: 06:45:29 Nature: 17B03G-Bravo FALL Location: WALNUT ST-JO/MAIN ST-JO | Sta 35
[28] 11 Time: 21:39:31 Nature: 06D03A-Delta BREATHING PROBLEMS Location: 205 CHANDLER AVE-JO | Sta 35, Sta 21, Sta 36

Contact: Ben Smith <cnfederatediesel@gmail.com>
Contact: Paul Zabinsky <pzabinsky@gmail.com>
Date: 06/02/11\nTime: 20:47:52\nNature: 10C01-Charlie CHEST PAIN\nLocation: 1518 W 2ND ST-CR\n| Sta 75
Date: 06/04/11\nTime: 11:03:04\nNature: 06D02-Delta  BREATHING PROBLEMS\nLocation: 908 SHORT AVE-CR\n| Sta 75
Date: 06/04/11\nTime: 17:24:03\nNature: STB-STAND BY\nLocation: 721 MAIN ST-PORB\n| Sta 73
Date: 06/05/11\nTime: 18:00:42\nNature: 52C04G-Charlie FIRE ALARM\nLocation: 111 ASHCROFT AVE-CB\n| Sta 70
Date: 06/13/11\nTime: 15:53:48\nNature: 02D02-Delta  ALLERGIC REACTION\nLocation: 1237 ST AUGUSTINE RD-CF\n| Sta 60, Sta 67

Contact: Paul Bomboy <training@easthillsems.com>
Sender: Cambria 9-1-1
FRM:Cambria 9-1-1\nMSG:Date: 11/07/11\nTime: 18:02:55\nNature: 10C01-Charlie CHEST PAIN\nLocation: 349 VO TECH DR-RI\n|

Contact: support@active911.com
Sender; "Cambria 9-1-1" <alerts@cambria.ealertgov.com>
Date: 01/24/12\nTime: 18:02:50\nNature: 69D03-Delta STRUCTURE FIRE\nLocation: 7458 ADMIRAL PEARY HWY-CB\nSta 70, Sta 71, Sta 72, Sta 75

Cambria County, PA (alternate)
Contact: Brian Flora <USMARINE_2002@yahoo.com>
Sender: alerts@cambria.ealertgov.com
DATE: 06/13/12\r\n | 13:21:53\r\n | 25B06V-BRAVO PSYCHIATRIC PROBLEM\r\n | 1109 DEVEAUX ST-WC\r\n | NUMBER 1 RD-WC FRAZIER ST-WC\r\n | Sta 64
DATE: 06/13/12\r\n | 13:08:24\r\n | 17A01G-ALPHA FALL\r\n | 180 WOOD AVE-CM\r\n | BELAIR ST-CM EDSEL ST\r\n | Sta 48
DATE: 06/12/12\r\n | 20:34:38\r\n | SS-EMS STATION STILL\r\n | 100 N CAROLINE ST-EB\r\n | E HIGH ST-EB\r\n | Sta 48
DATE: 06/12/12\r\n | 18:55:55\r\n | 26A01-ALPHA  SICK PERSON\r\n | 700 N CENTER ST-EB\r\n | BOLTON ST-EB W HIGHLAND AVE-EB\r\n | Sta 48
DATE: 06/12/12\r\n | 18:55:55\r\n | 26A01-ALPHA  SICK PERSON\r\n | 700 N CENTER ST-EB\r\n | BOLTON ST-EB W HIGHLAND AVE-EB\r\n | Sta 48
DATE: 06/12/12\r\n | 18:35:37\r\n | BLS-BLS EMS CALL\r\n | 121 UNION ST-CM\r\n | DEAD END TRIPOLI RD-CM\r\n | Sta 40, Sta 48
DATE: 06/12/12\r\n | 11:14:25\r\n | 10C01-CHARLIE CHEST PAIN\r\n | 1100 W HIGH ST-CM\r\n | MYERS ST-CM NEW GERMANY RD-CM\r\n | Sta 48
DATE: 06/12/12\r\n | 09:56:39\r\n | 52C03S-CHARLIE SMOKE DETECTOR ALARM\r\n | 140 E CARROLL ST-CL\r\n | BEDE ST-CL N CHURCH ST-CL\r\n | Sta 5
DATE: 06/11/12\r\n | 23:56:26\r\n | 28C03L-CHARLIE STROKE\r\n | 429 MANOR DR-CM\r\n | WINDY VALLEY RD-CM\r\n | Sta 48
DATE: 06/13/12\r\n | 15:52:42\r\n | 18C05-CHARLIE  HEADACHE\r\n | 236 JAMESWAY RD-CM\r\n | WALMART DR-CM ADMIRAL PEARY HWY-CM\r\n | Sta 48

*/

public class PACambriaCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER1 = Pattern.compile("\\d\\d");
  private static final Pattern MARKER2 = Pattern.compile("^\\d\\d ");
  private static final Pattern BAR_PTN = Pattern.compile("([ \n])\\| ");
  
  public PACambriaCountyParser() {
    super(CITY_CODES, "CAMBRIA COUNTY", "PA",
           "( Date:DATE | ) ( Time:TIME! Nature:CALL! Location:ADDR/y! | DATE:DATE! TIME CALL ADDR/y X ) UNIT Sta:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "alerts@cambria.ealertgov.com,Cambria 9-1-1";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (MARKER1.matcher(subject).matches()) {
      Matcher match = MARKER2.matcher(body);
      if (!match.find()) return false;
      body = body.substring(match.end()).trim();
    }
    
    String[] flds = body.split("\\|");
    if (flds.length >= 5) {
      return parseFields(flds, data);
    }
    body = BAR_PTN.matcher(body).replaceAll("$1Sta: ");
    if (body.endsWith("|")) body = body.substring(0,body.length()-1).trim();
    flds = body.split("\n");
    if (flds.length >= 5) {
      return parseFields(flds, data);
    } else {
      return super.parseMsg(body.replace('\n', ' '), data);
    }
  }
  
  private static final Pattern CITY_CODE_PTN = Pattern.compile("-[A-Z]{2} ");
  private static final Pattern CITY_CODE_END_PTN = Pattern.compile("-[A-Z]{2}$");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = CITY_CODE_PTN.matcher(field).replaceAll(" & ");
      field = CITY_CODE_END_PTN.matcher(field).replaceAll("");
      super.parse(field.trim(), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ADAM", "ADAMS TWP",
      "ASHB", "ASHVILLE",
      "BARR", "BARR TWP",
      "BN", "BROWNSTOWN",
      "BT", "BLACKLICK TWP",
      "CA", "CASSANDRA",
      "CB", "CRESSON",
      "CF", "CLEARFIELD TWP",
      "CH", "CHEST TWP",
      "CL", "CARROLLTOWN",
      "CM", "CAMBRIA TWP",
      "CONT", "CONEMAUGH TWP",
      "CP", "CHEST SPRINGS",
      "CR", "CRESSON TWP",
      "CROY", "CROYLE TWP",
      "DB", "DALE",
      "DE", "DEAN TWP",
      "DT", "DAISYTOWN",
      "EA", "EAST TAYLOR TWP",
      "EB", "EBENSBURG",
      "ECON", "EAST CONEMAUGH",
      "EF", "EHRENFELD",
      "ECAR", "EAST CARROLL TWP",
      "ET", "ELDER TWP",
      "FB", "FERNDALE",
      "FR", "FANKLIN",
      "GB", "GALLITZIN",
      "GE", "GEISTOWN",
      "GT", "GALLITZIN TWP",
      "HB", "HASTINGS",
      "JO", "JOHNSTOWN",
      "JT", "JACKSON TWP",
      "LB", "LORETTO",
      "LI", "LILLY",
      "LO", "LORAIN",
      "LY", "LOWER YODER TWP",
      "MT", "MIDDLE TAYLOR TWP",
      "MU", "MUNSTER TWP",
      "NC", "NORTHERN CAMBRIA",
      "NG", "NANTY GLO",
      "PATB", "PATTON ",
      "PORB", "PORTAGE",
      "PORT", "PORTAGE TWP",
      "RI", "RICHLAND TWP",
      "RT", "READE TWP",
      "SB", "SANKERTOWN",
      "SC", "STONYCREEK TWP",
      "SF", "SOUTH FORK",
      "SL", "SCALP LEVEL",
      "SM", "SOUTHMONT",
      "SQ", "SUSQUEHANNA TWP",
      "SUMB", "SUMMERHILL",
      "SUMT", "SUMMERHILL TWP",
      "TB", "TUNNELHILL",
      "UY", "UPPER YODER TWP",
      "VB", "VINTONDALE",
      "WB", "WESTOVER",
      "WC", "WEST CARROLL TWP",
      "WE", "WHITE TWP",
      "WI", "WILMORE",
      "WM", "WESTMONT",
      "WS", "WEST TAYLOR TWP",
      "WT", "WASHINGTON TWP"
  });
}
