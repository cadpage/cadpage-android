package net.anei.cadpage.parsers.NY;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Orange County, NY
Contact: George Ewings <gewings@gmail.com>
Contact: Seth Armstrong <setharmstrong31@gmail.com>
Contact: Dave Abbott <davea@a1-services.com>
Contact: Burton Struble <burton.struble@gmail.com>
Contact: kevin torres <nycff103@gmail.com>

Contact: Ken Rypkema <kenryp119@gmail.com> "mail.vailsgatefd.com" <krypkema@mail.vailsgatefd.com>
Sender:messaging@iamresponding.com
(Vails Gate) CARBON MONOXIDE DETR  1 KEARNEY DR  NEW WINDSOR  DEPT 45 TIME: 19:17 XST: MARSHALL DR XST2: 17 TRUEX DR\n\n\nThis
(Vails Gate) EXTRICATION  ST RTE 32&amp;ORRS MILLS RD  CORNWALL  SPRINT PCS WIRELESS  CALLER REPORTS CAR INTO TREE POSS ENTRAPEMENT  Parent Inc MCO11112
(Vails Gate) ROLLOVER MVA  2406 ST RTE 32  CORNWALL  JESSICA  ONE CAR ROLLOVER//UNK INJS  Parent Inc MCO111126000959 UPDATE PriUnt to CO/CODIS TIME: 23:
(Vails Gate) AUTOMATIC FIRE ALARM  273 WINDSOR HWY  NEW WINDSOR  VECTOR SECURITY  LAUDRY ROOM SMOKE DETECTOR   Location : HUDSON VALLEY VETERIAN TIME: 1
(Vails Gate) AUTOMATIC FIRE ALARM  516 REED ST  NEW WINDSOR  SGT THOMAS  CALLER STS THERE IS A FIRE ALARM STS BLINKING SYSTEM TROUBLE AND ALSO SAY  S DA
(Vails Gate) AUTOMATIC FIRE ALARM  935 UNION AVE  NEW WINDSOR  CENTRAL STATION  ZONE 32 OFFICE SMOKE DETECTOR/ ALARM CO IS ATTEMPTING KEY HOLDER/ PREM N

 */


public class NYOrangeCountyAParser extends FieldProgramParser {
  
  private static final Pattern KEYWORD_PTN = Pattern.compile("(?<! ) [A-Z]+[0-9]*:");
  
  public NYOrangeCountyAParser() {
    super("ORANGE COUNTY", "NY",
           "CALL ADDR CITY! INFO+ LOCATION:PLACE? TIME:TIME XST:X XST2:X");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strSource = subject;
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    body = KEYWORD_PTN.matcher(body).replaceAll(" $0");
    String[] flds = body.split("  +");
    if (flds.length < 3) return false;
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (!CITY_SET.contains(field.toUpperCase())) abort();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "MIDDLETOWN",
      "NEWBURGH",
      "PORT JERVIS",

      "CHESTER",
      "CORNWALL ON HUDSON",
      "FLORIDA",
      "GOSHEN",
      "GREENWOOD LAKE",
      "HARRIMAN",
      "HIGHLAND FALLS",
      "KIRYAS JOEL",
      "MAYBROOK",
      "MONROE",
      "MONTGOMERY",
      "OTISVILLE",
      "SOUTH BLOOMING GROVE",
      "TUXEDO PARK",
      "UNIONVILLE",
      "WALDEN",
      "WARWICK",
      "WASHINGTONVILLE",
      "WOODBURY",

      "BLOOMING GROVE",
      "CHESTER",
      "CORNWALL",
      "CRAWFORD",
      "DEERPARK",
      "GOSHEN",
      "GREENVILLE",
      "HAMPTONBURGH",
      "HIGHLANDS",
      "MINISINK",
      "MONROE",
      "MONTGOMERY",
      "MOUNT HOPE",
      "NEW WINDSOR",
      "NEWBURGH",
      "TUXEDO",
      "WALLKILL",
      "WARWICK",
      "WAWAYANDA",
      "WOODBURY",
  }));
}
